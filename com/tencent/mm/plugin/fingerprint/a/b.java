package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.bn;
import com.tencent.mm.e.a.bn.a;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends c<bn> implements e {
    private bn lNY;
    private boolean lNZ;

    public b() {
        this.lNZ = false;
        this.usg = bn.class.getName().hashCode();
    }

    private boolean a(bn bnVar) {
        if (ap.zb()) {
            this.lNZ = false;
            if (!(bnVar instanceof bn)) {
                return false;
            }
            this.lNY = bnVar;
            w.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            ap.vd().a(385, this);
            ap.vd().a(new d(), 0);
            return true;
        }
        w.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            a aVar = new a();
            w.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                aVar.fEX = 0;
            } else {
                w.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                aVar.fEX = i2;
            }
            ap.vd().b(385, this);
            this.lNY.fEW = aVar;
            this.lNZ = true;
            if (this.lNY.nFq != null) {
                this.lNY.nFq.run();
            }
            if (this.lNZ) {
                this.lNY = null;
            }
        }
    }
}
