package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.u;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class SubCoreSandBox implements v, am {
    public static boolean oVx = false;
    public static boolean oVy = false;

    public SubCoreSandBox() {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    }

    public final HashMap<Integer, c> uh() {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        return null;
    }

    public final void eD(int i) {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    }

    public final void aXT() {
        Updater.yo(16);
    }

    public final t a(Context context, OnCancelListener onCancelListener) {
        return Updater.c(context, onCancelListener);
    }

    public final t b(Context context, OnCancelListener onCancelListener) {
        return Updater.d(context, onCancelListener);
    }

    public final t cL(Context context) {
        return Updater.dT(context);
    }

    public final void cM(Context context) {
        Updater.cM(context);
    }

    public final void d(String str, int i, String str2, String str3) {
        Updater.d(str, i, str2, str3);
    }

    public final u aXU() {
        return new a(2);
    }

    public final String DE(String str) {
        return com.tencent.mm.sandbox.monitor.c.DE(str);
    }

    public final void o(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ExceptionMonitorService.class);
            ab.getContext().startService(intent);
        }
    }

    public final void p(Context context, Intent intent) {
        if (intent != null) {
            intent.setClass(context, AppUpdaterUI.class);
            context.startActivity(intent);
        }
    }

    public final void gG(boolean z) {
        oVx = true;
        oVy = z;
    }
}
