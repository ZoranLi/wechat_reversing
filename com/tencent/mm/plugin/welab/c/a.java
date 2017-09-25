package com.tencent.mm.plugin.welab.c;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class a extends i<com.tencent.mm.plugin.welab.c.a.a> {
    private e gUz;

    public final /* synthetic */ boolean a(c cVar) {
        return d((com.tencent.mm.plugin.welab.c.a.a) cVar);
    }

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.welab.c.a.a.gTP, "LabAppInfo", null);
        this.gUz = eVar;
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bAP() {
        Cursor Kk = Kk();
        List<com.tencent.mm.plugin.welab.c.a.a> arrayList = new ArrayList();
        while (Kk.moveToNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = new com.tencent.mm.plugin.welab.c.a.a();
            aVar.b(Kk);
            arrayList.add(aVar);
        }
        Kk.close();
        return arrayList;
    }

    public final void bO(List<com.tencent.mm.plugin.welab.c.a.a> list) {
        long cs;
        g gVar;
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(-1);
            gVar = gVar2;
        } else {
            gVar = null;
            cs = 0;
        }
        for (com.tencent.mm.plugin.welab.c.a.a c : list) {
            c(c);
        }
        if (gVar != null) {
            gVar.aD(cs);
        }
    }

    public final void c(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (!d(aVar)) {
            b(aVar);
        }
    }

    private boolean d(com.tencent.mm.plugin.welab.c.a.a aVar) {
        c aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = aVar.field_LabsAppId;
        b(aVar2, new String[0]);
        if (aVar.field_sequence > aVar2.field_sequence) {
            return super.a(aVar);
        }
        w.i("LabAppInfoStorage", "sequence old origin.seq " + aVar2.field_sequence + " old.seq " + aVar.field_sequence);
        return false;
    }
}
