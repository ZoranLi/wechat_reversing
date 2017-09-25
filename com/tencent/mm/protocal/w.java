package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class w {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ant tac = new ant();

        public final byte[] zh() {
            return this.tac.toByteArray();
        }

        public final int zi() {
            return 138;
        }

        public final int getCmdId() {
            return 121;
        }
    }

    public static class b extends e implements c {
        public anu tad = new anu();

        public final int y(byte[] bArr) {
            this.tad = (anu) new anu().aD(bArr);
            return this.tad.thX;
        }

        public final int getCmdId() {
            return 1000000121;
        }
    }
}
