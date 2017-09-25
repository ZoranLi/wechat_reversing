package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h extends ThreadPoolExecutor {
    public h(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(3, 3, 3000, timeUnit, blockingQueue, threadFactory);
    }

    protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        if (runnable instanceof c) {
            return new e(runnable, v, (c) runnable);
        }
        return super.newTaskFor(runnable, v);
    }

    protected final void terminated() {
        d bAt = d.bAt();
        if (bAt.spr != null) {
            bAt.spr.clear();
        }
        super.terminated();
    }

    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        w.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        if (runnable instanceof e) {
            e eVar = (e) runnable;
            if (!(eVar.spD == null || eVar.spD.sph == null)) {
                d.bAt().KA(eVar.spD.sph.spE);
                w.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
            }
        }
        w.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
        super.afterExecute(runnable, th);
    }
}
