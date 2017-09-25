package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.util.HashMap;

public final class h implements am {
    private static HashMap<Integer, c> gJr;
    private a nvn = new a(this) {
        final /* synthetic */ h nxe;

        {
            this.nxe = r1;
        }

        public final void a(d.a aVar) {
            String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + a);
            h.aJu().zU(a);
            h.aJu().aJp();
            h.aJu();
            c.cz(bg.Nz());
        }
    };
    private b nxa;
    private c nxb;
    private i nxc = new i();
    private g nxd = new g();

    private static h aJs() {
        h hVar = (h) ap.yR().gs("plugin.masssend");
        if (hVar != null) {
            return hVar;
        }
        Object hVar2 = new h();
        ap.yR().a("plugin.favorite", hVar2);
        return hVar2;
    }

    public static b aJt() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aJs().nxa == null) {
            h aJs = aJs();
            ap.yY();
            aJs.nxa = new b(com.tencent.mm.u.c.wO());
        }
        return aJs().nxa;
    }

    public static c aJu() {
        if (aJs().nxb == null) {
            aJs().nxb = new c();
        }
        return aJs().nxb;
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("masssendapp", this.nvn, false);
        com.tencent.mm.sdk.b.a.urY.c(this.nxc);
        com.tencent.mm.sdk.b.a.urY.c(this.nxd);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        ap.getSysCmdMsgExtension().a("masssendapp", this.nvn, false);
        com.tencent.mm.sdk.b.a.urY.b(this.nxc);
        com.tencent.mm.sdk.b.a.urY.b(this.nxd);
    }

    public final void aN(boolean z) {
    }
}
