package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public final class g implements com.tencent.mm.pluginsdk.wallet.g {
    private String fLV = null;
    public ae lOi = new ae(new com.tencent.mm.sdk.platformtools.ae.a(this) {
        final /* synthetic */ g lOr;

        {
            this.lOr = r1;
        }

        public final boolean handleMessage(Message message) {
            if (1 != message.what) {
                return false;
            }
            Object string = message.getData().getString("rsaKey");
            if (TextUtils.isEmpty(string)) {
                w.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lOs;

                    {
                        this.lOs = r1;
                    }

                    public final void run() {
                        this.lOs.lOr.lOm.S(-1, this.lOs.lOr.lOo.getString(R.l.ekQ));
                    }
                });
            }
            this.lOr.lOo.b(new e(string), false);
            return true;
        }
    });
    public com.tencent.mm.pluginsdk.wallet.a lOm = null;
    private com.tencent.mm.pluginsdk.wallet.a lOn = null;
    public WalletBaseUI lOo = null;
    private String lOp = null;
    private String lOq = null;

    private class a implements com.tencent.mm.plugin.fingerprint.a.n.a {
        final /* synthetic */ g lOr;

        public a(g gVar) {
            this.lOr = gVar;
        }

        public final void pq(final String str) {
            if (TextUtils.isEmpty(str)) {
                af.v(new Runnable(this) {
                    final /* synthetic */ a lOt;

                    {
                        this.lOt = r1;
                    }

                    public final void run() {
                        this.lOt.lOr.lOm.S(-1, this.lOt.lOr.lOo.getString(R.l.ekQ));
                    }
                });
                w.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                return;
            }
            af.v(new Runnable(this) {
                final /* synthetic */ a lOt;

                public final void run() {
                    w.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = this.lOt.lOr.lOi.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                }
            });
        }
    }

    public final void a(Context context, com.tencent.mm.pluginsdk.wallet.a aVar, String str) {
        this.lOo = (WalletBaseUI) context;
        this.lOm = aVar;
        this.lOq = str;
        Object rsaKey = FingerPrintAuth.getRsaKey(e.ca(ab.getContext()), e.getUserId(), p.rB());
        com.tencent.mm.plugin.soter.c.a.blQ();
        if (TextUtils.isEmpty(rsaKey)) {
            w.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new n(new a(this)).avz();
            return;
        }
        w.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.lOo.b(new e(rsaKey), false);
    }

    public final void clear() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        if (kVar instanceof e) {
            com.tencent.mm.pluginsdk.wallet.a aVar;
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) kVar;
                this.lOp = eVar.lOp;
                this.fLV = eVar.fLV;
                aVar = this.lOm;
                str = "";
            } else {
                w.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.lOm;
                i3 = -1;
                if (bg.mA(str)) {
                    str = this.lOo.getString(R.l.ekQ);
                }
            }
            aVar.S(i3, str);
            return true;
        } else if (!(kVar instanceof f)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.soter.c.a.blR();
                com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
                this.lOn.S(0, "");
            } else {
                this.lOn.S(-2, "");
            }
            return true;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.wallet.a aVar, String str, int i) {
        this.lOn = aVar;
        if (TextUtils.isEmpty(this.lOq)) {
            w.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.S(-1, this.lOo.getString(R.l.ekQ));
            return;
        }
        String userId = e.getUserId();
        String rB = p.rB();
        String ccb = m.ccb();
        String str2 = "";
        CharSequence charSequence = "";
        if (e.avd()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.ca(ab.getContext()), userId, rB, str, ccb, "", this.lOp, this.fLV, Build.MODEL);
            charSequence = FingerPrintAuth.genOpenFPSign(e.ca(ab.getContext()), e.getUserId(), p.rB(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.lOp)) {
            w.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(charSequence)) {
            w.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.lOo.b(new f(userId, charSequence, this.lOq, i), false);
    }
}
