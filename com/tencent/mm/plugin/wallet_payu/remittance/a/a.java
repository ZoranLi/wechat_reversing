package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fFd;
    public String fJH;
    public String fVb;
    public String pin;
    public double rFM;
    public int rQF;
    public int rSG;
    public double rSH;
    public String rSI;
    public String rwo;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        this.fJH = str;
        this.pin = str2;
        this.rFM = d;
        this.fFd = str3;
        this.rSG = i == 2 ? 0 : i;
        this.fVb = str4;
        this.rwo = str5;
        Map hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        x(hashMap);
    }

    public final int btw() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.rQF = jSONObject.optInt("response_result");
        this.rSH = bg.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.rSI = jSONObject.optString("fee_type");
    }
}
