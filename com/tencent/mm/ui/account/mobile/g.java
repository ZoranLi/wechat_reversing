package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g implements b, e {
    private String kwg = null;
    private MobileVerifyUI vdQ;
    private String vdU = "";
    private int vdV = 2;

    static /* synthetic */ class AnonymousClass3 {
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
        this.kwg = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.vdU = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.vdV = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean zE(int i) {
        com.tencent.mm.sdk.b.b hhVar;
        String str;
        String str2;
        final k tVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass3.vdT[i - 1]) {
            case 1:
                hhVar = new hh();
                hhVar.fMI.context = this.vdQ;
                a.urY.m(hhVar);
                str = hhVar.fMJ.fMK;
                hhVar = new hi();
                a.urY.m(hhVar);
                str2 = hhVar.fML.fMM;
                ap.vd().a(132, (e) this);
                tVar = new t(this.vdQ.fOI, 2, this.vdQ.vcL.getText().toString().trim(), "", str, str2);
                ap.vd().a(tVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = com.tencent.mm.ui.base.g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ g vdW;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(tVar);
                        ap.vd().b(132, this.vdW);
                    }
                });
                break;
            case 2:
                ap.vd().a(132, (e) this);
                ap.vd().a(new t(this.vdQ.fOI, 1, "", 0, ""), 0);
                break;
            case 3:
                hhVar = new hh();
                hhVar.fMI.context = this.vdQ;
                a.urY.m(hhVar);
                str = hhVar.fMJ.fMK;
                hhVar = new hi();
                a.urY.m(hhVar);
                str2 = hhVar.fML.fMM;
                ap.vd().a(132, (e) this);
                tVar = new t(this.vdQ.fOI, 2, this.vdQ.vcL.getText().toString().trim(), "", str, str2);
                ap.vd().a(tVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = com.tencent.mm.ui.base.g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ g vdW;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(tVar);
                        ap.vd().b(132, this.vdW);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        w.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vdQ.isv != null) {
            this.vdQ.isv.dismiss();
            this.vdQ.isv = null;
        }
        if (kVar.getType() == 132) {
            ap.vd().b(132, (e) this);
            if (((t) kVar).AJ() == 2 && i == 0 && i2 == 0) {
                ap.unhold();
                if (com.tencent.mm.pluginsdk.a.dp(this.vdQ).size() != 0) {
                    i3 = 1;
                }
                Intent ak;
                if (this.vdU == null || !this.vdU.contains("1") || r0 == 0) {
                    ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                    ak.addFlags(67108864);
                    this.vdQ.startActivity(ak);
                    this.vdQ.ves = 4;
                    this.vdQ.finish();
                    return;
                }
                com.tencent.mm.plugin.c.b.mN("R300_300_QQ");
                ak = new Intent(this.vdQ, FindMContactAddUI.class);
                ak.addFlags(67108864);
                ak.putExtra("regsetinfo_ticket", this.kwg);
                ak.putExtra("regsetinfo_NextStep", this.vdU);
                ak.putExtra("regsetinfo_NextStyle", this.vdV);
                ak.putExtra("login_type", 1);
                Intent ak2 = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                ak2.addFlags(67108864);
                MMWizardActivity.b(this.vdQ, ak, ak2);
                this.vdQ.finish();
            }
        } else if (!this.vdQ.p(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.vdQ, this.vdQ.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
