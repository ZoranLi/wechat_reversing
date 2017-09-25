package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;

public final class c extends f {
    public c(n nVar, Orders orders) {
        super(nVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_verifyreg";
    }

    public final int zi() {
        return 1559;
    }
}
