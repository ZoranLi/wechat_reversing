package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends d implements j {
    public final b gUA;
    private e gUD;
    public String lOH = "";
    public boolean lOI = false;

    public a() {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bcu();
        aVar.hsn = new bcv();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.hsl = 1586;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bcu com_tencent_mm_protocal_c_bcu = (bcu) this.gUA.hsj.hsr;
        c blU = com.tencent.mm.plugin.soter.c.b.blU();
        w.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[]{blU.qPZ, blU.qQa});
        com_tencent_mm_protocal_c_bcu.qPZ = r2;
        com_tencent_mm_protocal_c_bcu.qQa = r1;
        com_tencent_mm_protocal_c_bcu.scene = 0;
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            boolean z;
            bcv com_tencent_mm_protocal_c_bcv = (bcv) ((b) pVar).hsk.hsr;
            this.lOH = com_tencent_mm_protocal_c_bcv.lOH;
            q.rHB.lOH = this.lOH;
            this.lOI = 1 == com_tencent_mm_protocal_c_bcv.udK;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == com_tencent_mm_protocal_c_bcv.udK) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.d(str2, str3, objArr);
            q.rHB.lOI = this.lOI;
            w.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[]{this.lOH, Boolean.valueOf(this.lOI)});
        }
        this.gUD.a(i, i2, str, this);
    }

    public final void avA() {
        w.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }

    public final void bY(int i, int i2) {
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }
}
