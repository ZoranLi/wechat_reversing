package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;

public class RepairKit {
    public static final int FLAG_ALL_TABLES = 2;
    public static final int FLAG_NO_CREATE_TABLES = 1;
    private static final int INTEGRITY_DATA = 2;
    private static final int INTEGRITY_HEADER = 1;
    private static final int INTEGRITY_KDF_SALT = 4;
    private int mIntegrityFlags;
    private MasterInfo mMasterInfo;
    private long mNativePtr;

    public static class MasterInfo {
        public byte[] mKDFSalt;
        public long mMasterPtr;

        private MasterInfo(long j, byte[] bArr) {
            this.mMasterPtr = j;
            this.mKDFSalt = bArr;
        }

        public static MasterInfo make(String[] strArr) {
            long nativeMakeMaster = RepairKit.nativeMakeMaster(strArr);
            if (nativeMakeMaster != 0) {
                return new MasterInfo(nativeMakeMaster, null);
            }
            throw new SQLiteException("Cannot create MasterInfo.");
        }

        public static MasterInfo load(String str, byte[] bArr, String[] strArr) {
            if (str == null) {
                return make(strArr);
            }
            byte[] bArr2 = new byte[16];
            long nativeLoadMaster = RepairKit.nativeLoadMaster(str, bArr, strArr, bArr2);
            if (nativeLoadMaster != 0) {
                return new MasterInfo(nativeLoadMaster, bArr2);
            }
            throw new SQLiteException("Cannot create MasterInfo.");
        }

        public static boolean save(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
            long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
            boolean nativeSaveMaster = RepairKit.nativeSaveMaster(acquireNativeConnectionHandle, str, bArr);
            sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
            return nativeSaveMaster;
        }

        public void release() {
            if (this.mMasterPtr != 0) {
                RepairKit.nativeFreeMaster(this.mMasterPtr);
                this.mMasterPtr = 0;
            }
        }

        protected void finalize() {
            release();
            super.finalize();
        }
    }

    private static native void nativeFini(long j);

    public static native void nativeFreeMaster(long j);

    private static native long nativeInit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, byte[] bArr2);

    private static native int nativeIntegrityFlags(long j);

    private static native String nativeLastError();

    public static native long nativeLoadMaster(String str, byte[] bArr, String[] strArr, byte[] bArr2);

    public static native long nativeMakeMaster(String[] strArr);

    private static native boolean nativeOutput(long j, long j2, long j3, int i);

    public static native boolean nativeSaveMaster(long j, String str, byte[] bArr);

    public RepairKit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, MasterInfo masterInfo) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.mNativePtr = nativeInit(str, bArr, sQLiteCipherSpec, masterInfo == null ? null : masterInfo.mKDFSalt);
        if (this.mNativePtr == 0) {
            throw new SQLiteException("Failed initialize RepairKit.");
        }
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        this.mMasterInfo = masterInfo;
    }

    public void release() {
        if (this.mMasterInfo != null) {
            this.mMasterInfo.release();
            this.mMasterInfo = null;
        }
        if (this.mNativePtr != 0) {
            nativeFini(this.mNativePtr);
            this.mNativePtr = 0;
        }
    }

    public boolean output(SQLiteDatabase sQLiteDatabase, int i) {
        long j = 0;
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException();
        }
        if (this.mMasterInfo != null) {
            j = this.mMasterInfo.mMasterPtr;
        }
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
        boolean nativeOutput = nativeOutput(this.mNativePtr, acquireNativeConnectionHandle, j, i);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        return nativeOutput;
    }

    public boolean isSaltCorrupted() {
        return (this.mIntegrityFlags & 4) == 0;
    }

    public boolean isHeaderCorrupted() {
        return (this.mIntegrityFlags & 1) == 0;
    }

    public boolean isDataCorrupted() {
        return (this.mIntegrityFlags & 2) == 0;
    }

    public static String lastError() {
        return nativeLastError();
    }

    protected void finalize() {
        release();
        super.finalize();
    }
}
