package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class r {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public wm sZU = new wm();

        public final byte[] zh() {
            this.sZA = ac.bHu();
            this.sZU.tjF = new avw().bb(bg.bJQ());
            this.sZU.tDf = ac.bHs().ver;
            this.sZU.tYN = k.a(this);
            return this.sZU.toByteArray();
        }

        public final int zi() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends e implements c {
        public wn sZV = new wn();

        public final int y(byte[] bArr) {
            this.sZV = (wn) new wn().aD(bArr);
            k.a(this, this.sZV.tZe);
            return this.sZV.tZe.thX;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}
