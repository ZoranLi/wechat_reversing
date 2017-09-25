package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends com.tencent.mm.wallet_core.f.a.h {
    public h(n nVar) {
        this(nVar, -1);
    }

    public h(n nVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(nVar.oLz, hashMap, hashMap2);
        hashMap.put("flag", nVar.flag);
        if ("2".equals(nVar.flag)) {
            hashMap.put("passwd", nVar.rHx);
        }
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        if (!(nVar.oLz == null || bg.mA(nVar.oLz.fJH))) {
            hashMap.put("req_key", nVar.oLz.fJH);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            w.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        if (com.tencent.mm.wallet_core.c.n.ccc()) {
            hashMap2.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.n.cce());
            hashMap2.put("bindcard_scene", com.tencent.mm.wallet_core.c.n.ccd());
        }
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("test", "test");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int zi() {
        return 472;
    }
}
