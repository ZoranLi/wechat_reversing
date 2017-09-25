package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private e iAL;

    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED
    }

    public b(e eVar) {
        super(eVar, a.gTP, "AppBrandKVData", null);
        this.iAL = eVar;
    }

    public final Object[] aA(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return new Object[]{a.MISSING_PARAMS};
        }
        c aVar = new a();
        aVar.field_key = u(str, str2, "__");
        if (super.b(aVar, new String[0])) {
            return new Object[]{a.NONE, aVar.field_data, aVar.field_dataType};
        }
        return new Object[]{a.NO_SUCH_KEY};
    }

    public final a e(String str, String str2, String str3, String str4) {
        Object obj = null;
        if (bg.mA(str) || bg.mA(str2)) {
            return a.MISSING_PARAMS;
        }
        String u = u(str, str2, "__");
        int length = (str3 == null ? 0 : str3.length()) + (str2 == null ? 0 : str2.length());
        int nK = length - nK(u);
        if (nJ(str) + nK >= g.oe(str)) {
            obj = 1;
        }
        if (obj != null) {
            return a.QUOTA_REACHED;
        }
        c aVar = new a();
        aVar.field_key = u;
        aVar.field_data = str3;
        aVar.field_dataType = str4;
        aVar.field_size = length;
        if (!super.a(aVar)) {
            return a.UNKNOWN;
        }
        T(str, nK);
        return a.NONE;
    }

    public final a aB(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return a.MISSING_PARAMS;
        }
        String u = u(str, str2, "__");
        T(str, -nK(u));
        c aVar = new a();
        aVar.field_key = u;
        super.a(aVar, new String[0]);
        return a.NONE;
    }

    public final void clear(String str) {
        super.eE("AppBrandKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandKVData", "key", str}));
    }

    public final Object[] nI(String str) {
        Cursor a = this.iAL.a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{(str + "__").replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0).replace(r9, ""));
        }
        a.close();
        int nJ = nJ(str);
        int oe = g.oe(str);
        return new Object[]{arrayList, Integer.valueOf(nJ), Integer.valueOf(oe)};
    }

    private int nJ(String str) {
        c aVar = new a();
        aVar.field_key = u(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        if (super.b(aVar, new String[0])) {
            return bg.getInt(aVar.field_data, 0);
        }
        return 0;
    }

    private int T(String str, int i) {
        int max = Math.max(0, nJ(str) + i);
        c aVar = new a();
        aVar.field_key = u(str, "@@@TOTAL@DATA@SIZE@@@", "++");
        aVar.field_data = String.valueOf(max);
        super.a(aVar);
        return max;
    }

    private int nK(String str) {
        Cursor a = this.iAL.a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    private static String u(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
