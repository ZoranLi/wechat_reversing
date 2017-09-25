package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bo;
import java.lang.reflect.Field;

public final class a extends bo {
    public static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "championUrl";
        aVar.uxd.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "championMotto";
        aVar.uxd.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
