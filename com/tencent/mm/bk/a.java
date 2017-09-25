package com.tencent.mm.bk;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;

public class a {
    private static a uNz;
    private ae gWa;
    private ae mHandler;
    private HandlerThread mHandlerThread = e.Qu("WorkerThread#" + hashCode());

    private static a bOd() {
        if (uNz == null) {
            synchronized (a.class) {
                if (uNz == null) {
                    uNz = new a();
                }
            }
        }
        return uNz;
    }

    private a() {
        this.mHandlerThread.start();
        this.mHandler = new ae(this.mHandlerThread.getLooper());
        this.gWa = new ae(Looper.getMainLooper());
    }

    public static boolean post(Runnable runnable) {
        return bOd().mHandler.post(runnable);
    }

    public static boolean e(Runnable runnable) {
        return bOd().mHandler.postDelayed(runnable, 1000);
    }

    public static boolean W(Runnable runnable) {
        return bOd().gWa.post(runnable);
    }

    public static boolean X(Runnable runnable) {
        return bOd().gWa.postDelayed(runnable, 1000);
    }
}
