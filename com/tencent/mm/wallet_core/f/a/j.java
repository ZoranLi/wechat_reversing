package com.tencent.mm.wallet_core.f.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends h {
    public String appId;
    public String fGa;
    public String fJH;
    public int fRr;
    public String kAZ;
    public String rPJ;
    public int scene;
    public String wEQ;

    public j(String str, int i, int i2, int i3, int i4, String str2) {
        this.scene = i;
        this.fRr = i3;
        Map hashMap = new HashMap();
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        w.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[]{Integer.valueOf(i4), str2});
        if (i4 < 0) {
            w.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[]{Integer.valueOf(i4), str2});
            hashMap.put("source_type", "0");
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        x(hashMap);
    }

    public final int aki() {
        return 127;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        w.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[]{jSONObject.toString()});
        this.fJH = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.rPJ = jSONObject.optString("appsource");
        this.fGa = jSONObject.optString("productid");
        this.wEQ = jSONObject.optString("retcode");
        this.kAZ = jSONObject.optString("retmsg");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    public final int zi() {
        return 1694;
    }
}
