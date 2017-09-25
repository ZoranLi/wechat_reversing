package oicq.wlogin_sdk.a;

public final class k extends a {
    int xoq;

    public k() {
        this.xoq = 0;
        this.xnn = 265;
    }

    public final byte[] bO(byte[] bArr) {
        this.xoq = bArr.length;
        Object obj = new byte[this.xoq];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Ep(this.xnn);
        super.H(obj, this.xoq);
        super.cip();
        return super.cil();
    }
}
