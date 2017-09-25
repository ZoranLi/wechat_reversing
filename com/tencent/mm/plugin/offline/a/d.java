package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends h {
    public String ocr;
    public int ocs;
    public String oct;

    public d() {
        Map hashMap = new HashMap();
        ap.yY();
        Object obj = c.vr().get(a.uHE, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put("timestamp", System.currentTimeMillis());
        x(hashMap);
    }

    public final int aki() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            g.oUh.a(135, 56, 1, true);
            this.ocr = jSONObject.optString("appmsg");
            this.ocs = jSONObject.optInt("poll_time") * 1000;
            this.oct = jSONObject.optString("ack_key");
            if (this.ocs > 0) {
                ap.yY();
                c.vr().a(a.uHD, Integer.valueOf(this.ocs));
            }
            ap.yY();
            c.vr().a(a.uHE, this.oct);
            return;
        }
        g.oUh.a(135, 57, 1, true);
    }

    public final boolean aQi() {
        return false;
    }
}
