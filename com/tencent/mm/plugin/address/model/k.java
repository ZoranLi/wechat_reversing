package com.tencent.mm.plugin.address.model;

import com.tencent.mm.e.a.ln;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;

public final class k extends c<ln> implements e {
    private ln ite;
    private BizInfo itf;

    public k() {
        this.usg = ln.class.getName().hashCode();
    }

    private boolean a(ln lnVar) {
        if (lnVar instanceof ln) {
            this.ite = lnVar;
            ap.vd().a(417, this);
            ap.vd().a(new e(this.ite.fSw.url, this.ite.fSw.appId, 1), 0);
        }
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof e)) {
            return;
        }
        if (i2 == 0) {
            y(i2, true);
        } else {
            y(i2, false);
        }
    }

    private void y(int i, boolean z) {
        w.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        this.ite.fSx.errCode = i;
        if (i != 0) {
            this.ite.fSx.fSy = false;
        } else if (z) {
            r0 = this.itf;
            if (r0 != null) {
                r0.field_brandFlag |= 8;
                com.tencent.mm.modelbiz.e.g(r0);
            }
            this.ite.fSx.fSy = true;
            a.OR();
            com.tencent.mm.plugin.address.d.a aVar = a.OT().iti;
            if (aVar.itq.size() > 0) {
                b bVar = (b) aVar.itq.getFirst();
                this.ite.fSx.fSz = bVar.itz;
                this.ite.fSx.userName = bVar.itx;
                this.ite.fSx.fSA = bVar.ity;
                this.ite.fSx.fSB = bVar.itv;
                this.ite.fSx.fSC = bVar.its;
                this.ite.fSx.fSD = bVar.itt;
                this.ite.fSx.fSE = bVar.itu;
                this.ite.fSx.fSF = bVar.itw;
            }
        } else {
            r0 = this.itf;
            if (r0 != null) {
                r0.field_brandFlag &= -9;
                com.tencent.mm.modelbiz.e.g(r0);
            }
            this.ite.fSx.fSy = false;
        }
        if (this.ite.nFq != null) {
            this.ite.nFq.run();
        }
        ap.vd().b(417, this);
    }
}
