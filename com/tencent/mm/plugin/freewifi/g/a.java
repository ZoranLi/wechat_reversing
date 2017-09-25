package com.tencent.mm.plugin.freewifi.g;

import com.tencent.mm.e.b.be;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class a extends be {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.uxd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "key";
        aVar.columns[1] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "modifyTime";
        aVar.uxd.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
