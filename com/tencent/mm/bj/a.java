package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    private static final Pattern uLx = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    String arH;
    private String fPf = "";
    public boolean uLA = false;
    private boolean uLB = false;
    String uLC = "";
    e uLy;
    String uLz = "";

    public final String getError() {
        if (bg.mA(this.fPf) || bg.mA(this.uLC)) {
            return "";
        }
        if (!bg.mA(com.tencent.mm.sdk.e.a.getValue(this.uLC, "Reported"))) {
            return "";
        }
        com.tencent.mm.sdk.e.a.aa(this.uLC, "Reported", "true");
        return this.fPf;
    }

    private void eO(String str, String str2) {
        Set hashSet = new HashSet();
        String str3 = "";
        Cursor a = this.uLy.a("select * from " + str + " limit 1 ", null, 0);
        if (a.getCount() == 0) {
            a.close();
            return;
        }
        a.moveToFirst();
        for (int i = 0; i < a.getColumnCount(); i++) {
            hashSet.add(a.getColumnName(i));
        }
        a.close();
        a = this.uLy.a("PRAGMA table_info( " + str2 + " )", null, 0);
        String str4 = str3;
        while (a.moveToNext()) {
            str3 = a.getString(a.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        a.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.uLy.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
    }

    private boolean eP(String str, String str2) {
        Cursor a = this.uLy.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (a == null) {
            return false;
        }
        try {
            if (bg.mA(str2)) {
                this.uLy.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.uLy.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            this.uLy.beginTransaction();
            for (int i = 0; i < a.getCount(); i++) {
                int count;
                a.moveToPosition(i);
                Cursor a2 = this.uLy.a("select * from old.sqlite_master where tbl_name = '" + a.getString(0) + "'", null, 0);
                if (a2 != null) {
                    count = a2.getCount();
                    a2.close();
                } else {
                    count = 0;
                }
                if (count == 0) {
                    w.w("MicroMsg.DBInit", "In old db not found :" + a.getString(0));
                } else {
                    try {
                        eO("old." + a.getString(0), a.getString(0));
                    } catch (Exception e) {
                        w.w("MicroMsg.DBInit", "Insertselect FAILED :" + a.getString(0));
                    }
                }
            }
            this.uLy.endTransaction();
            a.close();
            this.uLy.execSQL("DETACH DATABASE old;");
            return true;
        } catch (SQLiteDatabaseCorruptException e2) {
            w.e("MicroMsg.DBInit", "Attached database is corrupted: " + str);
            FileOp.deleteFile(str);
            throw e2;
        }
    }

    public final boolean a(String str, HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.uLy != null) {
            this.uLy.close();
            this.uLy = null;
        }
        try {
            w.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.valueOf(z), Boolean.valueOf(e.aO(str)), str);
            this.uLy = e.aQ(str, z2);
            if (!e.aO(str)) {
                z3 = true;
            }
            a(hashMap, z, z3);
            return true;
        } catch (SQLiteException e) {
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, c> hashMap, boolean z) {
        Object obj;
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !bg.mA(str2));
        this.uLC = str2 + ".errreport";
        if (this.uLy != null) {
            this.uLy.close();
            this.uLy = null;
        }
        boolean aO = e.aO(str2);
        boolean aO2 = e.aO(str);
        boolean aO3 = e.aO(str3);
        Object obj2 = (aO || !aO2) ? null : 1;
        this.uLA = a(str2, j, str4, e.bNM(), str3);
        String str5 = "MicroMsg.DBInit";
        String str6 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(aO);
        objArr[2] = Boolean.valueOf(aO2);
        objArr[3] = Boolean.valueOf(true);
        objArr[4] = Boolean.valueOf(this.uLA);
        objArr[5] = Boolean.valueOf(this.uLy != null);
        objArr[6] = Thread.currentThread().getName();
        w.i(str5, str6, objArr);
        if (this.uLy == null || this.uLy.getPath().equals(str3) || !aO3) {
            obj = null;
        } else {
            obj = 1;
            w.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        a(hashMap, z, this.uLB);
        if (!aO2 && !aO3) {
            return true;
        }
        if (obj != null) {
            this.arH = g.n((str4 + j).getBytes()).substring(0, 7);
            eQ(str3, this.arH);
        }
        if (obj2 != null) {
            System.currentTimeMillis();
            boolean eQ = eQ(str, "");
            System.currentTimeMillis();
            return eQ;
        } else if (this.uLy != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean eQ(String str, String str2) {
        if (eP(str, str2)) {
            w.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            w.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(b.deleteFile(str)));
            return true;
        }
        w.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        return false;
    }

    private static void a(e eVar) {
        Cursor rawQueryWithFactory = (eVar.uLH != null ? eVar.uLH : eVar.uLI).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            return;
        }
        throw new SQLiteException("Cannot get count for sqlite_master");
    }

    private boolean a(String str, long j, String str2, boolean z, String str3) {
        Object obj;
        if (this.uLy != null) {
            throw new AssertionError();
        }
        this.arH = g.n((str2 + j).getBytes()).substring(0, 7);
        this.uLB = !FileOp.aO(str);
        try {
            this.uLy = e.r(str, this.arH, z);
            a(this.uLy);
            return true;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseCorruptException) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String deviceID = p.getDeviceID(ab.getContext());
                if (!(deviceID == null || deviceID.equals(str2))) {
                    obj = null;
                    String substring = g.n((deviceID + j).getBytes()).substring(0, 7);
                    try {
                        this.uLy = e.r(str, substring, z);
                        a(this.uLy);
                        this.arH = substring;
                        k.rj().set(258, deviceID);
                        com.tencent.mm.plugin.report.c.oTb.a(181, 5, 1, false);
                        return true;
                    } catch (SQLiteException e2) {
                        if (e2 instanceof SQLiteDatabaseCorruptException) {
                            obj = 1;
                        }
                        com.tencent.mm.plugin.report.c.oTb.a(181, (long) (z ? 42 : 41), 1, true);
                        e.Ss(str);
                        try {
                            this.uLy = e.r(str, this.arH, z);
                            a(this.uLy);
                            this.uLB = true;
                            com.tencent.mm.plugin.report.c.oTb.a(181, 6, 1, false);
                            return true;
                        } catch (SQLiteException e3) {
                            com.tencent.mm.plugin.report.c.oTb.a(181, 7, 1, false);
                            if (this.uLy != null) {
                                this.uLy.close();
                                this.uLy = null;
                            }
                            this.arH = null;
                            return false;
                        }
                    }
                }
                if (this.uLy == null && r2 != null) {
                    if (z) {
                    }
                    com.tencent.mm.plugin.report.c.oTb.a(181, (long) (z ? 42 : 41), 1, true);
                    e.Ss(str);
                    this.uLy = e.r(str, this.arH, z);
                    a(this.uLy);
                    this.uLB = true;
                    com.tencent.mm.plugin.report.c.oTb.a(181, 6, 1, false);
                    return true;
                }
            } else if (str3 != null && str3.length() > 0) {
                this.uLB = !FileOp.aO(str3);
                try {
                    this.uLy = e.r(str3, this.arH, z);
                    a(this.uLy);
                    com.tencent.mm.plugin.report.c.oTb.a(181, 6, 1, false);
                    return true;
                } catch (SQLiteException e4) {
                    com.tencent.mm.plugin.report.c.oTb.a(181, 7, 1, false);
                    if (this.uLy != null) {
                        this.uLy.close();
                        this.uLy = null;
                    }
                    this.arH = null;
                    return false;
                }
            }
            if (this.uLy != null) {
                this.uLy.close();
                this.uLy = null;
            }
            this.arH = null;
            return false;
        }
    }

    private boolean a(HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        int i;
        int i2;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        w.d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.uLz = this.uLy.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (c cVar : hashMap.values()) {
                    if (cVar.pP() == null) {
                        w.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", cVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + cVar.getClass().toString(), false);
                    }
                    for (String hashCode : cVar.pP()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.n(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.e.a.getValue(this.uLz, "createmd5");
                if (!bg.mA(str) && str3.equals(str)) {
                    w.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.uLy.getPath());
                    return true;
                }
            }
        }
        str = str3;
        this.uLy.execSQL("pragma auto_vacuum = 0 ");
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        this.uLy.beginTransaction();
        if (hashMap != null) {
            i2 = 0;
            for (c pP : hashMap.values()) {
                i = i2;
                for (String str4 : pP.pP()) {
                    try {
                        this.uLy.execSQL(str4);
                        i++;
                    } catch (Exception e) {
                        Matcher matcher = uLx.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            w.w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                i2 = i;
            }
        } else {
            i2 = 0;
        }
        long se = aVar.se();
        this.uLy.endTransaction();
        w.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(se), Long.valueOf(aVar.se()), Integer.valueOf(i2));
        if (z) {
            com.tencent.mm.sdk.e.a.aa(this.uLz, "createmd5", str);
        }
        return true;
    }
}
