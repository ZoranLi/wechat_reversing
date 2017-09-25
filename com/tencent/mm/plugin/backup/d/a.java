package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private e gUD;
    public p htt = new a();

    public static class a extends i {
        private final com.tencent.mm.protocal.j.a jEM = new com.tencent.mm.protocal.j.a();
        private final b jEN = new b();

        protected final d zf() {
            return this.jEM;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.jEN;
        }

        public final int getType() {
            return 1000;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
        }

        public final int BD() {
            return 1;
        }
    }

    public a(LinkedList<me> linkedList, String str, String str2) {
        final com.tencent.mm.protocal.j.a aVar = (com.tencent.mm.protocal.j.a) this.htt.BG();
        aVar.sZq = com.tencent.mm.plugin.backup.a.e.aai();
        aVar.sZp.thR = linkedList.size();
        aVar.sZp.thS = linkedList;
        aVar.sZp.thT = com.tencent.mm.compatible.d.p.getDeviceID(ab.getContext());
        aVar.sZp.thU = m.xL();
        aVar.sZp.tdM = 2;
        aVar.sZp.jNx = 0;
        aVar.sZp.thV = str;
        aVar.sZp.thW = str2;
        aVar.sZz = aVar.sZq;
        aVar.sZy = new com.tencent.mm.protocal.k.a(this) {
            final /* synthetic */ a jEL;

            public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                long j;
                long j2 = (long) aVar.sZs;
                if (com.tencent.mm.sdk.a.b.bIu() && j2 == 0) {
                    j = com.tencent.mm.protocal.d.sYM;
                } else {
                    j = j2;
                }
                ac acVar = aVar.sZA;
                if (i == 1000) {
                    byte[] bArr3 = aVar.sZz;
                    w.d("MicroMsg.BackupCreateQRCodeOfflineScene", "BakMove key:" + bArr3);
                    if (!acVar.bHv()) {
                        bArr3 = new byte[0];
                    }
                    if (bg.bm(bArr3)) {
                        w.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[]{Integer.valueOf(i)});
                        return false;
                    }
                    if (MMProtocalJni.pack(aVar.zh(), pByteArray, bArr3, bArr, aVar.sZv, (int) j, 1000, acVar.ver, acVar.tal.getBytes(), acVar.tam.getBytes(), bArr2, i2)) {
                        w.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[]{Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2)});
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((b) pVar.zg()).sZr.thZ});
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1000;
    }
}
