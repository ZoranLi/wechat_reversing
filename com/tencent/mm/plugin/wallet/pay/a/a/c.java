package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class c extends b {
    private boolean ryQ;
    private boolean ryR;
    private boolean ryS;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.ryS = z;
        bsJ();
    }

    private void bsJ() {
        this.ryQ = false;
        o.bsC();
        if (!(o.bsD().rIq == null || this.ryN.oLz == null || this.ryS)) {
            if (this.ryN.oLz.fRv == 31 || this.ryN.oLz.fRv == 32 || this.ryN.oLz.fRv == 33 || this.ryN.oLz.fRv == 42 || this.ryN.oLz.fRv == 37) {
                this.ryQ = true;
            } else {
                this.ryR = true;
            }
        }
        w.i("MicroMsg.NetSceneTenpayBalanceBindAuthen", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[]{Boolean.valueOf(this.ryQ), Boolean.valueOf(this.ryR), Boolean.valueOf(this.ryS)});
    }

    public final int aki() {
        return 120;
    }

    public final String getUri() {
        bsJ();
        if (this.ryQ) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
        }
        if (this.ryR) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public final int zi() {
        bsJ();
        if (this.ryQ) {
            return 1274;
        }
        if (this.ryR) {
            return 1259;
        }
        return 1600;
    }

    public final int a(e eVar, com.tencent.mm.y.e eVar2) {
        if (this.ryQ) {
            g.oUh.a(663, 24, 1, false);
        } else if (this.ryR) {
            g.oUh.a(663, 20, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.ryQ) {
            g.oUh.a(663, 25, 1, false);
        } else if (this.ryR) {
            g.oUh.a(663, 21, 1, false);
        }
    }
}
