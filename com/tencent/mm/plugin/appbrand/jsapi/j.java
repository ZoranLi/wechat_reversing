package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.w;

public final class j extends e {
    private static final int CTRL_INDEX = 248;
    private static final String NAME = "onUserCaptureScreen";
    private static j iLb = new j();

    public static void pd(String str) {
        w.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[]{str});
        iLb.ad(str, 0).SR();
    }
}
