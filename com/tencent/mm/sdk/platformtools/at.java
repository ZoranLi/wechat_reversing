package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class at<K, V> {
    private final long alA;
    public final aj fyI;
    public volatile boolean fyL = false;
    public final y<K, a<V>> mSt;
    protected Object tag;
    private final long threshold;
    public final LinkedHashMap<K, b<K, V>> uuZ = new LinkedHashMap();
    private final c<K, V> uva;
    public final aj uvb;
    private final long uvc;
    private boolean uvd = true;

    static class a<V> {
        final V uvf;

        a(V v) {
            this.uvf = v;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.uvf != null) {
                return this.uvf.equals(aVar.uvf);
            }
            if (aVar.uvf == null) {
                return true;
            }
            return false;
        }
    }

    public static class b<K, V> {
        public K sWq;
        public int uvg;
        public V values;
    }

    public interface c<K, V> {
        boolean Kc();

        void Kd();

        void a(at<K, V> atVar, b<K, V> bVar);
    }

    public at(c<K, V> cVar, Looper looper, int i, int i2, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("arg appender can not be null!");
        } else if (looper == null) {
            throw new IllegalArgumentException("arg looper can not be null!");
        } else if (i <= 0) {
            throw new IllegalArgumentException("arg size can not be <= 0!");
        } else {
            this.uva = cVar;
            this.mSt = new y(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (j <= 0) {
                j = 60000;
            }
            this.uvc = j;
            if (j2 <= 0) {
                j2 = 60000;
            }
            this.alA = j2;
            this.fyI = new aj(looper, new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ at uve;

                {
                    this.uve = r1;
                }

                public final boolean oQ() {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.uve.jV(false);
                    w.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return false;
                }
            }, false);
            this.uvb = new aj(new af("RWCache_timeoutChecker").nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ at uve;

                {
                    this.uve = r1;
                }

                public final boolean oQ() {
                    this.uve.fyL = true;
                    return false;
                }
            }, false);
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.mSt.get(k);
        if (aVar != null) {
            return aVar.uvf;
        }
        this.mSt.put(k, new a(null));
        return null;
    }

    public final boolean q(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.mSt.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            return false;
        }
        int i;
        this.mSt.put(k, aVar2);
        b bVar = new b();
        bVar.sWq = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.uvg = i;
        synchronized (this) {
            this.uuZ.put(k, bVar);
            if (this.uvd && ((long) this.uuZ.size()) > this.threshold) {
                this.fyI.v(0, 0);
                this.uvd = false;
            } else if (this.fyI.bJq()) {
                aj ajVar = this.fyI;
                long j = this.uvc;
                ajVar.v(j, j);
            }
        }
        return true;
    }

    public final void jV(boolean z) {
        w.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.uuZ.size());
        synchronized (this) {
            this.uvd = true;
            if (this.uuZ.isEmpty()) {
            } else if (this.uva.Kc()) {
                Iterator it = this.uuZ.entrySet().iterator();
                if (z) {
                    while (it.hasNext()) {
                        this.uva.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                } else {
                    this.fyL = false;
                    aj ajVar = this.uvb;
                    long j = this.alA;
                    ajVar.v(j, j);
                    while (!this.fyL && it.hasNext()) {
                        this.uva.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                    if (this.fyL) {
                        w.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.uuZ.size()), Boolean.valueOf(it.hasNext()));
                    }
                    this.uvb.KH();
                }
                this.uva.Kd();
            }
        }
    }
}
