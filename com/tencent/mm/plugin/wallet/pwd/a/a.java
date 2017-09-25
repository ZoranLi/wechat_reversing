package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        x(hashMap);
    }

    public final int aki() {
        return 9;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i + " errMsg: " + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    public final int zi() {
        return 468;
    }
}
