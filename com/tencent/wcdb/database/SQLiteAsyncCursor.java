package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;

public class SQLiteAsyncCursor extends AbstractCursor {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new SQLiteAsyncCursor(sQLiteCursorDriver, str, (SQLiteAsyncQuery) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new SQLiteAsyncQuery(sQLiteDatabase, str, objArr, cancellationSignal);
        }
    };
    private static final int MAX_KEEP_CHUNKS = 32;
    private static final int MAX_PREFETCH = 256;
    private static final int MIN_FETCH_ROWS = 32;
    private static final String TAG = "WCDB.SQLiteAsyncCursor";
    private final String[] mColumns;
    public volatile int mCount;
    private long mCurrentRow;
    private final SQLiteCursorDriver mDriver;
    public final SQLiteAsyncQuery mQuery;
    private QueryThread mQueryThread;
    public final Object mWaitLock;
    public ChunkedCursorWindow mWindow;

    private class QueryThread extends Thread {
        private int mFetchPos = 0;
        private int mMinPos = 0;
        private volatile int mRequestPos = 0;

        QueryThread() {
            super("SQLiteAsyncCursor.QueryThread");
        }

        public void run() {
            try {
                int count = SQLiteAsyncCursor.this.mQuery.getCount();
                synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                    SQLiteAsyncCursor.this.mCount = count;
                    SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                }
                while (!interrupted()) {
                    int i;
                    synchronized (this) {
                        while (this.mRequestPos + 256 <= this.mFetchPos && this.mRequestPos >= this.mMinPos) {
                            wait();
                        }
                        count = this.mRequestPos;
                        i = count + 256;
                    }
                    if (count < this.mMinPos) {
                        SQLiteAsyncCursor.this.mQuery.reset();
                        this.mFetchPos = 0;
                        SQLiteAsyncCursor.this.mWindow.clear();
                        this.mMinPos = 0;
                    }
                    if (this.mFetchPos < i) {
                        int fillRows;
                        if (SQLiteAsyncCursor.this.mWindow.getNumChunks() > 32) {
                            long removeChunk = SQLiteAsyncCursor.this.mWindow.removeChunk(this.mMinPos);
                            if (removeChunk != -1) {
                                this.mMinPos = (int) removeChunk;
                            }
                        }
                        synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                            fillRows = SQLiteAsyncCursor.this.mQuery.fillRows(SQLiteAsyncCursor.this.mWindow, this.mFetchPos, 32);
                            if (this.mFetchPos <= count && this.mFetchPos + fillRows > count) {
                                SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                            }
                        }
                        this.mFetchPos += fillRows;
                    }
                }
                SQLiteAsyncCursor.this.mQuery.release();
            } catch (InterruptedException e) {
                SQLiteAsyncCursor.this.mQuery.release();
            } catch (Throwable th) {
                SQLiteAsyncCursor.this.mQuery.release();
            }
        }

        void requestPos(int i) {
            synchronized (this) {
                this.mRequestPos = i;
                notifyAll();
            }
        }

        void quit() {
            interrupt();
        }
    }

    public SQLiteAsyncCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteAsyncQuery sQLiteAsyncQuery) {
        if (sQLiteAsyncQuery == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mQuery = sQLiteAsyncQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteAsyncQuery.getColumnNames();
        this.mCount = -1;
        this.mWaitLock = new Object();
        this.mWindow = new ChunkedCursorWindow(16777216);
        this.mQueryThread = new QueryThread();
        this.mQueryThread.start();
    }

    public void close() {
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    public void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    protected void onDeactivateOrClose() {
        if (this.mCurrentRow != 0) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        if (this.mQueryThread != null) {
            this.mQueryThread.quit();
            try {
                this.mQueryThread.join();
            } catch (InterruptedException e) {
            }
            this.mQueryThread = null;
        }
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
        this.mCount = -1;
        this.mPos = -1;
        super.onDeactivateOrClose();
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public int getCount() {
        if (this.mCount >= 0) {
            return this.mCount;
        }
        if (this.mWindow == null) {
            return -1;
        }
        try {
            synchronized (this.mWaitLock) {
                while (this.mCount < 0) {
                    this.mWaitLock.wait();
                }
            }
        } catch (InterruptedException e) {
        }
        return this.mCount;
    }

    private boolean isValidPosition(int i) {
        return i >= 0 && i < getCount();
    }

    private long waitForRow(int i) {
        try {
            long rowUnsafe;
            synchronized (this.mWaitLock) {
                while (true) {
                    rowUnsafe = this.mWindow.getRowUnsafe(i);
                    if (rowUnsafe != 0) {
                    } else if (isValidPosition(i)) {
                        this.mWaitLock.wait();
                    } else {
                        throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
                    }
                }
            }
            return rowUnsafe;
        } catch (InterruptedException e) {
            return 0;
        }
    }

    private boolean requestRow() {
        if (this.mWindow == null || !isValidPosition(this.mPos)) {
            return false;
        }
        this.mQueryThread.requestPos(this.mPos);
        this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
        if (this.mCurrentRow == 0) {
            this.mCurrentRow = waitForRow(this.mPos);
        }
        if (this.mCurrentRow != 0) {
            return true;
        }
        return false;
    }

    private void checkValidRow() {
        if (this.mCurrentRow == 0) {
            if (isValidPosition(this.mPos)) {
                throw new StaleDataException("Cannot get valid Row object");
            }
            throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
        }
    }

    public boolean moveToPosition(int i) {
        if (i < -1) {
            i = -1;
        }
        if (i != this.mPos) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        int count = getCount();
        if (i >= count) {
            this.mPos = count;
            return false;
        }
        this.mPos = i;
        return i >= 0 && requestRow();
    }

    public int getType(int i) {
        checkValidRow();
        return this.mWindow.getTypeUnsafe(this.mCurrentRow, i);
    }

    public byte[] getBlob(int i) {
        checkValidRow();
        return this.mWindow.getBlobUnsafe(this.mCurrentRow, i);
    }

    public String getString(int i) {
        checkValidRow();
        return this.mWindow.getStringUnsafe(this.mCurrentRow, i);
    }

    public short getShort(int i) {
        return (short) ((int) getLong(i));
    }

    public int getInt(int i) {
        return (int) getLong(i);
    }

    public long getLong(int i) {
        checkValidRow();
        return this.mWindow.getLongUnsafe(this.mCurrentRow, i);
    }

    public float getFloat(int i) {
        return (float) getDouble(i);
    }

    public double getDouble(int i) {
        checkValidRow();
        return this.mWindow.getDoubleUnsafe(this.mCurrentRow, i);
    }

    public boolean isNull(int i) {
        return getType(i) == 0;
    }
}
