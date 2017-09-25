package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g> implements e<R> {
    private final Object amS = new Object();
    protected final a<R> amT;
    private final CountDownLatch amU = new CountDownLatch(1);
    private final ArrayList<Object> amV = new ArrayList();
    private h<R> amW;
    private volatile R amX;
    private volatile boolean amY;
    private boolean amZ;
    private boolean ana;
    private q anb;

    public static class a<R extends g> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    Object obj = pair.first;
                    Object obj2 = pair.second;
                    return;
                case 2:
                    ((j) message.obj).a(Status.amP);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    protected j(Looper looper) {
        this.amT = new a(looper);
    }

    private void b(R r) {
        this.amX = r;
        this.anb = null;
        this.amU.countDown();
        g gVar = this.amX;
        if (this.amW != null) {
            this.amT.removeMessages(2);
            if (!this.amZ) {
                a aVar = this.amT;
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(this.amW, jy())));
            }
        }
        Iterator it = this.amV.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.amV.clear();
    }

    private static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e) {
                new StringBuilder("Unable to release ").append(gVar);
            }
        }
    }

    private boolean jw() {
        return this.amU.getCount() == 0;
    }

    private R jy() {
        R r;
        boolean z = true;
        synchronized (this.amS) {
            if (this.amY) {
                z = false;
            }
            w.a(z, "Result has already been consumed.");
            w.a(jw(), "Result is not ready.");
            r = this.amX;
            this.amX = null;
            this.amW = null;
            this.amY = true;
        }
        jx();
        return r;
    }

    public final void a(Status status) {
        synchronized (this.amS) {
            if (!jw()) {
                a(b(status));
                this.ana = true;
            }
        }
    }

    public final void a(R r) {
        boolean z = true;
        synchronized (this.amS) {
            if (this.ana || this.amZ) {
                c(r);
                return;
            }
            w.a(!jw(), "Results have already been set");
            if (this.amY) {
                z = false;
            }
            w.a(z, "Result has already been consumed");
            b((g) r);
        }
    }

    public abstract R b(Status status);

    public final R b(TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = 2 <= 0 || Looper.myLooper() != Looper.getMainLooper();
        w.a(z2, "await must not be called on the UI thread when time is greater than zero.");
        if (this.amY) {
            z = false;
        }
        w.a(z, "Result has already been consumed.");
        try {
            if (!this.amU.await(2, timeUnit)) {
                a(Status.amP);
            }
        } catch (InterruptedException e) {
            a(Status.amN);
        }
        w.a(jw(), "Result is not ready.");
        return jy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
        r2 = this;
        r1 = r2.amS;
        monitor-enter(r1);
        r0 = r2.amZ;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.amY;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.amX;	 Catch:{ all -> 0x0023 }
        c(r0);	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.amW = r0;	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.amZ = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.google.android.gms.common.api.Status.amQ;	 Catch:{ all -> 0x0023 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0023 }
        r2.b(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.j.cancel():void");
    }

    public final R ju() {
        boolean z = true;
        w.a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.amY) {
            z = false;
        }
        w.a(z, "Result has already been consumed");
        try {
            this.amU.await();
        } catch (InterruptedException e) {
            a(Status.amN);
        }
        w.a(jw(), "Result is not ready.");
        return jy();
    }

    protected void jx() {
    }
}
