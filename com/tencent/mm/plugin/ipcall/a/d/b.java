package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA = null;
    private e gUD;
    private arn mPF = null;
    public aro mPG = null;

    public b(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hsm = new arn();
        aVar.hsn = new aro();
        aVar.hsl = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPF = (arn) this.gUA.hsj.hsr;
        this.mPF.tWa = str;
        this.mPF.tWc = str2;
        this.mPF.tWe = str3;
        this.mPF.tWd = str4;
        this.mPF.tWf = i;
        w.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[]{str, str2, str3, str4, Integer.valueOf(i)});
    }

    public final int getType() {
        return 807;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPG = (aro) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
