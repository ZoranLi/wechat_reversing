package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h {
    public String rDe = null;
    public String rDf = null;
    public String rDg = null;
    public String rDh = null;
    public int rDi = 0;
    public long rDj = 0;
    public String title = null;

    public e(int i, int i2) {
        this.rDi = i2;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.rDe = jSONObject.optString("agreed_flag", "0");
            this.title = jSONObject.optString("title", "");
            this.rDf = jSONObject.optString("service_protocol_wording", "");
            this.rDg = jSONObject.optString("service_protocol_url", "");
            this.rDh = jSONObject.optString("button_wording", "");
            this.rDj = jSONObject.optLong("delay_expired_time", 0);
            if (this.rDj > 0) {
                ap.yY();
                c.vr().a(a.uDK, Long.valueOf(System.currentTimeMillis() + (this.rDj * 1000)));
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int zi() {
        return 1614;
    }
}
