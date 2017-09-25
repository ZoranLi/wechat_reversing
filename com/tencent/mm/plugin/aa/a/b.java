package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b implements e {
    com.tencent.mm.vending.g.b ink;

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            v vVar = ((j) kVar).ioh;
            w.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[]{Integer.valueOf(vVar.kAC)});
            if (vVar.kAC == 0) {
                g.a(this.ink, new Object[]{vVar});
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 6, 1, false);
                c mJ = com.tencent.mm.plugin.aa.b.NJ().mJ(vVar.tbh);
                if (mJ != null) {
                    mJ.field_status = vVar.state;
                    com.tencent.mm.plugin.aa.b.NJ().b(mJ);
                    return;
                }
                return;
            }
            if (vVar.kAC <= 0 || bg.mA(vVar.kAD)) {
                this.ink.bJ(Boolean.valueOf(false));
            } else {
                this.ink.bJ(vVar.kAD);
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(407, 8, 1, false);
            return;
        }
        if (this.ink != null) {
            this.ink.bJ(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(407, 7, 1, false);
    }
}
