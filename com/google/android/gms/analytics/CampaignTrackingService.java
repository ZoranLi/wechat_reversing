package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ac;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingService extends Service {
    private static Boolean agV;
    private Handler mHandler;

    public static boolean t(Context context) {
        w.Z(context);
        if (agV != null) {
            return agV.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingService.class);
        agV = Boolean.valueOf(a);
        return a;
    }

    protected final void a(final f fVar, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService ahc;

            public final void run() {
                boolean stopSelfResult = this.ahc.stopSelfResult(i);
                if (stopSelfResult) {
                    fVar.d("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        q.u(this).ig().C("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        q.u(this).ig().C("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (CampaignTrackingReceiver.agS) {
                as asVar = CampaignTrackingReceiver.agT;
                if (asVar != null && asVar.aBE.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q u = q.u(this);
        final f ig = u.ig();
        String str = null;
        if (com.google.android.gms.common.internal.f.apP) {
            ig.G("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            handler = new Handler(getMainLooper());
            this.mHandler = handler;
        }
        if (TextUtils.isEmpty(str)) {
            if (!com.google.android.gms.common.internal.f.apP) {
                ig.F("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            u.ih().c(new Runnable(this) {
                final /* synthetic */ CampaignTrackingService ahc;

                public final void run() {
                    this.ahc.a(ig, handler, i2);
                }
            });
        } else {
            int iL = ac.iL();
            if (str.length() > iL) {
                ig.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(iL));
                str = str.substring(0, iL);
            }
            ig.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            n ii = u.ii();
            Runnable anonymousClass2 = new Runnable(this) {
                final /* synthetic */ CampaignTrackingService ahc;

                public final void run() {
                    this.ahc.a(ig, handler, i2);
                }
            };
            w.i(str, "campaign param can't be empty");
            ii.ahK.ih().c(new com.google.android.gms.analytics.internal.m.AnonymousClass2(ii, str, anonymousClass2));
        }
        return 2;
    }
}
