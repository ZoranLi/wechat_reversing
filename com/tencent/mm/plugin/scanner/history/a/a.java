package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.mm.e.b.cs;
import java.lang.reflect.Field;

public final class a extends cs {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productId";
        aVar.uxd.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "productId";
        aVar.columns[1] = "xmlContent";
        aVar.uxd.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "ScanTime";
        aVar.uxd.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "funcType";
        aVar.uxd.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "qrcodeUrl";
        aVar.uxd.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "scene";
        aVar.uxd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
