package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class c extends b {
    private ne hNv;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        super(4);
        this.hNv = new ne();
        this.hNv.ttp = new avx().OV(bg.mz(str));
        this.hNv.ttr = i;
        this.nyY = this.hNv;
    }
}
