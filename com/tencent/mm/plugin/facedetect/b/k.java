package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class k {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public biw luV = new biw();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.luV.tjF = new avw().bb(bg.bJQ());
            this.luV.tYN = com.tencent.mm.protocal.k.a(this);
            this.sZz = this.luV.tjF.tZp.toByteArray();
            return this.luV.toByteArray();
        }

        public final int zi() {
            return 930;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bix luW = new bix();

        public final int y(byte[] bArr) {
            this.luW = (bix) new bix().aD(bArr);
            com.tencent.mm.protocal.k.a(this, this.luW.tZe);
            return this.luW.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
