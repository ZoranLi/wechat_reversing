package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends h {
    public String rBR;
    public int rBS;
    public String rBT;
    public String rBU;

    public j(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        x(hashMap);
        am(new HashMap());
    }

    public j(String str, String str2, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        x(hashMap);
        am(new HashMap());
    }

    public final int aki() {
        return 100;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.rBR = jSONObject.optString("usertoken");
        this.rBS = jSONObject.optInt("is_free_sms");
        this.rBT = jSONObject.optString("mobile_no");
        this.rBU = jSONObject.optString("relation_key");
    }

    public final boolean btt() {
        return this.rBS == 0;
    }

    public final int zi() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
