package com.tencent.mm.storage;

import com.tencent.mm.e.b.dh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bd extends dh {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.uxd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "openId";
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public bd(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }
}
