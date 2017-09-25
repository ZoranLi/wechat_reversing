package com.tencent.mm.plugin.product.a;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class a implements am {
    private c ooR = null;
    private d ooS = null;
    private com.tencent.mm.plugin.product.b.a ooT = new com.tencent.mm.plugin.product.b.a();

    public static a aSQ() {
        a aVar = (a) ap.yR().gs("plugin.product");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreProduct", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.product", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.ooR = null;
        com.tencent.mm.sdk.b.a.urY.b(this.ooT);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.ooT);
    }

    public static c aSR() {
        h.vG().uQ();
        if (aSQ().ooR == null) {
            aSQ().ooR = new c();
        }
        return aSQ().ooR;
    }

    public final d aSS() {
        h.vG().uQ();
        if (this.ooS == null) {
            this.ooS = new d();
        }
        return this.ooS;
    }
}
