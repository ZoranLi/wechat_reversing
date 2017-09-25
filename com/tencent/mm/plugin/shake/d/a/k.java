package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.g;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class k {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ d pqy;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(d dVar, Context context) {
            this.pqy = dVar;
            this.val$context = context;
        }

        public final void run() {
            k.a(this.pqy, this.val$context, false);
        }
    }

    public static void a(d dVar, Context context, boolean z) {
        int i = 4;
        if (dVar != null) {
            Intent intent;
            switch (dVar.field_type) {
                case 6:
                    String str = dVar.field_username;
                    ap.yY();
                    af Rc = c.wR().Rc(str);
                    if (Rc != null) {
                        Intent intent2 = new Intent();
                        if (a.ez(Rc.field_type) && Rc.bLe()) {
                            w.DH().hO(str);
                            if (dVar.field_distance.equals("1")) {
                                intent2.putExtra("Chat_User", str);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.imv.e(intent2, context);
                                return;
                            }
                        }
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bb.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                case 7:
                    Intent intent3 = new Intent();
                    i = 18;
                    if (z) {
                        i = 26;
                    }
                    intent3.putExtra("geta8key_scene", i);
                    intent3.putExtra("stastic_scene", 6);
                    intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                    intent3.putExtra("jsapiargs", bundle);
                    intent3.putExtra("rawUrl", dVar.field_username);
                    intent3.putExtra("srcUsername", dVar.field_distance);
                    com.tencent.mm.plugin.shake.a.imv.j(intent3, context);
                    return;
                case 8:
                    intent = new Intent();
                    intent.setClass(context, TVInfoUI.class);
                    intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                    intent.putExtra("key_TV_come_from_shake", true);
                    context.startActivity(intent);
                    return;
                case 9:
                    b grVar = new gr();
                    grVar.fLZ.actionCode = 11;
                    grVar.fLZ.result = dVar.field_username;
                    grVar.fLZ.context = context;
                    grVar.nFq = null;
                    com.tencent.mm.sdk.b.a.urY.a(grVar, Looper.myLooper());
                    return;
                case 10:
                    intent = new Intent();
                    intent.putExtra("key_product_id", dVar.field_username);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bb.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                    if (!z) {
                        i = 3;
                    }
                    a(dVar.field_distance, dVar.field_username, i, context);
                    return;
                case 13:
                    String str2 = dVar.field_username;
                    String str3 = dVar.field_reserved3;
                    int i2 = dVar.field_reserved2;
                    if (bg.mA(str2)) {
                        com.tencent.mm.sdk.platformtools.w.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                        return;
                    }
                    b prVar = new pr();
                    prVar.fWB.userName = str2;
                    prVar.fWB.fWD = bg.ap(str3, "");
                    prVar.fWB.fWE = 0;
                    prVar.fWB.scene = 1039;
                    prVar.fWB.fWF = i2;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                    com.tencent.mm.sdk.platformtools.w.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[]{prVar.fWB.userName, prVar.fWB.fWD, Integer.valueOf(prVar.fWB.scene), Integer.valueOf(prVar.fWB.fWE), Integer.valueOf(prVar.fWB.fWF)});
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean sA(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean baQ() {
        if (r.iiN) {
            return true;
        }
        String value = g.sV().getValue("ShowShakeTV");
        com.tencent.mm.sdk.platformtools.w.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[]{value});
        if (bg.mA(value) || !value.equals("1")) {
            return false;
        }
        return true;
    }

    public static void a(n nVar, Context context, int i) {
        if (nVar != null) {
            if (bg.mA(nVar.field_username) && bg.mA(nVar.field_deeplink)) {
                com.tencent.mm.plugin.report.service.g.oUh.i(12108, new Object[]{bg.mz(nVar.field_username), Integer.valueOf(i), Integer.valueOf(0)});
                return;
            }
            a(nVar.field_username, nVar.field_deeplink, i, context);
            com.tencent.mm.sdk.platformtools.w.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
    }

    private static void a(String str, String str2, int i, Context context) {
        if (!bg.mA(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i2 = 16;
            if (i == 3 || i == 4) {
                i2 = 17;
            }
            intent.putExtra("translate_link_scene", i2);
            context.startActivity(intent);
            com.tencent.mm.sdk.platformtools.w.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            com.tencent.mm.plugin.report.service.g.oUh.i(12108, new Object[]{bg.mz(str), Integer.valueOf(i), Integer.valueOf(1)});
        }
    }
}
