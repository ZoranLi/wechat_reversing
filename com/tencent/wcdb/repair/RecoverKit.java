package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;

public class RecoverKit {
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private int mFailedCount;
    private String mLastError = null;
    private long mNativePtr;
    private int mSuccessCount;

    private static native void nativeCancel(long j);

    private static native int nativeFailureCount(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, boolean z);

    private static native int nativeSuccessCount(long j);

    public RecoverKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
        this.mDB = sQLiteDatabase;
        this.mNativePtr = nativeInit(str, bArr);
        if (this.mNativePtr == 0) {
            throw new SQLiteException("Failed initialize recover context.");
        }
    }

    public int run(boolean z) {
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("RecoverKit not initialized.");
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("recover", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, z);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
        this.mFailedCount = nativeFailureCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        return nativeRun;
    }

    public int successCount() {
        return this.mSuccessCount;
    }

    public int failureCount() {
        return this.mFailedCount;
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
