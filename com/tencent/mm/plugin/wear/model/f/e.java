package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bnj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.u.m;
import java.io.IOException;

public final class e extends c {
    protected final void send() {
        int size = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().aKd().size();
        bnj com_tencent_mm_protocal_c_bnj = new bnj();
        com_tencent_mm_protocal_c_bnj.mvT = a.bvG().rTq.IC(m.xL()).id;
        com_tencent_mm_protocal_c_bnj.fDC = ab.getContext().getString(R.l.bpJ);
        com_tencent_mm_protocal_c_bnj.opI = ab.getContext().getString(R.l.eDS, new Object[]{Integer.valueOf(size)});
        try {
            a.bvG();
            r.a(20005, com_tencent_mm_protocal_c_bnj.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
