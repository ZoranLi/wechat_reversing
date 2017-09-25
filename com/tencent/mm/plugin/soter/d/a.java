package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.f.d;
import com.tencent.d.b.f.f;
import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.j.c;

public final class a implements com.tencent.mm.vending.c.a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    public b ink = null;

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        w.v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        com.tencent.d.b.f.e.a aVar = new com.tencent.d.b.f.e.a();
        aVar.xaw.xas = g.blW();
        aVar.xaw.xav = "WechatASK";
        aVar.xaw.xat = new int[]{1, 2};
        aVar.xaw.xar = null;
        aVar.xaw.xau = new e();
        d eVar = new e(ab.getContext(), aVar.xaw);
        this.ink = com.tencent.mm.vending.g.g.cbB();
        this.ink.cbA();
        eVar.xao = new com.tencent.d.b.a.b<com.tencent.d.b.a.d>(this) {
            final /* synthetic */ a qQd;

            {
                this.qQd = r1;
            }

            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.d dVar = (com.tencent.d.b.a.d) eVar;
                w.i("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(dVar.errCode), dVar.fPf});
                if (dVar.isSuccess()) {
                    w.v("MicroMsg.SoterInitFunc", "alvinluo resume %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
                    this.qQd.ink.resume();
                    return;
                }
                com.tencent.mm.plugin.soter.c.a.dj(0, dVar.errCode);
                this.qQd.ink.bJ(com.tencent.mm.vending.g.g.t(Integer.valueOf(dVar.errCode), dVar.fPf));
            }
        };
        if (!f.cfX().a(eVar, new com.tencent.d.b.a.d())) {
            w.e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        }
        w.v("MicroMsg.SoterInitFunc", "alvinluo pending %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        return cVar;
    }
}
