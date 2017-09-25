package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        w.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        g.oUh.i(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }

    public static void P(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.CardActivityHelper", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        a.imv.d(intent, context);
    }

    public static void Q(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.CardActivityHelper", "username is null");
        } else if (!o.eU(str)) {
            P(context, str);
        } else if (TextUtils.isEmpty(str)) {
            w.v("MicroMsg.CardActivityHelper", "username is null");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("finish_direct", true);
            d.a(context, ".ui.chatting.En_5b8fbb1e", intent);
        }
    }

    public static void a(MMActivity mMActivity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, float f, float f2, String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        d.b(mMActivity, "location", ".ui.RedirectUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, MMActivity.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, aVar);
    }

    public static void a(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        d.b(mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.afn());
        intent.putExtra("key_user_card_id", bVar.afm());
        intent.putExtra("key_card_code", bVar.afj().code);
        d.b(mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        g.oUh.i(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
    }

    public static boolean a(String str, lz lzVar, int i, int i2) {
        if (lzVar != null) {
            return d(str, lzVar.tnY, lzVar.tnZ, i, i2);
        }
        w.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
        return false;
    }

    public static boolean d(String str, String str2, String str3, int i, int i2) {
        if (bg.mA(str2)) {
            w.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            return false;
        }
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fWB.userName = str2;
        prVar.fWB.fWD = bg.ap(str3, "");
        prVar.fWB.fWE = i2;
        if (i == 26) {
            prVar.fWB.scene = 1029;
        } else {
            prVar.fWB.scene = 1028;
        }
        prVar.fWB.fCN = str;
        prVar.fWB.fWH = true;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        w.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[]{prVar.fWB.userName, prVar.fWB.fWD, Integer.valueOf(prVar.fWB.scene), Integer.valueOf(prVar.fWB.fWE)});
        return true;
    }
}
