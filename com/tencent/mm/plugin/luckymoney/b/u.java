package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends z {
    long fGM;
    String fJL;
    public e nnk;
    public String nnw;

    public u(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, "");
    }

    public u(String str, int i, String str2, long j, String str3, String str4) {
        this.nnk = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        x(hashMap);
    }

    public u(String str, int i, int i2, String str2, String str3, String str4) {
        this.nnk = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        x(hashMap);
    }

    public final int getType() {
        return 1585;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.nnk = l.z(jSONObject);
            this.nnw = jSONObject.optString("processContent");
        } catch (JSONException e) {
            w.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }
}
