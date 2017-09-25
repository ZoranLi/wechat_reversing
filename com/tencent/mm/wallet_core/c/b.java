package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class b {
    public String fLL = "";
    public String title = "";
    public String wDR = "";
    public String wDS = "";
    public String wDT = "";

    public b(String str) {
        if (!bg.mA(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString("title");
                this.wDR = jSONObject.optString("body1");
                this.wDS = jSONObject.optString("body2");
                this.wDT = jSONObject.optString("button");
            } catch (Exception e) {
                w.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[]{e.getMessage()});
            }
        }
    }
}
