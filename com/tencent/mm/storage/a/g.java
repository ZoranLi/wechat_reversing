package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.aq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends aq {
    protected static a gTP;

    public g(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    protected final a sY() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "groupID";
        aVar.uxd.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "desc";
        aVar.uxd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }
}
