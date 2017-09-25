package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.at;
import com.tencent.mm.u.at.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class g extends k implements j {
    public e gUD;
    private final p htt = new a();
    String rci = "";
    int rcj = 0;
    private String rck = "";

    public g(String str) {
        a aVar = (a) this.htt.BG();
        w.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(73), str});
        aVar.hmt.tIp = 73;
        aVar.hmt.tIq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 616;
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        at.b bVar = (at.b) pVar.zg();
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ g rcu;

                public final void run() {
                    new m().a(this.rcu.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 rcv;

                        {
                            this.rcv = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.rcv.rcu.a(this.rcv.rcu.hsD, this.rcv.rcu.gUD);
                            } else {
                                this.rcv.rcu.gUD.a(i, i2, "", this.rcv.rcu);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            if (bVar.hmu.tIr != null) {
                this.rci = new String(bVar.hmu.tIr.tYV.tZp.sYA);
                this.rcj = bVar.hmu.tIr.tYm;
                w.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[]{Integer.valueOf(this.rcj), this.rck, this.rci});
            } else {
                w.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
