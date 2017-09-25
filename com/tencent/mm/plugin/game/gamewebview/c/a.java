package com.tencent.mm.plugin.game.gamewebview.c;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public d mkn;
    private String mlI;
    private int mlJ = am.getNetType(ab.getContext());
    private int mlK;
    public int mlL;
    public boolean mlM;
    public long mlN;
    public long mlO;
    public long mlP;
    public long mlQ;
    public long mlR;

    public a(d dVar) {
        this.mkn = dVar;
        this.mlK = dVar.mmy.wwS ? 1 : 2;
        this.mlN = System.currentTimeMillis();
        this.mlI = bg.mz(this.mkn.mlI);
    }

    public final void ey(boolean z) {
        long j;
        int i = 1;
        w.d("MicroMsg.GameWebViewReportManager", "getA8keyTime = %d, success = %b", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mlQ), Boolean.valueOf(z)});
        String azN = this.mkn.azN();
        if (!z) {
            i = 0;
        }
        a(azN, 3, r4, i, 0);
        g gVar = g.oUh;
        if (z) {
            j = 2;
        } else {
            j = 1;
        }
        gVar.a(607, j, 1, false);
    }

    public final void a(String str, int i, long j, int i2, int i3) {
        g.oUh.i(14531, new Object[]{this.mkn.azO(), ai.xR(this.mlI), ai.xR(str), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.mlJ), Integer.valueOf(this.mlK), Integer.valueOf(i3)});
    }
}
