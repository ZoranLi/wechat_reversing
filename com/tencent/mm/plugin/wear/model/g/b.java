package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.e.a.sm;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;

public final class b implements d {
    public final com.tencent.mm.y.d.b b(a aVar) {
        bu buVar = aVar.hst;
        ap.yY();
        if (!bg.mA((String) c.vr().get(2, ""))) {
            String a = n.a(buVar.tfd);
            String a2 = n.a(buVar.tfe);
            if (bg.mA(a) || bg.mA(a2)) {
                w.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
            } else {
                String a3 = n.a(buVar.tff);
                w.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.bvG().rTv;
                synchronized (aVar2.rUJ) {
                    sm IJ = a.IJ(a);
                    if (aVar2.rUJ.containsKey(a) || IJ.gaf.gag == 1) {
                        w.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[]{a});
                        com.tencent.mm.sdk.b.b smVar = new sm();
                        smVar.gae.fEG = 2;
                        smVar.gae.username = a;
                        com.tencent.mm.sdk.b.a.urY.m(smVar);
                    } else {
                        w.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[]{a});
                        aVar2.rUJ.put(a, new a(aVar2, a, a3));
                    }
                }
                com.tencent.mm.plugin.wear.model.a.bvG().rTv.bvZ();
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
