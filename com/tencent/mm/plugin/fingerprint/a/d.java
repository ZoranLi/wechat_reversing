package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Map;

public final class d extends a {
    private com.b.a.a lOa = null;
    private a lOb = new a(this);
    public b lOc = null;

    private class a implements com.b.a.a.b {
        final /* synthetic */ d lOd;

        public a(d dVar) {
            this.lOd = dVar;
        }

        public final void av(int i, int i2) {
            if (this.lOd.lOc != null) {
                this.lOd.lOc.av(i, i2);
            }
        }
    }

    public final boolean auZ() {
        boolean z;
        boolean z2;
        int[] nb = com.b.a.a.nb();
        if (nb != null) {
            for (int i : nb) {
                if (1 == i) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (p.gRg.gRo == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z && z2) {
            return true;
        }
        return false;
    }

    public final boolean ava() {
        this.lOa = com.b.a.a.mZ();
        int[] na = na();
        if (na == null || na.length <= 0) {
            w.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        ave();
        return na != null && na.length > 0;
    }

    private int[] na() {
        if (this.lOa != null) {
            return this.lOa.na();
        }
        w.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        return null;
    }

    public final void bZ(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public final void avb() {
        w.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (auZ()) {
            ad buq = m.btS().buq();
            if (buq == null || buq.buh()) {
                final ae aeVar = new ae(Looper.myLooper());
                w.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                e.post(new Runnable(this) {
                    final /* synthetic */ d lOd;

                    public final void run() {
                        if (!e.avq()) {
                            try {
                                Context context = ab.getContext();
                                w.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
                                if (!c.auV()) {
                                    w.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
                                } else if (e.cb(context) != 0) {
                                    e.em(false);
                                    w.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
                                } else {
                                    e.em(true);
                                    w.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                                w.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                                e.em(false);
                            }
                        }
                        if (!e.avr()) {
                            try {
                                ClassLoader classLoader = com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
                                if (TextUtils.isEmpty(k.dy("teec"))) {
                                    w.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                                    e.en(false);
                                } else {
                                    w.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                                    k.b("fingerprintauth", classLoader);
                                    e.en(true);
                                }
                            } catch (UnsatisfiedLinkError e2) {
                                w.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                e.en(false);
                            } catch (Throwable e3) {
                                w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                                w.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                                e.en(false);
                            }
                        }
                        aeVar.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lOe;

                            {
                                this.lOe = r1;
                            }

                            public final void run() {
                                try {
                                    w.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
                                    if (!e.avd()) {
                                        w.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
                                    } else if (m.btS().buj() || m.btS().bun()) {
                                        w.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
                                    } else {
                                        try {
                                            String userId = e.getUserId();
                                            w.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:" + userId);
                                            CharSequence rsaKey = FingerPrintAuth.getRsaKey(e.ca(ab.getContext()), userId, p.rB());
                                            if (TextUtils.isEmpty(rsaKey)) {
                                                w.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                                                rsaKey = FingerPrintAuth.genRsaKey(e.ca(ab.getContext()), e.getUserId(), p.rB());
                                            }
                                            if (TextUtils.isEmpty(rsaKey)) {
                                                w.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                                            } else {
                                                w.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                                            }
                                        } catch (UnsatisfiedLinkError e) {
                                            w.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                                        } catch (Throwable e2) {
                                            w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                                            w.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                        }
                                    }
                                } catch (UnsatisfiedLinkError e3) {
                                    w.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e3.getMessage());
                                } catch (Throwable e22) {
                                    w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e22, "", new Object[0]);
                                    w.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e22.getMessage());
                                }
                            }
                        });
                    }
                }, getClass().getName());
                return;
            }
            w.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            return;
        }
        w.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
    }

    public final boolean avc() {
        return true;
    }

    public final boolean avd() {
        return e.avd();
    }

    public final int a(b bVar, int i, boolean z) {
        if (this.lOa == null) {
            this.lOa = com.b.a.a.mZ();
        }
        if (this.lOa == null) {
            return -1;
        }
        this.lOc = bVar;
        this.lOa = com.b.a.a.mZ();
        return this.lOa.a(this.lOb, 0, na());
    }

    public final void ave() {
        this.lOc = null;
        if (this.lOa != null) {
            try {
                com.b.a.a aVar = this.lOa;
                if (aVar.aIA != null) {
                    aVar.aIA.removeMessages(8);
                }
                try {
                    aVar.aIy.b(aVar.aIz);
                    aVar.aIy.asBinder().unlinkToDeath(aVar.aIE, 0);
                } catch (RemoteException e) {
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                w.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e2.getMessage());
            }
            this.lOa = null;
            return;
        }
        w.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
    }

    public final void avf() {
        if (this.lOa != null) {
            try {
                this.lOa.abort();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                w.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
    }

    public final void a(ko koVar, int i) {
        Object genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.ca(ab.getContext()), e.getUserId(), p.rB(), String.valueOf(i), com.tencent.mm.wallet_core.c.m.ccb(), koVar != null ? koVar.fQZ.fLT : "", Build.MODEL);
        Object genOpenFPSign = FingerPrintAuth.genOpenFPSign(e.ca(ab.getContext()), e.getUserId(), p.rB(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            w.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            w.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            w.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            w.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        w.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (koVar != null && koVar.fQZ.fRd != null) {
            ko.b bVar = new ko.b();
            bVar.fRf = 1;
            bVar.errCode = 0;
            bVar.fLU = genPayFPEncrypt;
            bVar.fLV = genOpenFPSign;
            bVar.fLS = i;
            koVar.fRa = bVar;
            koVar.fQZ.fRd.run();
        }
    }

    public final void avg() {
        w.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
    }

    public final g auY() {
        return new g();
    }

    public final Map<String, String> avh() {
        return null;
    }

    public final h avi() {
        return null;
    }

    public final Map<String, String> avj() {
        return null;
    }

    public final boolean avk() {
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void auW() {
        avf();
        ave();
    }

    public final int type() {
        return 1;
    }
}
