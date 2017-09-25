package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import org.json.JSONObject;

public final class q extends h {
    public double oQw;
    public String oRw;
    public String rCf;
    public double rCg;

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            w.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            return;
        }
        this.rCf = jSONObject.optString("short_desc");
        this.oRw = jSONObject.optString("charge_desc");
        this.rCg = jSONObject.optDouble("acc_fee");
        this.oQw = jSONObject.optDouble("remain_fee") / 100.0d;
    }
}
