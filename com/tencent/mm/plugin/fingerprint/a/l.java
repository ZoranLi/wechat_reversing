package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l implements h {
    public final void a(a aVar) {
        w.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
        if (bg.mA(q.rHB.lOH)) {
            w.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
            aVar.S(-1, "no challenge");
            return;
        }
        aVar.S(0, "");
    }
}
