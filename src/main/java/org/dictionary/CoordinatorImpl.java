package org.dictionary;

public class CoordinatorImpl implements Coordinator {
    String tid;
    String ip;
    public CoordinatorImpl(String ip,String tid){
        this.ip = ip;
        this.tid = tid;
    }
    @Override
    public Txn openTransatction() {
        return Txn.newBuilder().setTxn(ip+"//"+tid).build();
    }


    @Override
    public boolean haveCommited() {
        return false;
    }
}
