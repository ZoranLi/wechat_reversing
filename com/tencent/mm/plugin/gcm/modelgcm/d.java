package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class d {

    public static class a extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public cf mHH = new cf();

        public final byte[] zh() {
            this.mHH.tYN = k.a(this);
            return this.mHH.toByteArray();
        }

        public final int getCmdId() {
            return GameJsApiGetGameCommInfo.CTRL_BYTE;
        }

        public final int zi() {
            return 624;
        }
    }

    public static class b extends e implements c {
        public cg mHI = new cg();

        public final int y(byte[] bArr) {
            this.mHI = (cg) new cg().aD(bArr);
            k.a(this, this.mHI.tZe);
            return this.mHI.tZe.thX;
        }

        public final int getCmdId() {
            return 1000000241;
        }
    }
}
