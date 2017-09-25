package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements e {
    private String fOI;
    private ProgressDialog isv = null;
    private EditText vap;
    private i vaq = null;
    private boolean var;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.var = getIntent().getBooleanExtra("is_sync_addr", false);
        this.fOI = getIntent().getExtras().getString("bindmcontact_mobile");
        KC();
        ap.vd().a(126, this);
    }

    public void onDestroy() {
        if (this.vaq != null) {
            i iVar = this.vaq;
            s sVar = iVar.uZv;
            sVar.cancel();
            sVar.fyI.KH();
            sVar.reset();
            iVar.text = null;
        }
        ap.vd().b(126, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dmy;
    }

    protected final void KC() {
        zi(R.l.eJM);
        this.vap = (EditText) findViewById(R.h.cxC);
        this.vap.addTextChangedListener(new c(this.vap, null, 16));
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileSetNickUI vas;

            {
                this.vas = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.vas.vap.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    g.h(this.vas, R.l.eZQ, R.l.eJP);
                } else {
                    this.vas.aHf();
                    final k wVar = new w("", this.vas.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", this.vas.fOI, this.vas.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    ap.vd().a(wVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = this.vas;
                    Context context = this.vas;
                    this.vas.getString(R.l.dIO);
                    regByMobileSetNickUI.isv = g.a(context, this.vas.getString(R.l.eKf), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 vau;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(wVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileSetNickUI vas;

            {
                this.vas = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vas.aHf();
                this.vas.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, com.tencent.mm.y.k r11) {
        /*
        r7 = this;
        r2 = 2;
        r6 = 0;
        r3 = 0;
        r1 = 1;
        r0 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "onSceneEnd: errType = ";
        r4.<init>(r5);
        r4 = r4.append(r8);
        r5 = " errCode = ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = " errMsg = ";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r4);
        r0 = r7.isv;
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r7.isv;
        r0.dismiss();
        r7.isv = r6;
    L_0x003b:
        r0 = com.tencent.mm.sdk.platformtools.bg.bp(r7);
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        return;
    L_0x0042:
        if (r8 != 0) goto L_0x0104;
    L_0x0044:
        if (r9 != 0) goto L_0x0104;
    L_0x0046:
        r0 = com.tencent.mm.u.m.xP();
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile status = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r5 = " isSync = ";
        r4 = r4.append(r5);
        r5 = r7.var;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.d(r3, r4);
        r3 = r7.var;
        if (r3 == 0) goto L_0x00f2;
    L_0x0071:
        r3 = -131073; // 0xfffffffffffdffff float:NaN double:NaN;
        r0 = r0 & r3;
        com.tencent.mm.modelfriend.m.Fi();
        r7.getApplicationContext();
        com.tencent.mm.modelfriend.a.EL();
    L_0x007e:
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile update = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.d(r3, r4);
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.vr();
        r4 = 7;
        r0 = java.lang.Integer.valueOf(r0);
        r3.set(r4, r0);
        r0 = r7.var;
        if (r0 != 0) goto L_0x00f6;
    L_0x00a7:
        r0 = r1;
    L_0x00a8:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.wQ();
        r3 = new com.tencent.mm.ao.g;
        r4 = 17;
        r3.<init>(r4, r0);
        r2.b(r3);
        r0 = com.tencent.mm.plugin.c.a.imw;
        r0.ou();
        r0 = com.tencent.mm.u.ao.hlW;
        r2 = "login_user_name";
        r3 = r7.fOI;
        r0.L(r2, r3);
        r0 = com.tencent.mm.plugin.c.a.imv;
        r0 = r0.ak(r7);
        r2 = "LauncherUI.enter_from_reg";
        r0.putExtra(r2, r1);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r0.addFlags(r2);
        r11 = (com.tencent.mm.modelsimple.w) r11;
        r2 = r11.hSP;
        if (r2 == 0) goto L_0x00f8;
    L_0x00df:
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.ui.bindqq.BindQQUI.class;
        r2.<init>(r7, r3);
        r3 = "bindqq_regbymobile";
        r1 = r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x00f2:
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 | r3;
        goto L_0x007e;
    L_0x00f6:
        r0 = r2;
        goto L_0x00a8;
    L_0x00f8:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.account.BindFacebookUI.class;
        r1.<init>(r7, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x0104:
        r0 = r11.getType();
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r0 != r4) goto L_0x0117;
    L_0x010c:
        r0 = com.tencent.mm.f.a.dn(r10);
        if (r0 == 0) goto L_0x0117;
    L_0x0112:
        r0.a(r7, r6, r6);
        goto L_0x0041;
    L_0x0117:
        r0 = com.tencent.mm.plugin.c.a.imw;
        r4 = r7.uSU;
        r4 = r4.uTo;
        r0 = r0.a(r4, r8, r9, r10);
        if (r0 == 0) goto L_0x0143;
    L_0x0123:
        r0 = r1;
    L_0x0124:
        if (r0 != 0) goto L_0x0041;
    L_0x0126:
        r0 = com.tencent.mm.R.l.elL;
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r8);
        r2[r3] = r4;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r1] = r4;
        r0 = r7.getString(r0, r2);
        r0 = android.widget.Toast.makeText(r7, r0, r3);
        r0.show();
        goto L_0x0041;
    L_0x0143:
        switch(r8) {
            case 4: goto L_0x0148;
            default: goto L_0x0146;
        };
    L_0x0146:
        r0 = r3;
        goto L_0x0124;
    L_0x0148:
        r0 = -7;
        if (r9 == r0) goto L_0x014f;
    L_0x014b:
        r0 = -10;
        if (r9 != r0) goto L_0x0158;
    L_0x014f:
        r0 = com.tencent.mm.R.l.eJa;
        r4 = com.tencent.mm.R.l.eJb;
        com.tencent.mm.ui.base.g.h(r7, r0, r4);
        r0 = r1;
        goto L_0x0124;
    L_0x0158:
        r0 = -75;
        if (r9 != r0) goto L_0x0146;
    L_0x015c:
        r0 = com.tencent.mm.R.l.dDf;
        r4 = com.tencent.mm.R.l.eJb;
        com.tencent.mm.ui.base.g.h(r7, r0, r4);
        r0 = r1;
        goto L_0x0124;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegByMobileSetNickUI.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }
}
