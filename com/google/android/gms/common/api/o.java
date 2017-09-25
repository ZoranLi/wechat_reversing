package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o implements c {
    final Looper amB;
    final com.google.android.gms.common.b amC;
    final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> amD;
    public final int amy;
    private final int amz;
    final Condition anL;
    final l anM;
    final Queue<e<?>> anN = new LinkedList();
    volatile boolean anO;
    long anP = 120000;
    long anQ = 5000;
    final a anR;
    BroadcastReceiver anS;
    final Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.b> anT = new HashMap();
    final Map<com.google.android.gms.common.api.a.c<?>, ConnectionResult> anU = new HashMap();
    Set<Scope> anV = new HashSet();
    public volatile p anW;
    private ConnectionResult anX = null;
    private final Set<r<?>> anY = Collections.newSetFromMap(new WeakHashMap());
    final Set<e<?>> anZ = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    public final Lock anf = new ReentrantLock();
    final h anu;
    final Map<a<?>, Integer> anv;
    private final d aoa = new d(this) {
        final /* synthetic */ o aod;

        {
            this.aod = r1;
        }

        public final void c(e<?> eVar) {
            this.aod.anZ.remove(eVar);
        }
    };
    private final com.google.android.gms.common.api.c.b aob = new com.google.android.gms.common.api.c.b(this) {
        final /* synthetic */ o aod;

        {
            this.aod = r1;
        }

        public final void bR(int i) {
            this.aod.anf.lock();
            try {
                this.aod.anW.bR(i);
            } finally {
                this.aod.anf.unlock();
            }
        }

        public final void g(Bundle bundle) {
            this.aod.anf.lock();
            try {
                this.aod.anW.g(bundle);
            } finally {
                this.aod.anf.unlock();
            }
        }
    };
    private final com.google.android.gms.common.internal.l.a aoc = new com.google.android.gms.common.internal.l.a(this) {
        final /* synthetic */ o aod;

        {
            this.aod = r1;
        }

        public final boolean isConnected() {
            return this.aod.anW instanceof l;
        }
    };
    final Context mContext;

    final class a extends Handler {
        final /* synthetic */ o aod;

        a(o oVar, Looper looper) {
            this.aod = oVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    o oVar = this.aod;
                    oVar.anf.lock();
                    try {
                        if (oVar.jJ()) {
                            oVar.connect();
                        }
                        oVar.anf.unlock();
                        return;
                    } catch (Throwable th) {
                        oVar.anf.unlock();
                    }
                case 2:
                    this.aod.resume();
                    return;
                case 3:
                    ((b) message.obj).a(this.aod);
                    return;
                case 4:
                    throw ((RuntimeException) message.obj);
                default:
                    new StringBuilder("Unknown message id: ").append(message.what);
                    return;
            }
        }
    }

    static abstract class b {
        private final p aog;

        protected b(p pVar) {
            this.aog = pVar;
        }

        public final void a(o oVar) {
            oVar.anf.lock();
            try {
                if (oVar.anW == this.aog) {
                    jz();
                    oVar.anf.unlock();
                }
            } finally {
                oVar.anf.unlock();
            }
        }

        protected abstract void jz();
    }

    private static class c extends BroadcastReceiver {
        private WeakReference<o> aoh;

        c(o oVar) {
            this.aoh = new WeakReference(oVar);
        }

        public final void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals("com.google.android.gms")) {
                o oVar = (o) this.aoh.get();
                if (oVar != null) {
                    oVar.resume();
                }
            }
        }
    }

    interface d {
        void c(e<?> eVar);
    }

    interface e<A extends com.google.android.gms.common.api.a.b> {
        void a(Status status);

        void a(A a);

        void a(d dVar);

        void c(Status status);

        void cancel();

        com.google.android.gms.common.api.a.c<A> ji();
    }

    public o(Context context, Looper looper, h hVar, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Map<a<?>, Object> map, ArrayList<com.google.android.gms.common.api.c.b> arrayList, ArrayList<com.google.android.gms.common.api.c.c> arrayList2, int i, int i2) {
        this.mContext = context;
        this.anM = new l(looper, this.aoc);
        this.amB = looper;
        this.anR = new a(this, looper);
        this.amC = bVar;
        this.amy = i;
        this.amz = i2;
        this.anv = new HashMap();
        this.anL = this.anf.newCondition();
        this.anW = new n(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.anM.a((com.google.android.gms.common.api.c.b) it.next());
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.anM.a((com.google.android.gms.common.api.c.c) it.next());
        }
        Map map2 = hVar.aqn;
        for (a aVar2 : map.keySet()) {
            int i3;
            Object cVar;
            Object obj = map.get(aVar2);
            if (map2.get(aVar2) != null) {
                i3 = ((com.google.android.gms.common.internal.h.a) map2.get(aVar2)).aqq ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.anv.put(aVar2, Integer.valueOf(i3));
            if ((aVar2.amp != null ? 1 : null) != null) {
                w.a(aVar2.amn != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
                com.google.android.gms.common.api.a.e eVar = aVar2.amn;
                cVar = new com.google.android.gms.common.internal.c(context, looper, eVar.jq(), this.aob, a(aVar2, i3), hVar, eVar.jp());
            } else {
                cVar = aVar2.jh().a(context, looper, hVar, obj, this.aob, a(aVar2, i3));
            }
            this.anT.put(aVar2.ji(), cVar);
        }
        this.anu = hVar;
        this.amD = aVar;
    }

    private final com.google.android.gms.common.api.c.c a(final a<?> aVar, final int i) {
        return new com.google.android.gms.common.api.c.c(this) {
            final /* synthetic */ o aod;

            public final void a(ConnectionResult connectionResult) {
                this.aod.anf.lock();
                try {
                    this.aod.anW.a(connectionResult, aVar, i);
                } finally {
                    this.aod.anf.unlock();
                }
            }
        };
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        w.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.anf.lock();
        try {
            connect();
            long toNanos = timeUnit.toNanos(30);
            while (this.anW instanceof m) {
                toNanos = this.anL.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (this.anW instanceof l) {
                connectionResult = ConnectionResult.alY;
                this.anf.unlock();
            } else if (this.anX != null) {
                connectionResult = this.anX;
                this.anf.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.anf.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.anf.unlock();
        }
        return connectionResult;
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        w.b(t.amo != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        w.b(this.anT.containsKey(t.amo), "GoogleApiClient is not configured to use the API required for this call.");
        this.anf.lock();
        try {
            T a = this.anW.a(t);
            return a;
        } finally {
            this.anf.unlock();
        }
    }

    public final void a(com.google.android.gms.common.api.c.b bVar) {
        this.anM.a(bVar);
    }

    public final void a(com.google.android.gms.common.api.c.c cVar) {
        this.anM.a(cVar);
    }

    final void a(b bVar) {
        this.anR.sendMessage(this.anR.obtainMessage(3, bVar));
    }

    public final void a(String str, PrintWriter printWriter) {
        printWriter.append(str).append("mState=").append(this.anW.getName());
        printWriter.append(" mResuming=").print(this.anO);
        printWriter.append(" mWorkQueue.size()=").print(this.anN.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.anZ.size());
        String str2 = str + "  ";
        for (a aVar : this.anv.keySet()) {
            printWriter.append(str).append(aVar.mName).println(":");
            ((com.google.android.gms.common.api.a.b) this.anT.get(aVar.ji())).a(str2, printWriter);
        }
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t) {
        w.b(t.amo != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.anf.lock();
        try {
            if (this.anO) {
                this.anN.add(t);
                while (!this.anN.isEmpty()) {
                    e eVar = (e) this.anN.remove();
                    b(eVar);
                    eVar.c(Status.amO);
                }
            } else {
                t = this.anW.b(t);
                this.anf.unlock();
            }
            return t;
        } finally {
            this.anf.unlock();
        }
    }

    public final void b(com.google.android.gms.common.api.c.b bVar) {
        l lVar = this.anM;
        w.Z(bVar);
        synchronized (lVar.aqu) {
            if (!lVar.aqN.remove(bVar)) {
                new StringBuilder("unregisterConnectionCallbacks(): listener ").append(bVar).append(" not found");
            } else if (lVar.aqS) {
                lVar.aqO.add(bVar);
            }
        }
    }

    public final void b(com.google.android.gms.common.api.c.c cVar) {
        l lVar = this.anM;
        w.Z(cVar);
        synchronized (lVar.aqu) {
            if (!lVar.aqP.remove(cVar)) {
                new StringBuilder("unregisterConnectionFailedListener(): listener ").append(cVar).append(" not found");
            }
        }
    }

    final <A extends com.google.android.gms.common.api.a.b> void b(e<A> eVar) {
        this.anZ.add(eVar);
        eVar.a(this.aoa);
    }

    public final void connect() {
        this.anf.lock();
        try {
            this.anW.connect();
        } finally {
            this.anf.unlock();
        }
    }

    public final void disconnect() {
        this.anf.lock();
        try {
            jJ();
            this.anW.disconnect();
        } finally {
            this.anf.unlock();
        }
    }

    final void f(ConnectionResult connectionResult) {
        this.anf.lock();
        try {
            this.anX = connectionResult;
            this.anW = new n(this);
            this.anW.begin();
            this.anL.signalAll();
        } finally {
            this.anf.unlock();
        }
    }

    public final Looper getLooper() {
        return this.amB;
    }

    public final boolean isConnected() {
        return this.anW instanceof l;
    }

    public final boolean isConnecting() {
        return this.anW instanceof m;
    }

    final void jI() {
        for (e eVar : this.anZ) {
            eVar.a(null);
            eVar.cancel();
        }
        this.anZ.clear();
        for (r rVar : this.anY) {
            rVar.aoj = null;
        }
        this.anY.clear();
    }

    final boolean jJ() {
        if (!this.anO) {
            return false;
        }
        this.anO = false;
        this.anR.removeMessages(2);
        this.anR.removeMessages(1);
        if (this.anS != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.anS);
            this.anS = null;
        }
        return true;
    }

    public final void resume() {
        this.anf.lock();
        try {
            if (this.anO) {
                connect();
            }
            this.anf.unlock();
        } catch (Throwable th) {
            this.anf.unlock();
        }
    }
}
