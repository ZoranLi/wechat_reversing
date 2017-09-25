package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends h {
    public k szw;

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        x(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        am(hashMap);
    }

    public final int aki() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.szw = new k();
                this.szw.szA = jSONObject.optInt("credit_state");
                this.szw.szv = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
                this.szw.szB = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
                this.szw.szC = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
                this.szw.szD = jSONObject.optInt("bill_date");
                this.szw.szE = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
                this.szw.szF = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
                k kVar = this.szw;
                if (jSONObject.optInt("upgrade_amount") != 1) {
                    z = false;
                }
                kVar.szG = z;
                this.szw.szH = jSONObject.optInt("bill_month");
                this.szw.szI = jSONObject.optString("repay_url");
                this.szw.szJ = jSONObject.optString("repay_lasttime");
                this.szw.szN = jSONObject.optString("lasttime");
                JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.getString("jump_name");
                        if ("account_rights_url".equals(string)) {
                            this.szw.szL = jSONObject2.getString("jump_url");
                        } else if ("bill_url".equals(string)) {
                            this.szw.szM = jSONObject2.getString("jump_url");
                        } else if ("card_detail_url".equals(string)) {
                            this.szw.szK = jSONObject2.getString("jump_url");
                        } else if ("know_more_url".equals(string)) {
                            this.szw.szO = jSONObject2.getString("jump_url");
                        }
                    }
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
                if (jSONObject3 != null) {
                    this.szw.szP = new j();
                    this.szw.szP.szz = jSONObject3.getString("app_telephone");
                    this.szw.szP.fFa = jSONObject3.getString("nickname");
                    this.szw.szP.username = jSONObject3.getString("username");
                    this.szw.szP.url = jSONObject3.getString("jump_url");
                }
            } catch (Throwable e) {
                w.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
