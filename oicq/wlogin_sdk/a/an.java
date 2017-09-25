package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int xoJ;
    int xoK;
    int xoL;

    public an() {
        this.xoJ = 22;
        this.xoK = 1;
        this.xoL = 1536;
        this.xnn = 24;
    }

    public final byte[] a(long j, int i, long j2, int i2) {
        byte[] bArr = new byte[this.xoJ];
        util.p(bArr, 0, this.xoK);
        util.q(bArr, 2, this.xoL);
        util.q(bArr, 6, (int) j);
        util.q(bArr, 10, i);
        util.q(bArr, 14, (int) j2);
        util.p(bArr, 18, 0);
        util.p(bArr, 20, 0);
        super.Ep(this.xnn);
        super.H(bArr, this.xoJ);
        super.cip();
        return super.cil();
    }
}
