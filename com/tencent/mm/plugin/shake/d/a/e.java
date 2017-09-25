package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.y.k;

public abstract class e extends k implements j {
    protected boolean pqi = false;
    long pqj = 0;

    public abstract avp bbu();

    public e(long j) {
        this.pqj = j;
    }

    public final boolean bbt() {
        return this.pqi;
    }
}
