package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.ap;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends ap {
    protected static a gTP;

    protected final a sY() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5_lang";
        aVar.uxd.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.uxc = "md5_lang";
        aVar.columns[1] = "md5";
        aVar.uxd.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lang";
        aVar.uxd.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[3] = "desc";
        aVar.uxd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "groupId";
        aVar.uxd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "click_flag";
        aVar.uxd.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "download_flag";
        aVar.uxd.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public final String EP() {
        return this.field_md5 == null ? "" : this.field_md5;
    }
}
