package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mm.e.b.ea;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends ea {
    public static a izp;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.uxd.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "openDebug";
        aVar.uxd.put("openDebug", "INTEGER");
        stringBuilder.append(" openDebug INTEGER");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        izp = aVar;
    }

    protected final a sY() {
        return izp;
    }
}
