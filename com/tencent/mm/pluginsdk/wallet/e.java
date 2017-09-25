package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class e {
    public static boolean a(Context context, Bundle bundle, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d.b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        return true;
    }

    public static boolean a(MMActivity mMActivity, d dVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("bizUsername", dVar.fRu);
        intent.putExtra("pay_channel", dVar.fRx);
        intent.putExtra("pay_for_wallet_type", dVar.sYo);
        intent.putExtra("pay_scene", dVar.fRv);
        intent.putExtra("result_jump_mode", dVar.sYq);
        mMActivity.uSV = aVar;
        d.a(mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i, false);
        return true;
    }

    public static void P(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", i);
        d.b(context, "collect", ".ui.CollectAdapterUI", intent);
    }

    public static boolean a(Context context, String str, String str2, int i, int i2) {
        return bg.mA(str) ? false : a(context, a(str, str2, null, null, i, 0), i2);
    }

    public static PayInfo a(String str, String str2, String str3, String str4, int i, int i2) {
        PayInfo payInfo = new PayInfo();
        payInfo.fJH = str;
        payInfo.appId = str2;
        payInfo.rPJ = null;
        payInfo.fRv = i;
        payInfo.fPf = null;
        payInfo.fRr = 0;
        return payInfo;
    }

    public static boolean a(Context context, PayInfo payInfo, int i) {
        return a(context, false, "", payInfo, i);
    }

    private static boolean a(Context context, boolean z, String str, PayInfo payInfo, int i) {
        return a(context, z, str, payInfo, null, new Intent(), i);
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i) {
        return a(context, z, str, "", payInfo, str2, intent, i);
    }

    public static boolean a(Context context, boolean z, String str, String str2, PayInfo payInfo, String str3, Intent intent, int i) {
        if (2 == payInfo.fRv || 1 == payInfo.fRv || 4 == payInfo.fRv || 36 == payInfo.fRv) {
            payInfo.mqD = false;
        } else {
            payInfo.mqD = true;
        }
        if (payInfo.fRv == 4 || payInfo.fRv == 1 || 36 == payInfo.fRv || 8 == payInfo.fRv) {
            payInfo.sYb = true;
        } else {
            payInfo.sYb = false;
        }
        intent.putExtra("key_pay_info", payInfo);
        intent.putExtra("key_force_use_bind_serail", bg.mz(str));
        intent.putExtra("key_is_force_use_given_card", z);
        if (!bg.mA(str2)) {
            intent.putExtra("key_is_use_default_card", str2);
        }
        intent.putExtra("key_receiver_true_name", str3);
        if (m.xY()) {
            d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i);
        } else {
            d.b(context, "wallet", ".pay.ui.WalletPayUI", intent, i);
        }
        return true;
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2) {
        if (bg.mA(str2)) {
            return false;
        }
        return a(context, true, str, a(str2, str3, null, null, i, 0), i2);
    }

    public static boolean b(MMActivity mMActivity, d dVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("key_bind_scene", dVar.fRw);
        mMActivity.uSV = aVar;
        d.a(mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i, false);
        return true;
    }

    public static boolean Q(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i);
        d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        return true;
    }

    public static boolean R(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i);
        if (m.xY()) {
            d.b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            d.b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        return true;
    }

    public static boolean a(Context context, int i, String str, int i2, com.tencent.mm.plugin.wallet.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene", i);
        intent.putExtra("receiver_name", str);
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.plugin.wallet.a.a(aVar, intent);
        if (m.xY()) {
            d.b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (m.xZ()) {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.oUh.i(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.oUh.i(11850, Integer.valueOf(7), Integer.valueOf(1));
        } else {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.oUh.i(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.oUh.i(11850, Integer.valueOf(3), Integer.valueOf(1));
        }
        return true;
    }
}
