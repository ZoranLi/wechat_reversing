package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fOv;
    public String fWV;
    public String pin;
    public String rRk;

    public final int btw() {
        return 17;
    }

    public b(String str, String str2, String str3, String str4) {
        this.rRk = str;
        this.fWV = str2;
        this.pin = str3;
        this.fOv = str4;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        x(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
