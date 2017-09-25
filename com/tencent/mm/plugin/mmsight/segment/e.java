package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface e {

    public static class a {
        private Lock lQU = new ReentrantLock();
        private LinkedBlockingQueue<e> nGE;
        private final int nGF;
        private Callable<e> nGG;
        private volatile int size = 0;

        public a(int i, Callable<e> callable) {
            this.nGF = i;
            this.nGE = new LinkedBlockingQueue(i);
            this.nGG = callable;
        }

        public final e aLI() {
            e eVar = null;
            long NA = bg.NA();
            w.d("FetcherPool", "acquireFetcher");
            if (this.nGE == null) {
                w.d("FetcherPool", "acquireFetcher no pool directly return null");
            } else {
                this.lQU.lock();
                w.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[]{Integer.valueOf(this.nGE.size()), Integer.valueOf(this.size), Integer.valueOf(this.nGF)});
                if (this.nGE == null) {
                    this.lQU.unlock();
                } else {
                    if (!this.nGE.isEmpty() || this.size >= this.nGF) {
                        w.d("FetcherPool", "waiting fetcher");
                        this.lQU.unlock();
                        eVar = (e) this.nGE.poll(5, TimeUnit.SECONDS);
                    } else {
                        w.d("FetcherPool", "new fetcher");
                        this.size++;
                        this.lQU.unlock();
                        eVar = aLJ();
                    }
                    w.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[]{Long.valueOf(bg.aB(NA))});
                }
            }
            return eVar;
        }

        private e aLJ() {
            if (this.nGG == null) {
                throw new IllegalStateException("fetcher generator can not be null.");
            }
            try {
                e eVar = (e) this.nGG.call();
                w.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[]{Long.valueOf(bg.aB(bg.NA()))});
                return eVar;
            } catch (Throwable e) {
                w.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", new Object[]{e.getMessage()});
                throw e;
            }
        }

        public final void a(e eVar) {
            w.d("FetcherPool", "reuseFetcher");
            if (eVar == null) {
                w.e("FetcherPool", "Null object can not be reused.");
            } else if (this.nGE == null) {
                eVar.release();
            } else if (this.nGE.contains(eVar)) {
                throw new IllegalStateException("fetcher already in pool");
            } else {
                this.nGE.offer(eVar);
            }
        }

        public final void destroy() {
            if (this.nGE != null) {
                this.lQU.lock();
                if (this.nGE == null) {
                    this.lQU.unlock();
                    return;
                }
                try {
                    Iterator it = this.nGE.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).release();
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", new Object[]{e.getMessage()});
                } finally {
                    this.nGE = null;
                    this.lQU.unlock();
                }
            }
        }
    }

    int getDurationMs();

    Bitmap getFrameAtTime(long j);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i, int i2, int i3);

    void release();

    void reuseBitmap(Bitmap bitmap);
}
