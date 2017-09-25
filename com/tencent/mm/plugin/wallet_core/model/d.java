package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import org.json.JSONObject;

public class d {
    private static d rEq = null;

    public static d btE() {
        if (rEq == null) {
            rEq = new d();
        }
        return rEq;
    }

    public Bankcard K(JSONObject jSONObject) {
        String str;
        int i = 1;
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object obj = jSONObject;
        }
        objArr[0] = str;
        w.i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            w.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[]{bankcard.field_bindSerial});
            bankcard.rEf = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 2)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.rDX;
            }
            if ("NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.rDY;
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            if (bg.mA(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (bg.mA(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.rEd = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!bg.mA(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag != 2) {
                i = 0;
            }
            if (i != 0) {
                bankcard.field_cardType |= Bankcard.rDW;
            }
            CharSequence optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if ("0".equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            w.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            w.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            w.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            w.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            return bankcard;
        } catch (Throwable e) {
            w.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            w.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            w.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            w.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            return null;
        } catch (Throwable e22) {
            w.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e22.getMessage());
            w.printErrStackTrace("MicroMsg.BankcardParser", e22, "", new Object[0]);
            return null;
        }
    }
}
