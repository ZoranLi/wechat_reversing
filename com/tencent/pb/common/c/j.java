package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class j {
    public static Handler ji = new Handler(Looper.getMainLooper());

    public static void ac(Runnable runnable) {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) != null) {
            runnable.run();
        } else {
            ji.post(runnable);
        }
    }
}
