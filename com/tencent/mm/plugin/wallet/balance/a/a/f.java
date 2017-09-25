package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class f extends a<aui> {
    public f(int i, String str, String str2) {
        b.a aVar = new b.a();
        aVar.hsm = new auh();
        aVar.hsn = new aui();
        aVar.hsl = 1338;
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        auh com_tencent_mm_protocal_c_auh = (auh) BE.hsj.hsr;
        com_tencent_mm_protocal_c_auh.tVy = i;
        com_tencent_mm_protocal_c_auh.trZ = str;
        com_tencent_mm_protocal_c_auh.tVz = str2;
        this.gUA = BE;
    }
}
