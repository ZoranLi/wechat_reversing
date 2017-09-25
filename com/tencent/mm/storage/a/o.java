package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class o extends au {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "prodcutID";
        aVar.uxd.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "prodcutID";
        aVar.columns[1] = "totalCount";
        aVar.uxd.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "continuCount";
        aVar.uxd.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "flag";
        aVar.uxd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "modifyTime";
        aVar.uxd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "showTipsTime";
        aVar.uxd.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "setFlagTime";
        aVar.uxd.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return null;
    }
}
