package com.tencent.mm.vending.h;

import com.tencent.mm.vending.f.a;

public final class c extends d {
    public c() {
        a.printErrStackTrace("Vending.NoLooperScheduler", new Exception("This is not a handler thread!"), "This is not a handler thread!", new Object[0]);
    }

    public final void ab(Runnable runnable) {
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
    }

    public final void h(Runnable runnable, long j) {
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
    }

    public final String getType() {
        return Thread.currentThread().toString();
    }

    public final void cancel() {
    }
}
