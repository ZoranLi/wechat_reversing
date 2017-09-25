package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.xnn = 327;
    }

    private static int bR(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2) {
        int bR = bR(bArr);
        int bR2 = bR(bArr2);
        Object obj = new byte[(((bR + 6) + 2) + bR2)];
        util.c(obj, 0, j);
        util.p(obj, 4, bR);
        System.arraycopy(bArr, 0, obj, 6, bR);
        bR += 6;
        util.p(obj, bR, bR2);
        System.arraycopy(bArr2, 0, obj, bR + 2, bR2);
        super.Ep(this.xnn);
        super.H(obj, obj.length);
        super.cip();
        return super.cil();
    }
}
