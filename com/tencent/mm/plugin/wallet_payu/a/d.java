package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.plugin.wallet_payu.create.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wallet_payu.remittance.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public final class d implements am {
    public String rRK = null;
    private int rRL = -1;

    static {
        a.g("PayUOpenProcess", c.class);
        a.g("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
        a.g("PayUForgotPwdProcess", f.class);
        a.g("PayUModifyPasswordProcess", g.class);
        a.g("PayURemittanceProcess", i.class);
        a.g("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    }

    public static d bvC() {
        d dVar = (d) ap.yR().gs("plugin.wallet_payu");
        if (dVar != null) {
            return dVar;
        }
        w.w("MicroMsg.SubCoreWalletPayU", "not found in MMCore, new one");
        Object dVar2 = new d();
        ap.yR().a("plugin.wallet_payu", dVar2);
        return dVar2;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
