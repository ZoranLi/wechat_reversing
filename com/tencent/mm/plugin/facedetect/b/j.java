package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public aum luT = new aum();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.luT.tjF = new avw().bb(bg.bJQ());
            this.luT.tYN = k.a(this);
            this.sZz = this.luT.tjF.tZp.toByteArray();
            return this.luT.toByteArray();
        }

        public final int zi() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public aun luU = new aun();

        public final int y(byte[] bArr) {
            this.luU = (aun) new aun().aD(bArr);
            k.a(this, this.luU.tZe);
            return this.luU.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
