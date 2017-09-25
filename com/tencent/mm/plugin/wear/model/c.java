package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.pluginsdk.l.x.a;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bg;

public final class c implements a {
    public final String bvI() {
        bnp com_tencent_mm_protocal_c_bnp = a.bvG().rTo.rTF.rUt;
        if (com_tencent_mm_protocal_c_bnp != null) {
            return com_tencent_mm_protocal_c_bnp.umD + "\n" + com_tencent_mm_protocal_c_bnp.umE + "\n" + com_tencent_mm_protocal_c_bnp.umF;
        }
        return "Not Connect";
    }

    public final void bvJ() {
        a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.a());
    }

    public final boolean bvK() {
        String str = null;
        bnp com_tencent_mm_protocal_c_bnp = a.bvG().rTo.rTF.rUt;
        return (bg.mA(str) && bg.mA(str)) ? com_tencent_mm_protocal_c_bnp != null : bg.mA(str) ? com_tencent_mm_protocal_c_bnp != null && str.equals("gh_43f2581f6fd6") : bg.mA(str) ? com_tencent_mm_protocal_c_bnp != null && str.equals(com_tencent_mm_protocal_c_bnp.umA) : com_tencent_mm_protocal_c_bnp != null && str.equals("gh_43f2581f6fd6") && str.equals(com_tencent_mm_protocal_c_bnp.umA);
    }
}
