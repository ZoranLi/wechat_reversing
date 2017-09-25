package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private b gUA;
    private e gUD;
    public int opType;

    public g(int i, String str) {
        this.opType = i;
        a aVar = new a();
        aVar.hsm = new qz();
        aVar.hsn = new ra();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.gUA = aVar.BE();
        qz qzVar = (qz) this.gUA.hsj.hsr;
        if (bg.mA(str)) {
            str = "";
        }
        qzVar.twB = str;
        qzVar.mtF = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ra raVar = (ra) this.gUA.hsk.hsr;
            int i4 = raVar.tZe.thX;
            if (i4 != 0) {
                w.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + i4);
                this.gUD.a(4, i4, str, this);
                return;
            }
            w.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + raVar.twD + ", fbusername = " + raVar.twE);
            if (this.opType == 0 || this.opType == 1) {
                ap.yY();
                c.vr().set(65825, raVar.twD);
                com.tencent.mm.x.b.gY(raVar.twD);
                ap.yY();
                c.vr().set(65826, raVar.twE);
                ap.yY();
                c.vr().jY(true);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
