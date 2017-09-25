package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.ah;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsService extends Service {
    private static Boolean agV;
    private final Handler mHandler = new Handler();

    public static boolean t(Context context) {
        w.Z(context);
        if (agV != null) {
            return agV.booleanValue();
        }
        boolean a = k.a(context, AnalyticsService.class);
        agV = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        f ig = q.u(this).ig();
        if (com.google.android.gms.common.internal.f.apP) {
            ig.C("Device AnalyticsService is starting up");
        } else {
            ig.C("Local AnalyticsService is starting up");
        }
    }

    public final void onDestroy() {
        f ig = q.u(this).ig();
        if (com.google.android.gms.common.internal.f.apP) {
            ig.C("Device AnalyticsService is shutting down");
        } else {
            ig.C("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (AnalyticsReceiver.agS) {
                as asVar = AnalyticsReceiver.agT;
                if (asVar != null && asVar.aBE.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        final q u = q.u(this);
        final f ig = u.ig();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.apP) {
            ig.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            ig.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            u.ii().a(new ah(this) {
                final /* synthetic */ AnalyticsService agZ;

                public final void hr() {
                    this.agZ.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 aha;

                        {
                            this.aha = r1;
                        }

                        public final void run() {
                            if (!this.aha.agZ.stopSelfResult(i2)) {
                                return;
                            }
                            if (com.google.android.gms.common.internal.f.apP) {
                                ig.C("Device AnalyticsService processed last dispatch request");
                            } else {
                                ig.C("Local AnalyticsService processed last dispatch request");
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
