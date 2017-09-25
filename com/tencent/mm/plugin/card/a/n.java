package com.tencent.mm.plugin.card.a;

import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends c<hq> implements e {
    private long fEU;

    public n() {
        this.fEU = 0;
        this.usg = hq.class.getName().hashCode();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof af) {
            String str2 = ((af) kVar).fVm;
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(this.fEU);
            if (i == 0 && i2 == 0) {
                cA.dv(2);
            } else {
                cA.dv(5);
            }
            a ek = a.ek(cA.field_content);
            d sV = g.sV(cA.field_content);
            sV.fVm = str2;
            ek.hiy = g.a(sV);
            ek.fNg = a.a(ek, null, null);
            cA.setContent(a.a(ek, null, null));
            ap.yY();
            com.tencent.mm.u.c.wT().a(this.fEU, cA);
            ap.vd().b(652, this);
        }
    }

    private boolean a(hq hqVar) {
        if (!(hqVar instanceof hq)) {
            return false;
        }
        String str = hqVar.fNf.fNg;
        this.fEU = hqVar.fNf.fEU;
        String str2 = hqVar.fNf.fNh;
        d sV = g.sV(str);
        ap.yY();
        ce cA = com.tencent.mm.u.c.wT().cA(this.fEU);
        cA.dv(1);
        ap.yY();
        com.tencent.mm.u.c.wT().a(this.fEU, cA);
        if (sV == null) {
            sV = g.sV(cA.field_content);
        }
        if (sV == null) {
            return true;
        }
        ap.vd().a(652, this);
        ap.vd().a(new af(sV.fVl, str2, 17), 0);
        return true;
    }
}
