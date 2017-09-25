package com.tencent.mm.plugin.report.a;

import com.tencent.mm.e.b.al;
import java.lang.reflect.Field;

public final class a extends al {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bakLogId";
        aVar.uxd.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "valueStr";
        aVar.uxd.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
