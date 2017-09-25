package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends z {
    public a fVx;
    public int kAx;
    public String njw;
    public String nnL;
    public String nnM;
    public String nnN;
    public String nnO;
    public String nnP = "";
    public String nnQ = "";
    public String nnR = "";

    public ac(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.kAx = i;
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bg.mz(str)));
        hashMap.put("sendUserName", str5);
        if (!bg.mA(str3)) {
            hashMap.put("username", str3);
        }
        if (!bg.mA(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(bg.mz(str6)));
            if (!bg.mA(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", "0");
        }
        x(hashMap);
    }

    public final int getType() {
        return 1575;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.njw = jSONObject.optString("sendId");
        this.nnL = jSONObject.optString("reqkey");
        this.nnM = jSONObject.optString("sendMsgXml");
        this.nnN = jSONObject.optString("guide_flag", "0");
        this.nnO = jSONObject.optString("guide_wording");
        this.nnP = jSONObject.optString("left_button_wording", "");
        this.nnQ = jSONObject.optString("right_button_wording", "");
        this.nnR = jSONObject.optString("upload_credit_url", "");
        if (jSONObject.has("showmess")) {
            w.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
            this.fVx = C(jSONObject);
        }
    }

    public static a C(JSONObject jSONObject) {
        a aVar = new a();
        aVar.fNG = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.nnP = optJSONObject.optString("left_button_wording");
        aVar.nnQ = optJSONObject.optString("right_button_wording");
        aVar.kAJ = optJSONObject.optString("right_button_url");
        return aVar;
    }
}
