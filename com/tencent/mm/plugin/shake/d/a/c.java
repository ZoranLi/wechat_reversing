package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private b gUA;
    private e gUD;

    public c(int i, String str) {
        a aVar = new a();
        aVar.hsm = new aom();
        aVar.hsn = new aon();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        aVar.hsl = 1740;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aom com_tencent_mm_protocal_c_aom = (aom) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aom.mtF = i;
        com_tencent_mm_protocal_c_aom.tTC = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
