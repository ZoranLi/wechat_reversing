package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends h {
    public String fLT = null;
    public String fZb;
    public String fZc;
    public String fZd;
    public String fZe;
    public String fZf;
    public boolean rty = false;
    public String rtz = "";

    public c(double d, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        x(hashMap);
    }

    public final int aki() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fLT = jSONObject.optString("req_key");
            this.rty = "1".equals(jSONObject.optString("should_alert"));
            this.rtz = jSONObject.optString("alert_msg");
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                w.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.fZb = optJSONObject.optString("guide_flag");
                this.fZc = optJSONObject.optString("guide_wording");
                this.fZd = optJSONObject.optString("left_button_wording");
                this.fZe = optJSONObject.optString("right_button_wording");
                this.fZf = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int zi() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }
}
