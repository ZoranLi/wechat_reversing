package oicq.wlogin_sdk.a;

public final class j extends a {
    int xop;

    public j() {
        this.xop = 0;
        this.xnn = 264;
    }

    public final byte[] bN(byte[] bArr) {
        this.xop = bArr.length;
        Object obj = new byte[this.xop];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Ep(this.xnn);
        super.H(obj, this.xop);
        super.cip();
        return super.cil();
    }
}
