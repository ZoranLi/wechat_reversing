package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.b.co;
import com.tencent.mm.plugin.record.a.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class k extends co implements a {
    protected static c.a gTP;

    static {
        c.a aVar = new c.a();
        aVar.hXH = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "localId";
        aVar.columns[1] = "msgId";
        aVar.uxd.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "oriMsgId";
        aVar.uxd.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUser";
        aVar.uxd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "desc";
        aVar.uxd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "dataProto";
        aVar.uxd.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "favFrom";
        aVar.uxd.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        aVar.columns[10] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final c.a sY() {
        return gTP;
    }

    public final int aWC() {
        return this.field_localId;
    }
}
