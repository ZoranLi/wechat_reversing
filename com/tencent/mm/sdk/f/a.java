package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e.b;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class a {
    private ThreadGroup hIn;
    private final AtomicInteger uxu = new AtomicInteger(1);
    private b uxv;

    static class a extends HandlerThread {
        a(String str, int i) {
            super(str, i);
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    a(b bVar) {
        this.uxv = bVar;
        this.hIn = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final HandlerThread cD(String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        return new a("MM_Thread_Pool_Free_Handler_Thread#" + this.uxu.getAndIncrement() + "#" + str, i);
    }
}
