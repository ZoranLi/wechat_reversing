package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.e.b.dw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class ad extends dw {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.uxd.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "recordId";
        aVar.columns[1] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "domin";
        aVar.uxd.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "key";
        aVar.uxd.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
