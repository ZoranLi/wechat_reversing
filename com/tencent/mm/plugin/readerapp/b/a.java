package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.ao.g;
import com.tencent.mm.ao.n;
import com.tencent.mm.e.a.af;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;

final class a extends c<af> {
    a() {
        this.usg = af.class.getName().hashCode();
    }

    private boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            w.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        } else if (afVar.fDn.fDp == 0) {
            try {
                int xW = m.xW() | 262144;
                ap.yY();
                com.tencent.mm.u.c.vr().set(34, Integer.valueOf(xW));
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_aqr = new aqr();
                com_tencent_mm_protocal_c_aqr.tdB = 262144;
                com_tencent_mm_protocal_c_aqr.tVo = 1;
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(39, com_tencent_mm_protocal_c_aqr));
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", xW, "", ""));
                g.b(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                    final /* synthetic */ a oJL;

                    {
                        this.oJL = r1;
                    }

                    public final void aVY() {
                    }
                });
                int xR = m.xR() & -33;
                ap.yY();
                com.tencent.mm.u.c.vr().set(40, Integer.valueOf(xR));
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new g(21, 2));
                w.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
