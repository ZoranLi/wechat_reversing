package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.y.b.a;

public final class l extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new aza();
        aVar.hsn = new azb();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.hsl = 1761;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1761;
    }

    public l(String str, int i, String str2) {
        awJ();
        aza com_tencent_mm_protocal_c_aza = (aza) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aza.appId = str;
        com_tencent_mm_protocal_c_aza.lXo = i;
        com_tencent_mm_protocal_c_aza.fGV = str2;
    }
}
