package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.w;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> hgC = new ConcurrentSkipListMap();
    private Vector<a> hgD = new Vector();
    protected long hgE = 0;

    public abstract class a {
        final /* synthetic */ e hgF;

        public abstract S wp();

        public abstract long wq();

        public abstract int wr();

        public a(e eVar) {
            this.hgF = eVar;
        }
    }

    public abstract long at(T t);

    public abstract S au(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    public abstract long wj();

    public abstract long wk();

    public final void a(a aVar) {
        this.hgD.add(aVar);
        w.i("MicroMsg.BucketPool", "%s addPreload: %s", this, aVar);
        wn();
    }

    public final void wn() {
        if (this.hgD.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ e hgF;

                {
                    this.hgF = r1;
                }

                public final void run() {
                    this.hgF.wo();
                }
            }, "BucketPool_preload");
        }
    }

    public final void wo() {
        while (this.hgD.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = (a) this.hgD.remove(0);
            d c = c(b(aVar.wp()));
            long j = 0;
            int i = 0;
            long wq = aVar.wq();
            int wr = aVar.wr();
            w.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", this, aVar.wp(), b(aVar.wp()), Long.valueOf(wq), Integer.valueOf(wr));
            while (this.hgE < wj() && ((wq <= 0 || j < wq) && (wr <= 0 || i < wr))) {
                Object d = d(aVar.wp());
                c.put(d);
                j += at(d);
                i++;
                I(at(d));
            }
            j = System.currentTimeMillis();
            w.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", this, Integer.valueOf(c.size()), Long.valueOf(j - currentTimeMillis));
            this.hgC.put(b(aVar.wp()), c);
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.hgC.get(s);
        if (dVar == null || dVar.size() <= 0) {
            w.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            T pop = dVar.pop();
            this.hgC.put(dVar.wm(), dVar);
            J(at(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void as(T t) {
        if (t != null) {
            Comparable au = au(t);
            long at = at(t);
            if (at > wk()) {
                w.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(at));
            } else if (this.hgE + at > wj()) {
                w.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(at), Long.valueOf(this.hgE));
            } else {
                d dVar = (d) this.hgC.get(au);
                if (dVar == null) {
                    dVar = c(au);
                }
                dVar.put(t);
                this.hgC.put(au, dVar);
                I(at);
            }
        }
    }

    private synchronized void I(long j) {
        this.hgE += j;
    }

    protected final synchronized void J(long j) {
        this.hgE -= j;
    }

    public void wl() {
        w.i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.hgC.clear();
        this.hgE = 0;
    }
}
