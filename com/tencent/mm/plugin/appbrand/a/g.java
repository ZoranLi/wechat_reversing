package com.tencent.mm.plugin.appbrand.a;

import com.tencent.mm.plugin.appbrand.report.c;

abstract class g extends c {
    private final h iAK;

    g(h hVar) {
        this.iAK = hVar;
    }

    public void enter() {
        super.enter();
        this.iAK.a(this);
    }
}
