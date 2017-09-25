package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class z {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public axo tah = new axo();

        public final byte[] zh() {
            this.tah.tYN = k.a(this);
            return this.tah.toByteArray();
        }

        public final int getCmdId() {
            return 42;
        }

        public final int zi() {
            return 131;
        }
    }

    public static class b extends e implements c {
        public axp tai = new axp();

        public final int y(byte[] bArr) {
            this.tai = (axp) new axp().aD(bArr);
            k.a(this, this.tai.tZe);
            return this.tai.tZe.thX;
        }
    }
}
