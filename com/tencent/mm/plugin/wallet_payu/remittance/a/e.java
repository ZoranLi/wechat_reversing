package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public String desc;
    public double kBc;
    public int kBd;
    public String oQF;
    public String oQG;
    public int scene;
    public String username;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        x(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.username = jSONObject.optString("user_name");
            this.oQF = jSONObject.optString("true_name");
            this.kBc = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.oQG = jSONObject.optString("transfer_qrcode_id");
            this.kBd = jSONObject.optInt("time_stamp");
        }
    }

    public final int btw() {
        return 24;
    }
}
