package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;

public interface f {
    Cursor a(String str, String[] strArr, CancellationSignal cancellationSignal);

    void beginTransaction();

    boolean cb(int i, int i2);

    void commit();

    SQLiteStatement compileStatement(String str);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    long h(long j, long j2);

    void i(long j, long j2);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);

    boolean wT(String str);
}
