package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.ayg;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ad extends k implements j {
    private final b gUA;
    private e gUD;

    public ad(String str) {
        a aVar = new a();
        aVar.hsm = new ayg();
        aVar.hsn = new ayh();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        aVar.hsl = 108;
        aVar.hso = 43;
        aVar.hsp = 1000000043;
        this.gUA = aVar.BE();
        ((ayg) this.gUA.hsj.hsr).ttp = new avx().OV(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 108;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
