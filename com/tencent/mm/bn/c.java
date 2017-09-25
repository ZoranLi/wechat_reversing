package com.tencent.mm.bn;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.h.a;

public final class c implements a {
    private ae mHandler;

    private c(ae aeVar) {
        this.mHandler = aeVar;
    }

    public static c c(ae aeVar) {
        return new c(aeVar);
    }

    public final void f(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public final void g(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public final Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public final void cl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
