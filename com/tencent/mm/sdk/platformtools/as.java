package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class as {
    private static final ConcurrentLinkedQueue<Runnable> uuX = new ConcurrentLinkedQueue();
    private static ExecutorService uuY = null;

    as() {
    }

    public static ExecutorService bJy() {
        ExecutorService executorService;
        synchronized (as.class) {
            if (uuY == null) {
                uuY = Executors.newSingleThreadExecutor();
            }
            executorService = uuY;
        }
        return executorService;
    }

    public static void K(Runnable runnable) {
        uuX.add(runnable);
    }

    public static void L(Runnable runnable) {
        uuX.remove(runnable);
    }
}
