package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class p extends i<o> {
    public static final String[] gUx = new String[]{i.a(o.gTP, "FavSearchInfo")};
    e gUz;

    public p(e eVar) {
        super(eVar, o.gTP, "FavSearchInfo", null);
        this.gUz = eVar;
    }

    public final void bV(long j) {
        this.gUz.eE("FavSearchInfo", "delete from FavSearchInfo where localId = " + j);
    }

    public final o bW(long j) {
        o oVar = null;
        Cursor a = this.gUz.a("select * from FavSearchInfo where localId = " + j, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                oVar = new o();
                oVar.b(a);
            }
            a.close();
        }
        return oVar;
    }
}
