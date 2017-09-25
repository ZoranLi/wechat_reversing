package com.tencent.mm.plugin.welab;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;

public final class c implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.hst == null || aVar.hst.tff == null) {
            w.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            return;
        }
        String a = n.a(aVar.hst.tff);
        w.i("MicroMsg.WelabNewMsgLsn", "recv addMsg " + a);
        com.tencent.mm.sdk.e.c KW = g.KW(a);
        if (KW != null && KW.isValid()) {
            if (KW.field_status == 1) {
                b.bAG().ssN.a(KW, new String[]{"expId"});
            } else {
                b.bAG().ssN.c(KW);
                b.bAV().f(KW);
                g.oUh.a((long) KW.field_idkey, (long) KW.field_idkeyValue, 1, false);
            }
            e.o(KW.field_LabsAppId, 6, false);
        }
    }
}
