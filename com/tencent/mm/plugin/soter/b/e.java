package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgu;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;

public final class e extends k implements com.tencent.d.b.e.e, j {
    private b gUA;
    private com.tencent.mm.y.e gUD;
    private com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> lOJ = null;

    public final /* synthetic */ void aS(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hsm = new bgu();
        aVar2.hsn = new bgv();
        aVar2.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar2.hsl = 619;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        bgu com_tencent_mm_protocal_c_bgu = (bgu) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgu.tdM = 619;
        com_tencent_mm_protocal_c_bgu.ugF = aVar.xae;
        com_tencent_mm_protocal_c_bgu.ugG = aVar.xad;
        w.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", new Object[]{aVar.xad, aVar.xae});
        w.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", new Object[]{Integer.valueOf(hashCode())});
    }

    public final int getType() {
        return 619;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.lOJ != null) {
                this.lOJ.bV(new com.tencent.d.b.e.e.b(true));
                return;
            }
            return;
        }
        w.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.lOJ != null) {
            this.lOJ.bV(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void a(com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> bVar) {
        this.lOJ = bVar;
    }

    public final void execute() {
        w.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        h.vd().a(this, 0);
    }
}
