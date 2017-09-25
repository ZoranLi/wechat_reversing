package com.tencent.mm.app;

import android.os.HandlerThread;
import com.tencent.mm.bn.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;

public final class j {
    static j fww;
    HandlerThread fwx;
    d fwy;
    ae handler = new ae(this.fwx.getLooper());

    public j(String str) {
        this.fwx = e.cE(str, 10);
        this.fwx.start();
        this.fwy = new h(c.c(this.handler), str);
    }
}
