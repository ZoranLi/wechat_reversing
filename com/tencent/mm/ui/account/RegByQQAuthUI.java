package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RegByQQAuthUI extends MMActivity implements e {
    private String fGV;
    private String fSe;
    private String hSs;
    private ProgressDialog isv = null;
    private String uYS;
    private EditText vaS = null;
    private int vaT;

    protected final int getLayoutId() {
        return R.i.dmA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ap.vd().a(126, this);
    }

    public void onPause() {
        super.onPause();
        ap.vd().b(126, this);
    }

    protected final void KC() {
        this.vaT = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.uYS = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.hSs = getIntent().getStringExtra("RegByQQ_Account");
        this.fGV = getIntent().getStringExtra("RegByQQ_Ticket");
        this.fSe = getIntent().getStringExtra("RegByQQ_Nick");
        w.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.vaT + "  pass:" + this.uYS + "  ticket:" + this.fGV);
        this.vaS = (EditText) findViewById(R.h.coa);
        if (!(this.fSe == null || this.fSe.equals(""))) {
            this.vaS.setText(this.fSe);
        }
        zi(R.l.eKd);
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByQQAuthUI vaU;

            {
                this.vaU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vaU.fSe = this.vaU.vaS.getText().toString().trim();
                if (this.vaU.fSe.equals("")) {
                    g.h(this.vaU, R.l.eZQ, R.l.dGS);
                } else {
                    final k wVar = new com.tencent.mm.modelsimple.w("", this.vaU.uYS, this.vaU.fSe, this.vaU.vaT, "", "", this.vaU.fGV, 2);
                    ap.vd().a(wVar, 0);
                    RegByQQAuthUI regByQQAuthUI = this.vaU;
                    Context context = this.vaU;
                    this.vaU.getString(R.l.dIO);
                    regByQQAuthUI.isv = g.a(context, this.vaU.getString(R.l.eKf), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 vaW;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(wVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByQQAuthUI vaU;

            {
                this.vaU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vaU.aHf();
                this.vaU.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!bg.bp(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 126:
                    ap.unhold();
                    ao.hlW.L("login_user_name", this.hSs);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent ak = a.imv.ak(this);
                    ak.addFlags(67108864);
                    ak.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, ak);
                    return;
                default:
                    return;
            }
        }
        boolean z;
        if (kVar.getType() == 126) {
            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
            if (dn != null) {
                dn.a(this, null, null);
                return;
            }
        }
        if (a.imw.a(this.uSU.uTo, i, i2, str)) {
            z = true;
        } else {
            if (i == 4) {
                switch (i2) {
                    case -75:
                        g.h(this.uSU.uTo, R.l.dDf, R.l.dIO);
                        z = true;
                        break;
                    case -72:
                        g.h(this.uSU.uTo, R.l.eJZ, R.l.dIO);
                        z = true;
                        break;
                    case -12:
                        g.h(this, R.l.eKc, R.l.eKb);
                        z = true;
                        break;
                    case -11:
                        g.h(this, R.l.eKa, R.l.eKb);
                        z = true;
                        break;
                    case -4:
                        g.h(this, R.l.dGQ, R.l.eKb);
                        z = true;
                        break;
                    case -1:
                        if (ap.vd().BR() == 5) {
                            g.h(this, R.l.eDp, R.l.eDo);
                            z = true;
                            break;
                        }
                    case -3:
                        g.h(this, R.l.dGR, R.l.eKb);
                        z = true;
                        break;
                }
            }
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getString(R.l.elL, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
