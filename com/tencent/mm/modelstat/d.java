package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;

public final class d {
    private static d hVr;
    private HashSet<String> hVq = new HashSet();

    public static void b(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                d.JW().a(1, activity);
            }

            public final void onActivityStarted(Activity activity) {
                d.JW().a(2, activity);
            }

            public final void onActivityResumed(Activity activity) {
                d.JW().a(3, activity);
            }

            public final void onActivityPaused(Activity activity) {
                d.JW().a(4, activity);
            }

            public final void onActivityStopped(Activity activity) {
                d.JW().a(5, activity);
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
                d.JW().a(6, activity);
            }
        });
    }

    public static void a(int i, String str, int i2) {
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", bg.Nz());
        intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        Context context = ab.getContext();
        if (context == null) {
            return;
        }
        if (ab.bJb()) {
            c.JU().p(intent);
            return;
        }
        w.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", intent, intent.getExtras());
        context.sendBroadcast(intent);
    }

    public final void a(int i, Activity activity) {
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        w.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(this.hVq.contains(className)), bg.bJZ());
        if (!this.hVq.contains(className)) {
            a(i, className, hashCode);
        }
    }

    private d() {
        this.hVq.add("com.tencent.mm.ui.LauncherUI");
        this.hVq.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.hVq.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.hVq.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.hVq.add("com.tencent.mm.ui.chatting.En_5b8fbb1e");
        this.hVq.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
        this.hVq.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
        this.hVq.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
        this.hVq.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
        this.hVq.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
        this.hVq.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    }

    public static d JW() {
        if (hVr == null) {
            synchronized (d.class) {
                if (hVr == null) {
                    hVr = new d();
                }
            }
        }
        return hVr;
    }

    public static void d(String str, long j, long j2) {
        if (com.tencent.mm.protocal.d.sYQ || com.tencent.mm.protocal.d.sYR || com.tencent.mm.protocal.d.sYP) {
            w.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j));
            c.oTb.A(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
    }
}
