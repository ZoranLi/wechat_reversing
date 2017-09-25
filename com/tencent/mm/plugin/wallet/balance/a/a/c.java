package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class c extends a<asf> {
    public c(String str, int i) {
        b.a aVar = new b.a();
        aVar.hsm = new ase();
        aVar.hsn = new asf();
        aVar.hsl = 1276;
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        ase com_tencent_mm_protocal_c_ase = (ase) BE.hsj.hsr;
        com_tencent_mm_protocal_c_ase.tWB = str;
        com_tencent_mm_protocal_c_ase.tWC = i;
        this.gUA = BE;
    }
}
