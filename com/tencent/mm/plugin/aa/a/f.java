package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f implements e {
    b ink;
    boolean iny = false;

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.iny = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((i) kVar).iof;
            w.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(oVar.kAC), oVar.kAD});
            if (oVar.kAC == 0) {
                g.a(this.ink, new Object[]{oVar});
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 9, 1, false);
                return;
            }
            if (this.ink != null) {
                if (oVar.tbB != null && oVar.tbB.fRW == 1 && !bg.mA(oVar.tbB.kAJ) && !bg.mA(oVar.tbB.nnP) && !bg.mA(oVar.tbB.nnQ) && !bg.mA(oVar.tbB.fNG)) {
                    this.ink.bJ(oVar.tbB);
                } else if (oVar.kAC <= 0 || bg.mA(oVar.kAD)) {
                    this.ink.bJ(Boolean.valueOf(false));
                } else {
                    this.ink.bJ(oVar.kAD);
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(407, 11, 1, false);
            return;
        }
        if (this.ink != null) {
            this.ink.bJ(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(407, 10, 1, false);
    }
}
