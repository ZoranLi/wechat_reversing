package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.w;

public abstract class c extends com.tencent.mm.sdk.d.c {
    public void enter() {
        super.enter();
        w.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    public void exit() {
        super.exit();
        w.i("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
