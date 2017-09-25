package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;

class l {
    private static l gVZ;
    private ae gWa;
    private m gWb;
    private ae mHandler;
    private HandlerThread mHandlerThread = e.Qu("IPCThreadCaller#Worker-" + hashCode());

    private static l ur() {
        if (gVZ == null) {
            synchronized (l.class) {
                if (gVZ == null) {
                    gVZ = new l();
                }
            }
        }
        return gVZ;
    }

    private l() {
        this.mHandlerThread.start();
        this.mHandler = new ae(this.mHandlerThread.getLooper());
        this.gWa = new ae(Looper.getMainLooper());
        this.gWb = m.ut();
    }

    public static boolean d(Runnable runnable) {
        ur().gWb.gWd.execute(runnable);
        return true;
    }
}
