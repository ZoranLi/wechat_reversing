package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h {
    public e(String str, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("resetpwd_token", str2);
        hashMap.put("passwd", str);
        x(hashMap);
        am(hashMap2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", new Object[]{jSONObject.toString()});
    }

    public final int zi() {
        return 1371;
    }

    public final int aki() {
        return 1371;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
    }
}
