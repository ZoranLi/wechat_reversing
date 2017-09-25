package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class t {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public abn sZX = new abn();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.sZX.tjF = new avw().bb(bg.bJQ());
            this.sZX.tYN = k.a(this);
            return this.sZX.toByteArray();
        }

        public final int zi() {
            return 429;
        }
    }

    public static class b extends e implements c {
        public abo sZY = new abo();

        public final int y(byte[] bArr) {
            this.sZY = (abo) new abo().aD(bArr);
            k.a(this, this.sZY.tZe);
            return this.sZY.tZe.thX;
        }
    }
}
