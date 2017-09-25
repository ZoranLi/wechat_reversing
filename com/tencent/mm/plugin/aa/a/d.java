package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d implements e {
    private static int ino = 20;
    private static int inp = 20;
    private static int inq = 20;
    private static long inr = 4000000;
    private static long ins = 200000;
    b ink;
    public String int = "";
    public String inu = "";

    private d(String str, String str2) {
        this.int = str;
        this.inu = str2;
    }

    public static int NO() {
        ap.yY();
        return ((Integer) c.vr().get(a.uEP, Integer.valueOf(ino))).intValue();
    }

    public static int NP() {
        ap.yY();
        return ((Integer) c.vr().get(a.uER, Integer.valueOf(inq))).intValue();
    }

    public static long NQ() {
        ap.yY();
        return ((Long) c.vr().get(a.uET, Long.valueOf(ins))).longValue();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            m mVar = ((h) kVar).iod;
            w.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(mVar.kAC), mVar.kAD, Integer.valueOf(mVar.tbv), Integer.valueOf(mVar.tbw), Integer.valueOf(mVar.tbx), Long.valueOf(mVar.tby), Long.valueOf(mVar.tbz), mVar.kAO, mVar.kAP});
            if (mVar.kAC == 0) {
                ap.yY();
                c.vr().a(a.uEP, Integer.valueOf(mVar.tbv));
                ap.yY();
                c.vr().a(a.uEQ, Integer.valueOf(mVar.tbw));
                ap.yY();
                c.vr().a(a.uER, Integer.valueOf(mVar.tbx));
                ap.yY();
                c.vr().a(a.uES, Long.valueOf(mVar.tby));
                ap.yY();
                c.vr().a(a.uET, Long.valueOf(mVar.tbz));
                g.oUh.a(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.ink, new Object[]{new d(mVar.kAP, mVar.kAO)});
                return;
            }
            com.tencent.mm.vending.g.g.cbB().bJ(Boolean.valueOf(false));
            g.oUh.a(407, 35, 1, false);
            return;
        }
        com.tencent.mm.vending.g.g.cbB().bJ(Boolean.valueOf(false));
        g.oUh.a(407, 34, 1, false);
    }
}
