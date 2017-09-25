package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int xoo;

    public i() {
        this.xoo = 6;
        this.xnn = 263;
    }

    public final byte[] x(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[this.xoo];
        util.p(bArr, 0, 0);
        util.o(bArr, 2, 1);
        util.p(bArr, 3, 102400);
        util.o(bArr, 5, 1);
        super.Ep(this.xnn);
        super.H(bArr, this.xoo);
        super.cip();
        return super.cil();
    }
}
