package com.tencent.mm.plugin.appbrand;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;

public class p {
    private static p ixD;
    private HandlerThread ixE = e.Qu("appbrand_worker_thread");
    private ae mHandler;

    private static p PL() {
        if (ixD == null) {
            synchronized (p.class) {
                if (ixD == null) {
                    ixD = new p();
                }
            }
        }
        return ixD;
    }

    private p() {
        this.ixE.start();
        this.mHandler = new ae(this.ixE.getLooper());
    }

    public static boolean post(Runnable runnable) {
        return PL().mHandler.post(runnable);
    }
}
