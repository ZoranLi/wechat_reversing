package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public String fQC;
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new yj();
        aVar.hsn = new yk();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        aVar.hsl = 1337;
        this.gUA = aVar.BE();
        yj yjVar = (yj) this.gUA.hsj.hsr;
        yjVar.mtb = str;
        yjVar.tEO = str2;
        yjVar.tEP = str3;
        w.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
    }

    public final int getType() {
        return 1337;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        yk ykVar = (yk) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        if (pVar.zg().sZC != 0) {
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.fQC = ykVar.tCd;
        this.gUD.a(i2, i3, str, this);
    }
}
