package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.au;
import com.tencent.mm.u.au.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class e extends k implements j {
    public com.tencent.mm.y.e gUD;
    private int hsW = 2;
    private final p htt = new b();
    String kwg = "";

    public e(String str) {
        a aVar = (a) this.htt.BG();
        aVar.hmv.jNj = str;
        aVar.hmv.tIs = 1;
        w.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[]{Integer.valueOf(1), str});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 618;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        au.b bVar = (au.b) pVar.zg();
        this.kwg = bVar.hmw.tIt;
        w.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.kwg);
        if (i2 == 4 && i3 == -301) {
            aq.a(true, bVar.hmw.tjM, bVar.hmw.tjN, bVar.hmw.tjL);
            this.hsW--;
            if (this.hsW <= 0) {
                w.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.gUD.a(3, -1, "", this);
                return;
            }
            w.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            a(this.hsD, this.gUD);
        } else if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ e rcl;

                public final void run() {
                    new m().a(this.rcl.hsD, new com.tencent.mm.y.e(this) {
                        final /* synthetic */ AnonymousClass1 rcm;

                        {
                            this.rcm = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.rcm.rcl.a(this.rcm.rcl.hsD, this.rcm.rcl.gUD);
                            } else {
                                this.rcm.rcl.gUD.a(i, i2, "", this.rcm.rcl);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
