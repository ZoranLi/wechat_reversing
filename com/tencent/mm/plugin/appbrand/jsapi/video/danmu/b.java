package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.mm.bg.a;

public final class b {
    public static int iXO = 18;
    public static int iXP = 10;
    private static int iXQ = 3;

    public static float bx(Context context) {
        return ((float) a.fromDPToPix(context, iXO)) * 2.0f;
    }

    public static int t(Context context, int i) {
        return a.fromDPToPix(context, i);
    }

    public static int UG() {
        return iXQ;
    }
}
