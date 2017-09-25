package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa {
    public static void a(JSONObject jSONObject, int i) {
        w.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard()");
        try {
            ae aeVar;
            Object obj;
            Bankcard bankcard;
            Bankcard bankcard2;
            Object ap;
            j jVar;
            Bankcard bankcard3;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                m.setTimeStamp(String.valueOf(optLong));
            } else {
                w.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            w.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
            ae aeVar2 = new ae();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                w.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
                aeVar = null;
            } else {
                aeVar2.field_is_reg = jSONObject2.getInt("is_reg");
                aeVar2.field_true_name = jSONObject2.optString("true_name");
                aeVar2.field_cre_type = jSONObject2.optInt("cre_type", -1);
                aeVar2.field_main_card_bind_serialno = jSONObject2.optString("last_card_bind_serialno");
                aeVar2.field_cre_name = jSONObject2.optString("cre_name");
                aeVar2.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                aeVar2.field_reset_passwd_flag = jSONObject2.optString("reset_passwd_flag");
                aeVar2.field_find_passwd_url = jSONObject2.optString("reset_passwd_url");
                m.btS();
                af.HY(aeVar2.field_main_card_bind_serialno);
                aeVar2.field_isDomesticUser = "2".equals(jSONObject2.optString("icard_user_flag", "2"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("touch_info");
                if (optJSONObject != null) {
                    aeVar2.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
                    w.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is " + aeVar2.field_is_open_touch);
                } else {
                    w.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
                    aeVar2.field_is_open_touch = m.btS().buo() ? 1 : 0;
                    w.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + aeVar2.field_is_open_touch);
                }
                aeVar2.field_lct_wording = jSONObject2.optString("lct_wording");
                aeVar2.field_lct_url = jSONObject2.optString("lct_url");
                w.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + aeVar2.field_lct_wording + ", field_lct_url:" + aeVar2.field_lct_url);
                aeVar2.field_lqt_state = jSONObject2.optInt("lqt_state", -1);
                w.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s", new Object[]{Integer.valueOf(aeVar2.field_lqt_state)});
                if (i == 0 || i == 3 || i == 4) {
                    ap.yY();
                    c.vr().a(a.uID, Integer.valueOf(aeVar2.field_lqt_state));
                    ap.yY();
                    c.vr().a(a.uIE, aeVar2.field_lct_wording);
                }
                aeVar = aeVar2;
            }
            aeVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            String optString = jSONObject.optString("support_bank_word");
            ap.yY();
            c.vr().a(a.uAm, bg.mz(optString));
            ArrayList r = r(jSONObject.optJSONArray("Array"));
            ArrayList s = s(jSONObject.optJSONArray("virtual_card_array"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("balance_info");
            String str = "MicroMsg.WalletQueryBankcardParser";
            String str2 = "Bankcard getBalance %s";
            Object[] objArr = new Object[1];
            if (optJSONObject2 == null) {
                optString = "";
            } else {
                obj = optJSONObject2;
            }
            objArr[0] = optString;
            w.i(str, str2, objArr);
            if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
                w.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
                bankcard = null;
            } else {
                final Bankcard bankcard4 = new Bankcard((byte) 0);
                final long optLong2 = optJSONObject2.optLong("balance_version", -1);
                final long optLong3 = optJSONObject2.optLong("time_out", 7200);
                final int optInt = optJSONObject2.optInt("avail_balance");
                e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a() {
                    public final void J(Map<String, Object> map) {
                        if (map != null) {
                            long a = bg.a((Long) map.get("wallet_balance_version"), -1);
                            long a2 = bg.a((Long) map.get("wallet_balance_last_update_time"), -1);
                            if (a2 < 0 || a < 0 || a2 + optLong3 > bg.NA() || optLong2 >= a) {
                                e.a(new e.c[]{new e.c("wallet_balance_version", Long.valueOf(optLong2)), new e.c("wallet_balance_last_update_time", Long.valueOf(bg.NA())), new e.c("wallet_balance", Double.valueOf(((double) optInt) / 100.0d))});
                                bankcard4.rEh = ((double) optInt) / 100.0d;
                                return;
                            }
                            w.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                        }
                    }
                });
                bankcard4.rEh = ((double) optJSONObject2.optInt("avail_balance")) / 100.0d;
                bankcard4.rEi = optJSONObject2.optString("balance_show_wording");
                bankcard4.rEl = optJSONObject2.optString("max_fetch_wording");
                bankcard4.rEm = optJSONObject2.optString("avail_fetch_wording");
                bankcard4.rEj = ((double) optJSONObject2.optInt("fetch_balance")) / 100.0d;
                bankcard4.field_cardType |= Bankcard.rDZ;
                bankcard4.field_bankcardType = optJSONObject2.optString("balance_bank_type");
                bankcard4.field_bindSerial = optJSONObject2.optString("balance_bind_serial");
                bankcard4.field_forbidWord = optJSONObject2.optString("balance_forbid_word");
                if (bg.mA(bankcard4.field_forbidWord)) {
                    bankcard4.field_bankcardState = 0;
                } else {
                    bankcard4.field_bankcardState = 8;
                }
                bankcard4.field_fetchArriveTime = optJSONObject2.optLong("fetch_arrive_time");
                bankcard4.field_mobile = optJSONObject2.optString("mobile");
                bankcard4.field_support_micropay = optJSONObject2.optInt("support_micropay", 0) == 1;
                w.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + optJSONObject2.optInt("support_micropay", 0));
                bankcard4.rEk = optJSONObject2.optString("balance_list_url");
                optString = ab.getContext().getString(R.l.fdh);
                bankcard4.field_desc = optString;
                bankcard4.field_bankName = optString;
                bankcard4.field_bankcardTail = "10000";
                bankcard4.field_forbid_title = optJSONObject2.optString("forbid_title");
                bankcard4.field_forbid_url = optJSONObject2.optString("forbid_url");
                bankcard = bankcard4;
            }
            w.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", new Object[]{Integer.valueOf(jSONObject.optInt("query_cache_time"))});
            JSONArray optJSONArray = jSONObject.optJSONArray("history_card_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                w.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
                bankcard2 = null;
            } else {
                bankcard2 = d.btE().K(optJSONArray.getJSONObject(0));
                bankcard2.field_cardType |= Bankcard.rEa;
            }
            optJSONArray = jSONObject.optJSONArray("balance_notice");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
            if (optJSONArray != null) {
                ap = bg.ap(optJSONArray.toString(), "");
            } else {
                str = "";
            }
            if (optJSONArray2 != null) {
                obj = bg.ap(optJSONArray2.toString(), "");
            } else {
                obj = "";
            }
            w.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", new Object[]{ap, obj});
            ap.yY();
            c.vr().a(a.uAk, ap);
            ap.yY();
            c.vr().a(a.uAl, obj);
            ap.yY();
            c.vr().jY(true);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bank_priority");
            List linkedList = new LinkedList();
            if (optJSONObject3 != null) {
                try {
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray("bankinfo_array");
                    if (optJSONArray3 != null) {
                        int length = optJSONArray3.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c cVar = new c();
                            JSONObject jSONObject3 = optJSONArray3.getJSONObject(i2);
                            cVar.ofe = jSONObject3.optString("bind_serial");
                            cVar.rDV = jSONObject3.optString("polling_forbid_word");
                            linkedList.add(cVar);
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
                }
            }
            jSONObject.optString("query_order_time");
            optJSONObject3 = jSONObject.optJSONObject("loan_entry_info");
            if (optJSONObject3 == null) {
                w.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
                jVar = null;
            } else {
                w.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
                jVar = new j();
                jVar.field_title = optJSONObject3.optString("title");
                jVar.field_loan_jump_url = optJSONObject3.optString("loan_jump_url");
                w.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + jVar.field_loan_jump_url);
                jVar.field_is_show_entry = optJSONObject3.optInt("is_show_entry", 0);
                jVar.field_tips = optJSONObject3.optString("tips");
                jVar.field_is_overdue = optJSONObject3.optInt("is_overdue", 0);
                if (optJSONObject3.has("available_otb")) {
                    jVar.field_available_otb = e.d(optJSONObject3.optDouble("available_otb") / 100.0d, "CNY");
                }
                if (optJSONObject3.has("index")) {
                    jVar.field_red_dot_index = optJSONObject3.optInt("index");
                }
                w.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + jVar.field_red_dot_index + "  field_is_overdue:" + jVar.field_is_overdue + "  field_is_show_entry:" + jVar.field_is_show_entry);
            }
            optJSONObject3 = jSONObject.optJSONObject("fetch_info");
            b bVar = m.btS().rIo;
            w.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", new Object[]{bVar});
            if (optJSONObject3 != null) {
                bVar = a(optJSONObject3, true);
            } else {
                w.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            optJSONObject3 = jSONObject.optJSONObject("lqt_info");
            if (optJSONObject3 == null) {
                w.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
                bankcard3 = null;
            } else {
                w.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", new Object[]{optJSONObject3.toString()});
                bankcard3 = new Bankcard((byte) 0);
                bankcard3.field_bankcardType = optJSONObject3.optString("lqt_bank_type");
                bankcard3.field_bindSerial = optJSONObject3.optString("lqt_bind_serial");
                bankcard3.field_bankName = optJSONObject3.optString("lqt_bank_name");
                bankcard3.rEh = ((double) optJSONObject3.optLong("total_balance")) / 100.0d;
                bankcard3.rEj = ((double) optJSONObject3.optLong("avail_balance")) / 100.0d;
                bankcard3.rEp = new e();
                bankcard3.rEp.nXm = optJSONObject3.optString("lqt_logo_url");
                bankcard3.field_forbidWord = optJSONObject3.optString("lqt_forbid_word");
                bankcard3.field_forbid_title = optJSONObject3.optString("forbid_title");
                bankcard3.field_forbid_url = optJSONObject3.optString("forbid_url");
                bankcard3.rEi = optJSONObject3.optString("lqt_show_wording");
                bankcard3.field_mobile = optJSONObject3.optString("mobile");
                bankcard3.field_support_micropay = optJSONObject3.optInt("support_micropay", 0) == 1;
                bankcard3.field_cardType |= Bankcard.rEb;
                if (bg.mA(bankcard3.field_bankName)) {
                    bankcard3.field_bankName = ab.getContext().getString(R.l.fgJ);
                }
                bankcard3.field_desc = bankcard3.field_bankName;
                if (bg.mA(bankcard3.field_forbidWord)) {
                    bankcard3.field_bankcardState = 0;
                } else {
                    bankcard3.field_bankcardState = 8;
                }
            }
            m.btS().a(aeVar, r, s, bankcard, bankcard2, jVar, bVar, bankcard3, r11, i, linkedList);
        } catch (Throwable e2) {
            w.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e2.getMessage());
            w.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
        }
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        if (jSONObject == null) {
            w.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            return null;
        }
        w.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.rDT = jSONObject.optString("fetch_charge_title");
        w.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.rDT);
        if (z) {
            w.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.ruv = jSONObject.optInt("is_cal_charge", 0);
            bVar.ruu = jSONObject.optInt("is_show_charge", 0);
            bVar.ruw = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.rux = jSONObject.optDouble("min_charge_fee", 0.0d) / 100.0d;
            bVar.oQw = jSONObject.optDouble("remain_fee", 0.0d) / 100.0d;
            w.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.ruv + " is_show_charge:" + bVar.ruu + " min_charge_fee:" + bVar.rux + " remain_fee:" + bVar.oQw + " is_full_fetch_direct:" + bVar.ruw);
        } else {
            w.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            w.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.rDU = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b.a aVar = new b.a();
                    aVar.arH = optJSONObject.optString("key");
                    aVar.value = optJSONObject.optString(Columns.VALUE);
                    w.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + aVar.arH + " , feeItem.value is " + aVar.value);
                    if (!(TextUtils.isEmpty(aVar.arH) || TextUtils.isEmpty(aVar.value))) {
                        bVar.rDU.add(aVar);
                    }
                } else {
                    w.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            w.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.rDU.size());
        }
        return bVar;
    }

    private static ArrayList<Bankcard> r(JSONArray jSONArray) {
        w.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard K = d.btE().K(jSONArray.getJSONObject(i));
                if (K != null) {
                    if (K.btA()) {
                        K.field_desc = K.field_bankName;
                    } else if (K.btC()) {
                        K.field_desc = ab.getContext().getString(R.l.ffi, new Object[]{K.field_bankName, K.field_bankcardTail});
                    } else if (K.btz()) {
                        K.field_desc = ab.getContext().getString(R.l.fls, new Object[]{K.field_bankName, K.field_bankcardTail});
                    } else {
                        K.field_desc = ab.getContext().getString(R.l.ffw, new Object[]{K.field_bankName, K.field_bankcardTail});
                    }
                    arrayList.add(K);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Bankcard> s(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.rDY;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.rEd = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = ab.getContext().getString(R.l.fls, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.rEp = new e();
                bankcard.rEp.nXm = jSONObject.getString("logo_url");
                bankcard.rEp.rEr = jSONObject.getString("background_logo_url");
                bankcard.rEp.rEs = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }
}
