package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private ArrayList<Integer> rUI;
    private boolean sS = true;

    public i(ArrayList<Integer> arrayList) {
        this.rUI = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    protected final void send() {
        w.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[]{this.rUI});
        bnz com_tencent_mm_protocal_c_bnz = new bnz();
        if (this.rUI != null) {
            com_tencent_mm_protocal_c_bnz.umR.addAll(this.rUI);
        }
        com_tencent_mm_protocal_c_bnz.umS = this.sS;
        try {
            a.bvG();
            r.a(20004, com_tencent_mm_protocal_c_bnz.toByteArray(), false);
        } catch (IOException e) {
        }
    }
}
