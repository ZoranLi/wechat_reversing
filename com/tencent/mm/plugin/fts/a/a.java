package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements g {
    private boolean lYR;
    private boolean lYS;
    private f<String, String> lYT;
    public f lYU;
    public SQLiteStatement lYV;
    private SQLiteStatement lYW;
    private SQLiteStatement lYX;
    private SQLiteStatement lYY;
    private SQLiteStatement lYZ;
    public SQLiteStatement lZa;
    private SQLiteStatement lZb;
    public SQLiteStatement lZc;

    public abstract void tR();

    public /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        if (getPriority() < gVar.getPriority()) {
            return -1;
        }
        return getPriority() > gVar.getPriority() ? 1 : 0;
    }

    public a() {
        w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", getName());
    }

    public final void create() {
        w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.lYR));
        if (!this.lYR) {
            int i;
            if (((l) h.j(l.class)).isFTSContextReady()) {
                this.lYU = ((l) h.j(l.class)).getFTSIndexDB();
                w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", axF(), axE(), getTableName());
                if (this.lYU.wT(axF()) && this.lYU.wT(r3) && !tS()) {
                    w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                } else {
                    w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r0});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r3});
                    this.lYU.execSQL(format);
                    this.lYU.execSQL(format2);
                    this.lYU.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{axF()}));
                    this.lYU.execSQL(axG());
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[]{r3, r3}));
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", new Object[]{r3, r3}));
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", new Object[]{r3, r3}));
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{r3, r3}));
                }
                this.lYV = this.lYU.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{r0}));
                this.lYW = this.lYU.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{r3}));
                this.lYX = this.lYU.compileStatement(String.format("DELETE FROM %s WHERE rowid=?;", new Object[]{r0}));
                this.lYY = this.lYU.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r3}));
                this.lYZ = this.lYU.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[]{r3}));
                this.lZa = this.lYU.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", new Object[]{r3}));
                this.lZb = this.lYU.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", new Object[]{r3}));
                this.lZc = this.lYU.compileStatement("SELECT mm_last_error();");
                this.lYT = new f(100);
                tR();
                boolean z = true;
            } else {
                w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.lYR = true;
            }
        }
    }

    public String getTableName() {
        return "Common";
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2) {
        String wZ = d.wZ(str2);
        if (!bg.mA(wZ)) {
            boolean inTransaction = this.lYU.inTransaction();
            if (!inTransaction) {
                this.lYU.beginTransaction();
            }
            try {
                this.lYV.bindString(1, wZ);
                this.lYV.execute();
                this.lYW.bindLong(1, (long) i);
                this.lYW.bindLong(2, (long) i2);
                this.lYW.bindLong(3, j);
                this.lYW.bindString(4, str);
                this.lYW.bindLong(5, j2);
                this.lYW.execute();
                if (!inTransaction) {
                    this.lYU.commit();
                }
                if (axH()) {
                    this.lYT.put(aW(str, i2), wZ);
                }
            } catch (SQLiteException e) {
                w.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.lZc.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    w.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }

    private static String aW(String str, int i) {
        return str + "​" + i;
    }

    public final void a(int[] iArr, String str) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.k(iArr) + " AND aux_index=?;", new Object[]{axE()});
        Cursor rawQuery = this.lYU.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aC(arrayList);
    }

    public final void i(int[] iArr) {
        List arrayList = new ArrayList(2048);
        Cursor rawQuery = this.lYU.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + d.k(iArr) + ";", new Object[]{axE()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aC(arrayList);
    }

    public final void a(int[] iArr, long j) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.k(iArr) + " AND entity_id=?;", new Object[]{axE()});
        Cursor rawQuery = this.lYU.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aC(arrayList);
    }

    public final void aC(List<Long> list) {
        boolean inTransaction = this.lYU.inTransaction();
        if (!inTransaction) {
            this.lYU.beginTransaction();
        }
        for (Long longValue : list) {
            this.lYX.bindLong(1, longValue.longValue());
            this.lYX.execute();
        }
        for (Long longValue2 : list) {
            this.lYY.bindLong(1, longValue2.longValue());
            this.lYY.execute();
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void u(String str, long j) {
        this.lZb.bindLong(1, j);
        this.lZb.bindString(2, str);
        this.lZb.execute();
    }

    public final void h(Long l) {
        boolean inTransaction = this.lYU.inTransaction();
        if (!inTransaction) {
            this.lYU.beginTransaction();
        }
        this.lYX.bindLong(1, l.longValue());
        this.lYX.execute();
        this.lYY.bindLong(1, l.longValue());
        this.lYY.execute();
        if (!inTransaction) {
            commit();
        }
    }

    public final void f(List<Long> list, int i) {
        boolean inTransaction = this.lYU.inTransaction();
        if (!inTransaction) {
            this.lYU.beginTransaction();
        }
        this.lYZ.bindLong(1, (long) i);
        for (Long longValue : list) {
            this.lYZ.bindLong(2, longValue.longValue());
            this.lYZ.execute();
        }
        if (!inTransaction) {
            this.lYU.commit();
        }
    }

    public final List<Long> b(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.k(iArr) + ";", new Object[]{axE()});
        Cursor rawQuery = this.lYU.rawQuery(format, new String[]{str});
        List<Long> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        f(arrayList, 1);
        return arrayList;
    }

    public final List<b> e(int[] iArr, int i) {
        Cursor rawQuery = this.lYU.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.k(iArr) + ";", new Object[]{axE()}), null);
        List<b> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.lZN = rawQuery.getLong(0);
            bVar.type = rawQuery.getInt(1);
            bVar.hPr = rawQuery.getInt(2);
            bVar.lZO = rawQuery.getString(3);
            arrayList.add(bVar);
            arrayList2.add(Long.valueOf(bVar.lZN));
        }
        rawQuery.close();
        f(arrayList2, i);
        return arrayList;
    }

    public final Cursor a(String[] strArr, int[] iArr, boolean z) {
        return a(strArr, iArr, null, null, z, true);
    }

    public final Cursor a(String[] strArr, int[] iArr, int[] iArr2) {
        return a(strArr, iArr, iArr2, null, true, true);
    }

    public final Cursor a(String[] strArr, int[] iArr, int[] iArr2, String str, boolean z, boolean z2) {
        String s = d.s(strArr);
        String format = z ? String.format(",MMHighlight(%s, -1, type, subtype)", new Object[]{axF()}) : "";
        String str2 = "";
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.k(iArr2);
        String str4 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.k(iArr);
        return this.lYU.a(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str4 + str2 + " AND status >= 0" + str3 + ";", new Object[]{axE(), axE(), axF(), axE(), axF(), axF(), s}), null, null);
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return c.bNI();
        }
        if (iArr == null || iArr.length == 0) {
            return c.bNI();
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        if (z) {
            stringBuilder.append("docid,");
        }
        if (z2) {
            stringBuilder.append("entity_id,");
        }
        if (z3) {
            stringBuilder.append("aux_index,");
        }
        if (z4) {
            stringBuilder.append("timestamp,");
        }
        if (z5) {
            stringBuilder.append("status,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return this.lYU.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + d.k(iArr) + ";", new Object[]{stringBuilder2, axE()}), null);
    }

    public final void destroy() {
        w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.lYS), Boolean.valueOf(this.lYR));
        if (!this.lYS && this.lYR && tT()) {
            w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.lYS = true;
        }
    }

    public boolean tT() {
        this.lYU = null;
        this.lYV.close();
        this.lYW.close();
        this.lYX.close();
        this.lYY.close();
        this.lYZ.close();
        this.lZc.close();
        if (this.lYT != null) {
            this.lYT.clear();
        }
        return true;
    }

    public final String axE() {
        return "FTS5Meta" + getTableName();
    }

    public final String axF() {
        return "FTS5Index" + getTableName();
    }

    public final void beginTransaction() {
        this.lYU.beginTransaction();
    }

    public final void commit() {
        this.lYU.commit();
    }

    public final void i(long j, long j2) {
        this.lYU.i(j, j2);
    }

    public final boolean cb(int i, int i2) {
        return this.lYU.cb(i, i2);
    }

    public String axG() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{axE()});
    }

    public boolean tS() {
        return false;
    }

    public final long j(int[] iArr) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        long j = 0;
        try {
            cursor2 = this.lYU.rawQuery(String.format("SELECT count(*) FROM %s WHERE type IN %s", new Object[]{axE(), d.k(iArr)}), null);
            try {
                if (cursor2.moveToNext()) {
                    j = cursor2.getLong(0);
                }
                cursor2.close();
                return j;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final String aX(String str, int i) {
        String aW;
        if (axH()) {
            aW = aW(str, i);
            if (this.lYT.aV(aW)) {
                w.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
                return (String) this.lYT.get(aW);
            }
        }
        aW = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[]{axE(), axF(), axE(), axF()});
        Cursor rawQuery = this.lYU.rawQuery(aW, new String[]{str, String.valueOf(i)});
        aW = null;
        if (rawQuery.moveToFirst()) {
            aW = rawQuery.getString(0);
        }
        rawQuery.close();
        return aW;
    }

    public boolean axH() {
        return false;
    }
}
