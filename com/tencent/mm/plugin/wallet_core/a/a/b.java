package com.tencent.mm.plugin.wallet_core.a.a;

import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends h {
    public b(n nVar) {
        this(nVar, -1);
    }

    public b(n nVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", nVar.flag);
        hashMap.put("passwd", nVar.rHx);
        hashMap.put("verify_code", nVar.rHy);
        hashMap.put("token", nVar.token);
        hashMap.put("bind_flag", nVar.rHz ? "1" : "0");
        if (i > 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            w.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        if (com.tencent.mm.wallet_core.c.n.ccc()) {
            hashMap2.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.n.cce());
            hashMap2.put("bindcard_scene", com.tencent.mm.wallet_core.c.n.ccd());
        }
        a(nVar.oLz, hashMap, hashMap2);
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 17;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    public final int zi() {
        return 475;
    }
}
