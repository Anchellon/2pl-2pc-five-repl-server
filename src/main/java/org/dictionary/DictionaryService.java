package org.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class DictionaryService  extends dictionaryServiceGrpc.dictionaryServiceImplBase {
    Map<String, String> permanentDbStore;
    Map<Txn, List<String>> volatileDbStore;
    Map<String,Txn> lockManager;
    Logger logger;
    int PORT_NUM;
    List<String> addresses = new ArrayList<>(List.of("5001","5002","5003","5004","5005"));
    int tid = 0;

    public DictionaryService(Map<String, String> permanentDbStore, Map<Txn, List<String>> volatileDbStore,Map<String, Txn> lockManager, Logger logger, int PORT_NUM) {
        this.permanentDbStore = permanentDbStore;
        this.volatileDbStore = volatileDbStore;
        this.logger = logger;
        this.PORT_NUM = PORT_NUM;
        this.lockManager = lockManager;
        logger.info("Service Request Initiated");

    }
    public void put(KeyValue request, io.grpc.stub.StreamObserver<Status> responseObserver)  {
        logger.info("PUT fn Call Initiated");
        String key = request.getKey();
        String value = request.getValue();
        Txn txn = openTransatction("localhost:"+ PORT_NUM,String.valueOf(tid++));
        TxnKV txnKV = TxnKV.newBuilder().setTxn(txn).setKey(key).setValue(value).build();
        LockingService lockingSvc = new LockingServiceImpl(lockManager, permanentDbStore,txn,logger, PORT_NUM) ;
        try {
            try {
                lockingSvc.aquireLock(txnKV,txn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ReplicationService replSvc = new ReplicationServiceImpl(permanentDbStore, volatileDbStore, txn.getTxn(), logger, String.valueOf(PORT_NUM));
        List<String> useAddr = new ArrayList<>(addresses);
        useAddr.remove(useAddr.indexOf(String.valueOf(PORT_NUM)));

// txn id is built with port number

        Status result = null;
        try {
            result = replSvc.replicate(useAddr,request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(result!= null && result.getStatus().equals("FAIL")) {
            logger.info("Replication fn Call failed response back");
        }else {
            logger.info("Replication fn Call successfully Completed");
        }
        lockingSvc.releaseLock(txnKV);
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
    Txn openTransatction(String ip, String tid) {
        return Txn.newBuilder().setTxn(ip+"//"+tid).build();
    }
    public void delete(KeyValue request, io.grpc.stub.StreamObserver<Status> responseObserver)  {
        logger.info("DELETE fn Call Initiated");
        String key = request.getKey();
        String value = request.getValue();
        Txn txn = openTransatction("localhost:"+ PORT_NUM,String.valueOf(tid++));
        TxnKV txnKV = TxnKV.newBuilder().setTxn(txn).setKey(key).setValue(value).build();

        LockingService lockingSvc = new LockingServiceImpl(lockManager, permanentDbStore,txn,logger, PORT_NUM) ;
        try {
            lockingSvc.aquireLock(txnKV,txn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReplicationService replSvc = new ReplicationServiceImpl(permanentDbStore, volatileDbStore, txn.getTxn(), logger, String.valueOf(PORT_NUM));
        List<String> useAddr = new ArrayList<>(addresses);
        useAddr.remove(PORT_NUM);


        Status result = null;

        try {
            result = replSvc.delete(useAddr,request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(result!= null && result.getStatus().equals("FAIL")) {
            logger.info("DELETE fn Call failed response back");
        }else {
            logger.info("DELETE fn Call successfully Completed");
        }
        lockingSvc.releaseLock(txnKV);
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    public void get(KeyValue kv,io.grpc.stub.StreamObserver<Status> responseObserver ){

        String key = kv.getKey();
        Status.Builder status = Status.newBuilder();
        if (permanentDbStore.containsKey(key)) {
            String value = permanentDbStore.get(key);
            status.setStatus("Fetched");
            status.setMessage("The value was successfully fetched");
            status.setKey(key);
            status.setValue(value);
            logger.info("GET fn Call fetched Key:" + key + " with value:" + value);
        }

        else {
            status.setStatus("Key-Absent");
            status.setMessage("The Key is Absent");
            status.setKey(key);
            logger.info("GET fn Call cannot fetch absent Key:" + key);
        }
        logger.info("GET fn Call sending response back");
        responseObserver.onNext(status.build());
        logger.info("GET fn Call successfully Completed");
        responseObserver.onCompleted();
    }
}
