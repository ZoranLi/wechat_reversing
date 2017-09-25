package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.protocal.c.of;

@Deprecated
public final class l extends b {
    private amg hNE;

    public l(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        this.hNE = new amg();
        oe oeVar = new oe();
        oeVar.ttL = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        oeVar.ttN = i3;
        of ofVar = new of();
        ofVar.ttP = i;
        ofVar.ttQ = i2;
        oeVar.ttM = ofVar;
        ofVar.ttP = 0;
        ofVar.ttQ = 0;
        oeVar.ttO = ofVar;
        this.hNE.tRb = oeVar;
        this.nyY = this.hNE;
    }

    public l() {
        this(false, 22, 8);
    }
}
