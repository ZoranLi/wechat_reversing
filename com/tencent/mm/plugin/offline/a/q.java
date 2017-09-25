package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.e.b.ci;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class q extends ci {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqkey";
        aVar.uxd.put("reqkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "reqkey";
        aVar.columns[1] = "ack_key";
        aVar.uxd.put("ack_key", "TEXT");
        stringBuilder.append(" ack_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "receive_time";
        aVar.uxd.put("receive_time", "LONG");
        stringBuilder.append(" receive_time LONG");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
