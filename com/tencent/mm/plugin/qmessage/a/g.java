package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.y.d;
import java.util.HashMap;

public final class g implements am {
    private static HashMap<Integer, c> gJr;
    private e oyI;
    private f oyJ = new f();
    private a oyK = new a();
    private b oyL = new b();

    private static g aUd() {
        g gVar = (g) ap.yR().gs("plugin.qmessage");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        ap.yR().a("plugin.qmessage", gVar2);
        return gVar2;
    }

    public static e aUe() {
        h.vG().uQ();
        if (aUd().oyI == null) {
            g aUd = aUd();
            ap.yY();
            aUd.oyI = new e(com.tencent.mm.u.c.wO());
        }
        return aUd().oyI;
    }

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(36));
        d.c.aA(Integer.valueOf(39));
        a.urY.c(this.oyK);
        a.urY.c(this.oyL);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
        w.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            aUg();
        }
    }

    public static void aUf() {
        ap.yY();
        if (com.tencent.mm.u.c.wW().Rm("qmessage") == null) {
            ae aeVar = new ae();
            aeVar.setUsername("qmessage");
            aeVar.setContent("");
            aeVar.s(bg.Nz());
            aeVar.dw(0);
            aeVar.dt(0);
            ap.yY();
            com.tencent.mm.u.c.wW().d(aeVar);
            return;
        }
        ap.yY();
        ce Ai = com.tencent.mm.u.c.wT().Ai("qmessage");
        ae aeVar2 = new ae();
        aeVar2.setUsername("qmessage");
        aeVar2.setContent(Ai == null ? "" : Ai.field_content);
        aeVar2.s(bg.Nz());
        aeVar2.dw(0);
        aeVar2.dt(0);
        ap.yY();
        com.tencent.mm.u.c.wW().a(aeVar2, "qmessage");
    }

    public static void aUg() {
        ay.zp();
        ap.yY();
        com.tencent.mm.u.c.wW().Ap("@qqim");
        ap.yY();
        com.tencent.mm.u.c.wW().Rl("qmessage");
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(36), this.oyJ);
        d.c.a(Integer.valueOf(39), this.oyJ);
        a.urY.b(this.oyK);
        a.urY.b(this.oyL);
    }

    public final void aN(boolean z) {
    }
}
