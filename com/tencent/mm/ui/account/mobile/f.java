package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f implements b, e {
    public SecurityImage uUx = null;
    public com.tencent.mm.ui.account.f uYk = null;
    public MobileVerifyUI vdQ;
    private a vdc = null;

    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] vdT = new int[a.bRt().length];

        static {
            try {
                vdT[a.veC - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vdT[a.veD - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vdT[a.veE - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.vdQ = mobileVerifyUI;
    }

    public final void start() {
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_300," + ap.ec("F200_300") + ",1");
        com.tencent.mm.plugin.c.b.mM("F200_300");
    }

    public final void stop() {
        int i = 2;
        if (this.vdQ.ves != -1) {
            i = this.vdQ.ves;
        }
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",F200_300," + ap.ec("F200_300") + "," + i);
    }

    public final boolean zE(int i) {
        final k sVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass6.vdT[i - 1]) {
            case 1:
                ap.vd().a((int) a.CTRL_INDEX, (e) this);
                sVar = new s(this.vdQ.fOI, 9, this.vdQ.vcL.getText().toString().trim(), 0, "");
                ap.vd().a(sVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ f vdR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(sVar);
                        ap.vd().b((int) a.CTRL_INDEX, this.vdR);
                    }
                });
                break;
            case 2:
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_400," + ap.ec("R200_400") + ",1");
                ap.vd().a((int) a.CTRL_INDEX, (e) this);
                ap.vd().a(new s(this.vdQ.fOI, 8, "", 0, ""), 0);
                break;
            case 3:
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_350_auto," + ap.ec("R200_350_auto") + ",1");
                ap.vd().a((int) a.CTRL_INDEX, (e) this);
                sVar = new s(this.vdQ.fOI, 9, this.vdQ.vcL.getText().toString().trim(), 0, "");
                ap.vd().a(sVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ f vdR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(sVar);
                        ap.vd().b((int) a.CTRL_INDEX, this.vdR);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vdQ.isv != null) {
            this.vdQ.isv.dismiss();
            this.vdQ.isv = null;
        }
        if (this.uYk == null) {
            this.uYk = new com.tencent.mm.ui.account.f();
        }
        if (kVar.getType() != 701 || this.vdc == null) {
            com.tencent.mm.f.a dn;
            if (kVar.getType() == a.CTRL_INDEX) {
                this.uYk.hSs = ((s) kVar).getUsername();
                this.uYk.uYT = ((s) kVar).Ft();
                ap.vd().b((int) a.CTRL_INDEX, (e) this);
                if (((s) kVar).AJ() != 9) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    ap.vd().a(701, (e) this);
                    this.vdc = new a(new a.a(this) {
                        final /* synthetic */ f vdR;

                        {
                            this.vdR = r1;
                        }

                        public final void a(ProgressDialog progressDialog) {
                            this.vdR.vdQ.isv = progressDialog;
                        }
                    }, ((s) kVar).getUsername(), ((s) kVar).Ft(), this.vdQ.fOI);
                    this.vdc.h(this.vdQ);
                    return;
                } else if (i2 == -51) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.vdQ, null, null);
                        return;
                    } else {
                        g.h(this.vdQ, R.l.dOf, R.l.btr);
                        return;
                    }
                }
            }
            if (!this.vdQ.p(i, i2, str)) {
                if (kVar.getType() == 701) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null && dn.a(this.vdQ, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.vdQ, this.vdQ.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
                return;
            }
            return;
        }
        ap.vd().b(701, (e) this);
        this.uYk.uYU = ((u) kVar).FJ();
        this.uYk.uYW = ((u) kVar).FI();
        this.uYk.uYV = ((u) kVar).Jj();
        this.uYk.uYX = ((u) kVar).Ji();
        if (i2 == -6 || i2 == -311 || i2 == -310) {
            ap.vd().a(701, (e) this);
            if (this.uUx == null) {
                this.uUx = SecurityImage.a.a(this.vdQ, R.l.eKg, this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV, new OnClickListener(this) {
                    final /* synthetic */ f vdR;

                    {
                        this.vdR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.vdR.uYk.uYU + " img len" + this.vdR.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                        final k uVar = new u(this.vdR.uYk.hSs, this.vdR.uYk.uYT, this.vdR.uYk.uYX, this.vdR.uUx.bRz(), this.vdR.uUx.uYU, this.vdR.uUx.uYV, 1, "", false, true);
                        ap.vd().a(uVar, 0);
                        Context context = this.vdR.vdQ;
                        this.vdR.vdQ.getString(R.l.dIO);
                        g.a(context, this.vdR.vdQ.getString(R.l.ewX), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass3 vdS;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(uVar);
                                ap.vd().b(701, this.vdS.vdR);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ f vdR;

                    {
                        this.vdR = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.vdR.uUx = null;
                    }
                }, this.uYk);
                return;
            }
            w.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.uYk.uYU + " img len" + this.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
            this.uUx.a(this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV);
            return;
        }
        this.vdc.a(this.vdQ, i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            boolean Jp;
            if (kVar instanceof u) {
                Jp = ((u) kVar).Jp();
            } else {
                Jp = true;
            }
            this.vdQ.kE(Jp);
        }
    }
}
