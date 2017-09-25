package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int xor;
    int xos;

    public r() {
        this.xor = 0;
        this.xos = 0;
        this.xnn = 278;
    }

    public final byte[] a(int i, int i2, long[] jArr) {
        this.xor = 10;
        byte[] bArr = new byte[this.xor];
        util.o(bArr, 0, this.xos);
        util.q(bArr, 1, i);
        util.q(bArr, 5, i2);
        util.o(bArr, 9, 0);
        super.Ep(this.xnn);
        super.H(bArr, this.xor);
        super.cip();
        return super.cil();
    }
}
