package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.e.b.aa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends aa {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.uxd.put("canvasId", "LONG PRIMARY KEY ");
        stringBuilder.append(" canvasId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.uxd.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
