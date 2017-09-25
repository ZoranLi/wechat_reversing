package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.be;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class b implements am {
    private static b rrk = null;
    private a rrl = new a();
    private d rrm = new d();
    private c rrn = new c();
    private com.tencent.mm.plugin.voip_cs.a.a rro = new com.tencent.mm.plugin.voip_cs.a.a();
    private c rrp = new c<be>(this) {
        final /* synthetic */ b rrq;

        {
            this.rrq = r2;
            this.usg = be.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            be beVar = (be) bVar;
            if (beVar instanceof be) {
                be.a aVar = beVar.fEJ;
                if (!(b.brO().rst == 1 || b.brO().rst == 2)) {
                    z = false;
                }
                aVar.fEt = z;
            }
            return false;
        }
    };

    private static b brM() {
        if (rrk == null) {
            rrk = new b();
            ap.yR().a("plugin.voip_cs", rrk);
        }
        return rrk;
    }

    public static a brN() {
        return brM().rrl;
    }

    public static d brO() {
        h.vG().uQ();
        if (brM().rrm == null) {
            brM().rrm = new d();
        }
        return brM().rrm;
    }

    public static c brP() {
        return brM().rrn;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.b.a.urY.b(this.rro);
        com.tencent.mm.sdk.b.a.urY.b(this.rrp);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.rro);
        com.tencent.mm.sdk.b.a.urY.c(this.rrp);
    }
}
