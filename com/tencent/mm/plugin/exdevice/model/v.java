package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class v extends k implements j {
    public b gUA = null;
    private e gUD = null;

    public v(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new axi();
        aVar.hsn = new axj();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.hsl = 1270;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        axi com_tencent_mm_protocal_c_axi = (axi) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_axi.tjo = new aen();
        com_tencent_mm_protocal_c_axi.tjo.thD = str;
        com_tencent_mm_protocal_c_axi.tjo.jNm = str2;
        com_tencent_mm_protocal_c_axi.tZW = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1270;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
