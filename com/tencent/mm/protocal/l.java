package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l extends a {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public int netType;
        public int sZE = 0;

        public final byte[] zh() {
            ft ftVar = new ft();
            ftVar.tiC = d.sYN;
            ftVar.tjh = 2;
            ftVar.tji = this.netType;
            ftVar.tjj = this.sZE;
            w.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(ftVar.tjj), Integer.valueOf(ftVar.tji), Integer.valueOf(ftVar.tiC), Integer.valueOf(ftVar.tjh));
            byte[] bArr = null;
            try {
                bArr = ftVar.toByteArray();
            } catch (Throwable e) {
                w.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", bg.g(e));
            }
            return bArr;
        }

        public final int zi() {
            return 0;
        }

        public final int getCmdId() {
            return 312;
        }

        public final boolean bHp() {
            return true;
        }

        public final boolean Cl() {
            return false;
        }
    }

    public static class b extends e implements c {
        public fu sZF = new fu();

        public final int y(byte[] bArr) {
            this.sZF = (fu) new fu().aD(bArr);
            w.d("MicroMsg.MMBgFg", "retcode:" + this.sZF.kAC);
            return this.sZF.kAC;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean bHp() {
            return true;
        }
    }
}
