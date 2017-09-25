package com.tencent.mm.wallet_core.c;

import org.json.JSONObject;

public final class p {
    public String ufv = "";
    public String wEm = "";
    public String wEn = "";
    public String wEo = "";
    public int wEp = 0;

    public p(JSONObject jSONObject) {
        this.wEm = jSONObject.optString("device_id");
        this.wEn = jSONObject.optString("device_name");
        this.wEo = jSONObject.optString("device_os");
        this.wEp = jSONObject.optInt("Is_cur_device");
        this.ufv = jSONObject.optString("crt_no");
    }
}
