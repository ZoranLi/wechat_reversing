package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h implements j {
    public String fLV = "";
    public String lOL = "";
    public String lOp = "";

    public e(String str) {
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            w.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        x(hashMap);
    }

    public final int aki() {
        return 118;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lOp = jSONObject.optString("encrypted_device_info");
            this.fLV = jSONObject.optString("encrypted_rsa_sign");
            this.lOL = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.lOp)) {
                w.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                w.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.fLV)) {
                w.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                w.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.lOL)) {
                w.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
            } else {
                w.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    public final int zi() {
        return 1598;
    }
}
