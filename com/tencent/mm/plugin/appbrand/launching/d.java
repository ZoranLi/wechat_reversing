package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d extends ThreadPoolExecutor {
    private static volatile d iZu = null;

    private d() {
        super(4, 6, 15000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return e.d(runnable, "AppBrandPreparingThread", 5);
            }
        }, new RejectedExecutionHandler() {
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (runnable != null) {
                    e.post(runnable, "AppBrandPreparingThread");
                }
            }
        });
    }

    public static void UU() {
        if (iZu != null) {
            synchronized (d.class) {
                if (iZu != null) {
                    iZu.shutdownNow();
                }
            }
        }
        iZu = null;
    }
}
