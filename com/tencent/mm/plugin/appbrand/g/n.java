package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.report.e;

public final class n {
    public final e jdt;
    public volatile long jdu = 0;
    public volatile long jdv = 0;

    n(int i) {
        this.jdt = new e("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
    }

    public final boolean VV() {
        return this.jdu > 0 && this.jdv <= 0;
    }
}
