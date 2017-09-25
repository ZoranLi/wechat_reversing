package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.math.BigInteger;

public final class l implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.hst == null || aVar.hst.tff == null) {
            w.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            return;
        }
        String a = n.a(aVar.hst.tff);
        w.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + a);
        String M = M(a, "<TimelineObject", "</TimelineObject>");
        if (bg.mA(M)) {
            w.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            return;
        }
        String M2 = M(a, "<RecXml", "</RecXml>");
        if (bg.mA(M2)) {
            w.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            return;
        }
        a = M(a, "<ADInfo", "</ADInfo>");
        if (bg.mA(a)) {
            w.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            return;
        }
        bfc kL = e.kL(M);
        aud com_tencent_mm_protocal_c_aud = new aud();
        com_tencent_mm_protocal_c_aud.tXU = n.mw(a);
        bby com_tencent_mm_protocal_c_bby = new bby();
        com_tencent_mm_protocal_c_aud.tXT = com_tencent_mm_protocal_c_bby;
        com_tencent_mm_protocal_c_bby.udc = n.mw(M2);
        bbk com_tencent_mm_protocal_c_bbk = new bbk();
        com_tencent_mm_protocal_c_bbk.tmx = new BigInteger(kL.mQY).longValue();
        com_tencent_mm_protocal_c_bbk.ogM = kL.ogM;
        com_tencent_mm_protocal_c_bbk.tgG = kL.jNj;
        com_tencent_mm_protocal_c_bbk.ucj = n.G(M.getBytes());
        com_tencent_mm_protocal_c_bby.ubC = com_tencent_mm_protocal_c_bbk;
        com.tencent.mm.plugin.sns.model.a.b(com_tencent_mm_protocal_c_aud);
    }

    private static String M(String str, String str2, String str3) {
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3)) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            return "";
        }
        return str.substring(indexOf, indexOf2 + str3.length());
    }
}
