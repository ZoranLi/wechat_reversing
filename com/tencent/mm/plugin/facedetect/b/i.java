package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class i {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public va luR = new va();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.luR.tjF = new avw().bb(bg.bJQ());
            this.luR.tYN = k.a(this);
            this.sZz = this.luR.tjF.tZp.toByteArray();
            return this.luR.toByteArray();
        }

        public final int zi() {
            return 733;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public vb luS = new vb();

        public final int y(byte[] bArr) {
            this.luS = (vb) new vb().aD(bArr);
            k.a(this, this.luS.tZe);
            return this.luS.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
