package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends h {
    public String name;
    public String szt;
    public boolean szu = true;
    public String token;

    public b(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        am(hashMap);
    }

    public final int aki() {
        return 63;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.token = jSONObject.optString("session_key");
            if ("1".equals(jSONObject.optString("all_info"))) {
                this.szu = false;
                return;
            }
            this.szu = true;
            this.name = jSONObject.optString("name");
            this.szt = jSONObject.optString("cre_id");
        }
    }
}
