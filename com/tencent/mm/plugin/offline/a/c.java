package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends h {
    public c(String str) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        x(hashMap);
    }

    public final int aki() {
        return 1385;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("NetSceneOfflineCancelPay", "errcode=" + i + ";errmsg=" + str);
    }
}
