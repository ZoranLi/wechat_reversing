package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class d extends a<aso> {
    public d(String str, String str2, int i) {
        b.a aVar = new b.a();
        aVar.hsm = new asn();
        aVar.hsn = new aso();
        aVar.hsl = 1283;
        aVar.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        asn com_tencent_mm_protocal_c_asn = (asn) BE.hsj.hsr;
        com_tencent_mm_protocal_c_asn.tWT = str;
        com_tencent_mm_protocal_c_asn.oQK = str2;
        com_tencent_mm_protocal_c_asn.tWC = i;
        this.gUA = BE;
    }
}
