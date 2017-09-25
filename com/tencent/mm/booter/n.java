package com.tencent.mm.booter;

import com.tencent.mm.ap.k;
import com.tencent.mm.au.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;

public final class n {
    private static long gKu = 86400000;

    public static void run() {
        boolean z;
        ap.yY();
        if (u.az(Long.valueOf(u.c((Long) c.vr().get(81944, null))).longValue()) * 1000 > gKu) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e JK = d.JK();
            d.JL();
            if (!JK.hpL) {
                h.vJ();
                if (h.vI().isSDCardAvailable()) {
                    JK.release();
                    JK.hpL = true;
                    h.vd().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, JK);
                    h.vd().a(new k(9), 0);
                }
            }
        }
    }
}
