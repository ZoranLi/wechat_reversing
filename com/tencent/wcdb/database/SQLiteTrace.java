package com.tencent.wcdb.database;

import java.util.List;

public interface SQLiteTrace {
    void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z);

    void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2);

    void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase);

    void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j);
}
