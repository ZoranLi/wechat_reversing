package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String fFd;
    public String fOv;
    public double rFM;
    public int rSJ;
    public String toUserName;

    public d(double d, String str, String str2, int i) {
        this.rFM = d;
        this.fFd = str;
        this.toUserName = str2;
        this.rSJ = i;
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("to_customer_name", str2);
        hashMap.put("transfer_type", String.valueOf(i));
        x(hashMap);
    }

    public final int btw() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fOv = jSONObject.optString("PrepayId");
    }
}
