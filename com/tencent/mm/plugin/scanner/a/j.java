package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.e.a.le;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class j extends c<le> {
    public j() {
        this.usg = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        le leVar = (le) bVar;
        switch (leVar.fRQ.opType) {
            case 0:
                a bA = i.bA(leVar.fRQ.fRS, 0);
                if (bA != null) {
                    leVar.fRR.fRT = i.a(leVar.fRQ.context, bA);
                    leVar.fRR.fKz = com.tencent.mm.plugin.scanner.c.aXW().dl(bA.field_thumburl, "@S");
                    leVar.fRR.fFj = true;
                    break;
                }
                w.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", new Object[]{leVar.fRQ.fRS});
                leVar.fRR.fFj = false;
                break;
        }
        return false;
    }
}
