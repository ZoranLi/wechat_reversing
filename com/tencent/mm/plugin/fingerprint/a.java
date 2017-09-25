package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.fingerprint.a.b;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.f;
import com.tencent.mm.plugin.fingerprint.a.h;
import com.tencent.mm.plugin.fingerprint.a.i;
import com.tencent.mm.plugin.fingerprint.a.j;
import com.tencent.mm.plugin.fingerprint.a.m;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public class a implements am {
    private m lNQ = new m();
    private h lNR = new h();
    private i lNS = new i();
    private b lNT = new b();
    private f lNU = new f();
    private c lNV;

    static {
        com.tencent.mm.wallet_core.a.g("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    }

    public static a auQ() {
        a aVar = (a) ap.yR().gs("plugin.fingerprint");
        if (aVar != null) {
            return aVar;
        }
        w.e("MicroMsg.SubCoreFingerPrint", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.fingerprint", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreFingerPrint", "alvinluo SoterWrapperApi isInit: %b in SubCoreFingerprint initTA", new Object[]{Boolean.valueOf(com.tencent.d.b.b.a.cfM().isInit())});
        d jVar = com.tencent.mm.plugin.soter.c.g.hQ(false) ? new j() : new com.tencent.mm.plugin.fingerprint.a.d();
        com.tencent.mm.pluginsdk.l.a.sBC = jVar;
        jVar.avb();
        com.tencent.mm.sdk.b.a.urY.b(this.lNQ);
        com.tencent.mm.sdk.b.a.urY.b(this.lNR);
        com.tencent.mm.sdk.b.a.urY.b(this.lNS);
        com.tencent.mm.sdk.b.a.urY.b(this.lNT);
        com.tencent.mm.sdk.b.a.urY.b(this.lNU);
        if (this.lNV != null) {
            c.abort();
            c.release();
            this.lNV = null;
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.lNQ);
        this.lNR.release();
        com.tencent.mm.sdk.b.a.urY.c(this.lNR);
        com.tencent.mm.sdk.b.a.urY.c(this.lNS);
        com.tencent.mm.sdk.b.a.urY.c(this.lNT);
        com.tencent.mm.sdk.b.a.urY.c(this.lNU);
        com.tencent.mm.pluginsdk.l.a.sBC = null;
    }

    public static c auR() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (auQ().lNV == null) {
            auQ().lNV = new c();
        }
        return auQ().lNV;
    }
}
