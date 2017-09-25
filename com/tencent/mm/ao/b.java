package com.tencent.mm.ao;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class b extends com.tencent.mm.plugin.messenger.foundation.a.a.e.b {
    private nb hNu = new nb();

    public b(String str) {
        super(7);
        this.hNu.ttp = new avx().OV(bg.mz(str));
        this.nyY = this.hNu;
    }
}
