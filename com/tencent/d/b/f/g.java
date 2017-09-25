package com.tencent.d.b.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class g {
    private static volatile g xaC = null;
    private Handler xaD = null;
    private Handler xaE = null;

    private g() {
        HandlerThread handlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
        handlerThread.start();
        this.xaD = new Handler(handlerThread.getLooper());
        this.xaE = new Handler(Looper.getMainLooper());
    }

    public static g cfZ() {
        if (xaC != null) {
            return xaC;
        }
        g gVar;
        synchronized (g.class) {
            if (xaC == null) {
                xaC = new g();
            }
            gVar = xaC;
        }
        return gVar;
    }

    public final void y(Runnable runnable) {
        this.xaD.post(runnable);
    }

    public final void i(Runnable runnable, long j) {
        this.xaD.postDelayed(runnable, j);
    }

    public final void v(Runnable runnable) {
        this.xaE.post(runnable);
    }
}
