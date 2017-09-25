package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.plugin.soter_mp.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class b implements am {
    private static a qQE = new a();

    public final HashMap<Integer, c> uh() {
        w.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void eD(int i) {
        w.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter clearPluginData");
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter onAccountPostReset");
        if (!com.tencent.mm.sdk.b.a.urY.d(qQE)) {
            com.tencent.mm.sdk.b.a.urY.b(qQE);
        }
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onSdcardMount");
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onAccountRelease");
    }
}
