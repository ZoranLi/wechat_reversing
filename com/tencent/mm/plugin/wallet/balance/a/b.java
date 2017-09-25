package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends h {
    public int fEG = 0;
    public String fLT = null;
    public String fZb;
    public String fZc;
    public String fZd;
    public String fZe;
    public String fZf;
    public double oQE = 0.0d;
    public double oQs = 0.0d;
    public com.tencent.mm.plugin.wallet_core.model.b rtA;
    public com.tencent.mm.plugin.wallet_core.model.b rtB;
    public boolean rty = false;
    public String rtz = "";

    public b(double d, String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fLT = jSONObject.optString("req_key");
            this.rty = "1".equals(jSONObject.optString("should_alert"));
            this.rtz = jSONObject.optString("alert_msg");
            this.oQs = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            this.oQE = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
            JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
            if (optJSONObject != null) {
                w.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
                this.rtA = aa.a(optJSONObject, false);
            } else {
                w.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
            }
            optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
            if (optJSONObject != null) {
                w.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
                this.rtB = aa.a(optJSONObject, false);
            } else {
                w.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
            }
            this.fEG = jSONObject.optInt("operation", 0);
            w.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.oQs + " total_fee:" + this.oQE + " operation:" + this.fEG);
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                w.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.fZb = optJSONObject.optString("guide_flag");
                this.fZc = optJSONObject.optString("guide_wording");
                this.fZd = optJSONObject.optString("left_button_wording");
                this.fZe = optJSONObject.optString("right_button_wording");
                this.fZf = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int zi() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }
}
