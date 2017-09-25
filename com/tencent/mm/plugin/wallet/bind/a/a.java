package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public int rwm;
    public String rwn;

    public a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        x(hashMap);
    }

    public final int aki() {
        return 1540;
    }

    public final int zi() {
        return 1540;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i != 0) {
            return;
        }
        if (jSONObject != null) {
            this.rwm = jSONObject.optInt("unbindbannerlevel", 0);
            this.rwn = jSONObject.optString("unbindbannerwording");
            return;
        }
        w.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
    }
}
