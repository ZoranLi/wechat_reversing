package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.e.b.dt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

final class g extends dt {
    protected static a gTP;

    g() {
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "disable";
        aVar.uxd.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "configId";
        aVar.uxd.put("configId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" configId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "configId";
        aVar.columns[2] = "configUrl";
        aVar.uxd.put("configUrl", "TEXT");
        stringBuilder.append(" configUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "configResources";
        aVar.uxd.put("configResources", "TEXT");
        stringBuilder.append(" configResources TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "configCrc32";
        aVar.uxd.put("configCrc32", "LONG");
        stringBuilder.append(" configCrc32 LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isFromXml";
        aVar.uxd.put("isFromXml", "INTEGER default 'false' ");
        stringBuilder.append(" isFromXml INTEGER default 'false' ");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
