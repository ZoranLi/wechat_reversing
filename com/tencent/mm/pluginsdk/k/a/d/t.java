package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class t implements ThreadFactory {
    private static final AtomicInteger sGZ = new AtomicInteger(1);
    private final AtomicInteger hIo;
    private String hIp;

    public t() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public t(String str, String str2) {
        this.hIo = new AtomicInteger(1);
        this.hIp = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(sGZ.getAndIncrement()), str2});
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, this.hIp + this.hIo.getAndIncrement(), 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
