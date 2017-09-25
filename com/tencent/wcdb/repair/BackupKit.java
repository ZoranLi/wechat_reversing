package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Arrays;

public class BackupKit {
    public static final int FLAG_FIX_CORRUPTION = 4;
    public static final int FLAG_INCREMENTAL = 16;
    public static final int FLAG_NO_CIPHER = 1;
    public static final int FLAG_NO_COMPRESS = 2;
    public static final int FLAG_NO_CREATE_TABLE = 8;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private String mLastError = null;
    private long mNativePtr;
    private int mStatementCount;
    private String[] mTableDesc;

    private static native void nativeCancel(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr, int i);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, String[] strArr);

    private static native int nativeStatementCount(long j);

    public BackupKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, int i, String[] strArr) {
        this.mDB = sQLiteDatabase;
        this.mTableDesc = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.mNativePtr = nativeInit(str, bArr, i);
        if (this.mNativePtr == 0) {
            throw new SQLiteException("Failed initialize backup context.");
        }
    }

    public int run() {
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("BackupKit not initialized.");
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("backup", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, this.mTableDesc);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mStatementCount = nativeStatementCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        return nativeRun;
    }

    public int statementCount() {
        return this.mStatementCount;
    }

    public void cancel() {
        if (this.mNativePtr != 0) {
            nativeCancel(this.mNativePtr);
        }
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
    }

    protected void finalize() {
        release();
        super.finalize();
    }
}
