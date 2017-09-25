package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h {
    public String rDk;
    public String rDl;
    public String rDm;
    public String rDn;

    public f() {
        Map hashMap = new HashMap();
        hashMap.put("channel", "1");
        x(hashMap);
    }

    public final int aki() {
        return 1630;
    }

    public final int zi() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0 && jSONObject != null) {
            this.rDk = jSONObject.optString("guide_flag");
            this.rDl = jSONObject.optString("guide_wording");
            this.rDm = jSONObject.optString("left_button_wording");
            this.rDn = jSONObject.optString("right_button_wording");
        }
    }
}
