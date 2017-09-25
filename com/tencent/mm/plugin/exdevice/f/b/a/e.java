package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bq {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.uxd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.uxd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "timestamp";
        aVar.uxd.put("timestamp", "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "liketips";
        aVar.uxd.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
