package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class l implements Callback {
    public final a aqM;
    public final ArrayList<b> aqN = new ArrayList();
    public final ArrayList<b> aqO = new ArrayList();
    public final ArrayList<c> aqP = new ArrayList();
    public volatile boolean aqQ = false;
    public final AtomicInteger aqR = new AtomicInteger(0);
    public boolean aqS = false;
    public final Object aqu = new Object();
    public final Handler mHandler;

    public interface a {
        boolean isConnected();
    }

    public l(Looper looper, a aVar) {
        this.aqM = aVar;
        this.mHandler = new Handler(looper, this);
    }

    public final void a(b bVar) {
        w.Z(bVar);
        synchronized (this.aqu) {
            if (this.aqN.contains(bVar)) {
                new StringBuilder("registerConnectionCallbacks(): listener ").append(bVar).append(" is already registered");
            } else {
                this.aqN.add(bVar);
            }
        }
        if (this.aqM.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bVar));
        }
    }

    public final void a(c cVar) {
        w.Z(cVar);
        synchronized (this.aqu) {
            if (this.aqP.contains(cVar)) {
                new StringBuilder("registerConnectionFailedListener(): listener ").append(cVar).append(" is already registered");
            } else {
                this.aqP.add(cVar);
            }
        }
    }

    public final void bY(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        w.a(z, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.aqu) {
            this.aqS = true;
            ArrayList arrayList = new ArrayList(this.aqN);
            int i2 = this.aqR.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.aqQ && this.aqR.get() == i2) {
                    if (this.aqN.contains(bVar)) {
                        bVar.bR(i);
                    }
                }
            }
            this.aqO.clear();
            this.aqS = false;
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            b bVar = (b) message.obj;
            synchronized (this.aqu) {
                if (this.aqQ && this.aqM.isConnected() && this.aqN.contains(bVar)) {
                    bVar.g(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public final void kc() {
        this.aqQ = false;
        this.aqR.incrementAndGet();
    }
}
