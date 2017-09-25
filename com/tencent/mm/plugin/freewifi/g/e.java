package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.b.bg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bg {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.uxd.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = SlookAirButtonFrequentContactAdapter.ID;
        aVar.columns[1] = "protocolNumber";
        aVar.uxd.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "logContent";
        aVar.uxd.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
