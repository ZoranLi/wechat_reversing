package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class b extends e {
    private boolean ryQ = false;
    private boolean ryR;

    public final int aki() {
        return 121;
    }

    public b(n nVar, Orders orders) {
        super(nVar, orders);
        bsJ();
    }

    private void bsJ() {
        this.ryQ = false;
        o.bsC();
        if (!(o.bsD().rIq == null || this.ryV.oLz == null)) {
            String str = this.ryV.ofd;
            o.bsC();
            if (str.equals(o.bsD().rIq.field_bankcardType)) {
                if (this.ryV.oLz.fRv == 31 || this.ryV.oLz.fRv == 32 || this.ryV.oLz.fRv == 33 || this.ryV.oLz.fRv == 42 || this.ryV.oLz.fRv == 37) {
                    this.ryQ = true;
                } else {
                    this.ryR = true;
                }
            }
        }
        w.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[]{Boolean.valueOf(this.ryQ), Boolean.valueOf(this.ryR)});
    }

    public final int zi() {
        bsJ();
        if (this.ryQ) {
            return 1281;
        }
        if (this.ryR) {
            return 1305;
        }
        return 1601;
    }

    public final String getUri() {
        bsJ();
        if (this.ryQ) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
        }
        if (this.ryR) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
    }

    public final int a(e eVar, com.tencent.mm.y.e eVar2) {
        if (this.ryQ) {
            g.oUh.a(663, 26, 1, false);
        } else if (this.ryR) {
            g.oUh.a(663, 22, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.ryQ) {
            g.oUh.a(663, 27, 1, false);
        } else if (this.ryR) {
            g.oUh.a(663, 23, 1, false);
        }
    }
}
