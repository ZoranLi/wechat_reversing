package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private final b gUA;
    private e gUD = null;

    public c(axy com_tencent_mm_protocal_c_axy) {
        a aVar = new a();
        aVar.hsm = com_tencent_mm_protocal_c_axy;
        aVar.hsn = new axz();
        aVar.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        aVar.hsl = 433;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 433;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
