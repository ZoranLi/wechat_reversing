package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.e.b.cb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends cb {
    static final a iFJ;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
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
        aVar.columns[2] = "launchAction";
        aVar.uxd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "jsapiInfo";
        aVar.uxd.put("jsapiInfo", "BLOB");
        stringBuilder.append(" jsapiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "hostInfo";
        aVar.uxd.put("hostInfo", "BLOB");
        stringBuilder.append(" hostInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionsheetInfo";
        aVar.uxd.put("actionsheetInfo", "BLOB");
        stringBuilder.append(" actionsheetInfo BLOB");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        iFJ = aVar;
    }

    protected final a sY() {
        return iFJ;
    }
}
