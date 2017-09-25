package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "ScanHistoryItem")};
    public e gUz;

    public b(e eVar) {
        super(eVar, a.gTP, "ScanHistoryItem", null);
        this.gUz = eVar;
    }

    public final Cursor Kk() {
        return this.gUz.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    }
}
