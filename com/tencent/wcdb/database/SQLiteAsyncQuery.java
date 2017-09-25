package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteAsyncQuery";
    private final int mResultColumns = getColumnNames().length;

    private static native int nativeCount(long j);

    private static native int nativeFillRows(long j, long j2, int i, int i2);

    public SQLiteAsyncQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
    }

    void acquire() {
        if (this.mPreparedStatement == null) {
            acquirePreparedStatement();
            this.mPreparedStatement.bindArguments(getBindArgs());
        }
    }

    void release() {
        releasePreparedStatement();
    }

    int fillRows(ChunkedCursorWindow chunkedCursorWindow, int i, int i2) {
        acquire();
        if (chunkedCursorWindow.getNumColumns() != this.mResultColumns) {
            chunkedCursorWindow.setNumColumns(this.mResultColumns);
        }
        try {
            return nativeFillRows(this.mPreparedStatement.getPtr(), chunkedCursorWindow.mWindowPtr, i, i2);
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (SQLiteException e2) {
            Log.e(TAG, "Got exception on fillRows: " + e2.getMessage() + ", SQL: " + getSql());
            throw e2;
        }
    }

    int getCount() {
        acquire();
        try {
            return nativeCount(this.mPreparedStatement.getPtr());
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (SQLiteException e2) {
            Log.e(TAG, "Got exception on getCount: " + e2.getMessage() + ", SQL: " + getSql());
            throw e2;
        }
    }

    void reset() {
        if (this.mPreparedStatement != null) {
            this.mPreparedStatement.reset(false);
        }
    }
}
