package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int xox;

    public aa() {
        this.xox = 0;
        this.xnn = 296;
    }

    private static int I(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int I = I(bArr, 32);
        int I2 = I(bArr2, 16);
        this.xox = (((I + 11) + 2) + I2) + 2;
        Object obj = new byte[this.xox];
        util.p(obj, 0, 0);
        util.o(obj, 2, i);
        util.o(obj, 3, i2);
        util.o(obj, 4, i3);
        util.q(obj, 5, 0);
        util.p(obj, 9, I);
        System.arraycopy(bArr, 0, obj, 11, I);
        I += 11;
        util.p(obj, I, I2);
        I += 2;
        System.arraycopy(bArr2, 0, obj, I, I2);
        util.p(obj, I + I2, 0);
        super.Ep(this.xnn);
        super.H(obj, this.xox);
        super.cip();
        return super.cil();
    }
}
