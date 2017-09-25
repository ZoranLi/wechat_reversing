package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class bb extends k implements j {
    private e gUD;
    private final a hnr;
    private final String hns;
    private long hnt;

    public interface a {
        void a(com.tencent.mm.network.e eVar);
    }

    public bb(a aVar) {
        this(aVar, null);
    }

    public bb(a aVar, String str) {
        w.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, bg.bJZ());
        this.hnr = aVar;
        this.hns = str;
    }

    public final int getType() {
        return 0;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        c(eVar);
        this.gUD = eVar2;
        this.hnt = bg.NA();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ bb hnu;

            {
                this.hnu = r1;
            }

            public final void run() {
                this.hnu.a(0, 0, 0, null, null, null);
            }

            public final String toString() {
                return super.toString() + "|doScene";
            }
        });
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.hnr != null) {
            w.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.hns, Long.valueOf(bg.aB(this.hnt)));
            this.hnr.a(this.hsD);
        }
        this.gUD.a(0, 0, null, this);
    }
}
