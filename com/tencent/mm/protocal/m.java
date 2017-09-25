package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class m {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public gd sZG = new gd();

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.sZG.tjF = new avw().bb(bg.bJQ());
            this.sZG.tYN = k.a(this);
            return this.sZG.toByteArray();
        }

        public final int zi() {
            return com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
        }
    }

    public static class b extends e implements c {
        public ge sZH = new ge();

        public final int y(byte[] bArr) {
            this.sZH = (ge) new ge().aD(bArr);
            k.a(this, this.sZH.tZe);
            return this.sZH.tZe.thX;
        }
    }
}
