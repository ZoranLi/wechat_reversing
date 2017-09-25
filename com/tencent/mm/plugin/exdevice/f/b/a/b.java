package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.br;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends br {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.uxd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "score";
        aVar.uxd.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
