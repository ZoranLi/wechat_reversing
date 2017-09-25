package com.tencent.mm.e.b;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class by extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int guT = "logId".hashCode();
    private static final int guU = "liftTime".hashCode();
    public long field_liftTime;
    public int field_logId;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logId";
        aVar.uxd.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "logId";
        aVar.columns[1] = "liftTime";
        aVar.uxd.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }
}
