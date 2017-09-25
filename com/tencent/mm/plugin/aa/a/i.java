package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i implements e {
    long fGM = -1;
    b hsf;

    public final void init() {
        ap.vd().a(1530, this);
    }

    public final void NU() {
        ap.vd().b(1530, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.protocal.c.e eVar = ((com.tencent.mm.plugin.aa.a.a.e) kVar).inX;
            w.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[]{Integer.valueOf(eVar.kAC)});
            w.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[]{eVar.tbj});
            if (eVar.kAC == 0) {
                g.a(this.hsf, new Object[]{Boolean.valueOf(true)});
                if (!bg.mA(eVar.tbj) && this.fGM > 0 && ((com.tencent.mm.plugin.aa.a.a.e) kVar).scene == a.ing) {
                    h.g(this.fGM, eVar.tbj);
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 21, 1, false);
                return;
            } else if (eVar.kAC <= 0 || bg.mA(eVar.kAD)) {
                this.hsf.bJ(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 23, 1, false);
                return;
            } else {
                this.hsf.bJ(eVar.kAD);
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 11, 1, false);
                return;
            }
        }
        this.hsf.bJ(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.oUh.a(407, 22, 1, false);
    }
}
