package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i<d> {
    public static final String[] gUx = new String[]{i.a(d.gTP, "FavConfigInfo")};
    private com.tencent.mm.sdk.e.e gUz;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gTP, "FavConfigInfo", null);
        this.gUz = eVar;
    }

    public final void ao(byte[] bArr) {
        c atd = atd();
        if (8216 == atd.field_configId) {
            atd.field_value = bg.bo(bArr);
            boolean c = c(atd, new String[0]);
            w.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[]{atd.field_value, Boolean.valueOf(c)});
            return;
        }
        atd.field_configId = 8216;
        atd.field_value = bg.bo(bArr);
        c = b(atd);
        w.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[]{atd.field_value, Boolean.valueOf(c)});
    }

    final d atd() {
        d dVar = new d();
        w.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[]{new StringBuilder("select * from FavConfigInfo where configId = 8216").toString()});
        Cursor a = this.gUz.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                dVar.b(a);
            }
            a.close();
        }
        return dVar;
    }
}
