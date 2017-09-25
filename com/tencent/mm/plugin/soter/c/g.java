package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class g {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void blV() {
        w.i(TAG, "alvinluo dynamic config support soter: %b", new Object[]{Boolean.valueOf(bg.getInt(((a) h.vE().h(a.class)).sV().getValue("SoterEntry"), 0) == 1)});
        if (bg.getInt(((a) h.vE().h(a.class)).sV().getValue("SoterEntry"), 0) == 1) {
            w.d(TAG, "alvinluo set all soter support flag to true");
            p.gRi.fXh = true;
            p.gRg.gRo = 1;
            p.gRg.gRp = 1;
            w.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[]{Boolean.valueOf(p.gRi.fXh), Integer.valueOf(p.gRg.gRo), Integer.valueOf(p.gRg.gRp)});
        }
    }

    public static String blW() {
        return m.xO();
    }

    public static String blX() {
        return "WechatAuthKeyPay&" + m.xO();
    }

    public static boolean blY() {
        return hQ(true);
    }

    public static boolean hQ(boolean z) {
        if (!z || p.gRi.fXh) {
            return com.tencent.d.b.a.cfL();
        }
        w.i(TAG, "hy: dynamic config is not support soter");
        return false;
    }
}
