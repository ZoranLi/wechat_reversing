package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public String fLT = null;

    public a(int i, String str, String str2, String str3, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str3);
        hashMap.put("verify_code", str2);
        hashMap.put("pay_scene", String.valueOf(i2));
        x(hashMap);
        hashMap = new HashMap();
        if (n.ccc()) {
            hashMap.put("uuid_for_bindcard", n.cce());
            hashMap.put("bindcard_scene", n.ccd());
        }
        am(hashMap);
    }

    public final int aki() {
        return 76;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fLT = jSONObject.optString("req_key");
        }
    }

    public final int zi() {
        return 1506;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/verifybind";
    }
}
