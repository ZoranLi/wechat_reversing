package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public abstract class k<T, E> {
    public int uxk = 0;
    private final Hashtable<T, Object> uxl = new Hashtable();
    private final HashSet<E> uxm = new HashSet();

    public abstract void o(T t, E e);

    public final void lock() {
        this.uxk++;
    }

    public final void unlock() {
        this.uxk--;
        if (this.uxk <= 0) {
            this.uxk = 0;
            bKr();
        }
    }

    public synchronized void a(T t, Looper looper) {
        if (!this.uxl.containsKey(t)) {
            if (looper != null) {
                this.uxl.put(t, looper);
            } else {
                this.uxl.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.uxl.remove(t);
    }

    public final synchronized void removeAll() {
        this.uxl.clear();
    }

    private synchronized Vector<T> bKq() {
        Vector<T> vector;
        vector = new Vector();
        vector.addAll(this.uxl.keySet());
        return vector;
    }

    public final boolean by(E e) {
        boolean add;
        synchronized (this.uxm) {
            add = this.uxm.add(e);
        }
        return add;
    }

    public final void doNotify() {
        if ((this.uxk > 0 ? 1 : null) == null) {
            bKr();
        }
    }

    private void bKr() {
        Vector bKq = bKq();
        if (bKq.size() <= 0) {
            this.uxm.clear();
            return;
        }
        synchronized (this.uxm) {
            ArrayList arrayList = new ArrayList(this.uxm);
            this.uxm.clear();
        }
        Map hashMap = new HashMap();
        Iterator it = bKq.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.uxl.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        ae aeVar = (ae) hashMap.get(looper);
                        if (aeVar == null) {
                            aeVar = new ae(looper);
                            hashMap.put(looper, aeVar);
                        }
                        aeVar.post(new Runnable(this) {
                            final /* synthetic */ k uxp;

                            public final void run() {
                                this.uxp.o(next, next2);
                            }
                        });
                    } else {
                        o(next, next2);
                    }
                }
            }
        }
    }
}
