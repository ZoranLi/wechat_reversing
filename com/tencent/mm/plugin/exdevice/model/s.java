package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class s extends k implements j {
    private e gWW = null;
    private String lcq = null;
    private b ldE = null;

    public s(String str, String str2, String str3, int i) {
        a aVar = new a();
        aVar.hsm = new aeu();
        aVar.hsn = new aev();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.hsl = 1090;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldE = aVar.BE();
        aeu com_tencent_mm_protocal_c_aeu = (aeu) this.ldE.hsj.hsr;
        com_tencent_mm_protocal_c_aeu.tiD = com.tencent.mm.bd.b.NG(str2);
        com_tencent_mm_protocal_c_aeu.tiB = com.tencent.mm.bd.b.NG(str3);
        com_tencent_mm_protocal_c_aeu.mtF = i;
        this.lcq = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ad.apt().vj(this.lcq);
        if (i2 == 0 && i3 == 0) {
            en enVar = ((aev) this.ldE.hsk.hsr).tZe;
            int i4 = enVar.thX;
            if (enVar.tiE.tZs) {
                String str2 = enVar.tiE.tZr;
            }
            w.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + i4 + ",msg=" + str);
        }
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1090;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.ldE, this);
    }
}
