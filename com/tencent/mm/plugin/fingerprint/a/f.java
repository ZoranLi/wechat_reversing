package com.tencent.mm.plugin.fingerprint.a;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.gp;
import com.tencent.mm.e.a.gp.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends c<gp> implements e {
    private String fJH;
    private boolean lNZ;
    private gp lOg;
    private int lOh;
    ae lOi;

    private class a implements com.tencent.mm.plugin.fingerprint.a.n.a {
        final /* synthetic */ f lOj;

        public a(f fVar) {
            this.lOj = fVar;
        }

        public final void pq(final String str) {
            this.lOj.lOi.post(new Runnable(this) {
                final /* synthetic */ a lOl;

                public final void run() {
                    if (TextUtils.isEmpty(str)) {
                        w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    ap.vd().a(new com.tencent.mm.plugin.fingerprint.b.e(str), 0);
                }
            });
        }
    }

    public f() {
        this.lOh = 0;
        this.fJH = "";
        this.lNZ = false;
        this.lOi = new ae(Looper.getMainLooper());
        this.usg = gp.class.getName().hashCode();
    }

    private boolean a(gp gpVar) {
        boolean z = false;
        if (ap.zb()) {
            w.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.lNZ = false;
            if (!(gpVar instanceof gp)) {
                return false;
            }
            if (e.avd()) {
                this.lOg = gpVar;
                ap.vd().a(385, this);
                boolean z2 = this.lOg.fLP.fLR;
                this.lOh = this.lOg.fLP.fLS;
                this.fJH = this.lOg.fLP.fLT;
                if (z2) {
                    w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    Object rsaKey = FingerPrintAuth.getRsaKey(e.ca(ab.getContext()), e.getUserId(), p.rB());
                    if (TextUtils.isEmpty(rsaKey)) {
                        w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        ap.vd().a(new com.tencent.mm.plugin.fingerprint.b.e(rsaKey), 0);
                    }
                }
                if (z) {
                    w.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new n(new a(this)).avz();
                }
                return true;
            }
            w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            b bVar = new b();
            bVar.fHO = false;
            this.lOg.fLQ = bVar;
            this.lNZ = true;
            afu();
            return true;
        }
        w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.b.e) {
            b bVar = new b();
            bVar.fHO = false;
            w.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.b.e eVar = (com.tencent.mm.plugin.fingerprint.b.e) kVar;
                String str2 = eVar.lOp;
                String str3 = eVar.fLV;
                String userId = e.getUserId();
                String rB = p.rB();
                String ccb = m.ccb();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.ca(ab.getContext()), userId, rB, String.valueOf(this.lOh), ccb, "", str2, str3, Build.MODEL))) {
                    w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.fHO = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.ca(ab.getContext()), userId, rB, String.valueOf(this.lOh), ccb, this.fJH, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.ca(ab.getContext()), e.getUserId(), p.rB(), genPayFPEncrypt);
                bVar.fLU = genPayFPEncrypt;
                bVar.fLV = userId;
            } else {
                w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            ap.vd().b(385, this);
            this.lOg.fLQ = bVar;
            this.lNZ = true;
            afu();
        }
    }

    private void afu() {
        w.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.lOg.nFq != null) {
            this.lOg.nFq.run();
        }
        if (this.lNZ) {
            this.lOg = null;
        }
    }
}
