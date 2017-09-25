package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.f.f;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private i lON = null;
    Dialog lOO;
    private g lOP = null;
    private int lOQ = -1;
    private Animation lOR;
    private int lOS = 0;
    private boolean lOT = false;
    private int lOU = 0;
    private boolean lOV = false;
    private b lOc = new b(this) {
        final /* synthetic */ FingerPrintAuthTransparentUI lOW;

        {
            this.lOW = r1;
        }

        public final void av(int i, int i2) {
            String string;
            switch (i) {
                case 0:
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    this.lOW.lOQ = i2;
                    FingerPrintAuthTransparentUI.a(this.lOW);
                    return;
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    return;
                case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.b(this.lOW);
                    this.lOW.ep(true);
                    return;
                case 2005:
                case 2007:
                case 10308:
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    string = ab.getContext().getString(R.l.eXb);
                    if (i == 10308) {
                        string = ab.getContext().getString(R.l.eXc);
                        com.tencent.mm.plugin.soter.c.a.c(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    }
                    this.lOW.V(-1, string);
                    return;
                case 2009:
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    string = ab.getContext().getString(R.l.eXb);
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.c.a.ut(2);
                    this.lOW.V(-1, string);
                    return;
                default:
                    return;
            }
        }
    };
    View view = null;

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        fingerPrintAuthTransparentUI.lOT = false;
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        c.release();
        fingerPrintAuthTransparentUI.lON.dismiss();
        fingerPrintAuthTransparentUI.lOP.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.lOQ, 2);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.lOS > 1) {
            fingerPrintAuthTransparentUI.lOS = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(R.h.cIN)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(R.h.bMv);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.lOR == null) {
                fingerPrintAuthTransparentUI.lOR = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.uSU.uTo, R.a.aRb);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.lOR);
            af.f(new Runnable(fingerPrintAuthTransparentUI) {
                final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                public final void run() {
                    textView.setVisibility(0);
                }
            }, fingerPrintAuthTransparentUI.lOR.getDuration());
        }
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        com.tencent.mm.plugin.soter.c.a.di(2, fingerPrintAuthTransparentUI.lOU);
        if (z) {
            com.tencent.mm.plugin.soter.c.a.c(10, -1000223, -1, "user permanent cancelled");
            w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(true));
        } else {
            w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        com.tencent.mm.plugin.soter.c.a.di(3, fingerPrintAuthTransparentUI.lOU);
        Bundle ah = com.tencent.mm.wallet_core.a.ah(fingerPrintAuthTransparentUI);
        String str = "";
        if (ah != null) {
            str = ah.getString("key_pwd1");
        }
        fingerPrintAuthTransparentUI.lOP.a(fingerPrintAuthTransparentUI, new com.tencent.mm.pluginsdk.wallet.a(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI lOW;

            {
                this.lOW = r1;
            }

            public final void S(int i, String str) {
                this.lOW.da(false);
                if (i == 0) {
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                    FingerPrintAuthTransparentUI.d(this.lOW);
                    this.lOW.ep(false);
                    return;
                }
                this.lOW.V(-1, str);
            }
        }, str);
        fingerPrintAuthTransparentUI.da(true);
        if (fingerPrintAuthTransparentUI.lON != null && fingerPrintAuthTransparentUI.lON.isShowing()) {
            fingerPrintAuthTransparentUI.lON.dismiss();
        }
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        w.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(R.i.ddc, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        ViewGroup viewGroup = parent != null ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(R.h.bPR)).setOnClickListener(new OnClickListener(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI lOW;

            {
                this.lOW = r1;
            }

            public final void onClick(View view) {
                if (this.lOW.lON != null) {
                    this.lOW.lON.cancel();
                }
                FingerPrintAuthTransparentUI.avC();
                this.lOW.finish();
            }
        });
        if (fingerPrintAuthTransparentUI.lON != null && fingerPrintAuthTransparentUI.lON.isShowing()) {
            fingerPrintAuthTransparentUI.lON.dismiss();
            fingerPrintAuthTransparentUI.lON = null;
        }
        fingerPrintAuthTransparentUI.lON = new i(fingerPrintAuthTransparentUI, R.m.foN);
        fingerPrintAuthTransparentUI.lON.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.lON.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.lON.setCancelable(true);
        fingerPrintAuthTransparentUI.lON.show();
        fingerPrintAuthTransparentUI.lON.setOnCancelListener(new OnCancelListener(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI lOW;

            {
                this.lOW = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.avC();
                this.lOW.finish();
            }
        });
        com.tencent.mm.ui.base.g.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.lON);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.avd()) {
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
        } else if (m.xY()) {
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
        } else if (e.avp()) {
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
        } else {
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            if (c.auX()) {
                if (p.gRg.gRo != 1) {
                    w.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                com.tencent.mm.plugin.wallet_core.model.af btS = com.tencent.mm.plugin.wallet_core.model.m.btS();
                com.tencent.mm.plugin.fingerprint.a.auQ();
                com.tencent.mm.plugin.fingerprint.a.auR();
                this.lOP = c.auY();
                this.lOV = h.vI().vr().c(com.tencent.mm.storage.w.a.uBj, false);
                if (!btS.bum() || e.avp()) {
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + btS.bum() + ";isOpenTouch:" + e.avp());
                    w.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    return;
                }
                w.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                f.cfX().cfY();
                com.tencent.mm.plugin.report.service.g.oUh.i(12924, new Object[]{Integer.valueOf(1)});
                com.tencent.mm.plugin.soter.c.a.ur(0);
                if (h.vI().vr().c(com.tencent.mm.storage.w.a.uBg, true)) {
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    h.vI().vr().a(com.tencent.mm.storage.w.a.uBg, Boolean.valueOf(false));
                    h.vI().vr().a(com.tencent.mm.storage.w.a.uBj, Boolean.valueOf(false));
                    com.tencent.mm.ui.base.g.a(this, this.lOV ? getString(R.l.eqK) : getString(R.l.eqJ), "", getString(R.l.dPN), getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                        {
                            this.lOW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FingerPrintAuthTransparentUI.c(this.lOW);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                        {
                            this.lOW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FingerPrintAuthTransparentUI.b(this.lOW, false);
                        }
                    });
                    h.vI().vr().a(com.tencent.mm.storage.w.a.uBi, Integer.valueOf(1));
                    this.lOU = 1;
                    com.tencent.mm.plugin.soter.c.a.di(1, this.lOU);
                    return;
                }
                w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                View inflate = LayoutInflater.from(this).inflate(R.i.ddf, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.bPY);
                this.lOU = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uBi, null)).intValue() + 1;
                h.vI().vr().a(com.tencent.mm.storage.w.a.uBi, Integer.valueOf(this.lOU));
                com.tencent.mm.plugin.soter.c.a.di(1, this.lOU);
                com.tencent.mm.ui.base.g.a(this, false, null, inflate, getString(R.l.dPN), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                    {
                        this.lOW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FingerPrintAuthTransparentUI.c(this.lOW);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FingerPrintAuthTransparentUI.b(this.lOW, checkBox.isChecked());
                    }
                });
                return;
            }
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.lOT) {
            ep(false);
        }
    }

    public void onPause() {
        super.onPause();
        w.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.uSU.uTo.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        avC();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    private void ep(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        c.abort();
        c.release();
        if (!c.auX()) {
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        } else if (c.a(this.lOc, z) != 0) {
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
        }
    }

    private static void avC() {
        w.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.auQ();
        if (com.tencent.mm.plugin.fingerprint.a.auR() != null) {
            c.auW();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return this.lOP.d(i, i2, str, kVar);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void finish() {
        if (this.lOP != null) {
            this.lOP.clear();
        }
        super.finish();
    }

    private void V(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        com.tencent.mm.ui.base.g.a(this, string, "", getString(R.l.esq), false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FingerPrintAuthTransparentUI lOW;

            {
                this.lOW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
                dialogInterface.dismiss();
                this.lOW.finish();
            }
        });
    }

    protected final void da(boolean z) {
        if (z) {
            this.lOO = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else if (this.lOO != null && this.lOO.isShowing()) {
            this.lOO.dismiss();
            this.lOO = null;
        }
    }

    public void onDestroy() {
        if (this.lON != null && this.lON.isShowing()) {
            this.lON.dismiss();
            this.lON = null;
        }
        if (this.lOR != null) {
            this.lOR.cancel();
        }
        da(false);
        super.onDestroy();
    }

    protected final int Ol() {
        return 1;
    }

    public final void S(int i, String str) {
        da(false);
        if (i == 0) {
            w.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            b(new com.tencent.mm.plugin.wallet_core.b.m(null), false);
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, false, null, LayoutInflater.from(this).inflate(R.i.ddb, null), getString(R.l.esq), "", new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                {
                    this.lOW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
                    this.lOW.finish();
                }
            }, null);
        } else if (i == -2) {
            String string;
            w.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            int i2 = R.l.ekQ;
            if (TextUtils.isEmpty(str)) {
                string = getString(i2);
            } else {
                string = str;
            }
            com.tencent.mm.ui.base.g.a(this, string, "", getString(R.l.ekU), getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                {
                    this.lOW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
                    FingerPrintAuthTransparentUI.d(this.lOW);
                    this.lOW.ep(false);
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI lOW;

                {
                    this.lOW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lOW.finish();
                }
            });
        } else {
            V(-1, str);
        }
    }
}
