package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class m {
    private static m gWc;
    ExecutorService gWd;
    private int gWe = 3;
    private ae mHandler;

    private static m us() {
        if (gWc == null) {
            synchronized (m.class) {
                if (gWc == null) {
                    gWc = new m();
                }
            }
        }
        return gWc;
    }

    static m ut() {
        return new m();
    }

    private m() {
        final HandlerThread Qu = e.Qu("IPCThreadPool#WorkerThread-" + hashCode());
        Qu.start();
        this.mHandler = new ae(Qu.getLooper());
        this.gWd = Executors.newScheduledThreadPool(this.gWe, new ThreadFactory(this) {
            final /* synthetic */ m gWg;
            int index = 0;

            public final Thread newThread(final Runnable runnable) {
                StringBuilder stringBuilder = new StringBuilder("IPCThreadPool#Thread-");
                int i = this.index;
                this.index = i + 1;
                Thread thread = new Thread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 gWi;

                    public final void run() {
                        ThreadLocal threadLocal = (ThreadLocal) new a(Looper.class, "sThreadLocal").uv();
                        if (threadLocal == null || threadLocal.get() != null) {
                            w.d("IPC.IPCThreadPool", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                        } else {
                            w.d("IPC.IPCThreadPool", "create a new Looper ThreadLocal variable.");
                            threadLocal.set(Qu.getLooper());
                        }
                        runnable.run();
                    }
                }, stringBuilder.append(i).toString());
                w.i("IPC.IPCThreadPool", "newThread(thread : %s)", r0);
                return thread;
            }
        });
        w.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
    }

    public static boolean post(Runnable runnable) {
        us().gWd.execute(runnable);
        return true;
    }

    public static boolean e(Runnable runnable) {
        return us().mHandler.postDelayed(runnable, 2000);
    }
}
