package com.tencent.mm.plugin.address.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class a implements am {
    private l isT = null;
    private com.tencent.mm.plugin.address.b.a.a isU = null;
    private j isV = new j();
    private k isW = new k();

    public static a OR() {
        a aVar = (a) ap.yR().gs("plugin.address");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.address", aVar2);
        return aVar2;
    }

    public static com.tencent.mm.plugin.address.b.a.a OS() {
        h.vG().uQ();
        if (OR().isU == null) {
            OR().isU = new com.tencent.mm.plugin.address.b.a.a();
        }
        return OR().isU;
    }

    public static l OT() {
        h.vG().uQ();
        if (OR().isT == null) {
            OR().isT = new l();
        }
        return OR().isT;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.b(this.isV);
        com.tencent.mm.sdk.b.a.urY.b(this.isW);
        l OT = OT();
        ap.yY();
        OT.path = com.tencent.mm.u.c.xv() + "addrmgr";
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.isV);
        com.tencent.mm.sdk.b.a.urY.c(this.isW);
    }
}
