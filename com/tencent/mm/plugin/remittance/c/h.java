package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends com.tencent.mm.wallet_core.f.a.h {
    public String desc;
    public double kBc;
    public String oQF;
    public String oQG;
    public String oQH = "";
    public String oQI = "";
    public String oQJ = "";
    public int scene;
    public String username;

    public h(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        am(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            w.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[]{jSONObject.toString()});
            this.username = jSONObject.optString("user_name");
            this.oQF = jSONObject.optString("true_name");
            this.kBc = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.oQG = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
            this.oQH = jSONObject.optString("f2f_pay_desc");
            this.oQI = jSONObject.optString("rcvr_desc");
            this.oQJ = jSONObject.optString("payer_desc");
        }
    }
}
