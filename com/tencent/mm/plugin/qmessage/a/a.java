package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ao.n;
import com.tencent.mm.e.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;

final class a extends c<af> {
    a() {
        this.usg = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            w.f("MicroMsg.QMsg.EventListener", "not bind qq event");
        } else if (afVar.fDn.fDp == 0) {
            try {
                int xW = m.xW() | 32;
                ap.yY();
                com.tencent.mm.u.c.vr().set(34, Integer.valueOf(xW));
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", xW, "", ""));
                g.aUg();
                w.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
