package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends i<f> {
    public static final String[] gUx = new String[]{i.a(f.gTP, "shakemessage")};
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(e eVar) {
        super(eVar, f.gTP, "shakemessage", gaK);
        this.gUz = eVar;
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            w.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(fVar)) {
            return false;
        } else {
            Qr(fVar.uxb);
            return true;
        }
    }

    public final int Kr() {
        int i;
        Cursor a = this.gUz.a("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        return i > 0 ? i : 0;
    }
}
