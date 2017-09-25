package oicq.wlogin_sdk.a;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    int xnV = 0;
    public int xnW = 4;
    public int xnX = 0;
    public int xnb = FileUtils.S_IWUSR;
    public int xnc = 0;
    public byte[] xnh = new byte[this.xnb];
    public int xnn = 0;

    public final byte[] cil() {
        Object obj = new byte[this.xnc];
        System.arraycopy(this.xnh, 0, obj, 0, this.xnc);
        return obj;
    }

    public final byte[] cio() {
        Object obj = new byte[this.xnX];
        System.arraycopy(this.xnh, this.xnW, obj, 0, this.xnX);
        return obj;
    }

    public final void Ep(int i) {
        util.p(this.xnh, this.xnc, i);
        this.xnc += 2;
        util.p(this.xnh, this.xnc, 0);
        this.xnc += 2;
    }

    public final void cip() {
        util.p(this.xnh, 2, this.xnc - this.xnW);
    }

    public final void H(byte[] bArr, int i) {
        if (i > this.xnb - this.xnW) {
            this.xnb = (this.xnW + i) + 64;
            Object obj = new byte[this.xnb];
            System.arraycopy(this.xnh, 0, obj, 0, this.xnc);
            this.xnh = obj;
        }
        this.xnX = i;
        System.arraycopy(bArr, 0, this.xnh, this.xnc, i);
        this.xnc += i;
    }

    private static int m(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.K(bArr, i3) != i2) {
                i3 += 2;
                if (i3 + 2 > length) {
                    break;
                }
                i3 += util.K(bArr, i3) + 2;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final int n(byte[] bArr, int i, int i2) {
        int m = m(bArr, i, this.xnn);
        if (m < 0) {
            return -1;
        }
        int i3 = i2 - (m - i);
        if (this.xnW >= i3) {
            return -1;
        }
        this.xnX = util.K(bArr, m + 2);
        if (this.xnW + this.xnX > i3) {
            return -1;
        }
        int i4 = this.xnW + this.xnX;
        if (i4 > this.xnb) {
            this.xnb = i4 + FileUtils.S_IWUSR;
            this.xnh = new byte[this.xnb];
        }
        this.xnc = i4;
        System.arraycopy(bArr, m, this.xnh, 0, i4);
        this.xnn = util.K(bArr, m);
        this.xnX = i4 - this.xnW;
        if (ciq().booleanValue()) {
            return (this.xnW + m) + this.xnX;
        }
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int m = m(bArr, i, this.xnn);
        if (m < 0) {
            return -1;
        }
        int i3 = i2 - (m - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, m, obj, 0, i3);
        if (this.xnW >= i3) {
            return -1;
        }
        this.xnX = util.K(obj, 2);
        if (this.xnW + this.xnX > i3) {
            return -1;
        }
        Object decrypt = d.decrypt(obj, this.xnW, this.xnX, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        if (this.xnW + decrypt.length > this.xnb) {
            this.xnb = this.xnW + decrypt.length;
            this.xnh = new byte[this.xnb];
        }
        this.xnc = 0;
        System.arraycopy(obj, 0, this.xnh, 0, this.xnW);
        this.xnc += this.xnW;
        System.arraycopy(decrypt, 0, this.xnh, this.xnc, decrypt.length);
        this.xnc += decrypt.length;
        this.xnX = decrypt.length;
        return !ciq().booleanValue() ? -1005 : 0;
    }

    public Boolean ciq() {
        return Boolean.valueOf(true);
    }
}
