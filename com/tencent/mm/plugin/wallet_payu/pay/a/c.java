package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public Orders oSJ;
    private String ryT;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        this.oSJ = null;
        this.ryT = null;
        this.ryT = str;
        Map hashMap = new HashMap();
        hashMap.put("req_key", this.ryT);
        hashMap.put("query_scene", String.valueOf(i));
        x(hashMap);
    }

    public final int btw() {
        return 8;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.oSJ = Orders.L(jSONObject);
        if (this.oSJ != null) {
            this.oSJ.fJH = this.ryT;
        }
    }
}
