package com.tencent.mm.modelbiz;

import com.tencent.mm.e.b.z;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends z {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.uxd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "openId";
        aVar.columns[1] = "brandUsername";
        aVar.uxd.put("brandUsername", "TEXT default '' ");
        stringBuilder.append(" brandUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "headImgUrl";
        aVar.uxd.put("headImgUrl", "TEXT");
        stringBuilder.append(" headImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.uxd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "kfType";
        aVar.uxd.put("kfType", "INTEGER");
        stringBuilder.append(" kfType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public f(String str, String str2, String str3, String str4, int i, long j) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i;
        this.field_updateTime = j;
    }
}
