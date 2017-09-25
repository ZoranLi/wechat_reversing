package com.tencent.mm.plugin.appbrand.appstorage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.b.i;
import java.lang.reflect.Field;

public final class a extends i {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.uxd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "key";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.uxd.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "dataType";
        aVar.uxd.put("dataType", "TEXT");
        stringBuilder.append(" dataType TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "size";
        aVar.uxd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
