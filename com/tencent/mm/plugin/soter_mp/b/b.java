package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends d implements e, j {
    private com.tencent.mm.y.b gUA;
    private com.tencent.mm.y.e gUD;
    private com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> lOJ = null;

    public final /* synthetic */ void aS(Object obj) {
        a aVar = (a) obj;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new bhz();
        aVar2.hsn = new bia();
        aVar2.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar2.hsl = 1185;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        bhz com_tencent_mm_protocal_c_bhz = (bhz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhz.uhv = aVar.xad;
        com_tencent_mm_protocal_c_bhz.uhw = aVar.xae;
    }

    public final int getType() {
        return 1185;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.gUD != null) {
            this.gUD.a(i, i2, str, this);
        }
        if (this.lOJ == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.lOJ.bV(new com.tencent.d.b.e.e.b(true));
        } else {
            this.lOJ.bV(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void avA() {
        w.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
        if (this.lOJ != null) {
            this.lOJ.bV(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void bY(int i, int i2) {
        w.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }

    public final void execute() {
        h.vd().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> bVar) {
        this.lOJ = bVar;
    }
}
