package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.LoginUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c implements b, e {
    private SecurityImage uUx = null;
    private MobileInputUI vcZ;
    private a vdc = null;

    static /* synthetic */ class AnonymousClass3 {
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
        mobileInputUI.uZF.setVisibility(0);
        mobileInputUI.vdk.setVisibility(0);
        mobileInputUI.vdl.requestFocus();
        mobileInputUI.uZQ.setText(R.l.dHP);
        mobileInputUI.uZQ.setVisibility(0);
        mobileInputUI.vdp.setVisibility(0);
        mobileInputUI.vdq.setText(R.l.ewI);
        mobileInputUI.vdq.setVisibility(0);
        mobileInputUI.vdq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c vde;

            public final void onClick(View view) {
                mobileInputUI.nkt[0] = 1;
                Intent intent = new Intent();
                intent.setClass(mobileInputUI, LoginUI.class);
                mobileInputUI.startActivity(intent);
                mobileInputUI.finish();
            }
        });
    }

    public final void start() {
        ap.vd().a((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.mM("L200_100");
    }

    public final void stop() {
        ap.vd().b((int) a.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",2");
    }

    public final void zD(int i) {
        switch (AnonymousClass3.vdb[i - 1]) {
            case 1:
                this.vcZ.vdr = an.PD(this.vcZ.countryCode);
                this.vcZ.ota = this.vcZ.vdl.getText().toString();
                String PB = an.PB(this.vcZ.vdr + this.vcZ.ota);
                MobileInputUI mobileInputUI = this.vcZ;
                Context context = this.vcZ;
                this.vcZ.getString(R.l.dIO);
                mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.eJC), true, new OnCancelListener(this) {
                    final /* synthetic */ c vde;

                    {
                        this.vde = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ap.vd().a(new s(PB, 13, "", 0, ""), 0);
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vcZ.uYL != null) {
            this.vcZ.uYL.dismiss();
            this.vcZ.uYL = null;
        }
        if (kVar.getType() == 701 && this.vdc != null) {
            this.vdc.uZk = this.vcZ.uZk;
            this.vdc.a(this.vcZ, i, i2, str, kVar);
        } else if (kVar.getType() != a.CTRL_INDEX || ((s) kVar).AJ() != 13) {
        } else {
            if (i2 == -41) {
                com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this.vcZ, null, null);
                } else {
                    g.h(this.vcZ, R.l.eJJ, R.l.eJK);
                }
            } else if (i2 == -1) {
                Toast.makeText(this.vcZ, this.vcZ.getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i2 == -34) {
                g.b(this.vcZ, this.vcZ.getString(R.l.dNy), "", true);
            } else {
                this.vcZ.aHf();
                Intent intent = new Intent(this.vcZ, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", -1);
                intent.putExtra("mobile_auth_type", 7);
                intent.putExtra("input_country_code", this.vcZ.countryCode);
                intent.putExtra("input_mobile_number", this.vcZ.ota);
                this.vcZ.startActivity(intent);
            }
        }
    }
}
