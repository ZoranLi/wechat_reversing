package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.hj;
import com.tencent.mm.e.a.nc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends c<hj> implements e {
    private int pyH;
    private bbk pyI;
    private m pyJ;
    private aj pyK;

    public d() {
        this.usg = hj.class.getName().hashCode();
    }

    private boolean a(hj hjVar) {
        if (hjVar instanceof hj) {
            this.pyH = hjVar.fMN.fII;
            this.pyJ = ae.beL().tH(this.pyH);
            this.pyI = ai.m(this.pyJ);
            if (this.pyI == null || ((this.pyI.tQZ != 3 || this.pyI.ucy == null || this.pyI.ucy.size() <= 0) && (this.pyI.tQZ != 5 || this.pyI.tPQ == null || this.pyI.tPQ.size() <= 0))) {
                k pVar = new p(this.pyJ.field_snsId);
                ((bbl) pVar.gUA.hsj.hsr).ucE = 1;
                h.vJ();
                h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
                h.vJ();
                h.vH().gXC.a(pVar, 0);
                this.pyK = new aj(new a(this) {
                    final /* synthetic */ d pyL;

                    {
                        this.pyL = r1;
                    }

                    public final boolean oQ() {
                        b ncVar = new nc();
                        ncVar.fUl.fMP = null;
                        com.tencent.mm.sdk.b.a.urY.m(ncVar);
                        return false;
                    }
                }, false);
                this.pyK.v(10000, 10000);
                return true;
            }
            hjVar.fMO.fMP = this.pyI;
            return true;
        }
        w.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pyK.KH();
        if (i == 0 && i2 == 0) {
            m dG = ae.beL().dG(this.pyJ.field_snsId);
            b ncVar = new nc();
            ncVar.fUl.fMP = ai.m(dG);
            com.tencent.mm.sdk.b.a.urY.m(ncVar);
            return;
        }
        b ncVar2 = new nc();
        ncVar2.fUl.fMP = null;
        com.tencent.mm.sdk.b.a.urY.m(ncVar2);
    }
}
