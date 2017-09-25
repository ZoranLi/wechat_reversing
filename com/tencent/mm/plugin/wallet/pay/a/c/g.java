package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;

public final class g extends e {
    public g(n nVar, Orders orders) {
        super(nVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_verify";
    }

    public final int zi() {
        return 1592;
    }
}
