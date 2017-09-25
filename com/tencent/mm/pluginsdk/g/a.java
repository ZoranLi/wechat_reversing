package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.gq;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class a {

    public interface a {
        boolean U(Activity activity);
    }

    public static void S(Activity activity) {
        if (d.Jt("gesture")) {
            b gqVar = new gq();
            gqVar.fLW.fLY = 0;
            gqVar.fLW.activity = activity;
            com.tencent.mm.sdk.b.a.urY.m(gqVar);
            switch (((Integer) gqVar.fLX.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent();
                    intent.setAction("action.verify_pattern");
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.setPackage(ab.getPackageName());
                    d.b(activity, "gesture", ".ui.GestureGuardLogicUI", intent);
                    g.oUh.i(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        }
        w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static void a(Activity activity, a aVar) {
        if (d.Jt("gesture")) {
            b gqVar = new gq();
            gqVar.fLW.fLY = 1;
            gqVar.fLW.activity = activity;
            com.tencent.mm.sdk.b.a.urY.m(gqVar);
            switch (((Integer) gqVar.fLX.data).intValue()) {
                case 17:
                    if (aVar == null || aVar.U(activity)) {
                        Intent intent = new Intent();
                        intent.setAction("action.verify_pattern");
                        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.setPackage(ab.getPackageName());
                        d.b(activity, "gesture", ".ui.GestureGuardLogicUI", intent);
                        return;
                    }
                    w.d("MicroMsg.GestureGuardManager", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static void T(Activity activity) {
        if (d.Jt("gesture")) {
            Intent intent = new Intent();
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            d.b(activity, "wallet", ".pwd.ui.WalletGestureCheckPwdUI", intent);
            return;
        }
        w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
    }

    public static boolean aCG() {
        if (d.Jt("gesture")) {
            b gqVar = new gq();
            gqVar.fLW.fLY = 2;
            com.tencent.mm.sdk.b.a.urY.m(gqVar);
            try {
                return ((Boolean) gqVar.fLX.data).booleanValue();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GestureGuardManager", e, "", new Object[0]);
                return false;
            }
        }
        w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
        return false;
    }

    public static boolean bCy() {
        if (d.Jt("gesture")) {
            b gqVar = new gq();
            gqVar.fLW.fLY = 3;
            com.tencent.mm.sdk.b.a.urY.m(gqVar);
            try {
                return ((Boolean) gqVar.fLX.data).booleanValue();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GestureGuardManager", e, "", new Object[0]);
                return false;
            }
        }
        w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
        return false;
    }
}
