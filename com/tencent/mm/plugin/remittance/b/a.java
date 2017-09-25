package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.e.b.ak;
import java.lang.reflect.Field;

public final class a extends ak {
    public static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "transferId";
        aVar.uxd.put("transferId", "TEXT");
        stringBuilder.append(" transferId TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
