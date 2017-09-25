package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class i<T extends c> extends j implements d<T> {
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final e gUz;
    public final a uxf;
    private final String uxg;

    public i(e eVar, a aVar, String str, String[] strArr) {
        int i = 0;
        this.gUz = eVar;
        this.uxf = aVar;
        this.uxf.uxc = bg.mA(this.uxf.uxc) ? "rowid" : this.uxf.uxc;
        this.uxg = str;
        List a = a(this.uxf, getTableName(), this.gUz);
        for (int i2 = 0; i2 < a.size(); i2++) {
            this.gUz.eE(this.uxg, (String) a.get(i2));
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.gUz.eE(this.uxg, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.uxg;
    }

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.uxe);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, e eVar) {
        List<String> arrayList = new ArrayList();
        if (eVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            w.e(str2, str3, objArr);
            return arrayList;
        }
        Cursor a = eVar.a("PRAGMA table_info( " + str + " )", new String[0], 2);
        if (a == null) {
            return arrayList;
        }
        Map hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex(Columns.TYPE);
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        for (Entry entry : aVar.uxd.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    w.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    public final boolean eE(String str, String str2) {
        if (str.length() == 0) {
            Qt("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.gUz.eE(str, str2);
        } else {
            Qt("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public boolean a(T t, boolean z) {
        ContentValues pv = t.pv();
        if (pv == null || pv.size() <= 0) {
            Qt("insert failed, value.size <= 0");
            return false;
        }
        t.uxb = this.gUz.insert(getTableName(), this.uxf.uxc, pv);
        if (t.uxb <= 0) {
            Qt("insert failed");
            return false;
        }
        pv.put("rowid", Long.valueOf(t.uxb));
        if (z) {
            Qr(pv.getAsString(this.uxf.uxc));
        }
        return true;
    }

    public boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues pv = t.pv();
        if (pv == null || pv.size() <= 0) {
            Qt("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Qs("delete with primary key");
            if (this.gUz.delete(getTableName(), this.uxf.uxc + " = ?", new String[]{bg.mz(pv.getAsString(this.uxf.uxc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(pv, strArr);
            if (a == null) {
                Qt("delete failed, check keys failed");
                return false;
            } else if (this.gUz.delete(getTableName(), a.toString(), a(strArr, pv)) <= 0 || !z) {
                Qt("delete failed");
                return false;
            } else {
                Qr(this.uxf.uxc);
                return true;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.gUz.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        }
        return z;
    }

    public final boolean b(long j, T t) {
        Cursor a = this.gUz.a(getTableName(), this.uxf.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.b(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues pv = t.pv();
        if (pv == null || pv.size() <= 0) {
            Qt("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Qs("get with primary key");
            r0 = this.gUz.a(getTableName(), this.uxf.columns, this.uxf.uxc + " = ?", new String[]{bg.mz(pv.getAsString(this.uxf.uxc))}, null, null, null, 2);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            return false;
        } else {
            StringBuilder a = a(pv, strArr);
            if (a == null) {
                Qt("get failed, check keys failed");
                return false;
            }
            r0 = this.gUz.a(getTableName(), this.uxf.columns, a.toString(), a(strArr, pv), null, null, null, 2);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            Qs("get failed, not found");
            return false;
        }
    }

    public boolean a(long j, T t) {
        ContentValues pv = t.pv();
        if (pv == null || pv.size() <= 0) {
            Qt("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.gUz.query(getTableName(), this.uxf.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(pv, query)) {
            query.close();
            Qs("no need replace , fields no change");
            return true;
        }
        query.close();
        boolean z = this.gUz.update(getTableName(), pv, "rowid = ?", new String[]{String.valueOf(j)}) > 0;
        if (!z) {
            return z;
        }
        doNotify();
        return z;
    }

    public boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues pv = t.pv();
        if (pv == null || pv.size() <= 0) {
            Qt("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Qs("update with primary key");
            if (b(pv)) {
                Qs("no need replace , fields no change");
                return true;
            }
            if (this.gUz.update(getTableName(), pv, this.uxf.uxc + " = ?", new String[]{bg.mz(pv.getAsString(this.uxf.uxc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(pv, strArr);
            if (a == null) {
                Qt("update failed, check keys failed");
                return false;
            } else if (this.gUz.update(getTableName(), pv, a.toString(), a(strArr, pv)) > 0) {
                if (z) {
                    Qr(pv.getAsString(this.uxf.uxc));
                }
                return true;
            } else {
                Qt("update failed");
                return false;
            }
        }
    }

    public boolean c(T t, String... strArr) {
        return a((c) t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !bg.mA(this.uxf.uxc));
        ContentValues pv = t.pv();
        if (pv != null) {
            int i;
            int size = pv.size();
            int length = t.sY().hXH.length;
            if (pv.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (b(pv)) {
                    Qs("no need replace , fields no change");
                    return true;
                } else if (this.gUz.replace(getTableName(), this.uxf.uxc, pv) > 0) {
                    Qr(this.uxf.uxc);
                    return true;
                } else {
                    Qt("replace failed");
                    return false;
                }
            }
        }
        Qt("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean b(ContentValues contentValues) {
        Cursor query = this.gUz.query(getTableName(), this.uxf.columns, this.uxf.uxc + " = ?", new String[]{bg.mz(contentValues.getAsString(this.uxf.uxc))}, null, null, null);
        boolean a = c.a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor Kk() {
        return this.gUz.query(getTableName(), this.uxf.columns, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.gUz.rawQuery(str, strArr);
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = bg.mz(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void Qs(String str) {
        w.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void Qt(String str) {
        w.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }
}
