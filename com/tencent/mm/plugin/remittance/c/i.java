package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends h {
    public double kBc;
    private String oQK = null;
    public int oQL;
    public String oQM;
    private String oQN;
    public String oQO;
    public int oQP;
    public String oQQ;
    public String oQR;
    public int oQS;
    public int ogI;
    public String oga;
    public String ogy;
    public int status;

    public i(int i, String str, String str2, int i2) {
        this.oQK = str;
        this.ogI = i;
        Map hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.oQL = jSONObject.optInt("pay_time");
            this.kBc = jSONObject.optDouble("fee") / 100.0d;
            this.oga = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("trans_status");
            this.oQN = jSONObject.optString("trans_status_name");
            this.oQP = jSONObject.optInt("modify_time");
            this.oQO = jSONObject.optString("payer_name");
            this.oQM = jSONObject.optString("receiver_name");
            this.ogy = jSONObject.optString("refund_bank_type");
            this.oQQ = jSONObject.optString("status_desc");
            this.oQR = jSONObject.optString("status_supplementary");
            this.oQS = jSONObject.optInt("delay_confirm_flag");
        }
    }
}
