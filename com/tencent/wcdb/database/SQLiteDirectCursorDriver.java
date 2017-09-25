package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private static CursorFactory DEFAULT_FACTORY = SQLiteCursor.FACTORY;
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteProgram mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    public final Cursor query(CursorFactory cursorFactory, String[] strArr) {
        if (cursorFactory == null) {
            cursorFactory = DEFAULT_FACTORY;
        }
        SQLiteProgram sQLiteProgram = null;
        try {
            sQLiteProgram = cursorFactory.newQuery(this.mDatabase, this.mSql, strArr, this.mCancellationSignal);
            Cursor newCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteProgram);
            this.mQuery = sQLiteProgram;
            return newCursor;
        } catch (RuntimeException e) {
            if (sQLiteProgram != null) {
                sQLiteProgram.close();
            }
            throw e;
        }
    }

    public final void cursorClosed() {
    }

    public final void setBindArguments(String[] strArr) {
        this.mQuery.bindAllArgsAsStrings(strArr);
    }

    public final void cursorDeactivated() {
    }

    public final void cursorRequeried(Cursor cursor) {
    }

    public final String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
