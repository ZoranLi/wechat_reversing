package com.tencent.mm.plugin.appbrand.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class j extends com.tencent.mm.sdk.e.j {
    public static final String[] iCe = new String[]{i.a(a.izp, "AppBrandLauncherLayoutItem")};
    final b iCu;
    public final c iCv = new c(this);
    public final g izH;

    private static final class b extends i<a> {
        b(e eVar) {
            super(eVar, a.izp, "AppBrandLauncherLayoutItem", a.gaK);
        }
    }

    public final class c {
        public final /* synthetic */ j iCw;

        public c(j jVar) {
            this.iCw = jVar;
        }

        public final ArrayList<e> Rl() {
            return f(Long.MAX_VALUE, 30);
        }

        public final ArrayList<e> f(long j, int i) {
            return j.c(this.iCw.izH.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
        }
    }

    static final class a extends com.tencent.mm.e.b.j {
        static final String[] iCl = new String[]{"brandId", "versionType", "scene"};
        static final com.tencent.mm.sdk.e.c.a izp;

        a() {
        }

        protected final com.tencent.mm.sdk.e.c.a sY() {
            return izp;
        }

        public final ContentValues pv() {
            this.uxb = 0;
            ContentValues pv = super.pv();
            int r = j.r(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = r;
            pv.put("recordId", Integer.valueOf(r));
            return pv;
        }

        static {
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.hXH = new Field[5];
            aVar.columns = new String[6];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "recordId";
            aVar.uxd.put("recordId", "INTEGER PRIMARY KEY ");
            stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
            stringBuilder.append(", ");
            aVar.uxc = "recordId";
            aVar.columns[1] = "brandId";
            aVar.uxd.put("brandId", "TEXT");
            stringBuilder.append(" brandId TEXT");
            stringBuilder.append(", ");
            aVar.columns[2] = "versionType";
            aVar.uxd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[3] = "updateTime";
            aVar.uxd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            aVar.columns[4] = "scene";
            aVar.uxd.put("scene", "INTEGER");
            stringBuilder.append(" scene INTEGER");
            aVar.columns[5] = "rowid";
            aVar.uxe = stringBuilder.toString();
            izp = aVar;
        }
    }

    public j(g gVar) {
        this.izH = gVar;
        this.iCu = new b(gVar);
    }

    public final void c(com.tencent.mm.sdk.e.j.a aVar) {
        a(aVar, d.vL().nJF.getLooper());
    }

    public final boolean V(String str, int i) {
        boolean z = true;
        if (bg.mA(str)) {
            return false;
        }
        Cursor a = this.izH.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (a == null) {
            return false;
        }
        if (!a.moveToFirst()) {
            z = false;
        } else if (a.getInt(0) <= 0) {
            z = false;
        }
        a.close();
        return z;
    }

    final Cursor a(String[] strArr, int i, int i2) {
        return this.izH.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
    }

    public static ArrayList<e> c(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList<e> arrayList;
        if (cursor.moveToFirst()) {
            Collection linkedList = new LinkedList();
            a aVar = new a();
            do {
                aVar.b(cursor);
                if (!bg.mA(aVar.field_brandId)) {
                    linkedList.add(p.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
        } else {
            arrayList = new ArrayList();
        }
        cursor.close();
        return arrayList;
    }

    public final ArrayList<e> Rj() {
        return c(a(null, m.CTRL_INDEX, 0));
    }

    public final e nS(String str) {
        e eVar = null;
        if (!bg.mA(str)) {
            Cursor query = this.izH.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    a aVar = new a();
                    aVar.b(query);
                    if (!bg.mA(aVar.field_brandId)) {
                        eVar = p.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime);
                    }
                }
                query.close();
            }
        }
        return eVar;
    }

    public final List<String> nT(String str) {
        List<String> linkedList = new LinkedList();
        if (!bg.mA(str)) {
            Cursor query = this.izH.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, boolean z, boolean z2, int i2, int i3) {
        if (bg.mA(str) || 999 == i) {
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor a = this.izH.a(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long max = Math.max(j + 1, bg.Ny());
        int r = r(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.izH.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(r)}) > 0 ? 1 : null;
        if (obj != null) {
            a("single", 3, String.valueOf(r));
        }
        if (obj == null) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i;
            boolean a2 = a(aVar);
            if (a2) {
                a("single", 2, String.valueOf(r));
            }
            z3 = a2;
            z4 = a2;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z) {
            new m(i2, z2, i, 2, 1, str, i3).BC();
        }
        if (z3) {
            Rk();
        }
        return z4;
    }

    private void Rk() {
        int i;
        int i2 = 0;
        Cursor a = this.izH.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            i = 0;
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        }
        if (i > m.CTRL_INDEX) {
            a = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, m.CTRL_INDEX);
            if (a != null) {
                List<String> linkedList = new LinkedList();
                List arrayList = new ArrayList(i - 200);
                List arrayList2 = new ArrayList(i - 200);
                if (a.moveToFirst()) {
                    do {
                        linkedList.add(String.valueOf(a.getInt(0)));
                        arrayList.add(a.getString(1));
                        arrayList2.add(Integer.valueOf(a.getInt(2)));
                    } while (a.moveToNext());
                }
                a.close();
                if (!bg.bV(linkedList)) {
                    String on;
                    long cs = this.izH.cs(Thread.currentThread().getId());
                    for (String on2 : linkedList) {
                        this.izH.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{on2});
                    }
                    this.izH.aD(cs);
                    List arrayList3 = new ArrayList(arrayList.size());
                    List arrayList4 = new ArrayList(arrayList.size());
                    while (i2 < arrayList.size()) {
                        on2 = p.on((String) arrayList.get(i2));
                        if (!bg.mA(on2)) {
                            arrayList3.add(on2);
                            arrayList4.add(arrayList2.get(i2));
                        }
                        i2++;
                    }
                    if (com.tencent.mm.plugin.appbrand.app.c.PY() != null) {
                        com.tencent.mm.plugin.appbrand.app.c.PY().d(arrayList3, arrayList4);
                    }
                    a("batch", 5, linkedList);
                }
            }
        }
    }

    public final boolean a(String str, int i, boolean z, int i2, int i3) {
        boolean a = a(str, i, true, z, i2, i3);
        if (a) {
            a.QM();
        }
        return a;
    }

    final boolean a(a aVar) {
        if (bg.mA(aVar.field_brandId)) {
            return false;
        }
        long insert = this.izH.insert("AppBrandLauncherLayoutItem", "", aVar.pv());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            return true;
        }
        return false;
    }

    public static int r(String str, int i, int i2) {
        return String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
    }
}
