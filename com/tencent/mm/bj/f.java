package com.tencent.mm.bj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class f implements e {
    public static String uLT = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean sDZ;
    public g uLS;
    public Map<String, h> uLU;
    public Queue<a> uLV;
    public e uLy;

    public interface a {
        int a(f fVar);

        String getTableName();
    }

    public final boolean bKn() {
        if (this.uLy != null && this.uLy.isOpen()) {
            return false;
        }
        w.e("MicroMsg.MemoryStorage", "memory db is close [%s]", uLT);
        return true;
    }

    public final int St(String str) {
        String str2 = null;
        if (!this.sDZ) {
            return -4;
        }
        if (this.uLS == null || this.uLS.inTransaction()) {
            w.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            return -3;
        }
        try {
            if (e.a(this.uLy, str)) {
                this.uLy.execSQL("drop table " + str);
                w.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
            }
            Cursor a = this.uLS.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
            if (a != null) {
                if (a.getCount() == 1) {
                    a.moveToFirst();
                    str2 = a.getString(0);
                }
                a.close();
            }
            if (str2 == null) {
                w.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                return -1;
            }
            this.uLy.execSQL(str2);
            this.uLy.execSQL("insert into " + str + " select * from old." + str);
            w.d("MicroMsg.MemoryStorage", "copy table %s success", str);
            return 0;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.uLU.containsKey(str));
        if (this.uLy == null || !this.uLy.isOpen()) {
            w.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, uLT);
            if (this.uLS == null || !this.uLS.isOpen()) {
                return -1;
            }
            return this.uLS.delete(str, str2, strArr);
        }
        h hVar = (h) this.uLU.get(str);
        com.tencent.mm.bj.h.a aVar = new com.tencent.mm.bj.h.a();
        aVar.uvg = 5;
        aVar.uMm = str2;
        aVar.G(strArr);
        hVar.a(aVar);
        return this.uLy.delete(str, str2, strArr);
    }

    public final boolean eE(String str, String str2) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.uLU.containsKey(str));
        if (this.uLy == null || !this.uLy.isOpen()) {
            w.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, uLT);
            if (this.uLS == null || !this.uLS.isOpen()) {
                return false;
            }
            this.uLS.eE(str2, str);
            return true;
        }
        h hVar = (h) this.uLU.get(str);
        com.tencent.mm.bj.h.a aVar = new com.tencent.mm.bj.h.a();
        aVar.uvg = 1;
        aVar.uxe = str2;
        hVar.a(aVar);
        this.uLy.execSQL(str2);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.uLU.containsKey(str));
        if (this.uLy == null || !this.uLy.isOpen()) {
            w.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, uLT);
            if (this.uLS == null || !this.uLS.isOpen()) {
                return -1;
            }
            return this.uLS.insert(str, str2, contentValues);
        }
        h hVar = (h) this.uLU.get(str);
        com.tencent.mm.bj.h.a aVar = new com.tencent.mm.bj.h.a();
        aVar.uvg = 2;
        aVar.uxc = str2;
        aVar.values = new ContentValues(contentValues);
        hVar.a(aVar);
        return this.uLy.insert(str, str2, contentValues);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.uLU.containsKey(str));
        if (this.uLy == null || !this.uLy.isOpen()) {
            w.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, uLT);
            if (this.uLS == null || !this.uLS.isOpen()) {
                return -1;
            }
            return this.uLS.replace(str, str2, contentValues);
        }
        h hVar = (h) this.uLU.get(str);
        com.tencent.mm.bj.h.a aVar = new com.tencent.mm.bj.h.a();
        aVar.uvg = 4;
        aVar.uxc = str2;
        aVar.values = new ContentValues(contentValues);
        hVar.a(aVar);
        return this.uLy.replace(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.uLU.containsKey(str));
        if (this.uLy == null || !this.uLy.isOpen()) {
            w.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, uLT);
            if (this.uLS == null || !this.uLS.isOpen()) {
                return -1;
            }
            return this.uLS.update(str, contentValues, str2, strArr);
        }
        h hVar = (h) this.uLU.get(str);
        com.tencent.mm.bj.h.a aVar = new com.tencent.mm.bj.h.a();
        aVar.uvg = 3;
        aVar.uMm = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.G(strArr);
        hVar.a(aVar);
        return this.uLy.update(str, contentValues, str2, strArr);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.uLy != null && this.uLy.isOpen()) {
            return this.uLy.a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        }
        w.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, uLT);
        return c.bNI();
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        return query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.uLy != null && this.uLy.isOpen()) {
            return this.uLy.a(str, strArr, 0);
        }
        w.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, uLT);
        return c.bNI();
    }

    public final Cursor a(String str, String[] strArr, int i) {
        return rawQuery(str, strArr);
    }
}
