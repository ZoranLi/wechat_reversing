package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int xoM;
    int xoN;

    public ao() {
        this.xoM = 0;
        this.xoN = 0;
        this.xnn = 2;
    }

    public final byte[] m(byte[] bArr, byte[] bArr2) {
        this.xoM = (bArr.length + 6) + bArr2.length;
        Object obj = new byte[this.xoM];
        util.p(obj, 0, this.xoN);
        util.p(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        int length = bArr.length + 4;
        util.p(obj, length, bArr2.length);
        System.arraycopy(bArr2, 0, obj, length + 2, bArr2.length);
        super.Ep(this.xnn);
        super.H(obj, this.xoM);
        super.cip();
        return super.cil();
    }
}
