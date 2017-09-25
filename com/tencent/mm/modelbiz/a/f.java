package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.v;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends v {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "brandUserName";
        aVar.uxd.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "brandUserName";
        aVar.columns[1] = "userId";
        aVar.uxd.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
