package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class e extends b {
    private nn hNx = new nn();

    public e(String str, long j) {
        super(9);
        this.hNx.ttp = new avx().OV(bg.mz(str));
        this.hNx.ttw.add(Integer.valueOf((int) j));
        this.hNx.jNd = 1;
        this.nyY = this.hNx;
    }
}
