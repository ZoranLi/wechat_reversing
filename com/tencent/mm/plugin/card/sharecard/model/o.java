package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<n> {
    public static final String[] gUx = new String[]{i.a(n.gTP, "ShareCardSyncItemInfo")};
    private e gUz;

    public o(e eVar) {
        super(eVar, n.gTP, "ShareCardSyncItemInfo", null);
        this.gUz = eVar;
    }

    public final List<n> afX() {
        List<n> arrayList = new ArrayList();
        Cursor a = this.gUz.a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            n nVar = new n();
            nVar.b(a);
            arrayList.add(nVar);
        }
        a.close();
        w.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
