package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class h extends i<g> {
    public static final String[] gUx = new String[]{i.a(g.gTP, "FavEditInfo")};
    public e gUz;

    public h(e eVar) {
        super(eVar, g.gTP, "FavEditInfo", null);
        this.gUz = eVar;
        this.gUz.eE("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    }

    public final List<g> ate() {
        Cursor a = this.gUz.a("select count(*) from FavEditInfo", null, 2);
        if (a == null) {
            w.e("MicroMsg.FavModInfoStorage", "count all edit info, cursor is null");
            return null;
        }
        try {
            if (a.moveToFirst()) {
                w.i("MicroMsg.FavModInfoStorage", "get all edit infos, count %d", new Object[]{Integer.valueOf(a.getInt(0))});
            }
            a.close();
            a = this.gUz.a("select * from FavEditInfo", null, 2);
            if (a == null) {
                return null;
            }
            List<g> arrayList = new ArrayList();
            try {
                if (a.moveToFirst()) {
                    do {
                        g gVar = new g();
                        gVar.b(a);
                        arrayList.add(gVar);
                    } while (a.moveToNext());
                }
                a.close();
                return arrayList;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavModInfoStorage", e, "", new Object[0]);
                a.close();
                return null;
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.FavModInfoStorage", e2, "", new Object[0]);
            a.close();
            return null;
        }
    }
}
