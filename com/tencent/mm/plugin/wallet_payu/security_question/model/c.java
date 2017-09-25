package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String fOv;
    public String id;
    public String rSY;

    public c() {
        this("");
    }

    public c(String str) {
        this.fOv = str;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", bg.ap(str, ""));
        x(hashMap);
    }

    public final int btw() {
        return 23;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.id = jSONObject.optString(SlookAirButtonFrequentContactAdapter.ID);
        this.rSY = jSONObject.optString("description");
    }
}
