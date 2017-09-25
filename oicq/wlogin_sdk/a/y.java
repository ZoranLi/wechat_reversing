package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int xou;

    public y() {
        this.xou = 0;
        this.xnn = 292;
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

    public final byte[] a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int I = I(bArr, 16);
        int I2 = I(bArr2, 16);
        int I3 = I(bArr3, 16);
        int I4 = I(bArr4, 32);
        int I5 = I(bArr5, 16);
        this.xou = (((((((((I + 2) + 2) + I2) + 2) + 2) + I3) + 2) + I4) + 2) + I5;
        Object obj = new byte[this.xou];
        util.p(obj, 0, I);
        System.arraycopy(bArr, 0, obj, 2, I);
        I += 2;
        util.p(obj, I, I2);
        I += 2;
        System.arraycopy(bArr2, 0, obj, I, I2);
        I += I2;
        util.p(obj, I, i);
        I += 2;
        util.p(obj, I, I3);
        I += 2;
        System.arraycopy(bArr3, 0, obj, I, I3);
        I += I3;
        util.p(obj, I, I4);
        I += 2;
        System.arraycopy(bArr4, 0, obj, I, I4);
        I += I4;
        util.p(obj, I, I5);
        System.arraycopy(bArr5, 0, obj, I + 2, I5);
        super.Ep(this.xnn);
        super.H(obj, this.xou);
        super.cip();
        return super.cil();
    }
}
