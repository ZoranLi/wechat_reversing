package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public int fJA;
    private e gUD;
    private final b hKp;

    public a(int i) {
        this.fJA = i;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a qfVar = new qf();
        com.tencent.mm.bd.a qgVar = new qg();
        aVar.hsm = qfVar;
        aVar.hsn = qgVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        aVar.hsl = 792;
        aVar.hso = 0;
        aVar.hsp = 0;
        qfVar.mtF = i;
        qfVar.tvW = 1;
        this.hKp = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 792;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }
}
