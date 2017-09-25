package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends com.tencent.mm.wallet_core.f.a.h {
    public h(String str, String str2, String str3, Profession profession) {
        w.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s", new Object[]{str, str2, str3});
        Map hashMap = new HashMap();
        if (!bg.mA(str)) {
            hashMap.put("user_country", str);
        }
        if (!bg.mA(str2)) {
            hashMap.put("user_province", str2);
        }
        if (!bg.mA(str3)) {
            hashMap.put("user_city", str3);
        }
        if (profession != null) {
            w.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", new Object[]{profession.rDp, Integer.valueOf(profession.rDq)});
            hashMap.put("profession_name", profession.rDp);
            hashMap.put("profession_type", String.valueOf(profession.rDq));
        }
        x(hashMap);
    }

    public final int aki() {
        return 1978;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
    }

    public final int zi() {
        return 1978;
    }
}
