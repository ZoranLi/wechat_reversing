package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a rIW = null;

    public static a buH() {
        if (rIW == null) {
            rIW = new a();
        }
        return rIW;
    }

    public final Bankcard K(JSONObject jSONObject) {
        Bankcard K = super.K(jSONObject);
        K.field_ext_msg = b.P(jSONObject);
        K.field_bankcardClientType = 1;
        K.field_desc = jSONObject.optString("description");
        K.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            K.field_cardType |= Bankcard.rDX;
        } else {
            K.field_cardType |= Bankcard.rDZ;
        }
        return K;
    }
}
