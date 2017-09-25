package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends h {
    public g(String str) {
        Map hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        x(hashMap);
    }

    public final int aki() {
        return 1663;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zi() {
        return 1663;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    public final int getType() {
        return super.getType();
    }
}
