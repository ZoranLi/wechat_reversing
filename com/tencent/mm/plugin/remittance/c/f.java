package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h {
    public String nnN = "";
    public String oQo = null;

    public f(String str, String str2, int i, String str3, String str4, int i2) {
        this.oQo = str3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put("transaction_id", str);
        hashMap.put("op", str3);
        hashMap.put("username", str4);
        hashMap.put("invalid_time", String.valueOf(i2));
        hashMap.put("total_fee", String.valueOf(i));
        w.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i);
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1691;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                this.nnN = optJSONObject.optString("guide_flag", "0");
            }
        }
    }
}
