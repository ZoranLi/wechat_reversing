package com.tencent.mm.plugin.wallet_core.b.b;

import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    private boolean rCp;

    public a() {
        this("");
    }

    public a(String str) {
        this(str, true);
    }

    public a(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        x(hashMap);
        this.rCp = z;
    }

    public final int btw() {
        return 1;
    }

    public final int a(e eVar, com.tencent.mm.y.e eVar2) {
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            try {
                Bankcard bankcard;
                long optLong = jSONObject.optLong("time_stamp");
                if (optLong > 0) {
                    m.setTimeStamp(String.valueOf(optLong));
                } else {
                    w.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                ae aeVar = new ae();
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    aeVar = null;
                } else {
                    aeVar.field_is_reg = bg.getInt(jSONObject2.optString("is_reg"), 0);
                    aeVar.field_true_name = jSONObject2.optString("true_name");
                    aeVar.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                    aeVar.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                    com.tencent.mm.plugin.wallet_core.model.m.btS();
                    af.HY(aeVar.field_main_card_bind_serialno);
                }
                aeVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
                ArrayList r = r(jSONObject.optJSONArray("Array"));
                jSONObject2 = jSONObject.optJSONObject("balance_info");
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    bankcard = null;
                } else {
                    bankcard = new Bankcard((byte) 0);
                    bankcard.rEh = ((double) jSONObject2.optInt("avail_balance")) / 100.0d;
                    bankcard.rEj = ((double) jSONObject2.optInt("fetch_balance")) / 100.0d;
                    bankcard.field_bankcardType = jSONObject2.optString("balance_bank_type");
                    bankcard.field_bindSerial = jSONObject2.optString("balance_bind_serial");
                    bankcard.field_forbidWord = jSONObject2.optString("balance_forbid_word");
                    bankcard.field_desc = ab.getContext().getString(R.l.ffQ);
                    bankcard.field_cardType |= Bankcard.rDZ;
                }
                com.tencent.mm.plugin.wallet_core.model.m.btS().a(aeVar, r, null, bankcard, null, null, null, null, 0, 0, null);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", e, "", new Object[0]);
            }
            if (this.rCp && !com.tencent.mm.plugin.wallet_core.model.m.btS().bum()) {
                this.gUD.a(1000, -100869, "", this);
                this.wEb = true;
            }
        }
    }

    private static ArrayList<Bankcard> r(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("extra_bind_flag", "NORMAL");
                Bankcard K = com.tencent.mm.plugin.wallet_core.model.a.a.buH().K(jSONObject);
                if (K != null) {
                    arrayList.add(K);
                }
            }
        }
        return arrayList;
    }
}
