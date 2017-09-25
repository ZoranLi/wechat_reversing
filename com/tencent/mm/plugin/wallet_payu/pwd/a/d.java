package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String fOv;
    public String rSC;
    public String rSD;

    public d(String str, String str2) {
        this.rSC = str;
        this.rSD = str2;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        x(hashMap);
    }

    public final int btw() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fOv = jSONObject.optString("payu_reference");
    }
}
