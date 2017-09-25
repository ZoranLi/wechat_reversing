package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.e.a.rp;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.IOException;

public final class a extends c<rp> {
    public a() {
        this.usg = rp.class.getName().hashCode();
    }

    private static boolean a(rp rpVar) {
        if ((rpVar instanceof rp) && ap.zb()) {
            d brO = b.brO();
            Object obj = rpVar.fYB.fYC;
            if (!(obj == null || obj.length == 0)) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                bkj com_tencent_mm_protocal_c_bkj = new bkj();
                try {
                    com_tencent_mm_protocal_c_bkj.aD(obj2);
                    w.i("MicroMsg.voipcs.VoipCSService", "notify status = " + com_tencent_mm_protocal_c_bkj.ukd + ",notifySeq = " + brO.rsn);
                    bkq com_tencent_mm_protocal_c_bkq = new bkq();
                    com_tencent_mm_protocal_c_bkq.ujT = com_tencent_mm_protocal_c_bkj.ujT;
                    com_tencent_mm_protocal_c_bkq.tvM = com_tencent_mm_protocal_c_bkj.tvM;
                    com_tencent_mm_protocal_c_bkq.ukb = com_tencent_mm_protocal_c_bkj.ukb;
                    com_tencent_mm_protocal_c_bkq.ukd = com_tencent_mm_protocal_c_bkj.ukd;
                    com_tencent_mm_protocal_c_bkq.uke = com_tencent_mm_protocal_c_bkj.uke;
                    com_tencent_mm_protocal_c_bkq.ukf = com_tencent_mm_protocal_c_bkj.ukf;
                    com_tencent_mm_protocal_c_bkq.ukc = com_tencent_mm_protocal_c_bkj.ukc;
                    brO.a(com_tencent_mm_protocal_c_bkq);
                } catch (IOException e) {
                    w.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[]{e});
                }
            }
        }
        return false;
    }
}
