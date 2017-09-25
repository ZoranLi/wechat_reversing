package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import junit.framework.Assert;

public class af {
    private static ae utc = null;
    private ae lGD = null;
    public HandlerThread nJF = null;
    private String utd = null;

    public interface a {
        boolean Bn();

        boolean Bo();
    }

    public interface b {
        void vM();
    }

    public final void Pw(String str) {
        this.lGD = null;
        if (bg.mA(str)) {
            str = "MMHandlerThread";
        }
        this.utd = str;
        this.nJF = e.cE(this.utd, 0);
        this.nJF.start();
    }

    public static void yv(int i) {
        try {
            Process.setThreadPriority(i);
            w.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
        } catch (Throwable e) {
            w.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            w.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void bJh() {
        if (this.nJF == null || !this.nJF.isAlive()) {
            w.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            return;
        }
        int threadId = this.nJF.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                w.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 19);
            w.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            w.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            w.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void bJi() {
        if (this.nJF == null || !this.nJF.isAlive()) {
            w.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.nJF.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                w.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            w.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            w.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            w.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final boolean bJj() {
        if (this.nJF == null || !this.nJF.isAlive()) {
            w.e("MicroMsg.MMHandlerThread", "check inHighPriority failed thread is dead");
            return false;
        }
        int threadId = this.nJF.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                return true;
            }
        } catch (Throwable e) {
            w.w("MicroMsg.MMHandlerThread", "thread:%d  check inHighPriority failed", Integer.valueOf(threadId));
            w.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
        return false;
    }

    public final void bJk() {
        if (this.nJF == null || !this.nJF.isAlive()) {
            w.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            return;
        }
        int threadId = this.nJF.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                w.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 0);
            w.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            w.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            w.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public af() {
        w.i("MicroMsg.MMHandlerThread", "init stack:%s", bg.bJZ());
        Pw(null);
    }

    public af(String str) {
        Pw(str);
    }

    public final ae bJl() {
        if (this.lGD == null) {
            this.lGD = new ae(this.nJF.getLooper());
        }
        return this.lGD;
    }

    public final int a(final b bVar) {
        int a;
        w.i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), bg.bJZ());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.nJF.getId();
        final Object obj = new byte[0];
        final String str = this.utd;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ af uth;

            public final boolean Bo() {
                w.i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                return true;
            }

            public final boolean Bn() {
                w.i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (bVar != null) {
                    bVar.vM();
                }
                w.i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                this.uth.nJF.quit();
                w.i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(this.uth.nJF.getId()));
                this.uth.Pw(str);
                w.i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(this.uth.nJF.getId()));
                synchronized (obj) {
                    w.i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                    obj.notify();
                }
                return true;
            }
        };
        synchronized (obj) {
            a = a(anonymousClass1);
            w.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.nJF.getId()));
            if (a == 0 && id == r4) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    w.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
                }
            }
        }
        return a;
    }

    public int D(Runnable runnable) {
        if (runnable == null) {
            return -1;
        }
        bJl().post(runnable);
        return 0;
    }

    public final int H(Runnable runnable) {
        bJl().postAtFrontOfQueueV2(runnable);
        return 0;
    }

    public final int e(Runnable runnable, long j) {
        if (runnable == null) {
            return -1;
        }
        bJl().postDelayed(runnable, j);
        return 0;
    }

    public final int a(final a aVar) {
        return new ae(this.nJF.getLooper()).postAtFrontOfQueueV2(new Runnable(this) {
            final /* synthetic */ af uth;

            public final void run() {
                aVar.Bn();
                af.J(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 utj;

                    {
                        this.utj = r1;
                    }

                    public final void run() {
                        aVar.Bo();
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|" + aVar.toString();
            }
        }) ? 0 : -2;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    private static ae bJm() {
        if (utc == null) {
            utc = new ae(Looper.getMainLooper());
        }
        return utc;
    }

    public static void v(Runnable runnable) {
        if (runnable != null) {
            bJm().post(runnable);
        }
    }

    public static void f(Runnable runnable, long j) {
        if (runnable != null) {
            bJm().postDelayed(runnable, j);
        }
    }

    public static void I(Runnable runnable) {
        if (runnable != null) {
            bJm().removeCallbacks(runnable);
        }
    }

    public static void J(Runnable runnable) {
        bJm().postAtFrontOfQueueV2(runnable);
    }
}
