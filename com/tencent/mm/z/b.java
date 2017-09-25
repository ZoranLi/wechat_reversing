package com.tencent.mm.z;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new bgb();
        aVar.hsn = new bgc();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        this.gUA = aVar.BE();
        ((bgb) this.gUA.hsj.hsr).tuo = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 253;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
