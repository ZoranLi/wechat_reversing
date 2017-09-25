package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class b {
    public boolean lva;
    public Bankcard rIX;
    public String rIY;
    public String rIZ;
    public boolean rJa;
    public int rJb;

    public static String P(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
        return jSONObject2.toString();
    }

    public b(Bankcard bankcard) {
        this.rIX = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.rIX.field_ext_msg);
            this.rIY = jSONObject.optString("information");
            this.lva = jSONObject.optBoolean("verified");
            this.rIZ = jSONObject.optString("card_expiry");
            this.rJb = jSONObject.optInt("cvv_length");
            this.rJa = jSONObject.optBoolean("is_credit");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
    }
}
