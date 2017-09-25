package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends h {
    public j(String str) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", p.rB());
        x(hashMap);
    }

    public final int aki() {
        return 47;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
    }

    public final int zi() {
        return 566;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
    }
}
