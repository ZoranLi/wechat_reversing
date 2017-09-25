package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static Object agS = new Object();
    static as agT;
    static Boolean agU;

    public static boolean s(Context context) {
        w.Z(context);
        if (agU != null) {
            return agU.booleanValue();
        }
        boolean a = k.a(context, AnalyticsReceiver.class, false);
        agU = Boolean.valueOf(a);
        return a;
    }

    public final void onReceive(Context context, Intent intent) {
        f ig = q.u(context).ig();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.apP) {
            ig.d("Device AnalyticsReceiver got", action);
        } else {
            ig.d("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean t = AnalyticsService.t(context);
            Intent intent2 = new Intent(context, AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (agS) {
                context.startService(intent2);
                if (t) {
                    try {
                        if (agT == null) {
                            as asVar = new as(context, "Analytics WakeLock");
                            agT = asVar;
                            asVar.li();
                        }
                        agT.lh();
                    } catch (SecurityException e) {
                        ig.F("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
