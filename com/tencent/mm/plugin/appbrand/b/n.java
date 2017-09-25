package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.sdk.platformtools.bg;

public enum n {
    ;

    public static void h(final String str, final String str2, final int i) {
        if (!bg.mA(str2)) {
            b.an(str2, i);
            d.vL().D(new Runnable() {
                public final void run() {
                    n.i(str, str2, i);
                }
            });
        }
    }
}
