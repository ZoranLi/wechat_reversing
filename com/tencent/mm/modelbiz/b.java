package com.tencent.mm.modelbiz;

import com.tencent.mm.e.b.x;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends x {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.uxd.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "userName";
        aVar.columns[1] = "qyUin";
        aVar.uxd.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "userUin";
        aVar.uxd.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "userFlag";
        aVar.uxd.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wwExposeTimes";
        aVar.uxd.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wwMaxExposeTimes";
        aVar.uxd.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wwCorpId";
        aVar.uxd.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "wwUserVid";
        aVar.uxd.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        aVar.columns[8] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
