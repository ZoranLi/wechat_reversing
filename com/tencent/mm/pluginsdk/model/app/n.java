package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.p;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends p {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "flag";
        aVar.uxd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "sortId";
        aVar.uxd.put("sortId", "INTEGER default '0' ");
        stringBuilder.append(" sortId INTEGER default '0' ");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
