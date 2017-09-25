package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mm.e.b.cc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends cc {
    public static final a iFJ;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.uxd.put("appIdHash", "INTEGER");
        stringBuilder.append(" appIdHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pkgType";
        aVar.uxd.put("pkgType", "INTEGER");
        stringBuilder.append(" pkgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "widgetType";
        aVar.uxd.put("widgetType", "INTEGER");
        stringBuilder.append(" widgetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "launchAction";
        aVar.uxd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "jsApiInfo";
        aVar.uxd.put("jsApiInfo", "BLOB");
        stringBuilder.append(" jsApiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "versionInfo";
        aVar.uxd.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        iFJ = aVar;
    }

    protected final a sY() {
        return iFJ;
    }
}
