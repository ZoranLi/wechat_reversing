package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;

public final class l {
    private static boolean jPW = false;

    public static synchronized void bJ(final Context context) {
        synchronized (l.class) {
            if (!jPW) {
                jPW = true;
                h.vH().a(new a() {
                    public final void cU(int i) {
                        if (i == 4 || i == 6) {
                            l.acQ();
                        }
                    }
                });
            }
        }
    }

    public static void acQ() {
        if (!h.vG().uV() || com.tencent.mm.kernel.a.uP()) {
            w.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + h.vG().uV() + " isHold:" + com.tencent.mm.kernel.a.uP());
            return;
        }
        m.LA().run();
        o.La().run();
        n.GQ().run();
        an.bDm().run();
        if (ag.a.hlV != null) {
            ag.a.hlV.yK();
        }
        com.tencent.mm.sdk.b.a.urY.m(new pt());
    }
}
