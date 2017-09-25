package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends c {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.uxd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "username";
        aVar.columns[1] = "deeplink";
        aVar.uxd.put("deeplink", "TEXT default '' ");
        stringBuilder.append(" deeplink TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.uxd.put("title", "TEXT default '' ");
        stringBuilder.append(" title TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "iconurl";
        aVar.uxd.put("iconurl", "TEXT default '' ");
        stringBuilder.append(" iconurl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createtime";
        aVar.uxd.put("createtime", "LONG default '' ");
        stringBuilder.append(" createtime LONG default '' ");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
