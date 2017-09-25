package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l extends a {
    public int kAM = 0;
    public String oQV = "";
    public int oQW;
    public String oQk = "";
    public int oQp;

    public l(double d, String str, String str2, String str3, String str4, int i) {
        w.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        Map hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", str2);
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(bg.ap(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put("currency", String.valueOf(i));
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        x(hashMap);
    }

    public final int akg() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            w.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.oQk = jSONObject.optString("payurl");
        this.oQV = jSONObject.optString("tradeurl");
        this.oQp = jSONObject.optInt("transfering_num");
        this.oQW = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.oQk);
        stringBuffer.append(" tradeurl:" + this.oQV);
        stringBuffer.append(" transfering_num:" + this.oQp);
        stringBuffer.append(" transfering_type:" + this.oQW);
        w.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1622;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
