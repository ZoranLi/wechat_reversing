package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends com.tencent.mm.wallet_core.f.a.h {
    public h(String str, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str5);
        am(hashMap);
    }

    public final int aki() {
        return 66;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
    }
}
