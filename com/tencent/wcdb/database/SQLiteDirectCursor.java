package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor extends AbstractCursor {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new SQLiteDirectCursor(sQLiteCursorDriver, str, (SQLiteDirectQuery) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new SQLiteDirectQuery(sQLiteDatabase, str, objArr, cancellationSignal);
        }
    };
    private static final String TAG = "WCDB.SQLiteDirectCursor";
    private final String[] mColumns;
    private int mCount;
    private boolean mCountFinished;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteDirectQuery mQuery;

    public SQLiteDirectCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteDirectQuery sQLiteDirectQuery) {
        if (sQLiteDirectQuery == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mQuery = sQLiteDirectQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteDirectQuery.getColumnNames();
        this.mCount = -1;
        this.mCountFinished = false;
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

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public String getString(int i) {
        return this.mQuery.getString(i);
    }

    public byte[] getBlob(int i) {
        return this.mQuery.getBlob(i);
    }

    public short getShort(int i) {
        return (short) ((int) this.mQuery.getLong(i));
    }

    public int getInt(int i) {
        return (int) this.mQuery.getLong(i);
    }

    public long getLong(int i) {
        return this.mQuery.getLong(i);
    }

    public float getFloat(int i) {
        return (float) this.mQuery.getDouble(i);
    }

    public double getDouble(int i) {
        return this.mQuery.getDouble(i);
    }

    public int getType(int i) {
        return this.mQuery.getType(i);
    }

    public boolean isNull(int i) {
        return getType(i) == 0;
    }

    public boolean moveToPosition(int i) {
        if (i < 0) {
            this.mQuery.reset(false);
            this.mPos = -1;
            return false;
        } else if (!this.mCountFinished || i < this.mCount) {
            int step;
            if (i < this.mPos) {
                Log.w(TAG, "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
                this.mQuery.reset(false);
                step = this.mQuery.step(i + 1) - 1;
            } else if (i == this.mPos) {
                return true;
            } else {
                step = this.mPos + this.mQuery.step(i - this.mPos);
            }
            if (step < i) {
                this.mCount = step + 1;
                this.mCountFinished = true;
                this.mPos = this.mCount;
            } else {
                this.mPos = step;
                if (step >= this.mCount) {
                    this.mCount = step + 1;
                    this.mCountFinished = false;
                }
            }
            if (this.mPos < this.mCount) {
                return true;
            }
            return false;
        } else {
            this.mPos = this.mCount;
            return false;
        }
    }

    public int getCount() {
        if (!this.mCountFinished) {
            Log.w(TAG, "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
            this.mCount = (this.mPos + this.mQuery.step(Integer.MAX_VALUE)) + 1;
            this.mCountFinished = true;
            this.mQuery.reset(false);
            this.mPos = this.mQuery.step(this.mPos + 1) - 1;
        }
        return this.mCount;
    }

    public boolean requery() {
        boolean z = false;
        if (!isClosed()) {
            synchronized (this) {
                if (this.mQuery.getDatabase().isOpen()) {
                    this.mPos = -1;
                    this.mCountFinished = false;
                    this.mCount = -1;
                    this.mDriver.cursorRequeried(this);
                    this.mQuery.reset(z);
                    try {
                        z = super.requery();
                    } catch (IllegalStateException e) {
                        Log.w(TAG, "requery() failed " + e.getMessage(), e);
                    }
                }
            }
        }
        return z;
    }
}
