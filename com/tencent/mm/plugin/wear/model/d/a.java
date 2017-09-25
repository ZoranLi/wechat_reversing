package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public String fGl;
    public String fwJ;
    private e gUD;
    private b hKp;

    public a(String str, String str2) {
        this.fwJ = str;
        this.fGl = str2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1091;
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.hsm = new aes();
        aVar.hsn = new aet();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        aes com_tencent_mm_protocal_c_aes = (aes) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_aes.tiB = new com.tencent.mm.bd.b(str.getBytes());
        com_tencent_mm_protocal_c_aes.tiD = new com.tencent.mm.bd.b(str2.getBytes());
        com_tencent_mm_protocal_c_aes.tJX = new com.tencent.mm.bd.b("5".getBytes());
    }

    public final int getType() {
        return 1091;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }
}
