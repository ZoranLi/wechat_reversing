package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ao.n;
import com.tencent.mm.e.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;

final class b extends c<af> {
    b() {
        this.usg = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            w.f("MicroMsg.QQMail.EventListener", "not bind qq event");
        } else if (afVar.fDn.fDp == 0) {
            try {
                ap.yY();
                com.tencent.mm.u.c.vr().set(17, Integer.valueOf(2));
                int xW = m.xW() | 1;
                ap.yY();
                com.tencent.mm.u.c.vr().set(34, Integer.valueOf(xW));
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", xW, "", ""));
                w.aUB();
                w.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
