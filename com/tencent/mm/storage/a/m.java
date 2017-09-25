package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.at;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends at {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.uxd.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "productID";
        aVar.columns[1] = "content";
        aVar.uxd.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return null;
    }
}
