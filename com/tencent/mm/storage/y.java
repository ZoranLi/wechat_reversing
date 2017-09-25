package com.tencent.mm.storage;

import com.tencent.mm.e.b.ag;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends ag {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.uxd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "username";
        aVar.columns[1] = "cmdbuf";
        aVar.uxd.put("cmdbuf", "BLOB default '' ");
        stringBuilder.append(" cmdbuf BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
