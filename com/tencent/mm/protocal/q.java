package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.r;

public final class q {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public final pp sZQ = new pp();

        public a() {
            dj(0);
            this.sZQ.tvJ = new po();
            this.sZQ.tvJ.tvH = new kw();
            this.sZQ.tvI = new pq();
        }

        public final byte[] zh() {
            this.sZA = ac.bHs();
            this.sZQ.tvJ.tYN = k.a(this);
            this.sZQ.tvI.tjF = new avw().bb(bg.bJQ());
            this.sZz = this.sZQ.tvI.tjF.tZp.toByteArray();
            this.sZy = new com.tencent.mm.protocal.k.a(this) {
                final /* synthetic */ a sZS;

                public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                    long j;
                    com.tencent.mm.protocal.k.b bVar = (com.tencent.mm.protocal.k.b) this;
                    long j2 = (long) this.sZs;
                    if (com.tencent.mm.sdk.a.b.bIu() && j2 == 0) {
                        j = d.sYM;
                    } else {
                        j = j2;
                    }
                    ac acVar = this.sZA;
                    if (i == 722) {
                        w.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                        pp ppVar = ((a) this).sZQ;
                        byte[][] a = r.a(j, ppVar.tvI, ppVar.tvJ);
                        if (a == null) {
                            return false;
                        }
                        byte[] bArr3 = a[0];
                        byte[] bArr4 = a[1];
                        if (MMProtocalJni.packHybrid(pByteArray, bArr, this.sZv, (int) j, bVar.zi(), acVar.ver, bArr3, bArr4, acVar.tal.getBytes(), acVar.tam.getBytes(), this.sZz, i2)) {
                            w.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                            return true;
                        }
                    }
                    return false;
                }
            };
            return this.sZQ.toByteArray();
        }

        public final int zi() {
            return 722;
        }
    }

    public static class b extends e implements c {
        public final kx sZT = new kx();

        public final int y(byte[] bArr) {
            this.sZT.aD(bArr);
            return this.sZT.tZe.thX;
        }
    }
}
