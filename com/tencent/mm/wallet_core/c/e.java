package com.tencent.mm.wallet_core.c;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h {
    public String wDV;

    public e(String str) {
        this.wDV = str;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("crt_no", p.encode(str));
        hashMap.put("deviceid", com.tencent.mm.compatible.d.p.getDeviceID(ab.getContext()));
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 1568;
    }

    public final int zi() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[]{Integer.valueOf(i), str});
    }
}
