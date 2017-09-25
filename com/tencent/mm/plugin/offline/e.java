package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.i.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.pb.common.b.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String obq = "";
    private a obr = new a(this) {
        final /* synthetic */ e obs;

        {
            this.obs = r1;
        }

        public final void aPX() {
            this.obs.adZ();
        }
    };

    public final void adZ() {
        if (this.obn != null) {
            for (int i = 0; i < this.obn.size(); i++) {
                WeakReference weakReference = (WeakReference) this.obn.get(i);
                if (weakReference != null) {
                    b bVar = (b) weakReference.get();
                    if (bVar != null) {
                        bVar.afA();
                    }
                }
            }
        }
    }

    public e() {
        k.aQd();
        if (k.aQg() != null) {
            k.aQd();
            k.aQg().obU = this.obr;
        }
    }

    private static void aPV() {
        k.aQd();
        k.aQg().cF(1, 1);
    }

    public final String l(int i, int i2, String str) {
        int i3 = 0;
        int aPW = aPW();
        if (aPW > 0) {
            if (aPW < k.ocj) {
                w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[]{Integer.valueOf(k.ocj)});
                k.aQd();
                k.aQg().cE(2, 2);
            }
            k.aQd();
            String qL = k.qL(196617);
            if (TextUtils.isEmpty(qL)) {
                w.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + qL);
                return "";
            }
            com.tencent.mm.wallet_core.c.a.cbV();
            qL = com.tencent.mm.wallet_core.c.a.getToken(qL);
            if (TextUtils.isEmpty(qL)) {
                aPV();
                w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                return "";
            }
            if (qL != null) {
                w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s", new Object[]{Integer.valueOf(qL.length()), str});
            }
            ap.vd().a(new o(aPW - 1, i, i2, str), 0);
            w.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (aPW - 1));
            LinkedList Cc = com.tencent.mm.plugin.offline.c.a.Cc(com.tencent.mm.plugin.offline.c.a.aRb());
            if (Cc == null || Cc.size() == 0) {
                w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                aPV();
                return "";
            } else if (qL == null || !com.tencent.mm.plugin.offline.c.a.tb(qL)) {
                w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                return "";
            } else {
                long longValue = Long.valueOf(qL, 10).longValue();
                long j = 0;
                int i4 = 0;
                while (i4 < Cc.size()) {
                    long j2;
                    com.tencent.mm.plugin.offline.c.a.a aVar = (com.tencent.mm.plugin.offline.c.a.a) Cc.get(i4);
                    if (aVar == null || aVar.ofe == null || !aVar.ofe.equals(this.obq)) {
                        j2 = j;
                    } else {
                        j2 = (long) aVar.ofc;
                    }
                    i4++;
                    j = j2;
                }
                String valueOf = String.valueOf((j << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = "0" + valueOf;
                } else if (valueOf.length() == 14) {
                    valueOf = "00" + valueOf;
                } else if (valueOf.length() == 13) {
                    valueOf = "000" + valueOf;
                } else if (valueOf.length() == 12) {
                    valueOf = "0000" + valueOf;
                }
                if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.aRd())) {
                    return "12" + valueOf;
                }
                return com.tencent.mm.plugin.offline.c.a.aRd() + valueOf;
            }
        }
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.cB(ab.getContext()) ? 0 : 1);
        if (h.isNetworkConnected()) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        gVar.i(14163, objArr);
        g.oUh.a(135, 29, 1, true);
        if (am.isNetworkConnected(ab.getContext())) {
            g.oUh.a(135, 31, 1, true);
        } else {
            g.oUh.a(135, 30, 1, true);
        }
        aPV();
        w.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        return "";
    }

    public static int aPW() {
        k.aQd();
        k.aQg();
        return i.aQc();
    }
}
