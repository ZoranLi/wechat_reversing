package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.y.a;

public final class b extends a<arc> {
    public b(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new arb();
        aVar.hsn = new arc();
        aVar.hsl = 1324;
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.y.b BE = aVar.BE();
        ((arb) BE.hsj.hsr).tVy = i;
        this.gUA = BE;
    }
}
