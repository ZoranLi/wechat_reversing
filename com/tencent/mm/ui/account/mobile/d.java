package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d implements b, e {
    private String uZL;
    private String uZM;
    private int uZV = 0;
    private MobileInputUI vcZ;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] vdb = new int[a.bRs().length];

        static {
            try {
                vdb[a.vdx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(final MobileInputUI mobileInputUI) {
        this.vcZ = mobileInputUI;
        String string = mobileInputUI.getString(R.l.eJX);
        if (com.tencent.mm.protocal.d.sYQ) {
            string = string + mobileInputUI.getString(R.l.dDc);
        }
        mobileInputUI.qP(string);
        mobileInputUI.ks(false);
        mobileInputUI.vdo.setVisibility(0);
        mobileInputUI.vdo.setVisibility(0);
        mobileInputUI.uZF.setVisibility(0);
        mobileInputUI.vdk.setVisibility(0);
        mobileInputUI.vdl.requestFocus();
        mobileInputUI.vdn.setVisibility(0);
        mobileInputUI.uZQ.setVisibility(0);
        mobileInputUI.uZQ.setText(R.l.exb);
        if (mobileInputUI.uZP != null) {
            mobileInputUI.uZP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d vdf;

                public final void onClick(View view) {
                    bg.F(mobileInputUI, mobileInputUI.getString(R.l.eZp));
                }
            });
        }
        string = mobileInputUI.getString(R.l.ewh);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (v.bIK()) {
            string2 = mobileInputUI.getString(R.l.ewi);
            string3 = mobileInputUI.getString(R.l.eGS);
            string4 = mobileInputUI.getString(R.l.dDh);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d vdf;

                public final void onClick(View view) {
                    bg.F(mobileInputUI.uSU.uTo, mobileInputUI.getString(R.l.eZp));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d vdf;

                public final void onClick(View view) {
                    bg.F(mobileInputUI.uSU.uTo, "http://www.qq.com/privacy.htm");
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.uZO.setText(newSpannable);
        } else {
            string2 = mobileInputUI.getString(R.l.ewk);
            string3 = mobileInputUI.getString(R.l.ewj);
            string4 = mobileInputUI.getString(R.l.dDh);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d vdf;

                public final void onClick(View view) {
                    bg.F(mobileInputUI.uSU.uTo, mobileInputUI.getString(R.l.eZt));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ d vdf;

                public final void onClick(View view) {
                    bg.F(mobileInputUI.uSU.uTo, mobileInputUI.getString(R.l.eZs));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.uZO.setText(newSpannable);
        }
        mobileInputUI.uZO.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void start() {
        ap.vd().a((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_100," + ap.ec("R200_100") + ",1");
        com.tencent.mm.plugin.c.b.mM("R200_100");
        this.uZV = 0;
    }

    public final void stop() {
        ap.vd().b((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_100," + ap.ec("R200_100") + ",2");
    }

    public final void zD(int i) {
        switch (AnonymousClass2.vdb[i - 1]) {
            case 1:
                this.vcZ.vdr = an.PD(this.vcZ.countryCode);
                this.vcZ.ota = this.vcZ.vdk.getText().toString();
                String str = this.vcZ.vdr + this.vcZ.ota;
                if (this.vcZ.uYL != null) {
                    w.d("MicroMsg.MobileInputRegLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.vcZ;
                Context context = this.vcZ;
                this.vcZ.getString(R.l.dIO);
                mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.eJC), true, new OnCancelListener(this) {
                    final /* synthetic */ d vdf;

                    {
                        this.vdf = r1;
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
        w.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vcZ.uYL != null) {
            this.vcZ.uYL.dismiss();
            this.vcZ.uYL = null;
        }
        if (i2 == -75) {
            g.h(this.vcZ, R.l.dDf, R.l.eJb);
        } else if (kVar.getType() != a.CTRL_INDEX) {
        } else {
            com.tencent.mm.f.a dn;
            if (i2 == -41 || i2 == -59) {
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this.vcZ, null, null);
                    return;
                } else {
                    g.h(this.vcZ, R.l.eJJ, R.l.eJK);
                    return;
                }
            }
            int AJ = ((s) kVar).AJ();
            if (AJ == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Fw = ((s) kVar).Fw();
                    if (!bg.mA(Fw)) {
                        this.vcZ.ota = Fw.trim();
                    }
                    this.vcZ.ota = an.PB(this.vcZ.ota);
                    this.uZM = this.vcZ.vdr + this.vcZ.ota;
                    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",1");
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.vcZ, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ d vdf;

                            {
                                this.vdf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.vdf.bRp();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ d vdf;

                            {
                                this.vdf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",2");
                            }
                        });
                        return;
                    }
                    bRp();
                    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",2");
                    return;
                } else if (i2 == -34) {
                    g.b(this.vcZ, this.vcZ.getString(R.l.dNy), "", true);
                    return;
                } else {
                    Toast.makeText(this.vcZ, this.vcZ.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (AJ == 14) {
                com.tencent.mm.plugin.c.b.mN("R200_300");
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.vcZ.vdr + " " + this.vcZ.vdk.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.vcZ.ota);
                intent.putExtra("country_name", this.vcZ.hJF);
                intent.putExtra("couttry_code", this.vcZ.countryCode);
                intent.putExtra("mobileverify_countdownsec", ((s) kVar).Fy());
                intent.putExtra("mobileverify_countdownstyle", ((s) kVar).Fz());
                intent.putExtra("mobileverify_fb", ((s) kVar).FA());
                intent.putExtra("mobileverify_reg_qq", ((s) kVar).FC());
                intent.putExtra("mobile_verify_purpose", 2);
                intent.setClass(this.vcZ, MobileVerifyUI.class);
                this.vcZ.startActivity(intent);
                c.hj(c.a.irW);
            }
        }
    }

    public final void bRp() {
        MobileInputUI mobileInputUI = this.vcZ;
        Context context = this.vcZ;
        this.vcZ.getString(R.l.dIO);
        mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.eJC), true, new OnCancelListener(this) {
            final /* synthetic */ d vdf;

            {
                this.vdf = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ap.vd().a(new s(this.vcZ.vdr + this.vcZ.ota, 14, "", 0, ""), 0);
    }
}
