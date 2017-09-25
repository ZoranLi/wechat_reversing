package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fOv;
    public String pin;
    public String rRk;
    public String rRl;
    public String rRm;
    public String rRn;
    public String rRo;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.rRk = str;
        this.rRl = str2;
        this.pin = str3;
        this.rRn = str4;
        this.rRm = str4;
        this.rRo = str6;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("secret_question_id", str4);
        hashMap.put("secret_question_answer", str5);
        hashMap.put("payu_reference", str6);
        x(hashMap);
    }

    public final int btw() {
        return 5;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.fOv = jSONObject.optString("payu_reference");
    }
}
