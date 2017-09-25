package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;

public final class y {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] sZl;
        public anq tae = new anq();

        public final byte[] zh() {
            int i = -1;
            this.sZA = ac.bHs();
            this.tae.tjF = new avw().bb(bg.bJQ());
            this.tae.tYN = k.a(this);
            this.tae.tSw = f.usq;
            os osVar = new os();
            osVar.tuk = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(osVar.tuk, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.sZl = bArr2 != null ? bArr2 : new byte[0];
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(osVar.tuk);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = bg.bl(bArr);
            objArr[5] = bg.bl(bArr2);
            w.d(str, str2, objArr);
            osVar.thF = new avw().bb(bArr);
            this.tae.thJ = osVar;
            return this.tae.toByteArray();
        }

        public final int zi() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public byte[] idY;
        public byte[] sZn;
        public int sZo = 0;
        public anr taf = new anr();

        public final int y(byte[] bArr) {
            this.sZo = 0;
            this.taf = (anr) new anr().aD(bArr);
            k.a(this, this.taf.tZe);
            this.sZo = 0;
            return this.taf.tZe.thX;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void aW(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.idY = bArr;
        }
    }
}
