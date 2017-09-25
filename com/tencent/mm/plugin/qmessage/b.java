package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.e.a.lh;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;

public final class b extends c<lh> {
    public b() {
        this.usg = lh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lh lhVar = (lh) bVar;
        switch (lhVar.fSb.opType) {
            case 0:
                String str = lhVar.fSb.fSd;
                String str2 = lhVar.fSb.fSe;
                ap.yY();
                a Rc = com.tencent.mm.u.c.wR().Rc(str);
                if (Rc == null || ((int) Rc.gTQ) == 0) {
                    af xVar = new x(str);
                    xVar.ti();
                    xVar.bR(str2);
                    xVar.dl(4);
                    ap.yY();
                    com.tencent.mm.u.c.wR().R(xVar);
                    com.tencent.mm.x.b.hc(xVar.field_username);
                }
                d CJ = g.aUe().CJ(str);
                if (CJ == null || bg.mz(CJ.getUsername()).length() <= 0) {
                    CJ = new d();
                    CJ.fRW = -1;
                    CJ.oyB = 1;
                    CJ.username = str;
                    CJ.oyC = 0;
                    CJ.oyD = 0;
                    if (!g.aUe().a(CJ)) {
                        w.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                lhVar.fSc.fFj = true;
                break;
            case 1:
                d CJ2 = g.aUe().CJ(lhVar.fSb.fSf);
                if (CJ2 != null && bg.mz(CJ2.getUsername()).length() > 0) {
                    if (CJ2.oyC != ((long) lhVar.fSb.fSg) || CJ2.oyD != ((long) lhVar.fSb.fSh)) {
                        CJ2.oyB = 1;
                        CJ2.username = lhVar.fSb.fSf;
                        CJ2.oyC = (long) lhVar.fSb.fSg;
                        CJ2.oyD = (long) lhVar.fSb.fSh;
                        CJ2.fRW = 56;
                        if (!g.aUe().a(CJ2.getUsername(), CJ2)) {
                            w.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        lhVar.fSc.fFj = true;
                        break;
                    }
                    lhVar.fSc.fFj = true;
                    break;
                }
                CJ2 = new d();
                CJ2.fRW = -1;
                CJ2.oyB = 1;
                CJ2.username = lhVar.fSb.fSf;
                CJ2.oyC = (long) lhVar.fSb.fSg;
                CJ2.oyD = (long) lhVar.fSb.fSh;
                if (!g.aUe().a(CJ2)) {
                    w.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                lhVar.fSc.fFj = true;
                break;
                break;
            case 2:
                g.aUf();
                break;
        }
        return false;
    }
}
