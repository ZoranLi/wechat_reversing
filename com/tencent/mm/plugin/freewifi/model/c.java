package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class c {
    private HandlerThread lTf;
    private ae lTg;

    public final ae awp() {
        if (this.lTf == null) {
            this.lTf = e.Qu("FreeWifiHandlerThread_handlerThread");
            this.lTf.start();
        }
        if (this.lTg == null) {
            this.lTg = new ae(this.lTf.getLooper());
        }
        return this.lTg;
    }

    public final void release() {
        if (this.lTf != null) {
            this.lTf.quit();
            this.lTf = null;
        }
        this.lTg = null;
    }
}
