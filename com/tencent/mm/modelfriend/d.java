package com.tencent.mm.modelfriend;

import com.tencent.mm.ao.n;
import com.tencent.mm.e.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

final class d extends c<af> {
    d() {
        this.usg = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (afVar.fDn.fDp == 0) {
            try {
                int xW = m.xW() | Downloads.RECV_BUFFER_SIZE;
                ap.yY();
                com.tencent.mm.u.c.vr().set(34, Integer.valueOf(xW));
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", xW, "", ""));
                w.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
