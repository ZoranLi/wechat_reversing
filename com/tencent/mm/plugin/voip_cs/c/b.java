package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static final int nQW = a.fromDPToPix(ab.getContext(), 3);
    public static final int nQX = a.fromDPToPix(ab.getContext(), 4);
    public static final int nQY = a.fromDPToPix(ab.getContext(), 8);
    public static final int nQZ = a.fromDPToPix(ab.getContext(), 10);
    public static final int nRa = a.fromDPToPix(ab.getContext(), 14);
    public static final int nRb = a.fromDPToPix(ab.getContext(), 30);
    public static final int nRd = a.fromDPToPix(ab.getContext(), 32);
    public static final int nRe = a.fromDPToPix(ab.getContext(), 96);
    public static final int nRf = a.fromDPToPix(ab.getContext(), 76);
    public static final int nRg = a.fromDPToPix(ab.getContext(), cs.CTRL_INDEX);
    private static int rts = 0;

    public static int cZ(Context context) {
        if (rts == 0) {
            rts = a.dP(context);
        }
        return rts;
    }
}
