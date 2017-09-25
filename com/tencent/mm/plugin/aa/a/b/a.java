package com.tencent.mm.plugin.aa.a.b;

import java.lang.reflect.Field;

public final class a extends com.tencent.mm.e.b.a {
    public static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "payMsgId";
        aVar.uxd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "payMsgId";
        aVar.columns[1] = "insertmsg";
        aVar.uxd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "chatroom";
        aVar.uxd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgId";
        aVar.uxd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
