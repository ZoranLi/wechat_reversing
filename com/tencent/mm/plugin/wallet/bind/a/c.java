package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends h {
    public boolean fYT = false;
    public ArrayList<Bankcard> ruj = null;
    public boolean rwp = true;
    public String rwq;
    public String rwr;
    private String rws;
    public String token;

    public c(String str, PayInfo payInfo) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        ap.yY();
        o oVar = new o(bg.a((Integer) com.tencent.mm.u.c.vr().get(9, null), 0));
        this.rws = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", oVar.toString());
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.ruj = new ArrayList();
            try {
                this.fYT = "1".equals(jSONObject.optString("is_reg", "0"));
                this.token = jSONObject.optString("token", "");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Bankcard K = d.btE().K(jSONObject2);
                    if (K != null) {
                        if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                            K.field_cardType |= Bankcard.rDX;
                        }
                        K.field_bankcardTail = jSONObject2.optString("bank_tail");
                        K.rEd = "************" + K.field_bankcardTail;
                        K.field_trueName = jSONObject2.optString("true_name");
                        K.rEc = jSONObject2.optString("cre_id");
                        K.rDF = jSONObject2.optInt("cre_type", -1);
                        K.rEn = this.rws;
                        K.rEo = 1 == jSONObject2.optInt("samecardexist", 0);
                        if (K.btA()) {
                            K.field_desc = K.field_bankName;
                        } else if (K.btC()) {
                            K.field_desc = ab.getContext().getString(R.l.ffi, new Object[]{K.field_bankName, K.field_bankcardTail});
                        } else if (K.btz()) {
                            K.field_desc = ab.getContext().getString(R.l.fls, new Object[]{K.field_bankName, K.field_bankcardTail});
                        } else {
                            K.field_desc = ab.getContext().getString(R.l.ffw, new Object[]{K.field_bankName, K.field_bankcardTail});
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                        if (optJSONObject != null) {
                            this.rwq = optJSONObject.optString("username");
                            this.rwr = optJSONObject.optString("app_recommend_desc");
                        }
                        this.ruj.add(K);
                    }
                }
                w.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.fYT + ",bankcard.size:" + this.ruj.size());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            }
        }
    }
}
