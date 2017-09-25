package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends h {
    public String rBQ;
    public String rCe;

    public p(n nVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        hashMap.put("passwd", nVar.rHx);
        hashMap.put("relation_key", str);
        x(hashMap);
    }

    public final int aki() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.rBQ = jSONObject.optString("token_type");
            this.rCe = jSONObject.optString("usertoken");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int zi() {
        return 1604;
    }
}
