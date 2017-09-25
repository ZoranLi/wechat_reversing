package com.tencent.mm.plugin.game.model;

import com.tencent.mm.e.b.bi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class n extends bi {
    protected static a gTP;

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
        aVar.columns[1] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
