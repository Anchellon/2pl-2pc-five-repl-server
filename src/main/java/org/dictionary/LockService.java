package org.dictionary;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class LockService extends LockServiceGrpc.LockServiceImplBase {


    Map<String,Boolean> lockManager;
    Logger logger;
    int PORT_NUM;
    List<String> addresses = new ArrayList<>(List.of("5001","5002","5003","5004","5005"));

    public LockService(Map<String,Boolean> lockManager,Logger logger,int PORT_NUM){
        this.lockManager = lockManager;
        this.logger = logger;
        this.PORT_NUM = PORT_NUM;
    }

    @Override
    public void lock(KeyValue kv, StreamObserver<Lock> responseObserver){
        lockManager.put(kv.getKey(),Boolean.TRUE);
        Lock lock = Lock.newBuilder().setIsLocked(true).build();
        responseObserver.onNext(lock);
        responseObserver.onCompleted();
    }
    public void unlock(KeyValue kv,StreamObserver<Lock> responseObserver){
        if(lockManager.get(kv.getKey())){
            lockManager.put(kv.getKey(), Boolean.FALSE);
        }
        Lock lock = Lock.newBuilder().setIsLocked(false).build();
        responseObserver.onNext(lock);
        responseObserver.onCompleted();
    }
}
