package com.tencent.mm.sandbox.updater;

import com.tencent.mm.e.a.rh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class h extends c<rh> {
    public h() {
        this.usg = rh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rh rhVar = (rh) bVar;
        if (rhVar instanceof rh) {
            Updater c = Updater.c(rhVar.fYn.context, null);
            if (c != null) {
                c.ac(rhVar.fYn.type, true);
            }
        }
        return false;
    }
}
