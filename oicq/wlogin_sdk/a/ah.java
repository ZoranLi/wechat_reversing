package oicq.wlogin_sdk.a;

public final class ah extends a {
    public int xoE;

    public ah() {
        this.xoE = 0;
        this.xnn = 325;
    }

    public final byte[] bQ(byte[] bArr) {
        int length;
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        Object obj = new byte[length];
        if (obj.length > 0) {
            System.arraycopy(bArr, 0, obj, 0, length);
        }
        this.xoE = obj.length;
        super.Ep(this.xnn);
        super.H(obj, obj.length);
        super.cip();
        return super.cil();
    }
}
