package com.tencent.mm.ao;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
public final class n extends b {
    private amw hNG = new amw();

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        this.hNG.ttp = new avx().OV(bg.mz(str));
        this.hNG.tLj = new avx().OV(bg.mz(str2));
        this.hNG.tdy = 0;
        this.hNG.tRs = new avx().OV(bg.mz(str3));
        this.hNG.tRt = new avx().OV(bg.mz(str4));
        this.hNG.jNB = 0;
        byte[] c = e.c(bg.mz(str5), 0, -1);
        this.hNG.tRp = new com.tencent.mm.bd.b(c == null ? new byte[0] : c);
        this.hNG.tRo = c == null ? 0 : c.length;
        this.hNG.hAD = 0;
        this.hNG.hAH = 0;
        this.hNG.hAG = bg.mz(str6);
        this.hNG.hAF = bg.mz(str7);
        this.hNG.hAE = bg.mz(str8);
        this.hNG.tdB = i;
        this.hNG.tMR = bg.mz(str9);
        this.hNG.tRy = 0;
        this.hNG.hAI = bg.mz(str10);
        this.hNG.tMT = 0;
        this.hNG.tMS = "";
        this.nyY = this.hNG;
    }
}
