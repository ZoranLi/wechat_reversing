package com.tencent.mm.u;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class at {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public acq hmt = new acq();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.hmt.tjF = new avw().bb(bg.bJQ());
            this.hmt.tYN = k.a(this);
            return this.hmt.toByteArray();
        }

        public final int zi() {
            return 616;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public acr hmu = new acr();

        public final int y(byte[] bArr) {
            this.hmu = (acr) new acr().aD(bArr);
            k.a(this, this.hmu.tZe);
            return this.hmu.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
