package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class u {
    public static final void h(String str, int i, int i2, int i3) {
        if (!bg.mA(str)) {
            w.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)}));
            g.oUh.A(13234, r0);
        }
    }

    public static void BN(int i) {
        w.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", Integer.valueOf(13941), Integer.valueOf(i));
        g.oUh.i(13941, Integer.valueOf(i));
    }
}
