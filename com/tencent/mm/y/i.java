package com.tencent.mm.y;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class i implements p {
    public boolean hsA = false;
    private d hsz;

    public abstract d zf();

    public final d BG() {
        if (this.hsz == null) {
            this.hsz = zf();
            d dVar = this.hsz;
            dVar.sZv = com.tencent.mm.compatible.d.p.rB();
            dVar.sZu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            dVar.sZt = com.tencent.mm.protocal.d.sYN;
            dVar.dj(a.sZi.zd());
        }
        return this.hsz;
    }

    public int BD() {
        return 0;
    }

    public final boolean BH() {
        return this.hsA;
    }
}
