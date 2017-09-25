package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends z {
    public String njw;
    public String nnL;
    public String nnM;

    public ad(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i));
        hashMap.put("wishing", URLEncoder.encode(bg.mz(str)));
        hashMap.put("sendUserName", str4);
        if (!bg.mA(str3)) {
            hashMap.put("username", str3);
        }
        if (!bg.mA(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!bg.mA(str5)) {
            hashMap.put("nickName", URLEncoder.encode(bg.mz(str5)));
        }
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", String.valueOf(i3));
        x(hashMap);
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    public final int getType() {
        return 1643;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.njw = jSONObject.optString("sendId");
        this.nnL = jSONObject.optString("reqkey");
        this.nnM = jSONObject.optString("sendMsgXml");
    }
}
