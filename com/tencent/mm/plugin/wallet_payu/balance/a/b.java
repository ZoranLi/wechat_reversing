package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fFd;
    public String fJH;
    public String kAj;
    public String pin;
    public double rFM;
    public String rQB;
    public String rQC;
    public String rQD;
    public String rQE;
    public int rQF;
    public boolean rQG;
    public String rQH;
    public String rQI;
    public boolean rQJ;
    public String rQK;

    public b(String str, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.pin = str;
        this.rQB = str2;
        this.fJH = str3;
        this.rFM = d;
        this.fFd = str4;
        this.rQC = str5;
        this.rQD = str6;
        this.rQE = str7;
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        x(hashMap);
    }

    public final int btw() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kAj = jSONObject.optString("trans_id");
        this.rQF = jSONObject.optInt("response_result");
        this.rQG = jSONObject.optBoolean("redirect");
        this.rQH = jSONObject.optString("gateway_reference");
        this.rQI = jSONObject.optString("gateway_code");
        this.rQJ = jSONObject.optBoolean("is_force_adjust");
        this.rQK = jSONObject.optString("force_adjust_code");
    }
}
