package com.tencent.mm.plugin.sport.b;

import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static final void mN(int i) {
        w.v("MicroMsg.Sport.SportReportLogic", "report action=%d", Integer.valueOf(i));
        c.oTb.i(13168, Integer.valueOf(i));
    }
}
