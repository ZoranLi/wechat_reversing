package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bgu;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bgu qPQ = new bgu();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.qPQ.tjF = new avw().bb(bg.bJQ());
            this.qPQ.tYN = k.a(this);
            this.sZz = this.qPQ.tjF.tZp.toByteArray();
            return this.qPQ.toByteArray();
        }

        public final int zi() {
            return 627;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.k.c {
        public bgv qPR = new bgv();

        public final int y(byte[] bArr) {
            this.qPR = (bgv) new bgv().aD(bArr);
            k.a(this, this.qPR.tZe);
            return this.qPR.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
