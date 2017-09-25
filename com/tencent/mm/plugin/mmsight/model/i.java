package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.af;

public final class i {
    private static af nCH = new af("MMSightHandler");

    public static void y(Runnable runnable) {
        nCH.D(runnable);
    }

    public static void z(Runnable runnable) {
        nCH.e(runnable, 2000);
    }
}
