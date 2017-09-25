package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends h {
    private Map<String, String> ryJ = new HashMap();
    public String token = null;

    public d(Authen authen, boolean z) {
        this.ryJ.put("flag", authen.fRW);
        if (!bg.mA(authen.rDL)) {
            this.ryJ.put("first_name", authen.rDL);
            this.ryJ.put("last_name", authen.rDM);
            this.ryJ.put("country", authen.country);
            this.ryJ.put("area", authen.gkB);
            this.ryJ.put("city", authen.gkC);
            this.ryJ.put("address", authen.hCE);
            this.ryJ.put("phone_number", authen.mMc);
            this.ryJ.put("zip_code", authen.itg);
            this.ryJ.put("email", authen.gku);
        }
        this.ryJ.put("bank_type", authen.ofd);
        if (authen.rDF > 0) {
            this.ryJ.put("cre_type", authen.rDF);
        }
        if (!bg.mA(authen.rDD)) {
            this.ryJ.put("true_name", authen.rDD);
        }
        if (!bg.mA(authen.rDE)) {
            this.ryJ.put("identify_card", authen.rDE);
        }
        this.ryJ.put("mobile_no", authen.rBT);
        this.ryJ.put("bank_card_id", authen.rDG);
        if (!bg.mA(authen.rDH)) {
            this.ryJ.put("cvv2", authen.rDH);
        }
        if (!bg.mA(authen.rDI)) {
            this.ryJ.put("valid_thru", authen.rDI);
        }
        this.ryJ.put("new_card_reset_pwd", z ? "1" : "0");
        x(this.ryJ);
    }

    public final boolean aQi() {
        super.aQi();
        this.ryJ.put("is_repeat_send", "1");
        x(this.ryJ);
        return true;
    }

    public final int aki() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
    }

    public final String aQZ() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int zi() {
        return 469;
    }
}
