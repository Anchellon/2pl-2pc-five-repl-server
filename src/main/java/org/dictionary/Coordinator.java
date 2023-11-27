package org.dictionary;

public interface Coordinator {
    Txn openTransatction();
    boolean haveCommited();

//

}
