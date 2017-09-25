package com.tencent.mm.plugin.order.b;

import com.tencent.mm.e.b.ck;
import java.lang.reflect.Field;

public final class a extends ck {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "msgContentXml";
        aVar.uxd.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.uxd.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
