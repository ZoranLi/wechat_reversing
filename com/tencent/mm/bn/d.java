package com.tencent.mm.bn;

public final class d extends com.tencent.mm.vending.h.d {
    public final void ab(Runnable runnable) {
        runnable.run();
    }

    public final void h(Runnable runnable, long j) {
        runnable.run();
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}
