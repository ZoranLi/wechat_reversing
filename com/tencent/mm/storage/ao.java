package com.tencent.mm.storage;

import com.tencent.mm.e.b.bm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ao extends bm {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "originSvrId";
        aVar.uxd.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "originSvrId";
        aVar.columns[1] = "newMsgId";
        aVar.uxd.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "fromUserName";
        aVar.uxd.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUserName";
        aVar.uxd.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.uxd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "content";
        aVar.uxd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgSource";
        aVar.uxd.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "msgSeq";
        aVar.uxd.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "flag";
        aVar.uxd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.uxd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.uxd.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.uxd.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.uxd.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        aVar.columns[13] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
