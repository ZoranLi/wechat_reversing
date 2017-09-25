package com.tencent.mm.u.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public final class d implements com.tencent.mm.y.d {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null || buVar.tff == null) {
            w.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
        } else {
            String a = n.a(buVar.tff);
            h.vI().vr().set(328193, a);
            c Ae = g.Ae();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Ae.gv(a);
                a = (String) h.vI().vr().get(328197, null);
                if (bg.mA(a) || !(Ae.hoz == null || a.equals(Ae.hoz.hov))) {
                    h.vI().vr().set(328197, Ae.hoz.hov);
                    h.vI().vr().set(328195, Boolean.valueOf(false));
                    h.vI().vr().set(328194, Boolean.valueOf(false));
                    h.vI().vr().set(328196, Boolean.valueOf(false));
                    w.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                w.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
            }
            w.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (g.Ae().Ac()) {
                f.gx(g.Ae().hoz.hov);
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
