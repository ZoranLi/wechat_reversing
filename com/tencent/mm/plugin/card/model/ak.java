package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class ak extends i<aj> {
    public static final String[] gUx = new String[]{i.a(aj.gTP, "PendingCardId")};
    e gUz;

    public ak(e eVar) {
        super(eVar, aj.gTP, "PendingCardId", null);
        this.gUz = eVar;
    }

    public final List<aj> afX() {
        List<aj> arrayList = new ArrayList();
        Cursor a = this.gUz.a("select * from PendingCardId where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            aj ajVar = new aj();
            ajVar.b(a);
            arrayList.add(ajVar);
        }
        a.close();
        w.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
