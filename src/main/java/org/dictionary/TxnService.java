package org.dictionary;


import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TxnService extends TxnServiceGrpc.TxnServiceImplBase {

    Map<String, String> permanentDbStore;
    Map<Txn, List<String>> volatileDbStore;
    Map<String,Txn> lockManager;
    Logger logger;
    int PORT_NUM;
    TxnService(Map<String,String> permanentDbStore,Map<Txn,List<String>>  volatileDbStore,Map<String,Txn> lockManager, Logger logger, int PORT_NUM){
        this.permanentDbStore = permanentDbStore;
        this.volatileDbStore = volatileDbStore;
        this.lockManager = lockManager;
        this.logger = logger;
        this.PORT_NUM = PORT_NUM;
    }

//    message Status{
//        string status = 1;
//        string message = 2;
//        string key =3;
//        string value = 4;
//    }
//    added to volatile store
    public void copy(TxnKV txnKV,io.grpc.stub.StreamObserver<Status> responseObserver){
        System.out.println("Recieved copy request" + txnKV);
        this.volatileDbStore.put(txnKV.getTxn(),List.of(txnKV.getKey(),txnKV.getValue()));
        Status.Builder status = Status.newBuilder();
        status.setStatus("SUCCESS")
                .setKey(txnKV.getKey())
                .setValue(txnKV.getValue())
                .setMessage("CopyPrepared@"+PORT_NUM);
        System.out.println((status.build()));
        System.out.println(volatileDbStore);
        System.out.println("Copy request Successful");
        responseObserver.onNext(status.build());
        responseObserver.onCompleted();
    }
    public void delete(TxnKV txnKV,io.grpc.stub.StreamObserver<Status> responseObserver){
        System.out.println("Recieved delete request" + txnKV);
        this.volatileDbStore.put(txnKV.getTxn(),List.of(txnKV.getKey(),txnKV.getValue(),"DEL"));
        Status.Builder status = Status.newBuilder();
        status.setStatus("SUCCESS")
                .setKey(txnKV.getKey())
                .setValue(txnKV.getValue())
                .setMessage("DeletePrepared@"+PORT_NUM);
        System.out.println((status.build()));
        System.out.println(volatileDbStore);
        System.out.println("Delete request Successful");
        responseObserver.onNext(status.build());
        responseObserver.onCompleted();
    }
//    works
    public void doCommit(Txn txn,io.grpc.stub.StreamObserver<Status> responseObserver){
        Status.Builder status = Status.newBuilder();
        System.out.println(volatileDbStore);
        List<String> reccord = this.volatileDbStore.get(txn);
        if(reccord != null) {
//            getCommit
            System.out.println(reccord.size());
            if(reccord.size() == 2){

                this.permanentDbStore.put(reccord.get(0), reccord.get(1));
                status.setMessage("SUCCESS")
                        .setKey(reccord.get(0))
                        .setValue(reccord.get(1));

            }else{ // Delete commit
                this.permanentDbStore.remove(reccord.get(0));
                status.setMessage("SUCCESS")
                        .setKey(reccord.get(0))
                        .setValue(reccord.get(1));
            }

        }else{
            status.setMessage("FAIL:NO SUCH TXN");

        }
        this.volatileDbStore.remove(txn);
        System.out.println("Pending Transations" + volatileDbStore);
        responseObserver.onNext(status.build());
        responseObserver.onCompleted();
    }
    public void doAbort(Txn txn,io.grpc.stub.StreamObserver<Status> responseObserver){
        Status.Builder status = Status.newBuilder();
        List<String> reccord = this.volatileDbStore.get(txn.getTxn());
        if(reccord != null){
            this.volatileDbStore.remove(txn.getTxn());
            status.setMessage("ABORT SUCCESS");
        }else{
            status.setMessage("FAIL:NO SUCH TXN");
        }
        responseObserver.onNext(status.build());
        responseObserver.onCompleted();

    }


}
