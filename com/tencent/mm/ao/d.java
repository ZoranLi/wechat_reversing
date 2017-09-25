package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class d extends b {
    private nh hNw = new nh();

    public d(String str, long j) {
        super(8);
        this.hNw.ttp = new avx().OV(bg.mz(str));
        this.hNw.tfk = j;
        this.nyY = this.hNw;
    }
}
