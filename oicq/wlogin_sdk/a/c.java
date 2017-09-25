package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int xod;
    int xoe;
    int xof;

    public c() {
        this.xod = 1;
        this.xoe = util.xpj;
        this.xof = 22;
        this.xnn = 256;
    }

    public final byte[] a(long j, long j2, int i, int i2) {
        byte[] bArr = new byte[this.xof];
        util.p(bArr, 0, this.xod);
        util.q(bArr, 2, this.xoe);
        util.q(bArr, 6, (int) j);
        util.q(bArr, 10, 1);
        util.q(bArr, 14, i);
        util.q(bArr, 18, i2);
        super.Ep(this.xnn);
        super.H(bArr, this.xof);
        super.cip();
        return super.cil();
    }
}
