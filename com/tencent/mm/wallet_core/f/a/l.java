package com.tencent.mm.wallet_core.f.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends h {
    public l() {
        x(new HashMap());
    }

    public final int aki() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (bg.mA(optString)) {
            w.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            m.setTimeStamp((System.currentTimeMillis() / 1000));
            return;
        }
        m.setTimeStamp(optString);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    public final int zi() {
        return 477;
    }
}
