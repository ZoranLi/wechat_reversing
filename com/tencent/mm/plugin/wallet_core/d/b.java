package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import org.json.JSONObject;

public final class b {
    public static void Q(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            return;
        }
        w.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        int optInt = jSONObject.optInt("is_open_sns_pay", 0);
        int optInt2 = jSONObject.optInt("can_open_sns_pay", 0);
        int optInt3 = jSONObject.optInt("is_white_user", 0);
        if (optInt2 == 1) {
            str = jSONObject.optString("open_sns_pay_title");
            str2 = jSONObject.optString("open_sns_pay_wording");
            ap.yY();
            c.vr().a(a.uDq, str);
            ap.yY();
            c.vr().a(a.uDr, str2);
        }
        w.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        w.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str + ", open_sns_pay_wording:" + str2);
        ap.yY();
        c.vr().a(a.uDn, Integer.valueOf(optInt));
        ap.yY();
        c.vr().a(a.uDo, Integer.valueOf(optInt2));
        ap.yY();
        c.vr().a(a.uDp, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str = jSONObject.optString("set_sns_pay_title");
            str2 = jSONObject.optString("set_sns_pay_wording");
            ap.yY();
            c.vr().a(a.uDs, str);
            ap.yY();
            c.vr().a(a.uDt, str2);
        } else {
            str2 = str4;
            str = str3;
        }
        w.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str + ", set_sns_pay_wording:" + str2);
        ap.yY();
        c.vr().jY(true);
    }
}
