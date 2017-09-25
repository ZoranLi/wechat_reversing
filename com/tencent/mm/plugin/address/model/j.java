package com.tencent.mm.plugin.address.model;

import com.tencent.mm.e.a.lm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class j extends c<lm> {
    public j() {
        this.usg = lm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lm lmVar = (lm) bVar;
        w.i("MicroMsg.RcptAddressEventListener", "revent " + lmVar.fSt.fSv);
        ap.yY();
        com.tencent.mm.sdk.platformtools.j.ex(lmVar.fSt.fSv, com.tencent.mm.u.c.xv() + "address");
        return false;
    }
}
