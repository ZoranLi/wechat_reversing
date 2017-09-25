package com.tencent.mm.u.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class g implements am {
    private c hoF = null;

    private static g Ad() {
        return (g) l.o(g.class);
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        c Ae = Ae();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Ae.gv((String) h.vI().vr().get(328193, null));
            if (Ae.Ac()) {
                f.gx(Ae.hoz.hov);
            }
        } catch (Exception e) {
            w.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
        }
        w.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        c Ae = Ae();
        Ae.hoA = null;
        Ae.hoz = null;
    }

    public static c Ae() {
        h.vG().uQ();
        if (Ad().hoF == null) {
            Ad().hoF = new c();
        }
        return Ad().hoF;
    }
}
