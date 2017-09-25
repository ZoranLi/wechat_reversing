package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class e extends a<asq> {
    private b inV;
    private asp rtC = null;

    public e() {
        b.a aVar = new b.a();
        aVar.hsm = new asp();
        aVar.hsn = new asq();
        aVar.hsl = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.rtC = (asp) this.inV.hsj.hsr;
        this.rtC.time_stamp = (int) System.currentTimeMillis();
        this.gUA = aVar.BE();
    }
}
