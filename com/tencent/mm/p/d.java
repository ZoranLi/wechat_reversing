package com.tencent.mm.p;

import com.tencent.mm.e.b.bh;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class d extends bh {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cgi";
        aVar.uxd.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cmdid";
        aVar.uxd.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "functionmsgid";
        aVar.uxd.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "functionmsgid";
        aVar.columns[3] = "version";
        aVar.uxd.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "preVersion";
        aVar.uxd.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryinterval";
        aVar.uxd.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportid";
        aVar.uxd.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "successkey";
        aVar.uxd.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "failkey";
        aVar.uxd.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "finalfailkey";
        aVar.uxd.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "custombuff";
        aVar.uxd.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "addMsg";
        aVar.uxd.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "needShow";
        aVar.uxd.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void b(bu buVar) {
        if (buVar != null) {
            this.field_addMsg = buVar;
        }
    }
}
