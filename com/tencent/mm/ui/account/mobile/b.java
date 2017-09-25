package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b implements com.tencent.mm.ui.account.mobile.MobileInputUI.b, e {
    private String uZL;
    private String uZM;
    private int uZV = 0;
    private MobileInputUI vcZ;

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] vdb = new int[a.bRs().length];

        static {
            try {
                vdb[a.vdx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.vcZ = mobileInputUI;
        mobileInputUI.vdl.requestFocus();
        mobileInputUI.aHj();
        String string = mobileInputUI.getString(R.l.eJY);
        if (d.sYQ) {
            string = string + mobileInputUI.getString(R.l.dDc);
        }
        mobileInputUI.qP(string);
        mobileInputUI.uZF.setVisibility(0);
        mobileInputUI.vdk.setVisibility(0);
        mobileInputUI.vdl.requestFocus();
        mobileInputUI.uZQ.setText(R.l.dHP);
        mobileInputUI.uZQ.setVisibility(0);
    }

    public final void start() {
        ap.vd().a((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_100," + ap.ec("F200_100") + ",1");
        com.tencent.mm.plugin.c.b.mM("F200_100");
        this.uZV = 0;
    }

    public final void stop() {
        ap.vd().b((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",F200_100," + ap.ec("F200_100") + ",2");
    }

    public final void zD(int i) {
        switch (AnonymousClass5.vdb[i - 1]) {
            case 1:
                this.vcZ.vdr = an.PD(this.vcZ.countryCode);
                this.vcZ.ota = this.vcZ.vdk.getText().toString();
                String str = this.vcZ.vdr + this.vcZ.ota;
                if (this.vcZ.uYL != null) {
                    w.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.vcZ;
                Context context = this.vcZ;
                this.vcZ.getString(R.l.dIO);
                mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.eJC), true, new OnCancelListener(this) {
                    final /* synthetic */ b vda;

                    {
                        this.vda = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                String obj = this.vcZ.vdk.getText().toString();
                int i2 = (this.uZL == null || this.uZM == null || obj.equals(this.uZL) || !obj.equals(this.uZM)) ? (this.uZL == null || this.uZM == null || this.uZM.equals(this.uZL) || obj.equals(this.uZM)) ? 0 : 2 : 1;
                k sVar = new s(str, 12, "", 0, "");
                sVar.fG(this.uZV);
                sVar.fH(i2);
                ap.vd().a(sVar, 0);
                this.uZL = this.vcZ.vdk.getText().toString();
                this.uZV++;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vcZ.uYL != null) {
            this.vcZ.uYL.dismiss();
            this.vcZ.uYL = null;
        }
        if (i2 == -75) {
            g.h(this.vcZ, R.l.dDf, R.l.eJb);
        } else if (i2 == -41 || i2 == -59) {
            r0 = com.tencent.mm.f.a.dn(str);
            if (r0 != null) {
                r0.a(this.vcZ, null, null);
            } else {
                g.h(this.vcZ, R.l.eJJ, R.l.eJK);
            }
        } else if (kVar.getType() == a.CTRL_INDEX) {
            int AJ = ((s) kVar).AJ();
            if (AJ == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Fw = ((s) kVar).Fw();
                    if (!bg.mA(Fw)) {
                        this.vcZ.ota = Fw.trim();
                    }
                    this.vcZ.ota = an.PB(this.vcZ.ota);
                    this.uZM = this.vcZ.vdr + this.vcZ.ota;
                    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",1");
                    r0 = com.tencent.mm.f.a.dn(str);
                    if (r0 != null) {
                        r0.a(this.vcZ, new OnClickListener(this) {
                            final /* synthetic */ b vda;

                            {
                                this.vda = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.vda.bRp();
                                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ b vda;

                            {
                                this.vda = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
                            }
                        });
                        return;
                    }
                    bRp();
                    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
                    return;
                } else if (i2 == -34) {
                    g.b(this.vcZ, this.vcZ.getString(R.l.dNy), "", true);
                    return;
                } else {
                    Toast.makeText(this.vcZ, this.vcZ.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (AJ == 8 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.vcZ.vdr + " " + this.vcZ.vdk.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.vcZ.ota);
                intent.putExtra("country_name", this.vcZ.hJF);
                intent.putExtra("couttry_code", this.vcZ.countryCode);
                intent.putExtra("mobileverify_countdownsec", ((s) kVar).Fy());
                intent.putExtra("mobileverify_countdownstyle", ((s) kVar).Fz());
                intent.putExtra("mobileverify_fb", ((s) kVar).FA());
                intent.putExtra("mobileverify_reg_qq", ((s) kVar).FC());
                intent.putExtra("mobile_verify_purpose", 3);
                intent.setClass(this.vcZ, MobileVerifyUI.class);
                this.vcZ.startActivity(intent);
            }
        }
    }

    public final void bRp() {
        MobileInputUI mobileInputUI = this.vcZ;
        Context context = this.vcZ;
        this.vcZ.getString(R.l.dIO);
        mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.eJC), true, new OnCancelListener(this) {
            final /* synthetic */ b vda;

            {
                this.vda = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ap.vd().a(new s(this.vcZ.vdr + this.vcZ.ota, 8, "", 0, ""), 0);
    }
}
