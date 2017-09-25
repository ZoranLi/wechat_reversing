package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import com.tencent.d.a.c.h;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class k implements g {
    public WeakReference<WalletBaseUI> lOD = null;
    private a lOm = null;
    private a lOn = null;
    private String lOq = "";

    public final void a(Context context, a aVar, String str) {
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.lOD = new WeakReference((WalletBaseUI) context);
        this.lOm = aVar;
        this.lOq = str;
        ((WalletBaseUI) this.lOD.get()).hn(1586);
        ((WalletBaseUI) this.lOD.get()).hn(1638);
        com.tencent.mm.plugin.soter.c.a.blQ();
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        com.tencent.d.b.a.a(new b<c>(this) {
            final /* synthetic */ k lOE;

            {
                this.lOE = r1;
            }

            public final /* synthetic */ void a(e eVar) {
                c cVar = (c) eVar;
                w.i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
                if (cVar.isSuccess()) {
                    w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                    if (this.lOE.lOD == null || this.lOE.lOD.get() == null) {
                        this.lOE.T(-1, "base ui is null");
                        return;
                    } else {
                        ((WalletBaseUI) this.lOE.lOD.get()).b(new com.tencent.mm.plugin.fingerprint.b.a(), false);
                        return;
                    }
                }
                com.tencent.mm.plugin.soter.c.a.dj(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    w.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    w.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.d.b.a.De(1);
                    com.tencent.mm.plugin.soter.c.a.c(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    w.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.c.a.c(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    w.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.c.a.c(3, 4, cVar.errCode, cVar.fPf);
                } else {
                    w.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, cVar.errCode, cVar.fPf);
                }
                this.lOE.T(-1, cVar.fPf);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.b.c(this.lOq), new com.tencent.mm.plugin.soter.b.e());
    }

    public final void clear() {
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.lOD == null || this.lOD.get() == null)) {
            ((WalletBaseUI) this.lOD.get()).ho(1586);
            ((WalletBaseUI) this.lOD.get()).ho(1638);
        }
        this.lOm = null;
        q.rHB.reset();
        if (this.lOD != null && this.lOD.get() != null) {
            this.lOD.clear();
        }
    }

    public final void T(int i, String str) {
        if (this.lOm != null) {
            this.lOm.S(i, str);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (bg.mA(str)) {
            str = ab.getContext().getString(R.l.ekQ);
        }
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.b.a) {
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (bg.mA(((com.tencent.mm.plugin.fingerprint.b.a) kVar).lOH)) {
                    T(-1, str);
                    return true;
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ k lOE;

                    {
                        this.lOE = r1;
                    }

                    public final void run() {
                        this.lOE.T(0, "");
                    }
                });
            } else {
                w.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                T(i2, str);
                com.tencent.mm.plugin.soter.c.a.c(7, i, i2, "get challenge failed");
                return true;
            }
        }
        if (!(kVar instanceof com.tencent.mm.plugin.fingerprint.b.b)) {
            return false;
        }
        if (i2 == 0 && i == 0) {
            w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
            com.tencent.mm.plugin.soter.c.a.blR();
            com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
            U(0, str);
        } else {
            w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
            com.tencent.mm.plugin.soter.c.a.c(8, i, i2, "open fp pay failed");
            U(-1, str);
        }
        return true;
    }

    private void U(int i, String str) {
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.lOn.S(i, str);
        this.lOn = null;
    }

    public final void a(a aVar, String str, int i) {
        w.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.lOn = aVar;
        h hVar = q.rHB.rHD;
        if (hVar == null) {
            w.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.c.a.c(9, -1000223, -1, "signature is null");
            T(-1, ab.getContext().getString(R.l.ekQ));
        } else if (this.lOD != null && this.lOD.get() != null) {
            ((WalletBaseUI) this.lOD.get()).k(new com.tencent.mm.plugin.fingerprint.b.b(hVar.wZN, hVar.signature, this.lOq));
        }
    }
}
