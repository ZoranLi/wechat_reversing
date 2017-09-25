package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.aaa;
import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.y.b.a;

public final class h extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new aaa();
        aVar.hsn = new aab();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.hsl = 1760;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        awJ();
        aaa com_tencent_mm_protocal_c_aaa = (aaa) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aaa.appId = str;
        com_tencent_mm_protocal_c_aaa.lXo = i;
        com_tencent_mm_protocal_c_aaa.fGV = str2;
    }

    public final sr awN() {
        aab com_tencent_mm_protocal_c_aab = (aab) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_aab != null) {
            return com_tencent_mm_protocal_c_aab.tcs;
        }
        return null;
    }
}
