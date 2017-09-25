package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.aaf;
import com.tencent.mm.y.b.a;

public final class i extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new aae();
        aVar.hsn = new aaf();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.hsl = 1709;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        awJ();
        aae com_tencent_mm_protocal_c_aae = (aae) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aae.fEN = str;
        com_tencent_mm_protocal_c_aae.lTm = str2;
        com_tencent_mm_protocal_c_aae.lTn = str3;
        com_tencent_mm_protocal_c_aae.lTo = str4;
        com_tencent_mm_protocal_c_aae.fGV = str5;
        com_tencent_mm_protocal_c_aae.tch = str6;
    }

    public final String awU() {
        return ((aaf) this.gUA.hsk.hsr).lUu;
    }

    public final String awV() {
        return ((aaf) this.gUA.hsk.hsr).lUv;
    }
}
