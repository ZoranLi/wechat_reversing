package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class BindMContactVerifyUI extends MMWizardActivity implements e {
    private String fOI;
    private int fromScene = 0;
    private SharedPreferences hgx;
    private p irJ = null;
    private boolean jFm = false;
    private int status;
    private EditText vcL;
    private Button vcO;
    private boolean vcP = false;
    private boolean vcR = false;
    private TextView vdD;
    private boolean vtG = false;
    private boolean vtS = false;
    private boolean vtU = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(132, (e) this);
        zi(R.l.dNS);
        this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = m.xP();
        KC();
    }

    public void onDestroy() {
        ap.vd().b(132, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cVE;
    }

    protected final void KC() {
        ap.yY();
        this.fOI = (String) c.vr().get(4097, null);
        this.vcL = (EditText) findViewById(R.h.btq);
        this.vcP = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.vtG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.vcR = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.vtU = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
        this.vtS = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.jFm = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(R.h.btn);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(6, null);
        }
        this.vcL.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ BindMContactVerifyUI vtV;

            {
                this.vtV = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return bg.K(charSequence);
            }
        }});
        this.vcO = (Button) findViewById(R.h.bts);
        this.vdD = (TextView) findViewById(R.h.bto);
        boolean z = this.vtU;
        if (z) {
            this.status &= -513;
        } else {
            this.status |= 512;
        }
        this.hgx.edit().putBoolean("settings_find_me_by_mobile", z).commit();
        w.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
        this.vdD.setText(getString(R.l.dNJ, new Object[]{this.fOI}));
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI vtV;

            {
                this.vtV = r1;
            }

            public final void onClick(View view) {
                String trim = this.vtV.vcL.getText().toString().trim();
                if (trim.equals("")) {
                    g.h(this.vtV, R.l.dOl, R.l.dIO);
                    return;
                }
                this.vtV.aHf();
                b hhVar = new hh();
                hhVar.fMI.context = this.vtV;
                a.urY.m(hhVar);
                String str = hhVar.fMJ.fMK;
                hhVar = new hi();
                a.urY.m(hhVar);
                String str2 = hhVar.fML.fMM;
                int i = 2;
                if (this.vtV.vtS) {
                    i = 19;
                }
                final k tVar = new t(this.vtV.fOI, i, trim, "", str, str2);
                ap.vd().a(tVar, 0);
                BindMContactVerifyUI bindMContactVerifyUI = this.vtV;
                Context context = this.vtV;
                this.vtV.getString(R.l.dIO);
                bindMContactVerifyUI.irJ = g.a(context, this.vtV.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 vtW;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(tVar);
                    }
                });
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI vtV;

            {
                this.vtV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vtV.zu(1);
                return true;
            }
        });
        this.vcO.setVisibility(com.tencent.mm.ai.b.jN(this.fOI) ? 0 : 8);
        this.vcO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI vtV;

            {
                this.vtV = r1;
            }

            public final void onClick(View view) {
                this.vtV.aHf();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.vtV.fOI);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.c.a.imv.e(this.vtV, intent);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        zu(1);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).AJ() == 2 || ((t) kVar).AJ() == 19) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            boolean z;
            if (i != 0 || i2 != 0) {
                com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                    return;
                }
                if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            dn = com.tencent.mm.f.a.dn(str);
                            if (dn != null) {
                                dn.a(this, null, null);
                            }
                            z = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dNv, 0).show();
                            z = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dNx, 0).show();
                            z = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dNA, 0).show();
                            z = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dNw, 0).show();
                            z = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dNy, 0).show();
                            z = true;
                            break;
                        case -33:
                            g.a((Context) this, R.l.dOf, R.l.btr, null);
                            z = true;
                            break;
                        case -32:
                            g.a((Context) this, R.l.dOg, R.l.btr, null);
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                z = true;
                if (!z) {
                    Toast.makeText(this, getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).AJ() != 2 && ((t) kVar).AJ() != 19) {
            } else {
                if (this.fromScene == 5) {
                    w.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
                    zu(-1);
                } else if (this.vcP) {
                    if (!m.xT()) {
                        b rcVar = new rc();
                        rcVar.fYc.fYd = true;
                        rcVar.fYc.fYe = true;
                        a.urY.m(rcVar);
                    }
                    zu(1);
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.c.a.imv.d((Context) this, intent);
                } else if (this.vcR) {
                    zu(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else {
                    int i3;
                    z = (this.status & 512) > 0;
                    ap.yY();
                    c.vr().set(7, Integer.valueOf(this.status));
                    com.tencent.mm.bd.a suVar = new su();
                    suVar.tAG = 8;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    suVar.tAH = i3;
                    ap.yY();
                    c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, suVar));
                    com.tencent.mm.plugin.c.a.imw.ou();
                    if (!this.vtG) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.EL();
                    }
                    if (this.vtS) {
                        g.bl(this, getString(R.l.dNo));
                    }
                    if (this.jFm) {
                        if (this.vtG) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11002, Integer.valueOf(3), Integer.valueOf(3));
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11002, Integer.valueOf(1), Integer.valueOf(2));
                        }
                    }
                    MMWizardActivity.z(this, new Intent(this, BindMContactStatusUI.class));
                }
            }
        }
    }
}
