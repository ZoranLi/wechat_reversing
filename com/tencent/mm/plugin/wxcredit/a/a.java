package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    public String fOI;
    public boolean fYU = true;
    private Map<String, String> ryJ = new HashMap();
    public boolean szs = false;
    public String token;

    public a(String str, String str2, String str3, String str4) {
        this.ryJ.put("session_key", str3);
        this.ryJ.put("bank_type", str4);
        this.ryJ.put("name", str);
        this.ryJ.put("cre_id", str2);
        x(this.ryJ);
    }

    public final boolean aQi() {
        super.aQi();
        this.ryJ.put("retry", "1");
        x(this.ryJ);
        return true;
    }

    public final int aki() {
        return 64;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.optString("session_key");
                this.fYU = "1".equals(jSONObject.getString("need_bind"));
                this.szs = "1".equals(jSONObject.getString("bank_user"));
                this.fOI = jSONObject.optString("mobile_no");
            } catch (Throwable e) {
                w.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
