package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends h {
    public String desc;
    public double oQE;
    public String oga;

    public b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        x(hashMap);
    }

    public final int aki() {
        return 123;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.oga = jSONObject.optString("fee_type");
            this.oQE = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            ac btT = m.btT();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            btT.rIg.clear();
            if (optJSONObject == null) {
                w.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                return;
            }
            JSONObject jSONObject2;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                w.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            } else {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    d btE = d.btE();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard K = btE.K(jSONObject2);
                        if (K.btA()) {
                            K.field_desc = K.field_bankName;
                        } else if (K.btC()) {
                            K.field_desc = ab.getContext().getString(R.l.ffi, new Object[]{K.field_bankName, K.field_bankcardTail});
                        } else if (K.btz()) {
                            K.field_desc = ab.getContext().getString(R.l.fls, new Object[]{K.field_bankName, K.field_bankcardTail});
                        } else {
                            K.field_desc = ab.getContext().getString(R.l.ffw, new Object[]{K.field_bankName, K.field_bankcardTail});
                        }
                        btT.rIg.add(K);
                    }
                }
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                btT.rIh = jSONObject2.optString("last_card_bind_serialno");
            } else {
                w.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
            }
        }
    }

    public final int zi() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
