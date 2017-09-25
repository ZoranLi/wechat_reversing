package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.e.a.si;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class ah implements e {
    boolean nnZ;
    public ae noa;
    public ab nob;
    private u noc;
    public c nod = new c<si>(this) {
        final /* synthetic */ ah noe;

        {
            this.noe = r2;
            this.usg = si.class.getName().hashCode();
        }

        private boolean a(si siVar) {
            if (siVar instanceof si) {
                switch (siVar.fZQ.action) {
                    case 1:
                        ah ahVar = this.noe;
                        long j = siVar.fZQ.fEU;
                        if (!ahVar.nnZ) {
                            ahVar.nnZ = true;
                            ap.yY();
                            ce cA = com.tencent.mm.u.c.wT().cA(j);
                            String str = cA.field_content;
                            a B = str != null ? a.B(str, cA.field_reserved) : null;
                            if (B != null) {
                                String mz = bg.mz(B.hiW);
                                Uri parse = Uri.parse(mz);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = bg.getInt(parse.getQueryParameter("channelid"), 1);
                                if (ahVar.noa != null) {
                                    ap.vd().c(ahVar.noa);
                                    ahVar.noa = null;
                                }
                                ap.vd().a(1581, ahVar);
                                ahVar.noa = new ae(i, queryParameter, mz, 3, "v1.0");
                                ahVar.noa.fJL = cA.field_talker;
                                ahVar.noa.fGM = j;
                                ap.vd().a(ahVar.noa, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            return false;
        }
    };

    public ah() {
        com.tencent.mm.sdk.b.a.urY.b(this.nod);
    }

    public final void a(int i, int i2, String str, k kVar) {
        ap.vd().b(1581, this);
        ap.vd().b(1685, this);
        ap.vd().b(1585, this);
        if (kVar instanceof ae) {
            ae aeVar = (ae) kVar;
            if (i != 0 || i2 != 0) {
                this.nnZ = false;
                cy(aeVar.fGM);
            } else if (aeVar.fZG == 4) {
                if (this.noc != null) {
                    ap.vd().c(this.noc);
                    this.noc = null;
                }
                ap.vd().a(1585, this);
                this.noc = new u(aeVar.njw, 11, 0, aeVar.fZF, "v1.0");
                this.noc.fJL = aeVar.fJL;
                this.noc.fGM = aeVar.fGM;
                ap.vd().a(this.noc, 0);
                w.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
            } else if (aeVar.fZH == 1 || aeVar.fZG == 5 || aeVar.fZG == 1) {
                this.nnZ = false;
                w.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                cy(aeVar.fGM);
            } else {
                if (this.nob != null) {
                    ap.vd().c(this.nob);
                    this.nob = null;
                }
                ap.vd().a(1685, this);
                this.nob = new ab(aeVar.msgType, aeVar.fuV, aeVar.njw, aeVar.fZF, n.aHX(), m.xN(), aeVar.fJL, "v1.0", aeVar.nnW);
                this.nob.fGM = aeVar.fGM;
                ap.vd().a(this.nob, 0);
                w.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
            }
        } else if (kVar instanceof ab) {
            this.nnZ = false;
            ab abVar = (ab) kVar;
            if (i == 0 && i2 == 0) {
                e eVar = abVar.nnk;
                if (eVar.fZH == 2) {
                    a(eVar, abVar.fGM, abVar.fJL);
                    return;
                } else {
                    cy(abVar.fGM);
                    return;
                }
            }
            cy(abVar.fGM);
        } else if (kVar instanceof u) {
            this.nnZ = false;
            u uVar = (u) kVar;
            if (i == 0 && i2 == 0) {
                a(uVar.nnk, uVar.fGM, uVar.fJL);
            } else {
                cy(uVar.fGM);
            }
        }
    }

    private static void cy(long j) {
        b siVar = new si();
        siVar.fZQ.action = 2;
        siVar.fZR.fEU = j;
        siVar.fZR.fZT = 0;
        siVar.fZR.fZU = "";
        com.tencent.mm.sdk.b.a.urY.a(siVar, Looper.getMainLooper());
    }

    private static void a(e eVar, long j, String str) {
        b siVar = new si();
        siVar.fZQ.action = 2;
        siVar.fZR.fEU = j;
        siVar.fZR.fZT = eVar.fZT;
        siVar.fZR.fZU = eVar.nmt;
        siVar.fZR.fZV = new ArrayList();
        if (o.dH(str)) {
            Iterator it = eVar.nmB.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                siVar.fZR.fZV.add(n.Bz().hi(mVar.nmY) + "=" + mVar.nmX + "=" + mVar.nmK);
            }
        }
        com.tencent.mm.sdk.b.a.urY.a(siVar, Looper.getMainLooper());
    }
}
