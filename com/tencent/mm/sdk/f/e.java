package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e implements a {
    private static e uxF;
    static int[] uxG = new int[]{19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    public static long uxH = 0;
    public static long uxI = 0;
    private static b uxJ;
    private static a uxK;
    private static b uxL;
    private boolean fCF = false;
    volatile boolean fKF = false;
    Object lock = new Object();
    LinkedList<g> uxA = new LinkedList();
    private ArrayList<g> uxB = new ArrayList();
    private HashMap<g, Thread> uxC = new HashMap();
    ArrayList<c> uxD = new ArrayList();
    c uxE;
    f uxx = new f(this.uxy + 2, TimeUnit.SECONDS, this.uxz, this);
    private int uxy = bKt();
    private PriorityBlockingQueue<Runnable> uxz = new PriorityBlockingQueue(33);

    public interface b {
    }

    class a implements c {
        private final Runnable uxM;
        final /* synthetic */ e uxN;

        public a(e eVar, Runnable runnable) {
            this.uxN = eVar;
            this.uxM = runnable;
        }

        public final void x(Runnable runnable) {
            if (runnable.equals(this.uxM)) {
                synchronized (this.uxM) {
                    this.uxM.notifyAll();
                    e.c(this);
                }
            }
        }
    }

    class c extends ae {
        final /* synthetic */ e uxN;

        public c(e eVar, Looper looper) {
            this.uxN = eVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(message.what);
                    if (this.uxN.fKF) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (e.uxH > 0 && Math.abs(e.uxI - currentTimeMillis) > e.uxH) {
                            w.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
                            e eVar = this.uxN;
                            synchronized (eVar.lock) {
                                eVar.fKF = false;
                                e.uxI = 0;
                                e.uxH = 0;
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    e eVar2 = this.uxN;
                    synchronized (eVar2.lock) {
                        if (!eVar2.uxA.isEmpty()) {
                            Iterator it = eVar2.uxA.iterator();
                            if (it != null && it.hasNext()) {
                                g gVar = (g) it.next();
                                it.remove();
                                eVar2.bKu();
                                eVar2.uxx.execute(gVar);
                                it = new ArrayList(eVar2.uxD).iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    Runnable runnable = gVar.uty;
                                    eVar2.uxx.getActiveCount();
                                }
                            }
                        }
                        if (!eVar2.uxA.isEmpty()) {
                            eVar2.uxE.sendEmptyMessage(1);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static e bKs() {
        if (uxF == null) {
            synchronized (e.class) {
                if (uxF == null) {
                    uxF = new e();
                }
            }
        }
        return uxF;
    }

    private e() {
        HandlerThread Qu = Qu("THREAD_POOL_HANDLER");
        Qu.start();
        this.uxE = new c(this, Qu.getLooper());
    }

    private static int bKt() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 32) {
            return 32;
        }
        return availableProcessors;
    }

    public final void beforeExecute(Thread thread, Runnable runnable) {
        int i = 10;
        synchronized (this.lock) {
            Iterator it = this.uxB.iterator();
            if (it != null) {
                Object obj;
                g gVar = (g) runnable;
                int i2 = gVar.priority;
                if (i2 <= 0) {
                    i = 1;
                } else if (i2 <= 10) {
                    i = i2;
                }
                thread.setPriority(i);
                thread.setName(gVar.mjV);
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    this.uxC.put(gVar, thread);
                    ArrayList arrayList = new ArrayList(this.uxD);
                    if (!this.fCF) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    this.fCF = true;
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        Runnable runnable2 = gVar.uty;
                    }
                }
            }
        }
    }

    public final void N(Runnable runnable) {
        synchronized (this.lock) {
            g gVar = (g) runnable;
            Iterator it = this.uxC.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Iterator it2 = new ArrayList(this.uxD).iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).x(gVar.uty);
                    }
                }
            }
            int activeCount = this.uxx.getActiveCount();
            int size = this.uxx.getQueue().size();
            int corePoolSize = this.uxx.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.uxy = bKt();
                    this.uxx.setCorePoolSize(0);
                    this.uxx.setMaximumPoolSize(this.uxy + 2);
                }
                Iterator it3 = new ArrayList(this.uxD).iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                this.fCF = false;
            }
        }
    }

    public static void a(c cVar) {
        bKs().b(cVar);
    }

    private void b(c cVar) {
        synchronized (this.lock) {
            if (!this.uxD.contains(cVar)) {
                this.uxD.add(cVar);
            }
        }
    }

    public static void c(c cVar) {
        e bKs = bKs();
        synchronized (bKs.lock) {
            bKs.uxD.remove(cVar);
        }
    }

    public static void post(Runnable runnable, String str) {
        bKs().c(runnable, str, 5);
    }

    public static void b(Runnable runnable, String str, int i) {
        bKs().c(runnable, str, i);
    }

    private void c(Runnable runnable, String str, int i) {
        synchronized (this.lock) {
            g gVar = new g(runnable, str, i, true, uxL);
            this.uxA.add(gVar);
            this.uxB.add(gVar);
            this.uxE.sendEmptyMessage(1);
            jW(false);
        }
    }

    public static void a(Runnable runnable, String str) {
        e bKs = bKs();
        synchronized (bKs.lock) {
            Object gVar = new g(runnable, str, Integer.MAX_VALUE, true, uxL);
            bKs.uxB.add(gVar);
            bKs.uxx.execute(gVar);
            if (bKs.uxx.getActiveCount() < bKs.uxy || bKs.uxy >= bKt() * 2) {
                bKs.bKu();
            } else {
                bKs.uxy++;
                bKs.uxx.setCorePoolSize(bKs.uxy);
                bKs.uxx.setMaximumPoolSize(bKs.uxy);
                w.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + bKs.uxy);
            }
            Iterator it = new ArrayList(bKs.uxD).iterator();
            while (it.hasNext()) {
                it.next();
                Runnable runnable2 = gVar.uty;
            }
            bKs.jW(false);
        }
    }

    public static void O(Runnable runnable) {
        e bKs = bKs();
        synchronized (bKs.lock) {
            Thread P = bKs.P(runnable);
            if (P != null) {
                P.interrupt();
            } else {
                bKs.V(runnable);
            }
        }
    }

    private Thread P(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        synchronized (this.lock) {
            Iterator it = this.uxC.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    obj = (g) it.next();
                    if (obj != null && obj.uty.equals(runnable)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Thread thread = (Thread) this.uxC.get(obj);
                    return thread;
                }
            }
            return null;
        }
    }

    public static void Q(Runnable runnable) {
        bKs().R(runnable);
    }

    private void R(Runnable runnable) {
        Assert.assertNotNull("join arg runnable is null!", runnable);
        Object obj = null;
        synchronized (this.lock) {
            if (U(runnable)) {
                obj = new a(this, runnable);
                b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (this.uxD.contains(obj)) {
                    runnable.wait();
                } else {
                    w.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static void S(Runnable runnable) {
        int i = 1;
        e bKs = bKs();
        Assert.assertNotNull("join arg runnable is null!", runnable);
        if (5000 < 0) {
            throw new IllegalArgumentException();
        }
        int i2;
        if (5000 >= 9223372036854L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (5000 != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            bKs.R(runnable);
            return;
        }
        Object obj = null;
        synchronized (bKs.lock) {
            if (bKs.U(runnable)) {
                obj = new a(bKs, runnable);
                bKs().b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (bKs.uxD.contains(obj)) {
                    runnable.wait(5000, 0);
                } else {
                    w.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static boolean T(Runnable runnable) {
        return bKs().U(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean U(java.lang.Runnable r6) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = r5.lock;
        monitor-enter(r3);
        r0 = r5.uxB;	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x002a;
    L_0x0011:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x002a;
    L_0x0017:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x001f:
        r0 = r0.uty;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x002a:
        r0 = r5.uxC;	 Catch:{ all -> 0x0052 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x004f;
    L_0x0036:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x0044:
        r0 = r0.uty;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x004c:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x004f:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r1;
        goto L_0x0005;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.f.e.U(java.lang.Runnable):boolean");
    }

    public static boolean remove(Runnable runnable) {
        return bKs().V(runnable);
    }

    private boolean V(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            Iterator it = this.uxB.iterator();
            if (it != null) {
                Runnable runnable2;
                while (it.hasNext()) {
                    runnable2 = (g) it.next();
                    if (runnable2 != null && runnable2.uty.equals(runnable)) {
                        it.remove();
                        break;
                    }
                }
                runnable2 = null;
                if (runnable2 != null) {
                    this.uxx.remove(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    final void bKu() {
        if (this.uxx.getCorePoolSize() < this.uxy) {
            this.uxx.setCorePoolSize(this.uxy);
            this.uxx.setMaximumPoolSize(this.uxy);
        }
    }

    public static void bKv() {
        bKs().jW(true);
    }

    private void jW(boolean z) {
        if (z) {
            synchronized (this.lock) {
                w.i("MicroMsg.ThreadPool", "------------------------------------------");
                Iterator it = this.uxA.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        w.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + ((g) it.next()) + "}");
                    }
                }
                w.i("MicroMsg.ThreadPool", "-----------");
                it = this.uxB.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        w.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + ((g) it.next()) + "}");
                    }
                }
                w.i("MicroMsg.ThreadPool", "-----------");
                it = this.uxC.keySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        w.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + ((g) it.next()) + "}");
                    }
                }
                w.i("MicroMsg.ThreadPool", "-----------");
                w.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.uxx.getPoolSize() + "|activeCount=" + this.uxx.getActiveCount() + "|corePoolSize=" + this.uxx.getPoolSize() + "|largestPoolSize=" + this.uxx.getLargestPoolSize() + "|maximuPoolSize=" + this.uxx.getMaximumPoolSize());
                w.i("MicroMsg.ThreadPool", "------------------------------------------");
            }
        }
    }

    private static b bKw() {
        if (uxJ == null) {
            uxJ = new b(uxL);
        }
        return uxJ;
    }

    public static Thread b(Runnable runnable, String str) {
        return bKw().a(runnable, str, 5);
    }

    public static Thread d(Runnable runnable, String str, int i) {
        return bKw().a(runnable, str, i);
    }

    private static a bKx() {
        if (uxK == null) {
            uxK = new a(uxL);
        }
        return uxK;
    }

    public static HandlerThread Qu(String str) {
        return bKx().cD(str, 0);
    }

    public static HandlerThread cE(String str, int i) {
        return bKx().cD(str, i);
    }
}
