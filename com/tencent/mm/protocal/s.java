package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bg;

public final class s {

    public static class a extends d implements b {
        public aaw sZW = new aaw();

        public final byte[] zh() {
            this.sZA = ac.bHu();
            this.sZW.tjF = new avw().bb(bg.bJQ());
            this.sZW.tYN = k.a(this);
            return this.sZW.toByteArray();
        }

        public final int zi() {
            return 572;
        }
    }
}
