package com.tencent.mm.storage;

import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class a extends c {
    protected static com.tencent.mm.sdk.e.c.a gTP;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "abtestkey";
        aVar.uxd.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "abtestkey";
        aVar.columns[1] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.uxd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.uxd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.uxd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.uxd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.uxd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "noReport";
        aVar.uxd.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        aVar.columns[8] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final boolean isValid() {
        long Ny = bg.Ny();
        return Ny >= this.field_startTime && Ny < this.field_endTime;
    }
}
