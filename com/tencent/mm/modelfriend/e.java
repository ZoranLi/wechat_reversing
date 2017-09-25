package com.tencent.mm.modelfriend;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.x.h;

public final class e extends com.tencent.mm.u.e {
    protected final au a(bu buVar, String str, String str2, String str3) {
        String a = n.a(buVar.tff);
        if (a == null || a.length() <= 0) {
            w.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            return null;
        }
        a RF = a.RF(a);
        if (bg.mz(RF.rUK).length() > 0) {
            h hVar = new h();
            hVar.username = RF.rUK;
            hVar.gkq = 3;
            hVar.aV(true);
            hVar.hrB = RF.uJZ;
            hVar.hrA = RF.uKa;
            hVar.fRW = -1;
            w.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", RF.rUK, hVar.Bs(), hVar.Bt());
            com.tencent.mm.x.n.Bm().a(hVar);
        }
        return super.a(buVar, str, str2, str3);
    }
}
