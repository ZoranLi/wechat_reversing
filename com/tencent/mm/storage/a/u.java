package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.cz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class u extends cz {
    protected static a gTP;

    protected final a sY() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.uxd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "key";
        aVar.columns[1] = "position";
        aVar.uxd.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public u(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        return stringBuilder.toString();
    }
}
