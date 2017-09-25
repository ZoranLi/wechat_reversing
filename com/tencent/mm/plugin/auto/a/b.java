package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class b implements am {
    private a jAT = new a();

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.urY.b(this.jAT.jAR);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.urY.c(this.jAT.jAR);
    }
}
