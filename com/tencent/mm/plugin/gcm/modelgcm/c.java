package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public cd mHF = new cd();

        public final byte[] zh() {
            this.mHF.tYN = k.a(this);
            return this.mHF.toByteArray();
        }

        public final int getCmdId() {
            return 289;
        }

        public final int zi() {
            return 623;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.k.c {
        public ce mHG = new ce();

        public final int y(byte[] bArr) {
            this.mHG = (ce) new ce().aD(bArr);
            k.a(this, this.mHG.tZe);
            return this.mHG.tZe.thX;
        }

        public final int getCmdId() {
            return 1000000289;
        }
    }
}
