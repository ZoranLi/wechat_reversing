package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;

public final class d extends e {
    public d(n nVar, Orders orders) {
        super(nVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_verify";
    }

    public final int zi() {
        return 1699;
    }
}
