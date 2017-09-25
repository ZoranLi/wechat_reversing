package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.t;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class a extends t {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatId";
        aVar.uxd.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "bizChatId";
        aVar.columns[1] = "brandUserName";
        aVar.uxd.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "unReadCount";
        aVar.uxd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "newUnReadCount";
        aVar.uxd.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastMsgID";
        aVar.uxd.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "lastMsgTime";
        aVar.uxd.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.uxd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "digest";
        aVar.uxd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "digestUser";
        aVar.uxd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "atCount";
        aVar.uxd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "editingMsg";
        aVar.uxd.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatType";
        aVar.uxd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "isSend";
        aVar.uxd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgType";
        aVar.uxd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "msgCount";
        aVar.uxd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "flag";
        aVar.uxd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        aVar.columns[17] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
