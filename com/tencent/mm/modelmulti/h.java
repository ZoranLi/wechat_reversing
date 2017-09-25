package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private e gUD;
    private byte[] hKD;
    public long hKi = -1;
    private p htt;
    private int uin = 0;

    public static class b implements p {
        private final com.tencent.mm.protocal.x.a hKE = new com.tencent.mm.protocal.x.a();
        private final com.tencent.mm.protocal.x.b hKF = new com.tencent.mm.protocal.x.b();
        int uin;

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e zg() {
            return this.hKF;
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final d BG() {
            this.hKE.sZv = com.tencent.mm.compatible.d.p.rB();
            this.hKE.sZu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.hKE.sZt = com.tencent.mm.protocal.d.sYN;
            this.hKE.dj(this.uin);
            return this.hKE;
        }

        public final boolean BH() {
            return false;
        }

        public final int BD() {
            return 0;
        }
    }

    public static class a extends i {
        private final com.tencent.mm.protocal.x.a hKE = new com.tencent.mm.protocal.x.a();
        private final com.tencent.mm.protocal.x.b hKF = new com.tencent.mm.protocal.x.b();

        protected final /* bridge */ /* synthetic */ d zf() {
            return this.hKE;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e zg() {
            return this.hKF;
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }
    }

    public h(long j, byte[] bArr) {
        this.hKi = j;
        this.hKD = bArr;
    }

    public h(long j, byte[] bArr, int i) {
        this.hKi = j;
        this.hKD = bArr;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bg.bm(this.hKD)) {
            w.e("MicroMsg.NetSceneNotifyData", "dkpush %s", "get keyBuf failed");
            return -1;
        }
        if (this.uin == 0) {
            this.htt = new a();
        } else {
            this.htt = new b();
            ((b) this.htt).uin = this.uin;
        }
        w.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", Long.valueOf(this.hKi), bg.bk(this.hKD));
        ((com.tencent.mm.protocal.x.a) this.htt.BG()).hMJ = this.hKi;
        ((com.tencent.mm.protocal.x.a) this.htt.BG()).fKo = this.hKD;
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 268369922;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
    }
}
