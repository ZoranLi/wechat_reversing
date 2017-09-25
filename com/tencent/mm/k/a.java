package com.tencent.mm.k;

import com.tencent.mm.e.b.aj;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class a extends aj {
    public static com.tencent.mm.sdk.e.c.a gTP;
    public static final String gTS = null;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgCount";
        aVar.uxd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.uxd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "username";
        aVar.columns[2] = "unReadCount";
        aVar.uxd.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatmode";
        aVar.uxd.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isSend";
        aVar.uxd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "conversationTime";
        aVar.uxd.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "content";
        aVar.uxd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "msgType";
        aVar.uxd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "customNotify";
        aVar.uxd.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showTips";
        aVar.uxd.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "flag";
        aVar.uxd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "digest";
        aVar.uxd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "digestUser";
        aVar.uxd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hasTrunc";
        aVar.uxd.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "parentRef";
        aVar.uxd.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrflag";
        aVar.uxd.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "editingMsg";
        aVar.uxd.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "atCount";
        aVar.uxd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "sightTime";
        aVar.uxd.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "unReadMuteCount";
        aVar.uxd.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "lastSeq";
        aVar.uxd.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[22] = "UnDeliverCount";
        aVar.uxd.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "UnReadInvite";
        aVar.uxd.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "firstUnDeliverSeq";
        aVar.uxd.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.columns[25] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public a(String str) {
        setUsername(str);
    }

    public final void eB(int i) {
        dy(this.field_attrflag | i);
    }

    public final boolean eC(int i) {
        return (this.field_attrflag & i) != 0;
    }
}
