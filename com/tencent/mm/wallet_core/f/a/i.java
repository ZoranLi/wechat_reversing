package com.tencent.mm.wallet_core.f.a;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class i extends k {
    private static int wEJ = 0;
    private String ocA;
    private String ocB;
    private String ocC;
    private String ocD;
    public RealnameGuideHelper ocy;
    private String ocz;
    protected int ofL;
    public int rGn = 0;
    protected Map<String, String> wEH = new HashMap();
    public int wEI = 0;
    private boolean wEK = false;
    public int wEL = 0;
    public int wEM = 0;
    public String wEN = null;
    public JSONObject wEO = null;
    private boolean wEP = false;

    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        wEJ++;
        this.wEH.put("req_key", str);
        this.wEH.put("transaction_id", str2);
        this.wEH.put("pay_scene", String.valueOf(i));
        this.wEH.put("bank_type", str3);
        this.wEH.put("channel", String.valueOf(i2));
        this.wEH.put("bind_serial", str4);
    }

    public final Map<String, String> ccu() {
        return this.wEH;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        if (!this.wEK) {
            this.wEM = i;
            this.wEN = str;
            this.wEO = jSONObject;
            this.wEK = true;
            if (jSONObject != null) {
                this.wEI = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject != null && jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.ocz = optJSONObject.optString("guide_flag");
            this.ocA = optJSONObject.optString("guide_wording");
            this.ocB = optJSONObject.optString("left_button_wording");
            this.ocC = optJSONObject.optString("right_button_wording");
            this.ocD = optJSONObject.optString("upload_credit_url");
            if ("1".equals(this.ocz) || "2".equals(this.ocz)) {
                this.ocy = new RealnameGuideHelper();
                this.ocy.a(this.ocz, this.ocA, this.ocB, this.ocC, this.ocD, this.ofL);
            }
        }
        this.wEP = true;
        super.a(i, str, jSONObject);
    }

    public final boolean ccv() {
        return this.wEI == 1;
    }

    public final void a(c cVar, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
        if (!this.wEP && !this.wEK) {
            this.wEL = cVar.errType;
            this.wEM = cVar.errCode;
            this.wEN = cVar.fPf;
            if (jSONObject != null) {
                this.wEI = jSONObject.optInt("query_order_flag", 0);
                this.wEO = jSONObject;
            }
            this.wEK = true;
        }
    }

    public boolean bsI() {
        return false;
    }

    public final boolean bfA() {
        return false;
    }
}
