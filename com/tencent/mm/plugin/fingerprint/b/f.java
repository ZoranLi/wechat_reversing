package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h implements j {
    public f(String str, String str2, String str3, int i) {
        Map hashMap = new HashMap();
        hashMap.put("encrypted_open_info", URLEncoder.encode(str));
        hashMap.put("encrypted_rsa_sign", URLEncoder.encode(str2));
        hashMap.put("passwd", str3);
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("open_scene", String.valueOf(i));
        am(hashMap);
    }

    public final int aki() {
        return 119;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
            e.el(true);
            return;
        }
        w.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
    }

    public final int zi() {
        return 1599;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
    }
}
