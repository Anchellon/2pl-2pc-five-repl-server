package org.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DictionaryService  extends dictionaryServiceGrpc.dictionaryServiceImplBase {
    Map<String, String> permanentDbStore;
    Map<Txn, List<String>> volatileDbStore;
    Map<String, Txn> lockManager;
    Logger logger;
    int PORT_NUM;
    List<String> addresses = new ArrayList<>(List.of("5001","5002","5003","5004","5005"));
    int tid = 0;

    public DictionaryService(Map<String, String> permanentDbStore,Map<Txn, List<String>> volatileDbStore,Map<String,Boolean> lockManager,Logger logger,int PORT_NUM) {
        this.permanentDbStore = permanentDbStore;
        this.volatileDbStore = volatileDbStore;
        this.logger = logger;
        this.PORT_NUM = PORT_NUM;
        logger.info("Service Request Initiated");

    }
    public void put(KeyValue request, io.grpc.stub.StreamObserver<Status> responseObserver) {
        logger.info("PUT fn Call Initiated");
        String key = request.getKey();
        String value = request.getValue();

        Coordinator coordinator = new CoordinatorImpl("localhost:"+ String.valueOf(PORT_NUM),String.valueOf(tid));
        Txn txn = coordinator.openTransatction();
        LockingService lockingSvc = new LockingServiceImpl(lockManager, permanentDbStore,txn,logger, PORT_NUM) ;
        ReplicationService replSvc = new ReplicationServiceImpl(permanentDbStore, volatileDbStore, txn.getTxn(), logger, String.valueOf(PORT_NUM));
        List<String> useAddr = new ArrayList<>(addresses);
        useAddr.remove(PORT_NUM);

// txn id is built with port number

        Status result = null;
        try {
            result = replSvc.replicate(useAddr,request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
// temporary copy done


        if(result.getStatus() == "FAIL") {
            logger.info("Replication fn Call failed response back");
        }else {
            logger.info("Replication fn Call successfully Completed");
        }
        responseObserver.onNext(result);
        responseObserver.onCompleted();




//
//        Status.Builder status = Status.newBuilder();
//
//        if (dbStore.containsKey(key)) {
//            dbStore.put(key, value);
//            status.setStatus("Updated");
//            status.setMessage("The value was successfully Updated");
//            logger.info("PUT fn Call Updated Key:" + key + " with value:" + value);
//
//
//        } else {
//            dbStore.put(key, value);
//            status.setStatus("Added");
//            status.setMessage("The value was successfully Added");
//            logger.info("PUT fn Call Added Key:" + key + " with value:" + value);
//        }
//
//        status.setKey(key);
//        status.setValue(value);
//        logger.info("PUT fn Call sending response back");
//        responseObserver.onNext(status.build());
//        logger.info("PUT fn Call successfully Completed");
//        responseObserver.onCompleted();
    }
}
