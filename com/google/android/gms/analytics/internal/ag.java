package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.w;

public final class ag extends o {
    boolean ajL;
    boolean ajM;
    private AlarmManager ajN = ((AlarmManager) this.ahK.mContext.getSystemService("alarm"));

    protected ag(q qVar) {
        super(qVar);
    }

    private PendingIntent iY() {
        Intent intent = new Intent(this.ahK.mContext, AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(this.ahK.mContext, 0, intent, 0);
    }

    public final void cancel() {
        ie();
        this.ajM = false;
        this.ajN.cancel(iY());
    }

    protected final void hu() {
        try {
            this.ajN.cancel(iY());
            if (ac.iN() > 0) {
                ActivityInfo receiverInfo = this.ahK.mContext.getPackageManager().getReceiverInfo(new ComponentName(this.ahK.mContext, AnalyticsReceiver.class), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    C("Receiver registered. Using alarm for local dispatch.");
                    this.ajL = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public final void iX() {
        ie();
        w.a(this.ajL, "Receiver not registered");
        long iN = ac.iN();
        if (iN > 0) {
            cancel();
            long elapsedRealtime = this.ahK.ahZ.elapsedRealtime() + iN;
            this.ajM = true;
            this.ajN.setInexactRepeating(2, elapsedRealtime, 0, iY());
        }
    }
}
