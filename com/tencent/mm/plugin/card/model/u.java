package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class u extends k implements j {
    private final b gUA;
    private e gUD;

    public u(float f, float f2, String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new auz();
        aVar.hsn = new ava();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        aVar.hsl = 1253;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        auz com_tencent_mm_protocal_c_auz = (auz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_auz.latitude = (double) f;
        com_tencent_mm_protocal_c_auz.longitude = (double) f2;
        com_tencent_mm_protocal_c_auz.fVl = str;
        com_tencent_mm_protocal_c_auz.kdE = str2;
        com_tencent_mm_protocal_c_auz.tYy = i;
    }

    public final int getType() {
        return 1253;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
