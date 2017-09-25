package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class f extends b {
    public f(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
    }

    public final int zi() {
        return 1998;
    }

    public final boolean aQj() {
        if (this.ryN == null || this.ryN.oLz.sYm == 1) {
            return true;
        }
        return false;
    }
}
