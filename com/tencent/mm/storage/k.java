package com.tencent.mm.storage;

import com.tencent.mm.e.b.r;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends r {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgListDataId";
        aVar.uxd.put("msgListDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgListDataId";
        aVar.columns[1] = "sessionName";
        aVar.uxd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
