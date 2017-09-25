package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int xoA;
    int xoB;

    public ae() {
        this.xoA = 0;
        this.xoB = 0;
        this.xnn = 322;
    }

    public final byte[] bP(byte[] bArr) {
        this.xoB = bArr.length + 4;
        Object obj = new byte[this.xoB];
        util.p(obj, 0, this.xoA);
        util.p(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        super.Ep(this.xnn);
        super.H(obj, obj.length);
        super.cip();
        return super.cil();
    }
}
