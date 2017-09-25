package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends h {
    public c() {
        m.btW().gUz.eE("WalletBulletin", "delete from WalletBulletin");
        x(new HashMap());
    }

    public final int aki() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int zi() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            p.N(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            w.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + optLong);
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uCX, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.h btJ = com.tencent.mm.plugin.wallet_core.model.h.btJ();
                    if (optJSONArray != null) {
                        w.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        btJ.rFv = optJSONArray;
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(a.uDO, optJSONArray.toString());
                    }
                }
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDP, optJSONObject.optString("title"));
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDQ, optJSONObject.optString("content"));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("balance_title");
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDR, optString);
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uDS, optString2);
            }
        }
    }
}
