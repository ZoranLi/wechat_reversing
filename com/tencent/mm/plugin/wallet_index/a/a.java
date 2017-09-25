package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.plugin.wallet_index.c.d;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class a implements am {
    private d rPx = new d();

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.b(this.rPx.rPP);
        com.tencent.mm.sdk.b.a.urY.b(this.rPx.rPQ);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.rPx.rPP);
        com.tencent.mm.sdk.b.a.urY.c(this.rPx.rPQ);
    }
}
