package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String token = "";

    public c(String str) {
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        x(hashMap);
    }

    public final int btw() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + i + " errMsg: " + str);
        this.token = jSONObject.optString("payu_reference");
    }
}
