package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.dd;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class o extends dd {
    protected static a gTP;
    public int qnk;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logtime";
        aVar.uxd.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "offset";
        aVar.uxd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "logsize";
        aVar.uxd.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "errorcount";
        aVar.uxd.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.qnk = (int) this.uxb;
        } catch (Exception e) {
            String message = e.getMessage();
            w.e("MicroMsg.SnsKvReport", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.beP().bhl();
            }
            throw e;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
        }
    }
}
