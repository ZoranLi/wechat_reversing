package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;

public final class k extends com.tencent.mm.y.k implements j {
    private WakerLock gJG = new WakerLock(ab.getContext());
    private e gUD;
    private final p htt;

    public static class a extends i {
        private final com.tencent.mm.protocal.aa.a hKQ = new com.tencent.mm.protocal.aa.a();
        private final b hKR = new b();

        protected final d zf() {
            return this.hKQ;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hKR;
        }

        public final int getType() {
            return 39;
        }

        public final String getUri() {
            return null;
        }

        public final int BD() {
            return 1;
        }
    }

    public k() {
        this.gJG.lock(3000, "NetSceneSynCheck");
        this.htt = new a();
        h.vJ();
        if (h.vI() != null) {
            h.vJ();
            if (h.vI().vr() != null) {
                h.vJ();
                com.tencent.mm.protocal.aa.a aVar = (com.tencent.mm.protocal.aa.a) this.htt.BG();
                aVar.hKD = bg.PT((String) h.vI().vr().get(8195, null));
                com.tencent.mm.protocal.aa.a aVar2 = (com.tencent.mm.protocal.aa.a) this.htt.BG();
                h.vJ();
                h.vG();
                aVar2.uin = com.tencent.mm.kernel.a.uH();
                ((com.tencent.mm.protocal.aa.a) this.htt.BG()).netType = com.tencent.mm.protocal.a.getNetType(ab.getContext());
                ((com.tencent.mm.protocal.aa.a) this.htt.BG()).sZE = com.tencent.mm.protocal.a.bGY();
                w.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                return;
            }
        }
        w.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        int a = a(eVar, this.htt, this);
        if (a == -1 && this.gJG.isLocking()) {
            this.gJG.unLock();
        }
        return a;
    }

    public final boolean BI() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        b bVar = (b) pVar.zg();
        w.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.taj);
        if (h.vG().uV() && !com.tencent.mm.kernel.a.uP()) {
            byte[] bArr2 = ((com.tencent.mm.protocal.aa.a) pVar.BG()).gXJ;
            if (bg.bm(bArr2)) {
                w.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.gXJ = bArr2;
            ((com.tencent.mm.plugin.zero.b.b) h.h(com.tencent.mm.plugin.zero.b.b.class)).Hy().a(bVar.taj, 2, bVar.bHr());
        }
        this.gUD.a(i2, i3, str, this);
        this.gJG.unLock();
    }
}
