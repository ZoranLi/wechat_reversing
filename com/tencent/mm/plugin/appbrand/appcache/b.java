package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.y.a;

public final class b extends a<adp> {
    final String appId;
    public final com.tencent.mm.y.b gUA;
    final String iyA;
    final int version;

    public b(String str, int i, String str2, int i2) {
        this.appId = str;
        this.version = i;
        this.iyA = str2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1139;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ado = new ado();
        com_tencent_mm_protocal_c_ado.tlJ = i;
        com_tencent_mm_protocal_c_ado.fTO = str;
        com_tencent_mm_protocal_c_ado.tIZ = str2;
        com_tencent_mm_protocal_c_ado.tJa = i2;
        aVar.hsm = com_tencent_mm_protocal_c_ado;
        aVar.hsn = new adp();
        com.tencent.mm.y.b BE = aVar.BE();
        this.gUA = BE;
        this.gUA = BE;
    }
}
