package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public a(int i) {
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 1584;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + i + ";errMsg = " + str);
    }

    public final int zi() {
        return 1584;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
    }
}
