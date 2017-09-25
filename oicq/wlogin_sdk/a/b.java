package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int xnY;
    int xnZ;
    int xoa;
    int xob;
    byte[] xoc;

    public b() {
        this.xnY = 4;
        this.xnZ = 14;
        this.xoa = 1;
        this.xob = 20;
        this.xoc = new byte[2];
        this.xnn = 1;
    }

    public final Boolean ciq() {
        if (this.xnX < 20) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final byte[] g(long j, byte[] bArr) {
        Object obj = new byte[this.xob];
        util.p(obj, 0, this.xoa);
        util.q(obj, 2, util.civ());
        util.q(obj, 6, (int) j);
        util.c(obj, 10, util.cix());
        System.arraycopy(bArr, 0, obj, 14, bArr.length);
        util.p(obj, bArr.length + 14, 0);
        super.Ep(this.xnn);
        super.H(obj, this.xob);
        super.cip();
        return super.cil();
    }
}
