package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends h {
    public static String ocF = "";
    public static String ocX = "";
    private int kAC = -1;
    private String kAD = "";
    public String ocY = "";
    public String ocZ = "";
    public int ocv = -1;
    public String ocw = "";
    public String oda = "";

    public n(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("device_id", p.rB());
        hashMap.put("timestamp", str);
        hashMap.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.rB());
        stringBuilder.append("&");
        stringBuilder.append(str);
        hashMap.put("sign", aa.Pq(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        ap.yY();
        hashMap.put("code_ver", stringBuilder2.append(c.vr().get(a.uzn, "")).toString());
        x(hashMap);
    }

    public final int aki() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            ocF = jSONObject.optString("limit_fee");
            ocX = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.aQd();
            k.af(196629, ocF);
            k.aQd();
            k.af(196641, ocX);
            k.aQd();
            k.af(196645, optString);
            k.aQd();
            k.af(196646, optString2);
            com.tencent.mm.plugin.offline.c.a.Ce(optString3);
            this.kAC = jSONObject.optInt("retcode");
            this.kAD = jSONObject.optString("retmsg");
            this.ocv = jSONObject.optInt("wx_error_type");
            this.ocw = jSONObject.optString("wx_error_msg");
            this.ocY = jSONObject.optString("get_code_flag");
            this.ocZ = jSONObject.optString("micropay_pause_flag");
            this.oda = jSONObject.optString("micropay_pause_word");
        }
    }

    public final int zi() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
