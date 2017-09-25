package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gcm.modelgcm.d.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private e gUD = null;
    private p htt;
    private String mHJ = null;
    private int uin = 0;

    public static class a implements p {
        private final com.tencent.mm.plugin.gcm.modelgcm.d.a mHM = new com.tencent.mm.plugin.gcm.modelgcm.d.a();
        private final b mHN = new b();
        int uin;

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e zg() {
            return this.mHN;
        }

        public final int getType() {
            return 624;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/androidgcmunreg";
        }

        public final d BG() {
            this.mHM.sZv = com.tencent.mm.compatible.d.p.rB();
            this.mHM.sZu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.mHM.sZt = com.tencent.mm.protocal.d.sYN;
            this.mHM.dj(this.uin);
            return this.mHM;
        }

        public final boolean BH() {
            return false;
        }

        public final int BD() {
            return 0;
        }
    }

    public f(String str, int i) {
        this.mHJ = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        this.htt = new a();
        ((a) this.htt).uin = this.uin;
        ((com.tencent.mm.plugin.gcm.modelgcm.d.a) this.htt.BG()).mHH.tcd = this.mHJ;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 624;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
