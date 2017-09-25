package com.tencent.mm.pluginsdk.a;

import android.os.Bundle;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Iterator;

public final class a {
    public static com.tencent.mm.modelsimple.u.a a(u uVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        return a(uVar, bundle);
    }

    private static com.tencent.mm.modelsimple.u.a a(u uVar, Bundle bundle) {
        if (uVar == null) {
            return null;
        }
        if (((e) uVar.htt.zg()).sZm.ugy == null) {
            return null;
        }
        bad com_tencent_mm_protocal_c_bad = ((e) uVar.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            com.tencent.mm.modelsimple.u.a aVar = new com.tencent.mm.modelsimple.u.a();
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 19) {
                    aVar.fGV = com_tencent_mm_protocal_c_bdv.ufb;
                } else if (com_tencent_mm_protocal_c_bdv.oTD == 20) {
                    aVar.hSD = com_tencent_mm_protocal_c_bdv.ufb;
                } else if (com_tencent_mm_protocal_c_bdv.oTD == 21) {
                    aVar.fNG = com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
            aVar.hSE = bundle;
            aVar.type = 0;
            if (!bg.mA(aVar.fGV)) {
                aVar.username = ((d) uVar.htt.BG()).sZj.tOB.jNj;
                return aVar;
            }
        }
        return null;
    }
}
