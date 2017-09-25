package com.tencent.mm.plugin.wallet_core.a.a;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends h {
    private Map<String, String> ryJ = new HashMap();
    private Map<String, String> ryK = new HashMap();
    public String ryT = null;
    public String token = null;

    public a(Authen authen) {
        a(authen.oLz, this.ryJ, this.ryK);
        this.ryJ.put("flag", authen.fRW);
        this.ryJ.put("bank_type", authen.ofd);
        if (!bg.mA(authen.rDC)) {
            this.ryJ.put("passwd", authen.rDC);
        }
        if (!bg.mA(authen.token)) {
            this.ryJ.put("token", authen.token);
        }
        if (!bg.mA(authen.rws)) {
            ap.yY();
            o oVar = new o(bg.a((Integer) c.vr().get(9, null), 0));
            this.ryJ.put("import_code", authen.rws);
            this.ryJ.put("qqid", oVar.toString());
            if (authen.rDF > 0) {
                this.ryJ.put("cre_type", authen.rDF);
            }
            this.ryJ.put("bind_serailno", authen.ofe);
        }
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
            this.ryJ.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, v.bIN());
        }
        if (!bg.mA(authen.rDD)) {
            this.ryJ.put("true_name", authen.rDD);
        }
        if (!bg.mA(authen.rDE)) {
            this.ryJ.put("identify_card", authen.rDE);
        }
        if (authen.rDF > 0) {
            this.ryJ.put("cre_type", authen.rDF);
        }
        if (!bg.mA(authen.rBT)) {
            this.ryJ.put("mobile_no", authen.rBT);
        }
        this.ryJ.put("bank_card_id", authen.rDG);
        if (!bg.mA(authen.rDH)) {
            this.ryJ.put("cvv2", authen.rDH);
        }
        if (!bg.mA(authen.rDI)) {
            this.ryJ.put("valid_thru", authen.rDI);
        }
        if (n.ccc()) {
            this.ryK.put("uuid_for_bindcard", n.cce());
            this.ryK.put("bindcard_scene", n.ccd());
        }
        x(this.ryJ);
        am(this.ryK);
    }

    public final boolean aQi() {
        super.aQi();
        this.ryJ.put("is_repeat_send", "1");
        x(this.ryJ);
        return true;
    }

    public final int aki() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ryT = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
    }

    public final String aQZ() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int zi() {
        return 471;
    }
}
