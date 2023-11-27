package org.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TxnService extends TxnServiceGrpc.TxnServiceImplBase {

    Map<String, String> permanentDbStore;
    Map<Txn, List<String>> volatileDbStore;
    Map<String,Boolean> lockManager;
    Logger logger;
    int PORT_NUM;
    TxnService(Map<String,String> dbStore,Map<Txn,List<String>>  volatileDbStore,Map<String,Boolean> lockManager, Logger logger, int PORT_NUM){
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
        this.volatileDbStore.put(txnKV.getTxn(),List.of(txnKV.getKey(),txnKV.getValue()));
        Status.Builder status = Status.newBuilder();
        status.setMessage("SUCCESS")
                .setKey(txnKV.getKey())
                .setValue(txnKV.getValue());
        responseObserver.onNext(status.build());
        responseObserver.onCompleted();
    }

    public void doCommit(Txn txn,io.grpc.stub.StreamObserver<Status> responseObserver){
        Status.Builder status = Status.newBuilder();
        List<String> reccord = this.volatileDbStore.get(txn.getTxn());
        if(reccord != null) {
            this.permanentDbStore.put(reccord.get(0), reccord.get(1));
            status.setMessage("SUCCESS")
                    .setKey(reccord.get(0))
                    .setValue(reccord.get(1));

        }else{
            status.setMessage("FAIL:NO SUCH TXN");
            responseObserver.onNext(status.build());
            responseObserver.onCompleted();
        }
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
