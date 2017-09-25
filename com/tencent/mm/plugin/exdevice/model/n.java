package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    public String fwJ = null;
    b gUA = null;
    private e gUD = null;
    public int ldC = 0;

    public n(afg com_tencent_mm_protocal_c_afg, String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new bfp();
        aVar.hsn = new bfq();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.hsl = 1717;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bfp com_tencent_mm_protocal_c_bfp = (bfp) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bfp.thD = str;
        com_tencent_mm_protocal_c_bfp.tst = str2;
        com_tencent_mm_protocal_c_bfp.ufZ = com_tencent_mm_protocal_c_afg;
        com_tencent_mm_protocal_c_bfp.uga = i;
        this.fwJ = str2;
        this.ldC = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
