package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fJH;
    public String kAj;
    public int kBd;
    public String pin;
    public String rJi;
    public String rQB;
    public String rQH;
    public String rQI;
    public String rQK;
    public double rSb;
    public String rSc;
    public double rSd;
    public String rSe;
    public boolean rSf;
    public boolean rSg;
    public String rSh;
    public String rSi;
    public String rSj;
    public String rwo;

    public b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        this.fJH = str;
        this.rSb = d;
        this.rSc = str2;
        this.rJi = str3;
        this.rwo = str4;
        this.rQB = str5;
        this.pin = str6;
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", str3);
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", str5);
        }
        hashMap.put("pin", str6);
        x(hashMap);
    }

    public final int btw() {
        return 9;
    }

    public final boolean isSuccess() {
        return this.rSh.equals("1");
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kAj = jSONObject.optString("trans_id");
            this.rSd = jSONObject.optDouble("total_fee") / 100.0d;
            this.rSe = jSONObject.optString("fee_type");
            this.rSf = jSONObject.optBoolean("redirect");
            this.rQH = jSONObject.optString("gateway_reference");
            this.rQI = jSONObject.optString("gateway_code");
            this.rSh = jSONObject.optString("pay_status");
            this.kBd = jSONObject.optInt("timestamp");
            this.rSi = jSONObject.optString("pay_status_name");
            this.rSj = jSONObject.optString("bank_type");
            this.rSg = jSONObject.optBoolean("is_force_adjust");
            this.rQK = jSONObject.optString("force_adjust_code");
        }
    }
}
