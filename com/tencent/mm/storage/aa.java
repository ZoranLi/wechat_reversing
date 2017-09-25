package com.tencent.mm.storage;

import com.tencent.mm.e.b.ai;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class aa extends ai {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelId";
        aVar.uxd.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "contactName";
        aVar.uxd.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
