package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bnn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.x.b;
import java.io.IOException;

public final class f extends c {
    private String fFa;
    private int type;
    private String username;

    public f(String str, String str2, int i) {
        this.username = str;
        this.fFa = str2;
        this.type = i;
    }

    protected final void send() {
        com.tencent.mm.plugin.wear.model.f IC = a.bvG().rTq.IC(this.username);
        bnn com_tencent_mm_protocal_c_bnn = new bnn();
        if (this.type == 1) {
            bnm com_tencent_mm_protocal_c_bnm = new bnm();
            com_tencent_mm_protocal_c_bnm.mvT = IC.id;
            com_tencent_mm_protocal_c_bnm.jNj = this.username;
            com_tencent_mm_protocal_c_bnm.jOp = this.fFa;
            com_tencent_mm_protocal_c_bnm.opI = ab.getContext().getString(R.l.eEu);
            Bitmap a = b.a(this.username, false, -1);
            if (a != null) {
                com_tencent_mm_protocal_c_bnm.umz = new com.tencent.mm.bd.b(h.G(a));
            }
            com_tencent_mm_protocal_c_bnn.jNe.add(com_tencent_mm_protocal_c_bnm);
        }
        try {
            a.bvG();
            r.a(20006, com_tencent_mm_protocal_c_bnn.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }
}
