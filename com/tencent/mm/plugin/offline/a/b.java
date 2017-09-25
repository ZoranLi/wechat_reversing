package com.tencent.mm.plugin.offline.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends h {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b() {
        Map hashMap = new HashMap();
        hashMap.put("ack_key", a.aRj());
        hashMap.put("req_key", a.aRk());
        hashMap.put("paymsg_type", a.aRl());
        hashMap.put("transactionid", a.aRm());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, a.ck(ab.getContext()));
        hashMap.put("processed", k.oci ? "1" : "0");
        x(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            w.v(this.TAG, "response ok");
            g.oUh.a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uHD, Integer.valueOf(optInt));
                return;
            }
            return;
        }
        w.v(this.TAG, "response fail");
        g.oUh.a(135, 69, 1, true);
    }

    public final int aki() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
