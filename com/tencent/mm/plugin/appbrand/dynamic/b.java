package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.Thread.UncaughtExceptionHandler;

public final class b {
    private static ae iGt;
    private static ae iGu;
    private static ae iGv = new ae(Looper.getMainLooper());

    static {
        HandlerThread Qu = e.Qu("DynamicPage#WorkerThread");
        Qu.start();
        Qu.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                w.e("MicroMsg.DynamicPageLogic", "uncaughtException(%s, %s)", new Object[]{thread.getName(), Log.getStackTraceString(th)});
            }
        });
        iGt = new ae(Qu.getLooper());
        Qu = e.Qu("DynamicPage#IPCThread");
        Qu.start();
        Qu.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                w.e("MicroMsg.DynamicPageLogic", "uncaughtException(%s, %s)", new Object[]{thread.getName(), Log.getStackTraceString(th)});
            }
        });
        iGu = new ae(Qu.getLooper());
    }

    public static ae RN() {
        return iGt;
    }

    public static boolean k(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        return iGt.post(runnable);
    }

    public static boolean c(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        return iGt.postDelayed(runnable, j);
    }

    public static boolean l(Runnable runnable) {
        return iGv.post(runnable);
    }
}
