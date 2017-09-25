package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

abstract class k<T> implements Callable<T> {
    abstract String getTag();

    k() {
    }

    final Future<T> Vb() {
        Object futureTask = new FutureTask(this);
        e.post(futureTask, getTag());
        return futureTask;
    }
}
