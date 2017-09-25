package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.modelsimple.BindWordingContent;
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
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements e {
    private String fOI;
    private p irJ = null;
    private Timer okA;
    private boolean vcI = false;
    private EditText vcL;
    private TextView vcM;
    private TextView vcN;
    private Button vcO;
    private boolean vcP = false;
    private boolean vcQ = false;
    private boolean vcR = false;
    private Integer vcS = Integer.valueOf(15);
    private BindWordingContent vcs;
    private int vct;
    private boolean vcu;
    private boolean vcv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(132, this);
        zi(R.l.dNS);
        this.vcs = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.vct = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.vcu = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.vcv = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.vcI = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        KC();
    }

    public void onDestroy() {
        ap.vd().b(132, this);
        super.onDestroy();
    }

    protected void onStop() {
        bRo();
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.cVE;
    }

    protected final void KC() {
        ap.yY();
        this.fOI = (String) c.vr().get(4097, null);
        this.vcL = (EditText) findViewById(R.h.btq);
        this.vcM = (TextView) findViewById(R.h.btp);
        this.vcN = (TextView) findViewById(R.h.btk);
        this.vcP = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.vcQ = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.vcR = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        Button button = (Button) findViewById(R.h.btn);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(6, null);
        }
        if (this.fOI != null && this.fOI.length() > 0) {
            this.vcM.setVisibility(0);
            this.vcM.setText(this.fOI);
        }
        this.vcL.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ BindMobileVerifyUI vcT;

            {
                this.vcT = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return bg.K(charSequence);
            }
        }});
        this.vcO = (Button) findViewById(R.h.bts);
        button.setVisibility(8);
        this.vcN.setText(getResources().getQuantityString(R.j.dsv, this.vcS.intValue(), new Object[]{this.vcS}));
        if (this.okA == null) {
            this.okA = new Timer();
            TimerTask anonymousClass5 = new TimerTask(this) {
                final /* synthetic */ BindMobileVerifyUI vcT;

                {
                    this.vcT = r1;
                }

                public final void run() {
                    if (this.vcT.vcN != null) {
                        this.vcT.vcN.post(new Runnable(this.vcT) {
                            final /* synthetic */ BindMobileVerifyUI vcT;

                            {
                                this.vcT = r1;
                            }

                            public final void run() {
                                this.vcT.vcS;
                                this.vcT.vcS = Integer.valueOf(this.vcT.vcS.intValue() - 1);
                                if (this.vcT.vcS.intValue() > 0) {
                                    this.vcT.vcN.setText(this.vcT.getResources().getQuantityString(R.j.dsv, this.vcT.vcS.intValue(), new Object[]{this.vcT.vcS}));
                                    return;
                                }
                                this.vcT.vcN.setText(this.vcT.getResources().getQuantityString(R.j.dsv, 0, new Object[]{Integer.valueOf(0)}));
                                this.vcT.bRo();
                            }
                        });
                    }
                }
            };
            if (this.okA != null) {
                this.okA.schedule(anonymousClass5, 1000, 1000);
            }
        }
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI vcT;

            {
                this.vcT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.vcT.vcL.getText().toString().trim();
                if (trim.equals("")) {
                    g.h(this.vcT, R.l.dOl, R.l.dIO);
                } else {
                    this.vcT.aHf();
                    b hhVar = new hh();
                    hhVar.fMI.context = this.vcT;
                    a.urY.m(hhVar);
                    String str = hhVar.fMJ.fMK;
                    hhVar = new hi();
                    a.urY.m(hhVar);
                    final k tVar = new t(this.vcT.fOI, 2, trim, "", str, hhVar.fML.fMM);
                    ap.vd().a(tVar, 0);
                    BindMobileVerifyUI bindMobileVerifyUI = this.vcT;
                    Context context = this.vcT;
                    this.vcT.getString(R.l.dIO);
                    bindMobileVerifyUI.irJ = g.a(context, this.vcT.getString(R.l.dOc), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 vcV;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(tVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI vcT;

            {
                this.vcT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vcT.finish();
                return true;
            }
        });
        this.vcO.setVisibility(com.tencent.mm.ai.b.jN(this.fOI) ? 0 : 8);
        this.vcO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI vcT;

            {
                this.vcT = r1;
            }

            public final void onClick(View view) {
                this.vcT.aHf();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.vcT.fOI);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.c.a.imv.e(this.vcT, intent);
            }
        });
    }

    private void bRo() {
        if (this.okA != null) {
            this.okA.cancel();
            this.okA = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        w.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).AJ() == 2) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            boolean z2;
            if (i != 0 || i2 != 0) {
                if (!com.tencent.mm.plugin.c.a.imw.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                            if (dn != null) {
                                dn.a(this, null, null);
                            }
                            z2 = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dNv, 0).show();
                            z2 = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dNx, 0).show();
                            z2 = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dNA, 0).show();
                            z2 = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dNw, 0).show();
                            z2 = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dNy, 0).show();
                            z2 = true;
                            break;
                        case -33:
                            g.a(this, R.l.dOf, R.l.btr, null);
                            z2 = true;
                            break;
                        case -32:
                            g.a(this, R.l.dOg, R.l.btr, null);
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (!z2) {
                    Toast.makeText(this, getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).AJ() != 2) {
            } else {
                Intent intent;
                if (this.vcP) {
                    if (!m.xT()) {
                        b rcVar = new rc();
                        rcVar.fYc.fYd = true;
                        rcVar.fYc.fYe = true;
                        a.urY.m(rcVar);
                    }
                    zu(1);
                    intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.c.a.imv.d(this, intent);
                } else if (this.vcR) {
                    zu(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.vcI) {
                    if (this.vcu) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (this.vcv) {
                        z = false;
                    }
                    BindMobileStatusUI.c(this, z2, z);
                    exit(-1);
                } else {
                    if (!this.vcQ) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.EL();
                    }
                    intent = new Intent(this, BindMobileStatusUI.class);
                    intent.putExtra("kstyle_bind_wording", this.vcs);
                    intent.putExtra("kstyle_bind_recommend_show", this.vct);
                    intent.putExtra("Kfind_friend_by_mobile_flag", this.vcu);
                    intent.putExtra("Krecom_friends_by_mobile_flag", this.vcv);
                    z(this, intent);
                }
            }
        }
    }
}
