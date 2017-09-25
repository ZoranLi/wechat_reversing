package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.e.a.he;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends c<he> {
    public a() {
        this.usg = he.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        he heVar = (he) bVar;
        if (heVar instanceof he) {
            w.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            w.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", new Object[]{Boolean.valueOf(g.blY())});
            if (g.blY()) {
                heVar.fME.fMF = 1;
            } else {
                heVar.fME.fMF = 0;
            }
        }
        return true;
    }
}
