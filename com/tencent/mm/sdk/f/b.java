package com.tencent.mm.sdk.f;

import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b {
    private ThreadGroup hIn;
    private final AtomicInteger uxu = new AtomicInteger(1);
    private com.tencent.mm.sdk.f.e.b uxv;

    static class a extends Thread {
        private g uxw;

        a(ThreadGroup threadGroup, g gVar, String str) {
            super(threadGroup, gVar, str);
            this.uxw = gVar;
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    b(com.tencent.mm.sdk.f.e.b bVar) {
        this.uxv = bVar;
        this.hIn = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final Thread a(Runnable runnable, String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread aVar = new a(this.hIn, new g(runnable, str, i, false, this.uxv), "MM_Thread_Pool_Free_Thread#" + this.uxu.getAndIncrement() + "#" + str);
            aVar.setPriority(i);
            return aVar;
        }
        Thread aVar2 = new a(this.hIn, null, "MM_Thread_Pool_Free_Thread#" + this.uxu.getAndIncrement() + "#" + str);
        aVar2.setPriority(i);
        return aVar2;
    }
}
