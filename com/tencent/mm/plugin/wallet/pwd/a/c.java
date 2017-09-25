package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends h {
    public c(n nVar) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", nVar.flag);
        hashMap.put("passwd", nVar.rHx);
        hashMap.put("rpasswd", nVar.rHx);
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        a(nVar.oLz, hashMap, hashMap2);
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zi() {
        return 478;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
