package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.a.rv;
import com.tencent.mm.e.a.rv.b;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class t extends c<rv> implements e {
    private boolean lNZ;
    private rv rHH;

    public t() {
        this.lNZ = false;
        this.usg = rv.class.getName().hashCode();
    }

    private boolean a(rv rvVar) {
        if (rvVar instanceof rv) {
            this.lNZ = false;
            this.rHH = rvVar;
            ap.vd().a(385, this);
            ap.vd().a(1518, this);
            if (m.btS().bul()) {
                w.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (m.xY()) {
                    ap.vd().a(new a(), 0);
                } else {
                    ap.vd().a(new com.tencent.mm.plugin.wallet_core.b.m(null, 1), 0);
                }
            } else {
                boolean z;
                long az = bg.az(m.btS().rIr);
                w.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + az, new Object[]{Long.valueOf(r2.rIr), Long.valueOf(System.currentTimeMillis() / 1000)});
                if (az > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    w.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (m.xY()) {
                        ap.vd().a(new a(), 0);
                    } else {
                        ap.vd().a(new com.tencent.mm.plugin.wallet_core.b.m(null, 1), 0);
                    }
                } else {
                    this.lNZ = true;
                    w.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    a(0, "", null);
                }
            }
            return true;
        }
        w.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) || (kVar instanceof a)) {
            ap.vd().b(385, this);
            ap.vd().b(1518, this);
            this.lNZ = true;
            a(i2, str, kVar);
        }
    }

    private void a(int i, String str, k kVar) {
        boolean z = true;
        if (this.rHH != null) {
            this.rHH.fYR.errCode = i;
            this.rHH.fYR.fPf = str;
            this.rHH.fYR.fYT = m.btS().bum();
            b bVar = this.rHH.fYR;
            af btS = m.btS();
            boolean z2 = (btS.rIm != null && btS.rIm.buf()) || (btS.rwT != null && btS.rwT.size() > 0);
            z2 = z2 ? false : btS.rwS == null || btS.rwS.size() <= 0;
            bVar.fYU = z2;
            b bVar2 = this.rHH.fYR;
            af btS2 = m.btS();
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            btS2.d(arrayList, arrayList2);
            if (!af.bH(arrayList2)) {
                z = false;
            }
            bVar2.fYV = z;
            this.rHH.fYR.fYW = m.btS().buq().buf();
            this.rHH.fYR.fYX = m.btS().bup();
            this.rHH.fYR.fYY = m.btS().akr();
            this.rHH.fYR.fYZ = m.btS().bun();
            this.rHH.fYR.fZa = m.btS().buq().bui();
            this.rHH.fYR.fZb = "";
            if (kVar != null && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
                this.rHH.fYR.fZb = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZb;
                this.rHH.fYR.fZc = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZc;
                this.rHH.fYR.fZd = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZd;
                this.rHH.fYR.fZe = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZe;
                this.rHH.fYR.fZf = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZf;
                this.rHH.fYR.fZg = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZg;
                this.rHH.fYR.fZh = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZh;
                this.rHH.fYR.fZi = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZi;
                this.rHH.fYR.fZj = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZj;
                this.rHH.fYR.fZk = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZk;
                this.rHH.fYR.fZl = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZl;
                this.rHH.fYR.fZm = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZm;
                this.rHH.fYR.title = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).title;
                this.rHH.fYR.fZn = ((com.tencent.mm.plugin.wallet_core.b.m) kVar).fZn;
            }
            w.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.rHH.fYR.fYU + " hasNewTips : " + this.rHH.fYR.fYV + " swipeOn : " + this.rHH.fYR.fYW);
            if (this.rHH.nFq != null) {
                this.rHH.nFq.run();
            }
            if (this.rHH.fYR.fYS != null) {
                this.rHH.fYR.fYS.run();
            }
        }
        if (this.lNZ) {
            this.rHH = null;
        }
    }
}
