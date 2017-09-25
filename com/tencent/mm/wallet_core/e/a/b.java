package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        x(new HashMap());
    }

    public final int btw() {
        return 28;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!bg.mA(optString)) {
            m.setTimeStamp(optString);
        }
    }
}
