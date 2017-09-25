package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.b;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import java.util.HashMap;
import java.util.Map;

public final class o implements am {
    private static HashMap<Integer, c> gJr;
    private com.tencent.mm.u.br.a lYF = new com.tencent.mm.u.br.a(this) {
        final /* synthetic */ o nQF;

        {
            this.nQF = r1;
        }

        public final boolean Aa() {
            w.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (this.nQF.nQx != null) {
                this.nQF.nQx.aDI();
                if (this.nQF.nQx.nPl != null) {
                    w.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[]{i.h(this.nQF.nQx.nPl)});
                }
            }
            return true;
        }
    };
    private a nQA;
    private g nQB;
    private com.tencent.mm.plugin.multitalk.b.a nQC;
    private com.tencent.mm.plugin.multitalk.b.c nQD;
    private f nQE;
    private c nQw;
    public e nQx;
    private l nQy;
    private h nQz;

    class a implements com.tencent.mm.u.bp.a {
        final /* synthetic */ o nQF;

        a(o oVar) {
            this.nQF = oVar;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            f aNq = o.aNq();
            String a = n.a(aVar.hst.tff);
            Map q = bh.q(a, "sysmsg");
            if (((String) q.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
                w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + a);
                return;
            }
            String str = (String) q.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(bg.ap(str, "").getBytes(), 0);
                w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + n.a(aVar.hst.tff) + " buffer len " + decode.length);
                o.aNm().nOT.aK(bg.f((Integer) ap.yW().get(1)), m.xL());
                o.aNm().nOT.bv(decode);
                return;
            }
            str = (String) q.get(".sysmsg.multivoip.banner");
            if (str != null) {
                aNq.a(str, aVar);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.multitalk.b.a.gUx;
            }
        });
        gJr.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.multitalk.b.c.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    private static o aNi() {
        o oVar = (o) ap.yR().gs("plugin.multitalk");
        if (oVar != null) {
            return oVar;
        }
        Object oVar2 = new o();
        ap.yR().a("plugin.multitalk", oVar2);
        return oVar2;
    }

    public static com.tencent.mm.plugin.multitalk.b.a aNj() {
        ap.yY();
        if (com.tencent.mm.u.c.uH() == 0) {
            throw new b();
        }
        if (aNi().nQC == null) {
            o aNi = aNi();
            ap.yY();
            aNi.nQC = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.u.c.wO());
        }
        return aNi().nQC;
    }

    public static com.tencent.mm.plugin.multitalk.b.c aNk() {
        ap.yY();
        if (com.tencent.mm.u.c.uH() == 0) {
            throw new b();
        }
        if (aNi().nQD == null) {
            o aNi = aNi();
            ap.yY();
            aNi.nQD = new com.tencent.mm.plugin.multitalk.b.c(com.tencent.mm.u.c.wO());
        }
        return aNi().nQD;
    }

    public static h aNl() {
        h.vG().uQ();
        if (aNi().nQz == null) {
            aNi().nQz = new h();
        }
        return aNi().nQz;
    }

    public static c aNm() {
        h.vG().uQ();
        if (aNi().nQw == null) {
            aNi().nQw = new c();
        }
        return aNi().nQw;
    }

    public static e aNn() {
        h.vG().uQ();
        if (aNi().nQx == null) {
            aNi().nQx = new e();
        }
        return aNi().nQx;
    }

    public static l aNo() {
        h.vG().uQ();
        if (aNi().nQy == null) {
            aNi().nQy = new l();
        }
        return aNi().nQy;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.nQw = new c();
        this.nQA = new a(this);
        ap.getSysCmdMsgExtension().a("multivoip", this.nQA, true);
        ap.vK().a(this.lYF);
        com.tencent.mm.pluginsdk.l.a.sBz = aNp();
        aNp().aNc();
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.nQw != null) {
            e eVar = this.nQw;
            ap.vd().b(1918, eVar);
            ap.vd().b(1919, eVar);
            ap.vd().b(1927, eVar);
            ap.vd().b(1928, eVar);
            ap.vd().b(1929, eVar);
            ap.vd().b(1931, eVar);
            ap.vd().b(1932, eVar);
            ap.vd().b(1933, eVar);
            ap.vd().b(1935, eVar);
            ap.vd().b(1937, eVar);
            ap.vd().b(1938, eVar);
            ap.vd().b(1939, eVar);
            this.nQw = null;
        }
        if (this.nQx != null) {
            e eVar2 = this.nQx;
            ab.getContext().unregisterReceiver(eVar2.nPz);
            com.tencent.mm.sdk.b.a.urY.c(eVar2.nPA);
            eVar2.c(false, false, false);
            this.nQx = null;
        }
        if (this.nQy != null) {
            this.nQy.aNh();
            this.nQy = null;
        }
        if (this.nQz != null) {
            this.nQz.reset();
            this.nQz = null;
        }
        ap.getSysCmdMsgExtension().b("multivoip", this.nQA, true);
        ap.vK().b(this.lYF);
    }

    public static g aNp() {
        if (aNi().nQB == null) {
            aNi().nQB = new g();
        }
        return aNi().nQB;
    }

    public static f aNq() {
        if (aNi().nQE == null) {
            aNi().nQE = new f();
        }
        return aNi().nQE;
    }
}
