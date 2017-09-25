package com.tencent.mm.av;

import com.tencent.mm.e.b.aw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class f extends aw {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgContent";
        aVar.uxd.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "isSend";
        aVar.uxd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "talker";
        aVar.uxd.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "encryptTalker";
        aVar.uxd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "svrId";
        aVar.uxd.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.uxd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatroomName";
        aVar.uxd.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        aVar.columns[8] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean Kp() {
        return this.field_isSend % 2 == 0;
    }
}
