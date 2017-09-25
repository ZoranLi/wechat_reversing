package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.b.am;
import java.lang.reflect.Field;

public final class a extends am {
    public static com.tencent.mm.sdk.e.c.a izp;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.uxd.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cacheKey";
        aVar.uxd.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.uxd.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "interval";
        aVar.uxd.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        izp = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return izp;
    }
}
