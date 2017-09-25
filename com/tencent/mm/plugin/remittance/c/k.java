package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends a {
    public int kAM = 0;
    public String kAO;
    public String kAP;
    public String oQT = "";
    public String oQU = "";

    public k(int i) {
        w.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        Map hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        x(hashMap);
    }

    public final int akg() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            w.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.kAM = jSONObject.optInt("currency");
        this.oQT = jSONObject.optString("currencyUint");
        this.oQU = jSONObject.optString("currencyWording");
        this.kAO = jSONObject.optString("notice");
        this.kAP = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.kAM);
        stringBuffer.append(" currencyuint:" + this.oQT);
        stringBuffer.append(" currencywording:" + this.oQU);
        stringBuffer.append(" notice:" + this.kAO);
        stringBuffer.append(" notice_url:" + this.kAP);
        w.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1574;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
