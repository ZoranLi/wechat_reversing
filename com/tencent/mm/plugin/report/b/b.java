package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bg;

public final class b {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public aid oTn = new aid();

        public final byte[] zh() {
            this.sZA = ac.bHt();
            this.oTn.tjF = new avw().bb(bg.bJQ());
            this.oTn.tYN = k.a(this);
            return this.oTn.toByteArray();
        }

        public final int zi() {
            return 694;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
