package org.dictionary;

import java.util.concurrent.ExecutionException;

public interface LockingService {
    public boolean aquireLock(TxnKV kv, Txn txn) throws InterruptedException, ExecutionException;
    public Txn releaseLock(TxnKV kv) throws InterruptedException;


}
