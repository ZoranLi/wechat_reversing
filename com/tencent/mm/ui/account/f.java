package com.tencent.mm.ui.account;

import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f extends b {
    private static f uYY = null;
    public String hSs = null;
    public String uYS = null;
    public String uYT = null;
    public String uYU = null;
    public String uYV = null;
    public byte[] uYW = null;
    public int uYX = 0;

    public final void bQI() {
        if (bg.mA(this.uYT)) {
            ap.vd().a(new u(this.hSs, this.uYS, this.vfu.uYX, "", "", "", 0, "", false, false), 0);
            return;
        }
        ap.vd().a(new u(this.hSs, this.uYT, this.vfu.uYX, "", "", "", 0, "", false, true), 0);
    }

    public static void a(f fVar) {
        uYY = fVar;
    }

    public static String bQQ() {
        if (uYY != null) {
            return uYY.hSs;
        }
        return null;
    }

    public static String bQR() {
        if (uYY != null) {
            return uYY.uYS;
        }
        return null;
    }
}
