package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int xol;
    int xom;
    int xon;

    public h() {
        this.xol = 1;
        this.xom = 1;
        this.xon = 69;
        this.xnn = 262;
        this.xom = util.xpj;
        if (util.xpj <= 2) {
            this.xol = 1;
            this.xon = 69;
            return;
        }
        this.xol = 2;
        this.xon = 90;
    }

    public final byte[] a(long j, int i, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        if (util.xpj <= 2) {
            Object obj = new byte[this.xon];
            util.p(obj, 0, this.xol);
            util.q(obj, 2, util.civ());
            util.q(obj, 6, this.xom);
            util.q(obj, 10, (int) j);
            util.q(obj, 14, i);
            util.b(obj, 18, j2);
            System.arraycopy(bArr, 0, obj, 26, bArr.length);
            int length = bArr.length + 26;
            System.arraycopy(bArr2, 0, obj, length, bArr2.length);
            length += bArr2.length;
            util.o(obj, length, 1);
            length++;
            System.arraycopy(bArr3, 0, obj, length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, length + bArr3.length, bArr4.length);
            Object obj2 = new byte[24];
            System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
            util.b(obj2, 16, j2);
            byte[] b = d.b(obj, obj.length, c.bS(obj2));
            this.xon = b.length;
            super.Ep(this.xnn);
            super.H(b, this.xon);
            super.cip();
            return super.cil();
        }
        obj = new byte[this.xon];
        util.p(obj, 0, this.xol);
        util.q(obj, 2, util.civ());
        util.q(obj, 6, this.xom);
        util.q(obj, 10, (int) j);
        util.q(obj, 14, i);
        util.b(obj, 18, j2);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, obj, length, bArr2.length);
        length += bArr2.length;
        util.o(obj, length, 1);
        length++;
        System.arraycopy(bArr3, 0, obj, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, obj, length, bArr4.length);
        length += bArr4.length;
        util.q(obj, length, 0);
        length += 4;
        util.o(obj, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr6 = new byte[16];
            util.q(bArr6, 0, util.civ());
            util.q(bArr6, 4, util.civ());
            util.q(bArr6, 8, util.civ());
            util.q(bArr6, 12, util.civ());
        } else {
            System.arraycopy(bArr5, 0, obj, length, bArr5.length);
        }
        obj2 = new byte[24];
        System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
        util.b(obj2, 16, j2);
        b = d.b(obj, obj.length, c.bS(obj2));
        this.xon = b.length;
        super.Ep(this.xnn);
        super.H(b, this.xon);
        super.cip();
        return cil();
    }
}
