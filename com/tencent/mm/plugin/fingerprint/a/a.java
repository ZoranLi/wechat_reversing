package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bn;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;

public abstract class a implements d {
    public final void bY(Context context) {
        w.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (e.avp() && !auT()) {
            w.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
            w.i("MicroMsg.BaseFingerprintImp", "closeFP");
            final b bnVar = new bn();
            bnVar.nFq = new Runnable(this) {
                final /* synthetic */ a lNX;

                public final void run() {
                    if (bnVar.fEW == null) {
                        return;
                    }
                    if (bnVar.fEW.fEX == 0) {
                        w.i("MicroMsg.BaseFingerprintImp", "close finger print success!");
                        if (m.xY()) {
                            w.i("MicroMsg.BaseFingerprintImp", "now context is isPayUPay!");
                            return;
                        }
                        w.i("MicroMsg.BaseFingerprintImp", "do bound query, update data");
                        ap.vd().a(new com.tencent.mm.plugin.wallet_core.b.m(null, 1), 0);
                        return;
                    }
                    w.i("MicroMsg.BaseFingerprintImp", "close finger print failed!");
                }
            };
            com.tencent.mm.sdk.b.a.urY.a(bnVar, context.getMainLooper());
        } else if (p.gRg.gRo != 1) {
            w.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        } else if (e.avp() || !(e.avs() || e.avt())) {
            w.e("MicroMsg.BaseFingerprintImp", "mgr == null or not support FP or has show guide or show HWManager!");
        }
    }

    public final boolean auS() {
        return e.avp();
    }

    public final boolean auT() {
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        return c.auX();
    }

    public boolean auU() {
        return false;
    }

    public final void a(ko koVar, int i, String str) {
        w.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (koVar != null && koVar.fQZ.fRd != null) {
            koVar.fRa = new ko.b();
            koVar.fRa.errCode = i;
            koVar.fRa.fLU = "";
            koVar.fRa.fLV = "";
            koVar.fRa.fPf = str;
            koVar.fRa.fRf = type();
            koVar.fQZ.fRd.run();
        }
    }

    public final void ek(boolean z) {
        w.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[]{Boolean.valueOf(z)});
        e.el(z);
    }
}
