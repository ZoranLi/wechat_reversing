package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class v {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ann taa = new ann();

        public final byte[] zh() {
            this.taa.tYN = k.a(this);
            return this.taa.toByteArray();
        }

        public final int zi() {
            return w.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 27;
        }
    }

    public static class b extends e implements c {
        public ano tab = new ano();

        public final int y(byte[] bArr) {
            this.tab = (ano) new ano().aD(bArr);
            k.a(this, this.tab.tZe);
            return this.tab.tZe.thX;
        }

        public final int getCmdId() {
            return 1000000027;
        }
    }
}
