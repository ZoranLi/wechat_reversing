package com.tencent.mm.plugin.appbrand.n.e;

import com.tencent.mm.sdk.platformtools.w;

public final class d extends g implements b {
    private String joW = "*";

    public final void ra(String str) {
        if (str == null) {
            w.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.joW = str;
        }
    }

    public final String Ya() {
        return this.joW;
    }
}
