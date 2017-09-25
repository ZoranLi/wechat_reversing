package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.e.b.l;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

@Deprecated
final class m extends l {
    public static final a izp;

    m() {
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHashCode";
        aVar.uxd.put("appIdHashCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHashCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "appIdHashCode";
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appIcon";
        aVar.uxd.put("appIcon", "TEXT");
        stringBuilder.append(" appIcon TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "appName";
        aVar.uxd.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "BigHeadImgUrl";
        aVar.uxd.put("BigHeadImgUrl", "TEXT");
        stringBuilder.append(" BigHeadImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "appInfo";
        aVar.uxd.put("appInfo", "BLOB");
        stringBuilder.append(" appInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "versionInfo";
        aVar.uxd.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "bindInfo";
        aVar.uxd.put("bindInfo", "BLOB");
        stringBuilder.append(" bindInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "brandId";
        aVar.uxd.put("brandId", "TEXT");
        stringBuilder.append(" brandId TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "brandFlag";
        aVar.uxd.put("brandFlag", "INTEGER default '0' ");
        stringBuilder.append(" brandFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "signature";
        aVar.uxd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "AppOpt";
        aVar.uxd.put("AppOpt", "INTEGER default '0' ");
        stringBuilder.append(" AppOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "syncAttrVersion";
        aVar.uxd.put("syncAttrVersion", "TEXT");
        stringBuilder.append(" syncAttrVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lastSyncAttrTimeInSecond";
        aVar.uxd.put("lastSyncAttrTimeInSecond", "LONG default '0' ");
        stringBuilder.append(" lastSyncAttrTimeInSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "debugEnabled";
        aVar.uxd.put("debugEnabled", "INTEGER default 'false' ");
        stringBuilder.append(" debugEnabled INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "roundedSquareIcon";
        aVar.uxd.put("roundedSquareIcon", "TEXT");
        stringBuilder.append(" roundedSquareIcon TEXT");
        aVar.columns[16] = "rowid";
        aVar.uxe = stringBuilder.toString();
        izp = aVar;
    }

    protected final a sY() {
        return izp;
    }
}
