package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends h {
    public p(String str) {
        Map hashMap = new HashMap();
        hashMap.put("device_id", com.tencent.mm.compatible.d.p.rB());
        hashMap.put("passwd", str);
        x(hashMap);
    }

    public final int aki() {
        return 51;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
