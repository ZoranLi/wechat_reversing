package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ay;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private e gUD;
    private com.tencent.mm.y.b hKp;

    public b(String str) {
        a aVar = new a();
        aVar.hsl = 976;
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.hsm = new bon();
        aVar.hsn = new boo();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        bon com_tencent_mm_protocal_c_bon = (bon) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_bon.mvU = str;
        com_tencent_mm_protocal_c_bon.tQw = com_tencent_mm_protocal_c_bon.ogM;
        com_tencent_mm_protocal_c_bon.ogM = (int) ay.gk(str);
        com_tencent_mm_protocal_c_bon.jOc = 63;
        com_tencent_mm_protocal_c_bon.und = 1;
        com_tencent_mm_protocal_c_bon.jNd = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 976;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }
}
