package com.tencent.mm.u;

import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.Map;

public final class bq implements d {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            try {
                Map q = bh.q("<root>" + buVar.tff + "</root>", "root");
                int intValue = Integer.valueOf((String) q.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) q.get(".root.version")).intValue();
                ap.yY();
                t vr = c.vr();
                if (intValue2 == bg.f((Integer) vr.get(12305, null))) {
                    w.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                } else {
                    vr.set(12304, Integer.valueOf(intValue));
                    vr.set(12305, Integer.valueOf(intValue2));
                }
            } catch (Throwable e) {
                w.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", bg.g(e));
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
