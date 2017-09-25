package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public String appId;
    public a jnJ = new a(this) {
        final /* synthetic */ c jnK;

        {
            this.jnK = r1;
        }

        public final void XF() {
            w.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            j.pd(this.jnK.appId);
        }
    };
}
