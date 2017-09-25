package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends bv {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrId";
        aVar.uxd.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "svrId";
        aVar.columns[1] = "isRead";
        aVar.uxd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "content";
        aVar.uxd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pushTime";
        aVar.uxd.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgType";
        aVar.uxd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "descUrl";
        aVar.uxd.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
