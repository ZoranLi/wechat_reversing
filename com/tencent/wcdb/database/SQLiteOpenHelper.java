package com.tencent.wcdb.database;

import android.content.Context;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.Log;

public abstract class SQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "WCDB.SQLiteOpenHelper";
    private SQLiteCipherSpec mCipher;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final CursorFactory mFactory;
    private boolean mIsInitializing;
    private int mMode;
    private final String mName;
    private boolean mNeedMode;
    private final int mNewVersion;
    private byte[] mPassword;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    static {
        SQLiteDatabase.loadLib();
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        if (i <= 0) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.mContext = context;
        this.mName = str;
        this.mFactory = cursorFactory;
        this.mNewVersion = i;
        this.mErrorHandler = databaseErrorHandler;
        this.mPassword = bArr;
        this.mCipher = sQLiteCipherSpec == null ? null : new SQLiteCipherSpec(sQLiteCipherSpec);
        this.mNeedMode = false;
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, bArr, null, cursorFactory, i, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, null, null, cursorFactory, i, databaseErrorHandler);
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                if (!(this.mDatabase == null || !this.mDatabase.isOpen() || this.mDatabase.isReadOnly())) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                }
                this.mEnableWriteAheadLogging = z;
            }
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        if (this.mDatabase != null) {
            if (!this.mDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!(z && this.mDatabase.isReadOnly())) {
                return this.mDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabase2 != null) {
                if (z && sQLiteDatabase2.isReadOnly()) {
                    sQLiteDatabase2.reopenReadWrite();
                    sQLiteDatabase = sQLiteDatabase2;
                } else {
                    sQLiteDatabase = sQLiteDatabase2;
                }
            } else if (this.mName == null) {
                sQLiteDatabase = SQLiteDatabase.create(null);
            } else {
                this.mNeedMode = true;
                this.mMode = this.mEnableWriteAheadLogging ? 8 : 0;
                sQLiteDatabase = com.tencent.wcdb.support.Context.openOrCreateDatabase(this.mContext, this.mName, this.mPassword, this.mCipher, this.mMode, this.mFactory, this.mErrorHandler);
            }
        } catch (SQLiteException e) {
            if (z) {
                throw e;
            } else {
                Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", new Object[]{e});
                sQLiteDatabase = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mCipher, this.mFactory, 1, this.mErrorHandler);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            sQLiteDatabase = sQLiteDatabase2;
        }
        try {
            SQLiteDatabase databaseLockedLast = getDatabaseLockedLast(sQLiteDatabase);
            this.mIsInitializing = false;
            if (sQLiteDatabase == null || sQLiteDatabase == this.mDatabase) {
                return databaseLockedLast;
            }
            sQLiteDatabase.close();
            return databaseLockedLast;
        } catch (Throwable th3) {
            th2 = th3;
            this.mIsInitializing = false;
            if (!(sQLiteDatabase == null || sQLiteDatabase == this.mDatabase)) {
                sQLiteDatabase.close();
            }
            throw th2;
        }
    }

    private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase sQLiteDatabase) {
        onConfigure(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        if (version != this.mNewVersion) {
            if (sQLiteDatabase.isReadOnly()) {
                throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
            }
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                }
            } else if (version > this.mNewVersion) {
                onDowngrade(sQLiteDatabase, version, this.mNewVersion);
            } else {
                onUpgrade(sQLiteDatabase, version, this.mNewVersion);
            }
            sQLiteDatabase.setVersion(this.mNewVersion);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
        onOpen(sQLiteDatabase);
        if (sQLiteDatabase.isReadOnly()) {
            Log.w(TAG, "Opened " + this.mName + " in read-only mode");
        }
        this.mDatabase = sQLiteDatabase;
        return sQLiteDatabase;
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        } else if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }
}
