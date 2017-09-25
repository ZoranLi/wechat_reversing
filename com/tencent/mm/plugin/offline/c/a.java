package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.r.f;
import com.tencent.mm.plugin.offline.c;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static String kcJ = "";
    public static String oeO = "";
    public static String oeP = "";
    public static int oeQ = 1;
    public static String oeR = "";
    public static String oeS = "";
    public static String oeT = "";
    public static int oeU = 1;
    public static int oeV = 0;
    public static long oeW = 0;
    public static boolean oeX = false;
    public static String oeY = "";
    public static String oeZ = "";
    private static Comparator<Bankcard> ofa = new Comparator<Bankcard>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
        }
    };
    private static Comparator<a> ofb = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj).ofe.compareToIgnoreCase(((a) obj2).ofe);
        }
    };

    public static class a {
        public int ofc;
        public String ofd;
        public String ofe;
        public String off;
    }

    public static class b {
        public String ofd;
        public String ofg;
    }

    public static boolean aQL() {
        k.aQd();
        String qL = k.qL(196630);
        if (qL == null || !qL.equals("1")) {
            return false;
        }
        return true;
    }

    public static boolean aQM() {
        k.aQd();
        String qL = k.qL(196641);
        if (qL == null || !qL.equals("1")) {
            return false;
        }
        return true;
    }

    public static Bankcard aQN() {
        Bankcard bankcard;
        Object aQV = aQV();
        w.i("MicroMsg.WalletOfflineUtil", "step 1 getSelectedBindBankCard %s", new Object[]{aQV});
        List iB = m.btS().iB(true);
        int i = 0;
        while (!TextUtils.isEmpty(aQV) && i < iB.size()) {
            bankcard = (Bankcard) iB.get(i);
            if (bankcard != null && aQV.equals(bankcard.field_bindSerial)) {
                w.i("MicroMsg.WalletOfflineUtil", "step 2 micropay: %s, forbidword: %s", new Object[]{Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord});
                if (bankcard.field_support_micropay) {
                    return bankcard;
                }
            }
            i++;
        }
        w.i("MicroMsg.WalletOfflineUtil", "step 3 clear default bindserial");
        Ca("");
        bankcard = aQP();
        if (bankcard == null || !bg.mA(bankcard.field_forbidWord)) {
            i = 0;
            while (i < iB.size()) {
                bankcard = (Bankcard) iB.get(i);
                if (bankcard == null || !bankcard.field_support_micropay || bankcard.btA()) {
                    i++;
                } else {
                    w.i("MicroMsg.WalletOfflineUtil", "do change first card: %s", new Object[]{bankcard.field_bankcardType});
                    return bankcard;
                }
            }
            bankcard = m.btS().ruN;
            if (bankcard == null || !bankcard.field_support_micropay) {
                bankcard = m.btS().rIq;
                if (bankcard == null || !bankcard.field_support_micropay || !bg.mA(bankcard.field_forbidWord)) {
                    return null;
                }
                w.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
                return bankcard;
            }
            w.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
            return bankcard;
        }
        w.i("MicroMsg.WalletOfflineUtil", "do change main card: %s", new Object[]{bankcard.field_bankcardType});
        return bankcard;
    }

    public static Bankcard aQO() {
        Bankcard aQN = aQN();
        if (aQN != null && aQN.field_support_micropay && bg.mA(aQN.field_forbidWord)) {
            return aQN;
        }
        List it = m.btS().it(true);
        for (int i = 0; i < it.size(); i++) {
            aQN = (Bankcard) it.get(i);
            if (aQN != null && aQN.field_support_micropay) {
                return aQN;
            }
        }
        return null;
    }

    public static Bankcard aQP() {
        Bankcard a = m.btS().a(null, null, true, true);
        if (a == null) {
            w.e("MicroMsg.WalletOfflineUtil", "defaultBankcards == null");
        }
        return a;
    }

    public static int aQQ() {
        return m.btS().it(true).size();
    }

    public static List<Bankcard> ge(boolean z) {
        List<Bankcard> arrayList = new ArrayList();
        List it = m.btS().it(true);
        for (int i = 0; i < it.size(); i++) {
            Bankcard bankcard = (Bankcard) it.get(i);
            if (z) {
                arrayList.add(bankcard);
            } else {
                arrayList.add(bankcard);
            }
        }
        w.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        return arrayList;
    }

    public static List<Bankcard> aQR() {
        List<Bankcard> arrayList = new ArrayList();
        List iB = m.btS().iB(true);
        for (int i = 0; i < iB.size(); i++) {
            arrayList.add((Bankcard) iB.get(i));
        }
        w.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
        return arrayList;
    }

    public static int aQS() {
        k.aQd();
        String qL = k.qL(196629);
        if (TextUtils.isEmpty(qL) || !tb(qL)) {
            return 0;
        }
        return Integer.valueOf(qL).intValue();
    }

    public static void qP(int i) {
        k.aQd();
        k.af(196640, String.valueOf(i));
    }

    public static void qQ(int i) {
        k.aQd();
        k.af(196642, String.valueOf(i));
    }

    public static String aQT() {
        k.aQd();
        return k.qL(196632);
    }

    public static String aQU() {
        k.aQd();
        return k.qL(196631);
    }

    public static void BZ(String str) {
        k.aQd();
        k.af(196631, str);
    }

    public static void cH(Context context) {
        String bIN = v.bIN();
        if ("zh_CN".equals(bIN)) {
            bIN = context.getString(R.l.eZu);
        } else if ("zh_TW".equals(bIN)) {
            bIN = context.getString(R.l.eZx);
        } else if ("zh_HK".equals(bIN)) {
            bIN = context.getString(R.l.eZw);
        } else {
            bIN = context.getResources().getString(R.l.eZv);
        }
        aq(context, bIN);
    }

    private static void aq(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static boolean tb(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String aQV() {
        k.aQd();
        return k.qL(196633);
    }

    public static void Ca(String str) {
        w.i("MicroMsg.WalletOfflineUtil", "setSelectBindSerial %s %s", new Object[]{str, bg.bJZ().toString()});
        k.aQd();
        k.af(196633, str);
    }

    public static void aQW() {
        w.i("MicroMsg.WalletOfflineUtil", "clear offline data");
        k.aQd();
        k.af(196630, "0");
        k.aQd();
        k.af(196626, "");
        k.aQd();
        k.af(196627, "");
        k.aQd();
        k.af(196628, "");
        k.aQd();
        k.af(196617, "");
        k.aQd();
        k.af(196632, "");
        k.aQd();
        k.af(196641, "");
        k.aQd();
        k.af(196647, "");
        k.aQd();
        k.af(196649, "");
        i("", "", "", "");
        k.aQd();
        k.af(196629, new StringBuilder("0").toString());
        BZ("");
        k.aQd();
        k.aQe().odb = null;
        k.aQd();
        k.aQg();
        k.aQd();
        String qL = k.qL(196617);
        com.tencent.mm.wallet_core.c.a.cbV();
        com.tencent.mm.wallet_core.c.a.clearToken(qL);
        Ce("");
        Cb("");
    }

    public static void a(Activity activity, f fVar) {
        w.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (fVar == null || fVar.odo == null) {
            w.e("MicroMsg.WalletOfflineUtil", "order == null");
        } else if (aQM()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", fVar.odo);
            bundle.putInt("key_pay_type", 2);
            if (fVar.fZp != null) {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(fVar.fZp.fZb, fVar.fZp.fZc, fVar.fZp.fZd, fVar.fZp.fZe, fVar.fZp.fZf, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static Orders E(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.ofM = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.ofN = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.ofO = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.ofP = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.fTA = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.kBc = ((double) bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.ofT = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.ofU = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.ofY = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.ogf = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.ofW = bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.oga = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.ogb = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.ofD = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.rGs = ((double) bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
        bVar.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        bVar.ogb = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        bVar.type = Orders.rGq;
        commodity.rGt = bVar.ogb;
        bVar.oqk = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        bVar.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.rFV = i;
        commodity.rGw = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.rGx = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!bg.mA(bVar.name)) {
            commodity.rGA = true;
            commodity.rGz.add(bVar);
        }
        for (int i2 = 0; i2 < 255; i2++) {
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
            if (i2 == 0) {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
            } else {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_mch_id");
            }
            if (bg.mA(str2)) {
                w.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[]{Integer.valueOf(i2 + 1)});
                break;
            }
            bVar2.oqk = str;
            bVar2.name = str2;
            bVar2.url = str3;
            bVar2.rGG = str4;
            bVar2.type = Orders.rGr;
            bVar2.rGH = bg.getInt(str5, 0);
            bVar2.title = str6;
            bVar2.rGJ = bg.getInt(str7, 0);
            bVar2.rGI = bg.getLong(str8, 0);
            bVar2.rGL = bg.getInt(str9, 0);
            bVar2.rGK = bg.getInt(str10, 0);
            bVar2.rGM = bg.getInt(str11, 0);
            bVar2.rGN = str12;
            bVar2.rGO = str13;
            bVar2.rGP = str14;
            bVar2.rGQ = bg.getLong(str15, 0);
            commodity.rGz.add(bVar2);
        }
        str = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        commodity.rGB.text = str;
        commodity.rGB.url = str2;
        str = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
        str3 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
        str4 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
        str5 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
        if (!(bg.mA(str) || bg.mA(str2) || bg.mA(str3) || bg.mA(str4))) {
            commodity.rGy = new RecommendTinyAppInfo();
            commodity.rGy.rGR = str;
            commodity.rGy.rGS = str2;
            commodity.rGy.rGT = str3;
            commodity.rGy.rGU = str4;
            commodity.rGy.rGV = str5;
            commodity.rGy.rGW = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.rGy.rGX = bg.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.rGy.rGY = bg.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.rGy.rHa = bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.rGy.rHb = bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.rGy.rHc = (long) bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id.activity_mch_id"), 0);
        }
        orders.rGe = new ArrayList();
        orders.rGe.add(commodity);
        orders.rGo = bg.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.rGp = (String) map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.rFX = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.rFV = i;
        orders.fJH = (String) map.get(".sysmsg.req_key");
        commodity.rGs = bg.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            w.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        } else {
            int i3 = 0;
            while (true) {
                if (i3 == 0) {
                    str = "";
                } else {
                    str = String.valueOf(i3);
                }
                str3 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".favor_desc";
                str4 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".payment_amount";
                if (TextUtils.isEmpty((CharSequence) map.get(str3)) || TextUtils.isEmpty((CharSequence) map.get(str4))) {
                    w.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.rxH = (String) map.get(str3);
                    discountInfo.rGF = bg.getDouble((String) map.get(str4), 0.0d);
                    commodity.rGv.add(discountInfo);
                    i3++;
                }
            }
            w.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        return orders;
    }

    public static void a(Activity activity, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.WalletOfflineUtil", "transid == null");
        } else if (aQM()) {
            Bundle bundle = new Bundle();
            if (kVar instanceof e) {
                Parcelable parcelable = ((e) kVar).ocy;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static void f(Activity activity, int i) {
        a(activity, i, -1);
    }

    public static void a(Activity activity, int i, int i2) {
        Parcelable payInfo = new PayInfo();
        payInfo.fRw = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i);
        if (i2 >= 0) {
            bundle.putInt("key_entry_scene", i2);
        }
        if (!m.btS().bum()) {
            if (m.btS().buj()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            } else if (m.btS().bun()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, c.class, bundle);
    }

    public static void g(Activity activity, int i) {
        a(activity, "create", activity.getString(R.l.flg), 0, i);
    }

    private static void a(Activity activity, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        if (i2 >= 0) {
            bundle.putInt("offline_from_scene", i2);
        }
        com.tencent.mm.wallet_core.a.a(activity, h.class, bundle);
    }

    public static void K(Activity activity) {
        a(activity, "freeze", activity.getString(R.l.flj), 0, -1);
    }

    public static void L(Activity activity) {
        String str = "create";
        String str2 = "";
        k.aQd();
        String qL = k.qL(196640);
        int intValue = (TextUtils.isEmpty(qL) || !tb(qL)) ? 0 : Integer.valueOf(qL).intValue();
        a(activity, str, str2, intValue > 0 ? intValue * 100 : 20000, -1);
    }

    public static void b(final Activity activity, String str) {
        g.a(activity, false, str, "", activity.getString(R.l.flp), activity.getString(R.l.dGs), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.aQW();
                a.L(activity);
                activity.finish();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        });
    }

    public static void aQX() {
        k.aQd();
        k.af(196643, "1");
    }

    public static void qR(int i) {
        k.aQd();
        k.af(196644, String.valueOf(i));
    }

    public static int aQY() {
        k.aQd();
        String qL = k.qL(196644);
        if (TextUtils.isEmpty(qL) || !tb(qL)) {
            return 0;
        }
        return Integer.valueOf(qL).intValue();
    }

    public static String aQZ() {
        if (!TextUtils.isEmpty(oeO)) {
            return oeO;
        }
        aRc();
        if (TextUtils.isEmpty(oeO)) {
            w.e("MicroMsg.WalletOfflineUtil", "token is null");
        }
        return oeO;
    }

    public static void i(String str, String str2, String str3, String str4) {
        oeO = str;
        oeP = str2;
        oeR = str3;
        oeS = str4;
        Cb(oeR);
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.Cc() != null) {
                    if (a.oeO != null) {
                        eVar.Cc().h("offline_token", a.oeO.getBytes());
                    }
                    if (a.oeP != null) {
                        eVar.Cc().h("offline_token_V2", a.oeP.getBytes());
                    }
                    if (a.oeS != null) {
                        eVar.Cc().h("offline_key_list", a.oeS.getBytes());
                    }
                }
            }
        }), 0);
    }

    public static String aRa() {
        if (!TextUtils.isEmpty(oeP)) {
            return oeP;
        }
        aRc();
        if (TextUtils.isEmpty(oeP)) {
            w.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
        }
        return oeP;
    }

    public static String aRb() {
        if (!TextUtils.isEmpty(oeR)) {
            return oeR;
        }
        if (TextUtils.isEmpty(oeR)) {
            k.aQd();
            String qL = k.qL(196656);
            oeR = qL;
            return qL;
        }
        if (TextUtils.isEmpty(oeR)) {
            w.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
        }
        return oeR;
    }

    private static void Cb(String str) {
        k.aQd();
        k.af(196656, str);
        oeR = str;
    }

    private static void aRc() {
        ap.vd().a(new bb(new com.tencent.mm.u.bb.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar == null || eVar.Cc() == null) {
                    w.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
                    return;
                }
                byte[] hu = eVar.Cc().hu("offline_token");
                if (hu != null) {
                    a.oeO = new String(hu);
                }
                hu = eVar.Cc().hu("offline_token_V2");
                if (hu != null) {
                    a.oeP = new String(hu);
                }
                hu = eVar.Cc().hu("offline_key_list");
                if (hu != null) {
                    a.oeS = new String(hu);
                }
            }
        }), 0);
    }

    public static LinkedList<a> Cc(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = o(new JSONArray(str));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> o(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                a aVar = new a();
                aVar.ofc = jSONObject.optInt("card_id");
                aVar.ofd = jSONObject.optString("bank_type");
                aVar.ofe = jSONObject.optString("bind_serial");
                aVar.off = jSONObject.optString("forbid_word");
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public static String aRd() {
        k.aQd();
        return k.qL(196647);
    }

    private static String aRe() {
        k.aQd();
        return k.qL(196616);
    }

    public static void Cd(String str) {
        k.aQd();
        k.af(196616, str);
    }

    public static void M(Activity activity) {
        g.bl(activity, activity.getResources().getString(R.l.flh));
        if (!TextUtils.isEmpty(aRe())) {
            aq(activity, aRe());
        }
    }

    public static boolean aRf() {
        List it = m.btS().it(true);
        LinkedList Cc = Cc(aRb());
        if (Cc == null || it.size() != Cc.size()) {
            return false;
        }
        int i;
        Collections.sort(Cc, ofb);
        Collections.sort(it, ofa);
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < Cc.size(); i++) {
            stringBuilder.append(((a) Cc.get(i)).ofe);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (i = 0; i < it.size(); i++) {
            stringBuilder2.append(((Bankcard) it.get(i)).field_bindSerial);
        }
        if (aa.Pq(stringBuilder.toString()).equals(aa.Pq(stringBuilder2.toString()))) {
            return true;
        }
        return false;
    }

    private static String aRg() {
        if (!TextUtils.isEmpty(oeT)) {
            return oeT;
        }
        k.aQd();
        String qL = k.qL(196615);
        oeT = qL;
        return qL;
    }

    public static void Ce(String str) {
        k.aQd();
        k.af(196615, str);
        oeT = str;
    }

    private static LinkedList<b> Cf(String str) {
        LinkedList<b> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = p(new JSONArray(str));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<b> p(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.ofd = jSONObject.optString("bank_type");
                bVar.ofg = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }

    public static int aRh() {
        k.aQd();
        String qL = k.qL(196649);
        if (TextUtils.isEmpty(qL) || !tb(qL)) {
            return 0;
        }
        return Integer.valueOf(qL).intValue();
    }

    public static boolean aRi() {
        Object aQT = aQT();
        if (TextUtils.isEmpty(aQT)) {
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(aQT).longValue() >= ((long) aRh())) {
            return true;
        }
        return false;
    }

    public static String Cg(String str) {
        LinkedList Cf = Cf(aRg());
        if (Cf == null) {
            return "";
        }
        String str2 = "";
        for (int i = 0; i < Cf.size(); i++) {
            b bVar = (b) Cf.get(i);
            if (bVar != null && str.equals(bVar.ofd)) {
                return bVar.ofg;
            }
        }
        return str2;
    }

    public static String Ch(String str) {
        int i = 0;
        LinkedList Cc = Cc(aRb());
        LinkedList Cf = Cf(aRg());
        if (Cc == null || Cf == null || Cc.size() == 0 || Cf.size() == 0) {
            w.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            return "";
        }
        String str2 = "";
        for (int i2 = 0; i2 < Cc.size(); i2++) {
            a aVar = (a) Cc.get(i2);
            if (aVar != null && str.equals(aVar.ofe)) {
                Object obj = aVar.ofd;
                break;
            }
        }
        String str3 = str2;
        if (TextUtils.isEmpty(obj)) {
            w.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            return "";
        }
        str2 = "";
        while (i < Cf.size()) {
            b bVar = (b) Cf.get(i);
            if (bVar != null && obj.equals(bVar.ofd)) {
                return bVar.ofg;
            }
            i++;
        }
        return str2;
    }

    public static boolean cB(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            w.d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                w.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ab.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        w.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        return true;
    }

    public static void Ci(String str) {
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uHE, str);
    }

    public static String aRj() {
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uHE, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void Cj(String str) {
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIm, str);
    }

    public static String aRk() {
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIm, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void qS(int i) {
        if (i < 0) {
            i = 0;
        }
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIn, Integer.valueOf(i));
    }

    public static int aRl() {
        int intValue;
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIn, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = 0;
        }
        if (intValue < 0) {
            return 0;
        }
        return intValue;
    }

    public static void Ck(String str) {
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIo, str);
    }

    public static String aRm() {
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIo, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static int ck(Context context) {
        if (!am.isConnected(context)) {
            return -1;
        }
        if (am.isWifi(context)) {
            return 1;
        }
        if (am.is2G(context)) {
            return 2;
        }
        if (am.is3G(context)) {
            return 3;
        }
        if (am.is4G(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean aRn() {
        boolean z = false;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100232");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            if (bKK.containsKey("open") && "1".equals(bKK.get("open"))) {
                z = true;
            }
        }
        w.v("MicroMsg.WalletOfflineUtil", "isPosEnabled: " + z);
        return z;
    }
}
