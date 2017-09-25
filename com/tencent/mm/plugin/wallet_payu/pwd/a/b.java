package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("old_pin", str);
        hashMap.put("new_pin", str2);
        x(hashMap);
    }

    public final int btw() {
        return 2;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
