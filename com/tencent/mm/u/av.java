package com.tencent.mm.u;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class av {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bjj hmx = new bjj();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.hmx.tjF = new avw().bb(bg.bJQ());
            this.hmx.tYN = k.a(this);
            return this.hmx.toByteArray();
        }

        public final int zi() {
            return 617;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bjk hmy = new bjk();

        public final int y(byte[] bArr) {
            this.hmy = (bjk) new bjk().aD(bArr);
            k.a(this, this.hmy.tZe);
            return this.hmy.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
