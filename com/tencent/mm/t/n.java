package com.tencent.mm.t;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public class n extends ce {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.uxd.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isSend";
        aVar.uxd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "isShowTimer";
        aVar.uxd.put("isShowTimer", "INTEGER");
        stringBuilder.append(" isShowTimer INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "talker";
        aVar.uxd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.uxd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgPath";
        aVar.uxd.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved";
        aVar.uxd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "lvbuffer";
        aVar.uxd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "talkerId";
        aVar.uxd.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "transContent";
        aVar.uxd.put("transContent", "TEXT default '' ");
        stringBuilder.append(" transContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "transBrandWording";
        aVar.uxd.put("transBrandWording", "TEXT default '' ");
        stringBuilder.append(" transBrandWording TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "bizClientMsgId";
        aVar.uxd.put("bizClientMsgId", "TEXT default '' ");
        stringBuilder.append(" bizClientMsgId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "bizChatId";
        aVar.uxd.put("bizChatId", "LONG default '-1' ");
        stringBuilder.append(" bizChatId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "bizChatUserId";
        aVar.uxd.put("bizChatUserId", "TEXT default '' ");
        stringBuilder.append(" bizChatUserId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "msgSeq";
        aVar.uxd.put("msgSeq", "LONG");
        stringBuilder.append(" msgSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "flag";
        aVar.uxd.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
