package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends h {
    public String rBQ;
    private int scene;
    public String token;

    public i(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i == 6) {
            hashMap.put("time_stamp", System.currentTimeMillis());
        }
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        if (n.ccc()) {
            hashMap.put("uuid_for_bindcard", n.cce());
            hashMap.put("bindcard_scene", n.ccd());
        }
        am(hashMap);
        this.scene = i;
    }

    public final int aki() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (this.scene == 6) {
            this.token = jSONObject.optString("usertoken");
            this.rBQ = jSONObject.optString("token_type");
        }
    }

    public final int zi() {
        return 476;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
