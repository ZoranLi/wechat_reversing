package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bd.a;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;

public final class h implements q<bu> {
    public final /* synthetic */ void a(a aVar) {
        final String a = n.a(((bu) aVar).tfd);
        if (o.dH(a)) {
            ap.yY();
            final com.tencent.mm.storage.q fW = c.xa().fW(a);
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(a);
            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                ag.a.hlS.a(a, null, new b.a(this) {
                    final /* synthetic */ h jPT;

                    public final void p(String str, boolean z) {
                        if (fW != null && fW.bKT()) {
                            com.tencent.mm.sdk.b.b jhVar = new jh();
                            jhVar.fPB.chatroomName = a;
                            jhVar.fPB.fPC = fW.bKS();
                            com.tencent.mm.sdk.b.a.urY.m(jhVar);
                        }
                    }
                });
            } else if (fW.bKT()) {
                com.tencent.mm.sdk.b.b jhVar = new jh();
                jhVar.fPB.chatroomName = a;
                jhVar.fPB.fPC = fW.bKS();
                com.tencent.mm.sdk.b.a.urY.m(jhVar);
            }
        }
    }

    public final /* synthetic */ void b(a aVar) {
        String a = n.a(((bu) aVar).tfd);
        if (!bg.mA(a) && !((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Re(a)) {
            ag.a.hlS.J(a, "");
        }
    }
}
