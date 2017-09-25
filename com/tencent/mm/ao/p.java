package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class p extends b {
    private ata hNI = new ata();

    public p(String str, String str2) {
        super(16);
        this.hNI.ttp = new avx().OV(bg.mz(str));
        this.hNI.teL = new avx().OV(bg.mz(str2));
        this.nyY = this.hNI;
    }
}
