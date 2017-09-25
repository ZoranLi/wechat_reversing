package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gcm.modelgcm.c.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private com.tencent.mm.y.e gUD = null;
    private p htt;
    private String mHJ = null;
    private int uin = 0;

    public static class a implements p {
        private final com.tencent.mm.plugin.gcm.modelgcm.c.a mHK = new com.tencent.mm.plugin.gcm.modelgcm.c.a();
        private final b mHL = new b();
        int uin;

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e zg() {
            return this.mHL;
        }

        public final int getType() {
            return 623;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/androidgcmreg";
        }

        public final d BG() {
            this.mHK.sZv = com.tencent.mm.compatible.d.p.rB();
            this.mHK.sZu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.mHK.sZt = com.tencent.mm.protocal.d.sYN;
            this.mHK.dj(this.uin);
            return this.mHK;
        }

        public final boolean BH() {
            return false;
        }

        public final int BD() {
            return 0;
        }
    }

    public e(String str, int i) {
        this.mHJ = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        this.htt = new a();
        ((a) this.htt).uin = this.uin;
        ((com.tencent.mm.plugin.gcm.modelgcm.c.a) this.htt.BG()).mHF.tcd = this.mHJ;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 623;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
