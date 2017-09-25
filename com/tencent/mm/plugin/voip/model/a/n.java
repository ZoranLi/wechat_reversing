package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.voip.model.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class n<REQ, RESP> extends k implements j {
    protected b gUA;
    public e gUD;
    private e lTU;
    protected com.tencent.mm.plugin.voip.model.e rgj = f.bpu();

    public abstract e bqA();

    public final void a(int i, final int i2, final int i3, final String str, p pVar, byte[] bArr) {
        dl(i2, i3);
        if (this.lTU != null) {
            this.lTU.a(i2, i3, str, this);
        }
        if (this.gUD != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ n rjE;

                public final void run() {
                    if (this.rjE.gUD != null) {
                        this.rjE.gUD.a(i2, i3, str, this.rjE);
                    }
                }
            });
        }
    }

    public int bqB() {
        return 0;
    }

    public void dl(int i, int i2) {
    }

    public final void bqD() {
        w.d("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ap.vd().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int bqB = bqB();
        if (bqB != 0) {
            return bqB;
        }
        this.lTU = eVar2;
        this.gUD = bqA();
        return a(eVar, this.gUA, this);
    }

    public final <RESP> RESP bqE() {
        return this.gUA.hsk.hsr;
    }

    public final <REQ> REQ bqF() {
        return this.gUA.hsj.hsr;
    }
}
