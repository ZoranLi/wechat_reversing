package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class l extends i<k> {
    public static final String[] gUx = new String[]{i.a(k.gTP, "IPCallRecord")};
    public static final String[] mRf = new String[]{"*", "rowid"};
    public e gUz;

    public l(e eVar) {
        super(eVar, k.gTP, "IPCallRecord", null);
        this.gUz = eVar;
    }

    public final Cursor yx(String str) {
        return this.gUz.query("IPCallRecord", mRf, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
    }

    public final Cursor cu(long j) {
        return this.gUz.query("IPCallRecord", mRf, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
    }

    public final void a(k kVar) {
        if (kVar != null) {
            a(kVar.uxb, kVar);
        }
    }
}
