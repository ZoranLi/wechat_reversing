package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.dp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends dp {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pref_key";
        aVar.uxd.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "pref_key";
        aVar.columns[1] = "pref_title";
        aVar.uxd.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pref_url";
        aVar.uxd.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show";
        aVar.uxd.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
