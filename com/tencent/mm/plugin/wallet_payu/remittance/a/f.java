package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public int fJA;
    public int fRW;
    public double kBc;
    private String oQK;
    public int oQL;
    public String oga;
    public int rSK;
    public int rSL;
    public int status;

    public f(String str, String str2, int i) {
        this(str, str2, i, 1, 0);
    }

    public f(String str, String str2, int i, int i2, int i3) {
        this.oQK = null;
        this.oQK = str;
        this.fJA = 1;
        this.fRW = i3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        x(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.oQL = jSONObject.optInt("pay_time");
            this.kBc = jSONObject.optDouble("total_fee") / 100.0d;
            this.oga = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("pay_status");
            this.rSK = jSONObject.optInt("refund_time");
            this.rSL = jSONObject.optInt("receive_time");
        }
    }

    public final int btw() {
        return 25;
    }
}
