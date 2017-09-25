package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.e.b.do;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class w extends do {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mNativeUrl";
        aVar.uxd.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "mNativeUrl";
        aVar.columns[1] = "hbType";
        aVar.uxd.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveAmount";
        aVar.uxd.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "receiveTime";
        aVar.uxd.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "receiveStatus";
        aVar.uxd.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hbStatus";
        aVar.uxd.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
