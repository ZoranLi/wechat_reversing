package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.e.b.du;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends du {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "host";
        aVar.uxd.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "expireTime";
        aVar.uxd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
