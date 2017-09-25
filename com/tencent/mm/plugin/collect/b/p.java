package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends h {
    public String desc;
    public String fFd;
    public String kBb = null;
    public double kBc;

    public p(double d, String str, String str2) {
        Map hashMap = new HashMap();
        try {
            hashMap.put("fee", Math.round(100.0d * d));
            hashMap.put("fee_type", str);
            hashMap.put("desc", URLEncoder.encode(str2, "UTF-8"));
        } catch (Throwable e) {
            w.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", e, "", new Object[0]);
        }
        this.kBc = d;
        this.fFd = str;
        this.desc = str2;
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1623;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.kBb = jSONObject.optString("pay_url");
        }
    }
}
