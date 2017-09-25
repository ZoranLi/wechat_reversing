package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends h {
    public j(String str, String str2, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("from", String.valueOf(i2));
        hashMap.put("invalid_time", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1545;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferresendmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + i + " errMsg: " + str);
    }
}
