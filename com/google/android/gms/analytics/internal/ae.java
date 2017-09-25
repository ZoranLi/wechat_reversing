package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.w;

abstract class ae {
    private static volatile Handler ajG;
    public final q ahK;
    final Runnable ajH = new Runnable(this) {
        final /* synthetic */ ae ajK;

        {
            this.ajK = r1;
        }

        public final void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.ajK.ahK.ih().c(this);
                return;
            }
            boolean iV = this.ajK.iV();
            this.ajK.ajI = 0;
            if (iV && !this.ajK.ajJ) {
                this.ajK.run();
            }
        }
    };
    public volatile long ajI;
    public boolean ajJ;

    ae(q qVar) {
        w.Z(qVar);
        this.ahK = qVar;
    }

    public final void cancel() {
        this.ajI = 0;
        getHandler().removeCallbacks(this.ajH);
    }

    final Handler getHandler() {
        if (ajG != null) {
            return ajG;
        }
        Handler handler;
        synchronized (ae.class) {
            if (ajG == null) {
                ajG = new Handler(this.ahK.mContext.getMainLooper());
            }
            handler = ajG;
        }
        return handler;
    }

    public final boolean iV() {
        return this.ajI != 0;
    }

    public final void j(long j) {
        cancel();
        if (j >= 0) {
            this.ajI = this.ahK.ahZ.currentTimeMillis();
            if (!getHandler().postDelayed(this.ajH, j)) {
                this.ahK.ig().g("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public abstract void run();
}
