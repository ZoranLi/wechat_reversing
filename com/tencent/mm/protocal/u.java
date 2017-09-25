package com.tencent.mm.protocal;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bg;

public final class u {

    public static class a extends d implements b {
        public acn sZZ = new acn();

        public final byte[] zh() {
            this.sZA = ac.bHu();
            this.sZZ.tjF = new avw().bb(bg.bJQ());
            this.sZZ.tYN = k.a(this);
            return this.sZZ.toByteArray();
        }

        public final int zi() {
            return MMGIFException.D_GIF_ERR_WRONG_RECORD;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}
