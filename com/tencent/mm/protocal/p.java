package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class p {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ot sZO = new ot();

        public final byte[] zh() {
            this.sZA = ac.bHu();
            this.sZO.tjF = new avw().bb(bg.bJQ());
            this.sZO.tYN = k.a(this);
            return this.sZO.toByteArray();
        }

        public final int zi() {
            return 481;
        }
    }

    public static class b extends e implements c {
        public ou sZP = new ou();

        public final int y(byte[] bArr) {
            this.sZP = (ou) new ou().aD(bArr);
            k.a(this, this.sZP.tZe);
            return this.sZP.tZe.thX;
        }
    }
}
