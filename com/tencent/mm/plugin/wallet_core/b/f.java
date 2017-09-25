package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.Orders.b;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h {
    public String ksO;
    public b rBN;
    public String rBO;
    public String rBP;

    public f(b bVar, String str, String str2, long j) {
        this.rBN = bVar;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", bVar.rGI);
        hashMap.put("award_id", bVar.rGK);
        hashMap.put("send_record_id", bVar.rGL);
        hashMap.put("user_record_id", bVar.rGM);
        hashMap.put("req_key", str);
        hashMap.put("transaction_id", str2);
        hashMap.put("activity_mch_id", String.valueOf(j));
        x(hashMap);
    }

    public final int aki() {
        return 1589;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.rBO = jSONObject.optString("result_code");
            this.ksO = jSONObject.optString("result_msg");
            this.rBP = jSONObject.optString("alert_wording");
        }
    }

    public final int zi() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
