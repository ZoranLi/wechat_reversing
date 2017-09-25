package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.e.b.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends cp {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "transferId";
        aVar.uxd.put("transferId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" transferId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "transferId";
        aVar.columns[1] = "locaMsgId";
        aVar.uxd.put("locaMsgId", "LONG");
        stringBuilder.append(" locaMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveStatus";
        aVar.uxd.put("receiveStatus", "INTEGER default '-1' ");
        stringBuilder.append(" receiveStatus INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "isSend";
        aVar.uxd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
