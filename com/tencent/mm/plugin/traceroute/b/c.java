package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class c extends ThreadPoolExecutor {
    public c() {
        super(10, 20, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(m.CTRL_INDEX), new CallerRunsPolicy());
    }
}
