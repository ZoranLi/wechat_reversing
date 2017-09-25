package com.tencent.wcdb.database;

public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
