package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends bw {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "countryCode";
        aVar.uxd.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "countryCode";
        aVar.columns[1] = "callTimeCount";
        aVar.uxd.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "lastCallTime";
        aVar.uxd.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
