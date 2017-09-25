package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fOv;
    public boolean rRJ;
    public String rRk;
    public String rRl;

    public b(String str, String str2) {
        this.rRk = str;
        this.rRl = str2;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        x(hashMap);
    }

    public final int btw() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.rRJ = jSONObject.optBoolean("has_mobile");
        this.fOv = jSONObject.optString("payu_reference");
    }
}
