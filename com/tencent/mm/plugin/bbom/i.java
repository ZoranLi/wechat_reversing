package com.tencent.mm.plugin.bbom;

import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;

public final class i implements f, k {
    public final void a(alq com_tencent_mm_protocal_c_alq, au auVar) {
        if (e.dr(auVar.field_talker)) {
            com_tencent_mm_protocal_c_alq.tfi = auVar.gxF;
            if (bg.mA(com_tencent_mm_protocal_c_alq.tfi)) {
                com_tencent_mm_protocal_c_alq.tfi = com.tencent.mm.modelbiz.a.e.iw(auVar.gxF);
                return;
            }
            return;
        }
        com_tencent_mm_protocal_c_alq.tfi = auVar.gxF;
    }

    public final String s(au auVar) {
        if (e.dr(auVar.field_talker)) {
            return com.tencent.mm.modelbiz.a.e.zz();
        }
        return null;
    }
}
