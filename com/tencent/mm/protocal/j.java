package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.w;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ed sZp = new ed();
        public byte[] sZq;

        public final byte[] zh() {
            this.sZp.tYN = k.a(this);
            w.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.sZq, Integer.valueOf(this.sZp.thR), this.sZp.thS, this.sZp.thT, this.sZp.thU, Integer.valueOf(this.sZp.tdM), Long.valueOf(this.sZp.jNx), this.sZp.thV, this.sZp.thW);
            return this.sZp.toByteArray();
        }

        public final int zi() {
            return 1000;
        }

        public final int getCmdId() {
            return 1000;
        }
    }

    public static class b extends e implements c {
        public ef sZr = new ef();

        public final int y(byte[] bArr) {
            this.sZr = (ef) new ef().aD(bArr);
            w.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.sZr.thX), this.sZr.thY, this.sZr.thZ);
            return this.sZr.thX;
        }

        public final int getCmdId() {
            return 1000;
        }
    }
}
