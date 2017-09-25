package com.tencent.mm.u;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.acu;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class au {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public acu hmv = new acu();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.hmv.tjF = new avw().bb(bg.bJQ());
            this.hmv.tYN = k.a(this);
            return this.hmv.toByteArray();
        }

        public final int zi() {
            return 618;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public acv hmw = new acv();

        public final int y(byte[] bArr) {
            this.hmw = (acv) new acv().aD(bArr);
            k.a(this, this.hmw.tZe);
            return this.hmw.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
