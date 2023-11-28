package org.dictionary;

import com.google.common.util.concurrent.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class LockingServiceImpl extends LockServiceGrpc.LockServiceImplBase implements LockingService{

    Lock resultLock;
    List<String> addresses = new ArrayList<>(List.of("5001","5002","5003","5004","5005"));
    Map<String, String> permanentDbStore;
    Map<String, Txn> lockManager;
    Lock.Builder result = Lock.newBuilder();
    Logger logger;
    CountDownLatch latch = new CountDownLatch(4);
    int PORT_NUM;
    public LockingServiceImpl(Map<String, Txn> lockManager, Map<String, String> permanentDbStore,Txn txn ,Logger logger, int PORT_NUM){
        this.lockManager = lockManager;
        this.permanentDbStore = permanentDbStore;
        this.logger = logger;
        this.PORT_NUM = PORT_NUM;
    }
    @Override
    public boolean aquireLock(TxnKV kv,Txn txn) throws InterruptedException, ExecutionException {

        while(lockManager.get(kv.getKey()) != null);
        ExecutorService execService = Executors.newSingleThreadExecutor();
        ListeningExecutorService lExecService = MoreExecutors.listeningDecorator(execService);


        List<String> useAddr = new ArrayList<>(addresses);
        useAddr.remove(String.valueOf(PORT_NUM));

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(0))).usePlaintext().build();

        LockServiceGrpc.LockServiceFutureStub lockingSvc = LockServiceGrpc.newFutureStub(channel);
        ListenableFuture<Lock> lock1 = lockingSvc.lock(kv);
        Futures.addCallback(lock1,new Notify(latch), lExecService);

        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(1))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newFutureStub(channel);
        ListenableFuture<Lock> lock2 = lockingSvc.lock(kv);
        Futures.addCallback(lock1,new Notify(latch), lExecService);


        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(2))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newFutureStub(channel);
        ListenableFuture<Lock> lock3 = lockingSvc.lock(kv);
        Futures.addCallback(lock1,new Notify(latch), lExecService);



        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(3))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newFutureStub(channel);
        ListenableFuture<Lock> lock4 = lockingSvc.lock(kv);
        Futures.addCallback(lock1,new Notify(latch), lExecService);

        latch.await();
        ListenableFuture<List<Lock>> lockStat = Futures.allAsList(lock1, lock2, lock3, lock4);
        Futures.addCallback(lockStat, new FutureCallback<List<Lock>>() {
            @Override
            public void onSuccess(@Nullable List<Lock> lockList) {
                // do on all futures success
                System.out.println(lockList);
                resultLock = result.setIsLocked(true).build();


            }

            @Override
            public void onFailure(Throwable t) {
                // handle on at least one failure
            }
        }, lExecService);


        lockManager.put(kv.getKey(),txn);
        return true;


    }

    @Override
    public Txn releaseLock(TxnKV kv) {
        List<String> useAddr = new ArrayList<>(addresses);
        useAddr.remove(String.valueOf(PORT_NUM));

        if(lockManager.containsKey(kv.getKey())){
            lockManager.remove(kv.getKey());
        }
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(0))).usePlaintext().build();
        LockServiceGrpc.LockServiceStub lockingSvc = LockServiceGrpc.newStub(channel);
        lockingSvc.unlock(kv,new UnockCallBack());

        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(1))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newStub(channel);
        lockingSvc.unlock(kv,new UnockCallBack());

        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(2))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newStub(channel);
        lockingSvc.unlock(kv,new UnockCallBack());

        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(useAddr.get(3))).usePlaintext().build();
        lockingSvc = LockServiceGrpc.newStub(channel);
        lockingSvc.unlock(kv,new UnockCallBack());


        return null;
    }
    class UnockCallBack implements io.grpc.stub.StreamObserver<Lock> {
        @Override
        public void onNext(Lock lock) {
            System.out.println("Commit Status:" + lock.getIsLocked());
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            System.out.println("Unlock Request Sent");
        }
    }

    private class Notify implements FutureCallback<Lock> {
        CountDownLatch latch;
        Notify(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void onSuccess(Lock result) {
            latch.countDown();
            System.out.println("Result: " + result);

        }

        @Override
        public void onFailure(Throwable failure) {

            failure.printStackTrace();
        }
    }
}
