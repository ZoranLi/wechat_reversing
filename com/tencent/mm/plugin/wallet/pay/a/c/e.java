package com.tencent.mm.plugin.wallet.pay.a.c;

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

public class e extends i {
    private int oRh = -1;
    public Orders ryM = null;
    protected n ryV;

    public e(n nVar, Orders orders) {
        String str = null;
        this.ryM = orders;
        this.ryV = nVar;
        List list = orders.rGe;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fTA;
        }
        if (nVar.oLz == null) {
            w.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            return;
        }
        this.oRh = nVar.oLz.fRv;
        a(orders.fJH, str, nVar.oLz.fRv, nVar.oLz.fRr, nVar.ofd, nVar.ofe);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", nVar.flag);
        hashMap.put("passwd", nVar.rHx);
        w.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bg.mA(nVar.rHx))});
        a(nVar.oLz, hashMap, hashMap2, r0);
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        hashMap.put("bank_type", nVar.ofd);
        hashMap.put("bind_serial", nVar.ofe);
        hashMap.put("arrive_type", nVar.rDK);
        hashMap.put("default_favorcomposedid", nVar.rDN);
        hashMap.put("favorcomposedid", nVar.rDO);
        if (com.tencent.mm.wallet_core.c.n.ccc()) {
            hashMap2.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.n.cce());
            hashMap2.put("bindcard_scene", com.tencent.mm.wallet_core.c.n.ccd());
        }
        x(hashMap);
        am(hashMap2);
    }

    public int aki() {
        return 1;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            w.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.rzL = true;
                this.ryM = Orders.a(jSONObject, this.ryM);
            } else {
                this.rzL = false;
            }
            w.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.oRh);
            if (this.oRh == 39) {
                w.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
                b.Q(jSONObject);
                return;
            }
            w.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.oRh == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.oRh == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    public int zi() {
        if (this.oRh == 11) {
            return 1607;
        }
        if (this.oRh == 21) {
            return 1606;
        }
        return 462;
    }

    public final boolean bsI() {
        if (this.oRh == 11 || this.oRh == 21) {
            return true;
        }
        return false;
    }
}
