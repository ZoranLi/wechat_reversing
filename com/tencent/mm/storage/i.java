package com.tencent.mm.storage;

import com.tencent.mm.e.b.q;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends q {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceId";
        aVar.uxd.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "sessionName";
        aVar.uxd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "moveTime";
        aVar.uxd.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
