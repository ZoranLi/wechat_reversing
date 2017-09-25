package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends h {
    public int rBZ;
    public int rCa;
    public Profession[] rDo = null;

    public g() {
        Map hashMap = new HashMap();
        if (!bg.mA(null)) {
            hashMap.put("scene", null);
        }
        x(hashMap);
    }

    public final int aki() {
        return 1976;
    }

    public final int zi() {
        return 1976;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        w.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        w.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[]{jSONObject.toString()});
        this.rBZ = jSONObject.optInt("need_area");
        this.rCa = jSONObject.optInt("need_profession");
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optJSONArray != null) {
            this.rDo = new Profession[optJSONArray.length()];
            while (i2 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("profession_name");
                    int optInt = optJSONObject.optInt("profession_type");
                    if (bg.mA(optString)) {
                        w.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
                    } else {
                        this.rDo[i2] = new Profession(optString, optInt);
                    }
                }
                i2++;
            }
        }
    }
}
