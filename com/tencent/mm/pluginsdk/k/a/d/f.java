package com.tencent.mm.pluginsdk.k.a.d;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class f<T extends b> {
    public final Map<String, b> sGt = new ConcurrentHashMap();
    public final Map<String, Future<?>> sGu = new ConcurrentHashMap();

    protected class a extends ThreadPoolExecutor {
        final /* synthetic */ f sGv;

        public a(f fVar, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, t tVar) {
            this.sGv = fVar;
            super(i, i2, j, timeUnit, blockingQueue, tVar);
        }

        protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            if (runnable instanceof d) {
                return new c(runnable, v, ((d) runnable).sGw);
            }
            return super.newTaskFor(runnable, v);
        }

        protected final void terminated() {
            this.sGv.sGu.clear();
            super.terminated();
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (this.sGv.sGu.containsKey(cVar.sGw.bDp())) {
                    cVar.cancel(false);
                } else {
                    this.sGv.sGu.put(cVar.sGw.bDp(), cVar);
                    this.sGv.sGt.remove(cVar.sGw.bDp());
                }
            } else {
                w.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
        }

        protected final void afterExecute(Runnable runnable, Throwable th) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                this.sGv.sGu.remove(cVar.sGw.bDp());
                this.sGv.sGt.remove(cVar.sGw.bDp());
            } else {
                w.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
        }
    }

    public interface b {
        String bDp();
    }

    protected static class c<V> extends FutureTask<V> {
        protected final b sGw;

        public c(Runnable runnable, V v, b bVar) {
            super(runnable, v);
            this.sGw = bVar;
        }
    }

    protected static abstract class d<Req extends b> implements Runnable {
        public final Req sGw;

        public Req Qv() {
            return this.sGw;
        }

        public d(Req req) {
            this.sGw = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    public abstract d a(T t);

    public abstract a bDv();

    public final void b(T t) {
        this.sGt.put(t.bDp(), t);
        bDv().submit(a(t));
    }

    public final synchronized boolean Ms(String str) {
        boolean z;
        z = this.sGu.containsKey(str) || this.sGt.containsKey(str);
        return z;
    }
}
