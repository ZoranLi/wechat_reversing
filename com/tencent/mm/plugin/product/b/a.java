package com.tencent.mm.plugin.product.b;

import com.tencent.mm.e.a.le;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends c<le> {
    public a() {
        this.usg = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        le leVar = (le) bVar;
        switch (leVar.fRQ.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.aSQ();
                c aSR = com.tencent.mm.plugin.product.a.a.aSR();
                if (aSR != null) {
                    m b = m.b(null, leVar.fRQ.fRS);
                    aSR.a(b, null);
                    leVar.fRR.fRT = aSR.aTj();
                    le.b bVar2 = leVar.fRR;
                    if (!bg.mA(b.aTm())) {
                        str = com.tencent.mm.plugin.product.ui.c.CA(b.aTm());
                    }
                    bVar2.fKz = str;
                    leVar.fRR.fFj = true;
                    break;
                }
                w.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", new Object[]{leVar.fRQ.fRS});
                leVar.fRR.fFj = false;
                break;
        }
        return false;
    }
}
