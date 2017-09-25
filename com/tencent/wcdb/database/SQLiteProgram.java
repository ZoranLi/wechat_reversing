package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String TAG = "WCDB.SQLiteProgram";
    private final Object[] mBindArgs;
    private SQLiteSession mBoundSession;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    protected PreparedStatement mPreparedStatement;
    private final boolean mReadOnly;
    private final String mSql;

    protected SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        boolean z = true;
        this.mDatabase = sQLiteDatabase;
        this.mSql = str.trim();
        int sqlStatementType = DatabaseUtils.getSqlStatementType(this.mSql);
        switch (sqlStatementType) {
            case 4:
            case 5:
            case 6:
                this.mReadOnly = false;
                this.mColumnNames = EMPTY_STRING_ARRAY;
                this.mNumParameters = 0;
                break;
            default:
                if (sqlStatementType != 1) {
                    z = false;
                }
                SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
                sQLiteDatabase.getThreadSession().prepare(this.mSql, sQLiteDatabase.getThreadDefaultConnectionFlags(z), cancellationSignal, sQLiteStatementInfo);
                this.mReadOnly = sQLiteStatementInfo.readOnly;
                this.mColumnNames = sQLiteStatementInfo.columnNames;
                this.mNumParameters = sQLiteStatementInfo.numParameters;
                break;
        }
        if (objArr == null || objArr.length <= this.mNumParameters) {
            if (this.mNumParameters != 0) {
                this.mBindArgs = new Object[this.mNumParameters];
                if (objArr != null) {
                    System.arraycopy(objArr, 0, this.mBindArgs, 0, objArr.length);
                }
            } else {
                this.mBindArgs = null;
            }
            this.mPreparedStatement = null;
            this.mBoundSession = null;
            return;
        }
        throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
    }

    public final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public final String getSql() {
        return this.mSql;
    }

    protected final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    public final String[] getColumnNames() {
        return this.mColumnNames;
    }

    protected final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    protected final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    public final void onCorruption() {
        SQLiteDebug.collectLastIOTraceStats(this.mDatabase);
        this.mDatabase.onCorruption();
    }

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    public void bindNull(int i) {
        bind(i, null);
    }

    public void bindLong(int i, long j) {
        bind(i, Long.valueOf(j));
    }

    public void bindDouble(int i, double d) {
        bind(i, Double.valueOf(d));
    }

    public void bindString(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        bind(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        bind(i, bArr);
    }

    public void clearBindings() {
        if (this.mBindArgs != null) {
            Arrays.fill(this.mBindArgs, null);
        }
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    protected void onAllReferencesReleased() {
        releasePreparedStatement();
        clearBindings();
    }

    private void bind(int i, Object obj) {
        if (i <= 0 || i > this.mNumParameters) {
            throw new IllegalArgumentException("Cannot bind argument at index " + i + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
        }
        this.mBindArgs[i - 1] = obj;
    }

    protected synchronized boolean acquirePreparedStatement() {
        boolean z;
        SQLiteSession threadSession = this.mDatabase.getThreadSession();
        if (threadSession == this.mBoundSession) {
            z = false;
        } else if (this.mBoundSession != null) {
            throw new IllegalStateException("SQLiteProgram has bound to another thread.");
        } else {
            this.mBoundSession = threadSession;
            this.mPreparedStatement = threadSession.acquirePreparedStatement(this.mSql, this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly));
            this.mPreparedStatement.bindArguments(this.mBindArgs);
            z = true;
        }
        return z;
    }

    protected synchronized void releasePreparedStatement() {
        if (!(this.mBoundSession == null && this.mPreparedStatement == null)) {
            if (this.mBoundSession != this.mDatabase.getThreadSession()) {
                throw new IllegalStateException("SQLiteProgram has bound to another thread.");
            }
            this.mBoundSession.releasePreparedStatement(this.mPreparedStatement);
            this.mPreparedStatement = null;
            this.mBoundSession = null;
        }
    }

    protected void finalize() {
        synchronized (this) {
            if (this.mBoundSession == null && this.mPreparedStatement == null) {
            } else {
                throw new SQLiteMisuseException("Acquired prepared statement is not released.");
            }
        }
        super.finalize();
    }
}
