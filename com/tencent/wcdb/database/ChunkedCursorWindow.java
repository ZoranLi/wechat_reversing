package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow extends SQLiteClosable {
    public static final long CHUNK_NOT_FOUND = -1;
    private int mNumColumns = 0;
    long mWindowPtr;

    private static native void nativeClear(long j);

    private static native long nativeCreate(int i);

    private static native void nativeDispose(long j);

    private static native void nativeEndRow(long j, long j2);

    private static native byte[] nativeGetBlob(long j, int i);

    private static native double nativeGetDouble(long j, int i);

    private static native long nativeGetLong(long j, int i);

    private static native int nativeGetNumChunks(long j);

    private static native long nativeGetRow(long j, int i);

    private static native String nativeGetString(long j, int i);

    private static native int nativeGetType(long j, int i);

    private static native long nativeRemoveChunk(long j, int i);

    private static native boolean nativeSetNumColumns(long j, int i);

    public ChunkedCursorWindow(int i) {
        this.mWindowPtr = nativeCreate(i);
        if (this.mWindowPtr == 0) {
            throw new CursorWindowAllocationException("Cursor window allocation failed.");
        }
    }

    private void dispose() {
        if (this.mWindowPtr != 0) {
            nativeDispose(this.mWindowPtr);
            this.mWindowPtr = 0;
        }
    }

    protected void finalize() {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    protected void onAllReferencesReleased() {
        dispose();
    }

    public void clear() {
        acquireReference();
        try {
            nativeClear(this.mWindowPtr);
        } finally {
            releaseReference();
        }
    }

    public long removeChunk(int i) {
        acquireReference();
        try {
            long nativeRemoveChunk = nativeRemoveChunk(this.mWindowPtr, i);
            return nativeRemoveChunk;
        } finally {
            releaseReference();
        }
    }

    public int getNumChunks() {
        acquireReference();
        try {
            int nativeGetNumChunks = nativeGetNumChunks(this.mWindowPtr);
            return nativeGetNumChunks;
        } finally {
            releaseReference();
        }
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public boolean setNumColumns(int i) {
        acquireReference();
        try {
            boolean nativeSetNumColumns = nativeSetNumColumns(this.mWindowPtr, i);
            if (nativeSetNumColumns) {
                this.mNumColumns = i;
            }
            releaseReference();
            return nativeSetNumColumns;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    long getRowUnsafe(int i) {
        acquireReference();
        long nativeGetRow = nativeGetRow(this.mWindowPtr, i);
        if (nativeGetRow == 0) {
            releaseReference();
        }
        return nativeGetRow;
    }

    void endRowUnsafe(long j) {
        if (j != 0) {
            nativeEndRow(this.mWindowPtr, j);
            releaseReference();
        }
    }

    int getTypeUnsafe(long j, int i) {
        return nativeGetType(j, i);
    }

    byte[] getBlobUnsafe(long j, int i) {
        return nativeGetBlob(j, i);
    }

    String getStringUnsafe(long j, int i) {
        return nativeGetString(j, i);
    }

    long getLongUnsafe(long j, int i) {
        return nativeGetLong(j, i);
    }

    double getDoubleUnsafe(long j, int i) {
        return nativeGetDouble(j, i);
    }

    public int getType(int i, int i2) {
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            throw new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
        }
        try {
            int nativeGetType = nativeGetType(rowUnsafe, i2);
            return nativeGetType;
        } finally {
            endRowUnsafe(rowUnsafe);
        }
    }

    public byte[] getBlob(int i, int i2) {
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            throw new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
        }
        try {
            byte[] nativeGetBlob = nativeGetBlob(rowUnsafe, i2);
            return nativeGetBlob;
        } finally {
            endRowUnsafe(rowUnsafe);
        }
    }

    public String getString(int i, int i2) {
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            throw new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
        }
        try {
            String nativeGetString = nativeGetString(rowUnsafe, i2);
            return nativeGetString;
        } finally {
            endRowUnsafe(rowUnsafe);
        }
    }

    public long getLong(int i, int i2) {
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            throw new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
        }
        try {
            long nativeGetLong = nativeGetLong(rowUnsafe, i2);
            return nativeGetLong;
        } finally {
            endRowUnsafe(rowUnsafe);
        }
    }

    public double getDouble(int i, int i2) {
        long rowUnsafe = getRowUnsafe(i);
        if (rowUnsafe == 0) {
            throw new IllegalStateException("Couldn't read row " + i + ", column " + i2 + " from ChunkedCursorWindow.");
        }
        try {
            double nativeGetDouble = nativeGetDouble(rowUnsafe, i2);
            return nativeGetDouble;
        } finally {
            endRowUnsafe(rowUnsafe);
        }
    }
}
