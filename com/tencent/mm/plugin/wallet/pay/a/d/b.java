package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;

public final class b extends f {
    public b(n nVar, Orders orders) {
        super(nVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_ff_verifyreg";
    }

    public final int zi() {
        return 1517;
    }
}
