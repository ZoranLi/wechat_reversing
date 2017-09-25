package com.tencent.mm.ah.a.a;

import com.tencent.mm.ah.a.c.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a {

    private static class a implements ThreadFactory {
        private static final AtomicInteger hIm = new AtomicInteger(1);
        private final ThreadGroup hIn;
        private final AtomicInteger hIo = new AtomicInteger(1);
        private final String hIp;
        private final int hIq;

        a(int i, String str) {
            this.hIq = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.hIn = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.hIp = str + hIm.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.hIn, runnable, this.hIp + this.hIo.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.hIq);
            return thread;
        }
    }

    private static class b extends ThreadPoolExecutor implements h {
        private ReentrantLock hIr = new ReentrantLock();
        private Condition hIs = this.hIr.newCondition();
        private BlockingQueue<Runnable> hIt;
        private boolean isPaused;

        public b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
            this.hIt = blockingQueue;
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            this.hIr.lock();
            while (this.isPaused) {
                try {
                    this.hIs.await();
                } catch (Exception e) {
                    thread.interrupt();
                    w.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.hIr.unlock();
                }
            }
        }

        public final void pause() {
            this.hIr.lock();
            try {
                this.isPaused = true;
            } finally {
                this.hIr.unlock();
            }
        }

        public final void resume() {
            this.hIr.lock();
            try {
                this.isPaused = false;
                this.hIs.signalAll();
            } finally {
                this.hIr.unlock();
            }
        }

        public final void execute(Runnable runnable) {
            super.execute(runnable);
        }

        public final boolean oV() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            if (this.hIt != null) {
                this.hIt.remove(obj);
            }
        }
    }

    public static h aN(int i, int i2) {
        BlockingQueue aVar = new com.tencent.mm.ah.a.e.a();
        return new b(i, i, TimeUnit.MILLISECONDS, aVar, new a(i2, "image_loader_"));
    }
}
