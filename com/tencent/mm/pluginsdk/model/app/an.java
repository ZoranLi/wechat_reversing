package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.cn;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.k.a.d.p;
import com.tencent.mm.pluginsdk.k.a.d.s;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.x;
import com.tencent.mm.y.d;
import java.util.HashMap;

public class an implements am {
    private static HashMap<Integer, c> gJr;
    private k sEl;
    private o sEm;
    private a sEn = null;
    private j sEo = new j();
    private b sEp = new b();
    private final s sEq = new s();
    private com.tencent.mm.sdk.b.c sEr = new com.tencent.mm.sdk.b.c<gy>(this) {
        final /* synthetic */ an sEt;

        {
            this.sEt = r2;
            this.usg = gy.class.getName().hashCode();
        }

        private static boolean a(gy gyVar) {
            int i;
            try {
                if (g.sV() == null) {
                    i = 0;
                } else {
                    i = bg.getInt(g.sV().getValue("AndroidUseUnicodeEmoji"), 0);
                }
            } catch (Exception e) {
                i = 0;
            }
            gyVar.fMn.fFY = i;
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c sEs = new com.tencent.mm.sdk.b.c<cg>(this) {
        final /* synthetic */ an sEt;

        {
            this.sEt = r2;
            this.usg = cg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = bg.getInt(g.sV().getValue("AndroidUseUnicodeEmoji"), 0);
            com.tencent.mm.sdk.b.b cnVar = new cn();
            cnVar.fFX.fFY = i;
            com.tencent.mm.sdk.b.a.urY.m(cnVar);
            return false;
        }
    };

    private static an bDi() {
        an anVar = (an) ap.yR().gs(an.class.getName());
        if (anVar == null) {
            return new an();
        }
        return anVar;
    }

    public static j bDj() {
        return bDi().sEo;
    }

    public static c abL() {
        return com.tencent.mm.plugin.w.a.abL();
    }

    public static e aRp() {
        return com.tencent.mm.plugin.w.a.aRp();
    }

    public static h aRq() {
        return com.tencent.mm.plugin.w.a.aRq();
    }

    public static i aRr() {
        return com.tencent.mm.plugin.w.a.aRr();
    }

    public static k bDk() {
        h.vG().uQ();
        if (bDi().sEl == null) {
            an bDi = bDi();
            ap.yY();
            bDi.sEl = new k(com.tencent.mm.u.c.wO());
        }
        return bDi().sEl;
    }

    public static o bDl() {
        h.vG().uQ();
        if (bDi().sEm == null) {
            an bDi = bDi();
            ap.yY();
            bDi.sEm = new o(com.tencent.mm.u.c.wO());
        }
        return bDi().sEm;
    }

    public static a bDm() {
        h.vG().uQ();
        if (bDi().sEn == null) {
            bDi().sEn = new a();
        }
        return bDi().sEn;
    }

    public static m aRs() {
        return com.tencent.mm.plugin.w.a.aRs();
    }

    public static d aBG() {
        return com.tencent.mm.plugin.w.a.aBG();
    }

    public final void onAccountRelease() {
        a aVar = bDi().sEn;
        if (aVar != null) {
            aVar.fBo = 0;
        }
        d.c.aA(Integer.valueOf(47));
        d.c.aA(Integer.valueOf(49));
        com.tencent.mm.sdk.b.a.urY.c(this.sEr);
        com.tencent.mm.sdk.b.a.urY.c(this.sEs);
        j.bCG();
        s sVar = this.sEq;
        h.vH().b(sVar.sGW);
        com.tencent.mm.sdk.b.a.urY.c(sVar.sGX);
        for (com.tencent.mm.pluginsdk.k.a.d.g onAccountRelease : p.bDH()) {
            onAccountRelease.onAccountRelease();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return k.gUx;
            }
        });
        gJr.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return o.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        x.a.hlQ = com.tencent.mm.plugin.w.a.aRq();
        d.c.a(Integer.valueOf(47), this.sEp);
        d.c.a(Integer.valueOf(49), this.sEo);
        com.tencent.mm.sdk.b.a.urY.b(this.sEr);
        com.tencent.mm.sdk.b.a.urY.b(this.sEs);
        SightVideoJNI.registerALL();
        s sVar = this.sEq;
        for (com.tencent.mm.pluginsdk.k.a.d.g bwP : p.bDH()) {
            bwP.bwP();
        }
        h.vH().a(sVar.sGW);
        com.tencent.mm.sdk.b.a.urY.b(sVar.sGX);
    }

    public final void aN(boolean z) {
    }
}
