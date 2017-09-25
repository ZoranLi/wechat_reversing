package com.tencent.mm.storage;

import com.tencent.mm.e.b.dj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;

public final class bf extends dj {
    protected static a gTP;

    protected final a sY() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "cmsgId";
        aVar.uxd.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "content";
        aVar.uxd.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public final void Sa(String str) {
        if (!bg.mA(str)) {
            this.field_cmsgId = str;
        }
    }
}
