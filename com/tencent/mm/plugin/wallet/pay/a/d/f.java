package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends i {
    private int oRh = -1;
    public Orders ryM = null;

    public f(n nVar, Orders orders) {
        String str = null;
        int i = -1;
        this.ryM = orders;
        if (nVar.oLz != null) {
            this.oRh = nVar.oLz.fRv;
            i = nVar.oLz.fRr;
        }
        List list = orders.rGe;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fTA;
        }
        a(orders.fJH, str, this.oRh, i, nVar.ofd, nVar.ofe);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        w.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bg.mA(nVar.rHx))});
        a(nVar.oLz, hashMap, hashMap2, r0);
        hashMap.put("flag", nVar.flag);
        hashMap.put("passwd", nVar.rHx);
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        hashMap.put("favorcomposedid", nVar.rDO);
        hashMap.put("default_favorcomposedid", nVar.rDN);
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            w.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.rzL = true;
                this.ryM = Orders.a(jSONObject, this.ryM);
            } else {
                this.rzL = false;
            }
            w.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.oRh);
            if (this.oRh == 39) {
                w.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
                b.Q(jSONObject);
                return;
            }
            w.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.oRh == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.oRh == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    public int zi() {
        if (this.oRh == 11) {
            return 1684;
        }
        if (this.oRh == 21) {
            return 1608;
        }
        return 474;
    }

    public final boolean bsI() {
        if (this.oRh == 11 || this.oRh == 21) {
            return true;
        }
        return false;
    }
}
