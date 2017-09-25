package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.File;

public final class c implements f {
    private SQLiteDatabase lYh;
    private SQLiteStatement lYi;
    private SQLiteStatement lYj;
    private SQLiteStatement lYk;

    public c(String str) {
        w.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[]{str});
        if (this.lYh != null) {
            w.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.lYh.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        this.lYh = SQLiteDatabase.openOrCreateDatabase(absolutePath, null);
        String rA = p.rA();
        h.vJ();
        h.vG();
        byte[] o = g.o((rA + ((long) a.uH())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.lYh;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, o);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        e.s(18, System.currentTimeMillis() - currentTimeMillis);
        w.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s", new Object[]{Long.valueOf(r4 - currentTimeMillis), bg.ew((long) com.tencent.mm.a.e.aN(absolutePath))});
        this.lYh.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.lYh.execSQL("PRAGMA synchronous=NORMAL;");
        this.lYh.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.lYi = this.lYh.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.lYj = this.lYh.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.lYk = this.lYh.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        w.d("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.lYh.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
    }

    public final Cursor a(String str, String[] strArr, CancellationSignal cancellationSignal) {
        w.d("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.lYh.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null, null));
    }

    public final SQLiteStatement compileStatement(String str) {
        w.d("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[]{str});
        return this.lYh.compileStatement(str);
    }

    public final boolean cb(int i, int i2) {
        int i3;
        if (!wT("FTS5IndexVersion") || this.lYi == null) {
            i3 = 0;
        } else {
            i3 = (int) h((long) i, 0);
        }
        w.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final long h(long j, long j2) {
        this.lYi.bindLong(1, j);
        try {
            j2 = this.lYi.simpleQueryForLong();
        } catch (SQLiteDoneException e) {
        }
        return j2;
    }

    public final void i(long j, long j2) {
        this.lYj.bindLong(1, j);
        this.lYj.bindLong(2, j2);
        this.lYj.execute();
    }

    public final boolean wT(String str) {
        Cursor rawQuery = this.lYh.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    public final void execSQL(String str) {
        w.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.lYh.execSQL(str);
    }

    public final void execSQL(String str, Object[] objArr) {
        w.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.lYh.execSQL(str, objArr);
    }

    public final void close() {
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.lYh;
        objArr[1] = Boolean.valueOf(this.lYh == null ? false : this.lYh.isOpen());
        w.w(str, str2, objArr);
        if (this.lYh != null && this.lYh.isOpen()) {
            w.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[]{Boolean.valueOf(this.lYh.inTransaction())});
            while (this.lYh.inTransaction()) {
                this.lYh.endTransaction();
            }
            this.lYi.close();
            this.lYj.close();
            this.lYh.close();
            this.lYh = null;
        }
    }

    public final synchronized void beginTransaction() {
        if (!(this.lYh == null || this.lYh.inTransaction())) {
            this.lYh.beginTransaction();
        }
    }

    public final boolean inTransaction() {
        if (this.lYh == null || !this.lYh.inTransaction()) {
            return false;
        }
        return true;
    }

    public final synchronized void commit() {
        if (this.lYh != null && this.lYh.inTransaction()) {
            this.lYh.setTransactionSuccessful();
            this.lYh.endTransaction();
        }
    }

    public final synchronized void rollback() {
        if (this.lYh != null && this.lYh.isOpen() && this.lYh.inTransaction()) {
            w.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.lYh.endTransaction();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", new Object[]{e});
            }
        }
    }

    protected static final void axB() {
        h.vJ();
        new File(h.vI().cachePath, "FTS5IndexMicroMsg.db").delete();
    }
}
