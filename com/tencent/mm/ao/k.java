package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class k extends b {
    private amc hND = new amc();

    public k(String str, int i) {
        super(20);
        this.hND.teL = new avx().OV(bg.mz(str));
        this.hND.jNB = i;
        this.nyY = this.hND;
    }
}
