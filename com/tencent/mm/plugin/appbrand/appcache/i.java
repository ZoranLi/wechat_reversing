package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.e.b.m;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends m {
    public static final String[] izo = new String[]{"appId", "version", "debugType"};
    static final a izp;

    static {
        int i = 0;
        a aVar = new a();
        aVar.hXH = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.uxd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionMd5";
        aVar.uxd.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "versionState";
        aVar.uxd.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.uxd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "createTime";
        aVar.uxd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "resourceCount";
        aVar.uxd.put("resourceCount", "INTEGER");
        stringBuilder.append(" resourceCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.uxd.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "downloadURL";
        aVar.uxd.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "startTime";
        aVar.uxd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "endTime";
        aVar.uxd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[11] = "rowid";
        aVar.uxe = stringBuilder.toString();
        izp = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = izo;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = izp;
        aVar2.uxe = stringBuilder2.append(aVar2.uxe).append(",").append(str2).toString();
    }

    protected final a sY() {
        return izp;
    }
}
