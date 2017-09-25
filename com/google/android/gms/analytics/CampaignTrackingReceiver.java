package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object agS = new Object();
    static as agT;
    static Boolean agU;

    public static boolean s(Context context) {
        w.Z(context);
        if (agU != null) {
            return agU.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingReceiver.class, true);
        agU = Boolean.valueOf(a);
        return a;
    }

    public Class<? extends CampaignTrackingService> hs() {
        return CampaignTrackingService.class;
    }

    public void onReceive(Context context, Intent intent) {
        f ig = q.u(context).ig();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        ig.d("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            ig.F("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean t = CampaignTrackingService.t(context);
        if (!t) {
            ig.F("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        t(stringExtra);
        if (com.google.android.gms.common.internal.f.apP) {
            ig.G("Received unexpected installation campaign on package side");
            return;
        }
        Class hs = hs();
        w.Z(hs);
        Intent intent2 = new Intent(context, hs);
        intent2.putExtra("referrer", stringExtra);
        synchronized (agS) {
            context.startService(intent2);
            if (t) {
                try {
                    if (agT == null) {
                        as asVar = new as(context, "Analytics campaign WakeLock");
                        agT = asVar;
                        asVar.li();
                    }
                    agT.lh();
                } catch (SecurityException e) {
                    ig.F("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }

    public void t(String str) {
    }
}
