package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.b.f.f;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private boolean isPaused = false;
    private Dialog lOO = null;
    private g lOP = null;
    private Animation lOR;
    private int lOS = 0;
    private TextView lOY;
    private c lOZ;
    private a lPa;
    private boolean lPb = false;
    private final int lPc = 1;

    public class a implements b {
        final /* synthetic */ FingerPrintAuthUI lPd;
        private WeakReference<FingerPrintAuthUI> lPg = null;

        public a(FingerPrintAuthUI fingerPrintAuthUI, FingerPrintAuthUI fingerPrintAuthUI2) {
            this.lPd = fingerPrintAuthUI;
            this.lPg = new WeakReference(fingerPrintAuthUI2);
        }

        private FingerPrintAuthUI avE() {
            if (this.lPg != null) {
                return (FingerPrintAuthUI) this.lPg.get();
            }
            return null;
        }

        public final void av(int i, int i2) {
            String string;
            switch (i) {
                case 0:
                    w.i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (avE() != null) {
                        FingerPrintAuthUI.a(avE(), i2);
                        return;
                    }
                    return;
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    w.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (avE() != null) {
                        this.lPd.ep(false);
                        return;
                    }
                    return;
                case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                    w.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (avE() != null) {
                        FingerPrintAuthUI.a(avE());
                        this.lPd.ep(true);
                        return;
                    }
                    return;
                case 2005:
                case 2007:
                case 10308:
                    w.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    string = ab.getContext().getString(R.l.eXb);
                    if (i == 10308) {
                        string = ab.getContext().getString(R.l.eXc);
                        com.tencent.mm.plugin.soter.c.a.c(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    }
                    if (avE() != null) {
                        avE().aT(string, -1);
                        return;
                    }
                    return;
                case 2009:
                    w.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    string = ab.getContext().getString(R.l.eXb);
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.c.a.ut(2);
                    if (avE() != null) {
                        avE().aT(string, -1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.lOS > 1) {
            fingerPrintAuthUI.lOS = currentTimeMillis;
            fingerPrintAuthUI.lOY.setText(R.l.ekN);
            fingerPrintAuthUI.lOY.setTextColor(fingerPrintAuthUI.getResources().getColor(R.e.aVD));
            fingerPrintAuthUI.lOY.setVisibility(4);
            if (fingerPrintAuthUI.lOR == null) {
                fingerPrintAuthUI.lOR = AnimationUtils.loadAnimation(fingerPrintAuthUI.uSU.uTo, R.a.aRb);
            }
            fingerPrintAuthUI.lOY.startAnimation(fingerPrintAuthUI.lOR);
            af.f(new Runnable(fingerPrintAuthUI) {
                final /* synthetic */ FingerPrintAuthUI lPd;

                {
                    this.lPd = r1;
                }

                public final void run() {
                    this.lPd.lOY.setVisibility(0);
                }
            }, fingerPrintAuthUI.lOR.getDuration());
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, int i) {
        fingerPrintAuthUI.lPb = false;
        c.abort();
        c.release();
        fingerPrintAuthUI.lOP.a(fingerPrintAuthUI, String.valueOf(i), 1);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!fingerPrintAuthUI.isPaused);
        w.i(str, str2, objArr);
        return !fingerPrintAuthUI.isPaused;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.eFl));
        this.lOY = (TextView) findViewById(R.h.bXN);
        com.tencent.mm.plugin.fingerprint.a.auQ();
        this.lOZ = com.tencent.mm.plugin.fingerprint.a.auR();
        this.lOP = c.auY();
        Bundle ah = com.tencent.mm.wallet_core.a.ah(this);
        if (ah != null) {
            Object string = ah.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                w.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                aT(getString(R.l.ekQ), -1);
                com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "get user pwd error");
                return;
            } else if (e.avd()) {
                da(true);
                f.cfX().cfY();
                this.lOP.a(this, new com.tencent.mm.pluginsdk.wallet.a(this) {
                    final /* synthetic */ FingerPrintAuthUI lPd;

                    {
                        this.lPd = r1;
                    }

                    public final void S(int i, String str) {
                        this.lPd.da(false);
                        if (i == 0) {
                            this.lPd.lPb = true;
                            if (FingerPrintAuthUI.c(this.lPd)) {
                                this.lPd.ep(false);
                                return;
                            }
                            return;
                        }
                        this.lPd.aT(str, i);
                    }
                }, string);
                return;
            } else {
                w.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                return;
            }
        }
        w.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        aT(getString(R.l.ekQ), -1);
        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
    }

    protected final void da(final boolean z) {
        af.v(new Runnable(this) {
            final /* synthetic */ FingerPrintAuthUI lPd;

            public final void run() {
                if (z) {
                    this.lPd.lOO = com.tencent.mm.wallet_core.ui.g.a(this.lPd, false, null);
                } else if (this.lPd.lOO != null && this.lPd.lOO.isShowing()) {
                    this.lPd.lOO.dismiss();
                    this.lPd.lOO = null;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (this.lPb) {
            ep(false);
        }
    }

    private void ep(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        c.abort();
        c.release();
        if (c.auX()) {
            if (this.lPa == null) {
                this.lPa = new a(this, this);
            }
            if (c.a(this.lPa, z) != 0) {
                w.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
                return;
            }
            return;
        }
        w.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }

    public void onPause() {
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.uSU.uTo.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        w.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.auQ();
        if (com.tencent.mm.plugin.fingerprint.a.auR() != null) {
            c.auW();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    public void onDestroy() {
        w.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.lOR != null) {
            this.lOR.cancel();
        }
        this.lPa = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (this.lOP.d(i, i2, str, kVar)) {
            return true;
        }
        if (!(kVar instanceof m)) {
            return false;
        }
        da(false);
        com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
        Toast.makeText(this, R.l.ekR, 0).show();
        return true;
    }

    private void aT(final String str, final int i) {
        af.v(new Runnable(this) {
            final /* synthetic */ FingerPrintAuthUI lPd;

            public final void run() {
                com.tencent.mm.ui.base.g.a(this.lPd, str, "", this.lPd.getString(R.l.esq), false, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 lPf;

                    {
                        this.lPf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.c(this.lPf.lPd, new Bundle(), i);
                    }
                });
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.ddd;
    }

    protected final int Ol() {
        return 1;
    }

    public final void S(int i, String str) {
        if (i == 0) {
            w.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            b(new m(null), false);
            return;
        }
        da(false);
        w.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        com.tencent.mm.ui.base.g.a(this, getString(R.l.ekQ), "", new OnClickListener(this) {
            final /* synthetic */ FingerPrintAuthUI lPd;

            {
                this.lPd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.wallet_core.a.c(this.lPd, new Bundle(), -1);
            }
        });
    }
}
