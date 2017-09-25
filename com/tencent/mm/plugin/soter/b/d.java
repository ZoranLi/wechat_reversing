package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public abstract class d extends k implements j {
    private g qPS;

    private class a implements a {
        final /* synthetic */ d qPT;

        public a(d dVar) {
            this.qPT = dVar;
        }

        public final void blP() {
            this.qPT.avA();
        }

        public final void uq(int i) {
            this.qPT.bY(3, i);
        }
    }

    public abstract void avA();

    public abstract void bY(int i, int i2);

    public abstract void c(int i, int i2, String str, p pVar);

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        boolean z = true;
        w.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.qPS = new g(new a(this));
        this.qPS.qPV = -3202;
        g gVar = this.qPS;
        if (i2 == 4 && i3 == -3200) {
            com.tencent.d.b.a.a(new b<c>(gVar) {
                final /* synthetic */ g qPW;

                {
                    this.qPW = r1;
                }

                public final /* synthetic */ void a(e eVar) {
                    c cVar = (c) eVar;
                    w.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
                    if (!cVar.isSuccess()) {
                        a.dj(1, cVar.errCode);
                        if (this.qPW.qPU != null) {
                            this.qPW.qPU.uq(cVar.errCode);
                        }
                    } else if (this.qPW.qPU != null) {
                        this.qPW.qPU.blP();
                    }
                }
            }, true, new e());
        } else if (i2 != 4 || i3 != gVar.qPV) {
            z = false;
        } else if (gVar.qPU != null) {
            gVar.qPU.blP();
        }
        if (!z) {
            c(i2, i3, str, pVar);
        }
    }
}
