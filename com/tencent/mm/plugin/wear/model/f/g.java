package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.o;
import java.io.IOException;

public final class g extends b {
    private au fTk;

    public g(au auVar) {
        this.fTk = auVar;
    }

    protected final void send() {
        bnr com_tencent_mm_protocal_c_bnr = new bnr();
        String str = this.fTk.field_content;
        if (str != null) {
            a B = a.B(str, this.fTk.field_reserved);
            if (B.hiW.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                com_tencent_mm_protocal_c_bnr.umI = this.fTk.field_msgId;
                com_tencent_mm_protocal_c_bnr.umH = this.fTk.field_talker;
                str = this.fTk.field_isSend == 1 ? B.hiQ : B.hiP;
                com_tencent_mm_protocal_c_bnr.fDC = h.IH(this.fTk.field_talker);
                if (o.dH(this.fTk.field_talker)) {
                    String d = b.d(this.fTk.field_talker, this.fTk);
                    com_tencent_mm_protocal_c_bnr.opI = String.format(ab.getContext().getString(R.l.eEo), new Object[]{h.IH(d), Character.valueOf('​'), str});
                } else {
                    com_tencent_mm_protocal_c_bnr.opI = str;
                }
                try {
                    com.tencent.mm.plugin.wear.model.a.bvG();
                    r.a(20014, com_tencent_mm_protocal_c_bnr.toByteArray(), true);
                    com.tencent.mm.plugin.wear.model.c.a.dv(10, 0);
                    com.tencent.mm.plugin.wear.model.c.a.vJ(10);
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            w.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
            return;
        }
        w.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
