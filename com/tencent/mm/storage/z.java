package com.tencent.mm.storage;

import com.tencent.mm.e.b.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends ah {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelID";
        aVar.uxd.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "labelID";
        aVar.columns[1] = "labelName";
        aVar.uxd.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "labelPYFull";
        aVar.uxd.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "labelPYShort";
        aVar.uxd.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isTemporary";
        aVar.uxd.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
