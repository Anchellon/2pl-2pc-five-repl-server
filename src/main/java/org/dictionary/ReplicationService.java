package org.dictionary;

import java.util.List;

public interface ReplicationService {
    Status replicate( List<String> addresses, KeyValue keyValue) throws InterruptedException;// canCommit
    Status delete(List<String> addresses, KeyValue keyValue,String txn);

}
