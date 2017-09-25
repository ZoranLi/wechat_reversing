package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fOv;
    public String rRG;
    public boolean rRH;
    public String rRI;

    public a(String str, String str2) {
        this.rRG = str;
        this.fOv = str2;
        Map hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", str2);
        x(hashMap);
    }

    public final int btw() {
        return 4;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.rRH = jSONObject.optBoolean("verified");
        this.rRI = jSONObject.optString("payu_reference");
    }
}
