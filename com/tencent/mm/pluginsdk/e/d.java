package com.tencent.mm.pluginsdk.e;

import com.tencent.mm.e.a.ip;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

public abstract class d implements a {
    public int sBM = 0;

    public abstract j aBJ();

    public abstract b xW(String str);

    public final void Rg() {
        if (this.sBM == 0) {
            j aBJ = aBJ();
            if (aBJ != null) {
                aBJ.c(this);
            }
        }
        this.sBM++;
    }

    public final void unregister() {
        if (this.sBM != 0) {
            this.sBM--;
            if (this.sBM == 0) {
                j aBJ = aBJ();
                if (aBJ != null) {
                    aBJ.f(this);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        b ipVar = new ip();
        ipVar.fOq.fOr = xW(str);
        com.tencent.mm.sdk.b.a.urY.m(ipVar);
    }
}
