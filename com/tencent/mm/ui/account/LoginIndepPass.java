package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class LoginIndepPass extends MMActivity implements e {
    private String fWY;
    private String hSs;
    private ProgressDialog isv = null;
    private String oVg;
    private String oVk;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ LoginIndepPass uYM;

        {
            this.uYM = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.LoginIndepPass", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private EditText uYI;
    private String uYJ;
    private Button uYK;
    private p uYL;
    private f uYk = new f();
    private String uYm;
    private String uYn;

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        if (bg.mA(str)) {
            g.h(loginIndepPass, R.l.faa, R.l.ewN);
        } else if (bg.mA(str2)) {
            g.h(loginIndepPass, R.l.eZX, R.l.ewN);
        } else {
            loginIndepPass.uYI.setText(str2);
            loginIndepPass.aHf();
            ap.vd().a(701, (e) loginIndepPass);
            final k uVar = new u(str, str2, null, 1);
            ap.vd().a(uVar, 0);
            loginIndepPass.getString(R.l.dIO);
            loginIndepPass.isv = g.a((Context) loginIndepPass, loginIndepPass.getString(R.l.ewX), true, new OnCancelListener(loginIndepPass) {
                final /* synthetic */ LoginIndepPass uYM;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                }
            });
        }
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        if (bg.mA(loginIndepPass.uYI.getText().toString().trim())) {
            loginIndepPass.kr(false);
        } else {
            loginIndepPass.kr(true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dgV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.ewQ);
        if (d.sYQ) {
            string = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        qP(string);
        this.uYJ = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.uYJ != null) {
            this.hSs = an.PB(this.uYJ);
        }
        a.imw.ox();
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        KC();
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L200_200," + ap.ec("L200_200") + ",1");
        com.tencent.mm.plugin.c.b.mM("L200_200");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L200_200," + ap.ec("L200_200") + ",2");
    }

    public void onDestroy() {
        ap.vd().b(701, (e) this);
        super.onDestroy();
    }

    protected final void KC() {
        this.uYI = (EditText) findViewById(R.h.bXx);
        this.uYK = (Button) findViewById(R.h.ccI);
        kr(false);
        a(0, getString(R.l.ewS), new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uYM.Tq();
                return true;
            }
        });
        this.uYI.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final void afterTextChanged(Editable editable) {
                LoginIndepPass.b(this.uYM);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.uYI.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.uYM.Tq();
                return true;
            }
        });
        this.uYI.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.uYM.Tq();
                return true;
            }
        });
        this.uYK.setText(getString(R.l.ewV));
        this.uYK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final void onClick(View view) {
                g.a(this.uYM, this.uYM.getString(R.l.eJV) + this.uYM.uYJ, this.uYM.getString(R.l.eJW), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 uYO;

                    {
                        this.uYO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, this.uYO.uYM);
                        final k sVar = new s(this.uYO.uYM.hSs, 16, "", 0, "");
                        ap.vd().a(sVar, 0);
                        LoginIndepPass loginIndepPass = this.uYO.uYM;
                        Context context = this.uYO.uYM;
                        this.uYO.uYM.getString(R.l.dIO);
                        loginIndepPass.uYL = g.a(context, this.uYO.uYM.getString(R.l.eSL), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 uYQ;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(sVar);
                                ap.vd().b(701, this.uYQ.uYO.uYM);
                            }
                        });
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 uYO;

                    {
                        this.uYO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginIndepPass uYM;

            {
                this.uYM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.c.b.mN("L200_100");
                Intent intent = new Intent(this.uYM, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                this.uYM.startActivity(intent);
                this.uYM.finish();
                return true;
            }
        });
        this.oVg = getIntent().getStringExtra("auth_ticket");
        if (!bg.mA(this.oVg)) {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ LoginIndepPass uYM;

                {
                    this.uYM = r1;
                }

                public final void run() {
                    LoginIndepPass.a(this.uYM, f.bQQ(), f.bQR());
                }
            }, 500);
        }
    }

    private void Tq() {
        String obj = this.uYI.getText().toString();
        if (bg.mA(this.hSs)) {
            g.h(this, R.l.faa, R.l.ewN);
        } else if (obj.equals("")) {
            g.h(this, R.l.eZX, R.l.ewN);
        } else {
            aHf();
            ap.vd().a(701, (e) this);
            final k uVar = new u(this.hSs, obj, null, 1);
            ap.vd().a(uVar, 0);
            getString(R.l.dIO);
            this.isv = g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ LoginIndepPass uYM;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (this.uYL != null) {
            this.uYL.dismiss();
            this.uYL = null;
        }
        if (kVar.getType() == 701) {
            this.fWY = ((u) kVar).Jh();
            ap.vd().b(701, (e) this);
            this.uYk.uYU = ((u) kVar).FJ();
            this.uYk.uYW = ((u) kVar).FI();
            this.uYk.uYV = ((u) kVar).Jj();
            this.uYk.uYX = ((u) kVar).Ji();
            this.uYk.hSs = this.hSs;
            this.uYk.uYS = this.uYI.getText().toString();
            if (i2 == -75) {
                m.bo(this.uSU.uTo);
            } else if (i2 == -106) {
                m.E(this, str);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
            } else if (i2 == -205) {
                this.oVg = ((u) kVar).Fv();
                this.uYm = ((u) kVar).Jk();
                this.uYn = ((u) kVar).Jn();
                w.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bg.Qj(this.oVg), this.uYn);
                f.a(this.uYk);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.oVg);
                intent.putExtra("binded_mobile", this.uYm);
                intent.putExtra("close_safe_device_style", this.uYn);
                intent.putExtra("from_source", 5);
                a.imv.f((Context) this, intent);
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    ap.vd().a(new bb(new bb.a(this) {
                        final /* synthetic */ LoginIndepPass uYM;

                        {
                            this.uYM = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                com.tencent.mm.network.c Cc = eVar.Cc();
                                byte[] bArr = new byte[0];
                                ap.yY();
                                Cc.i(bArr, com.tencent.mm.u.c.uH());
                            }
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    ap.vd().a(701, (e) this);
                    if (this.uUx == null) {
                        this.uUx = SecurityImage.a.a(this.uSU.uTo, R.l.eKg, this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LoginIndepPass uYM;

                            {
                                this.uYM = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                w.d("MicroMsg.LoginIndepPass", "imgSid:" + this.uYM.uYk.uYU + " img len" + this.uYM.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                                final k uVar = new u(this.uYM.uYk.hSs, this.uYM.uYk.uYS, this.uYM.uYk.uYX, this.uYM.uUx.bRz(), this.uYM.uUx.uYU, this.uYM.uUx.uYV, 1, "", false, false);
                                ap.vd().a(uVar, 0);
                                LoginIndepPass loginIndepPass = this.uYM;
                                Context context = this.uYM;
                                this.uYM.getString(R.l.dIO);
                                loginIndepPass.isv = g.a(context, this.uYM.getString(R.l.ewX), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass4 uYN;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(uVar);
                                        ap.vd().b(701, this.uYN.uYM);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ LoginIndepPass uYM;

                            {
                                this.uYM = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.uYM.uUx = null;
                            }
                        }, this.uYk);
                        return;
                    }
                    w.d("MicroMsg.LoginIndepPass", "imgSid:" + this.uYk.uYU + " img len" + this.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                    this.uUx.a(this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV);
                } else if (z || (i == 0 && i2 == 0)) {
                    ap.unhold();
                    m.mv(this.uYk.hSs);
                    com.tencent.mm.modelsimple.d.bc(this);
                    m.a(this, new Runnable(this) {
                        final /* synthetic */ LoginIndepPass uYM;

                        {
                            this.uYM = r1;
                        }

                        public final void run() {
                            w.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
                            Intent ak = a.imv.ak(this.uYM);
                            ak.addFlags(67108864);
                            this.uYM.startActivity(ak);
                            this.uYM.finish();
                        }
                    }, false, 2);
                } else if (!p(i, i2, str)) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                        if (dn != null && dn.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (!bg.mA(this.fWY)) {
                m.j(this, str, this.fWY);
            }
        } else if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX) {
            ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
            String Fw = ((s) kVar).Fw();
            if (i2 == -41) {
                g.h(this, R.l.eJJ, R.l.eJK);
            } else if (i2 == -75) {
                g.b(this, getString(R.l.dDe), "", true);
            } else {
                com.tencent.mm.plugin.c.b.mN("L3");
                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L3," + ap.ec("L3") + ",1");
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.uYJ);
                intent2.putExtra("bindmcontact_shortmobile", Fw);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("login_type", 3);
                intent2.putExtra("mobileverify_countdownsec", ((s) kVar).Fy());
                intent2.putExtra("mobileverify_countdownstyle", ((s) kVar).Fz());
                intent2.putExtra("mobileverify_fb", ((s) kVar).FA());
                a(MobileVerifyUI.class, intent2);
            }
        } else if (!p(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean p(int i, int i2, String str) {
        if (a.imw.a(this.uSU.uTo, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bg.mA(this.fWY)) {
                    m.j(this.uSU.uTo, str, this.fWY);
                }
                return true;
            case -100:
                ap.hold();
                g.a(this.uSU.uTo, TextUtils.isEmpty(ap.uI()) ? com.tencent.mm.bg.a.V(this.uSU.uTo, R.l.ezi) : ap.uI(), this.uSU.uTo.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginIndepPass uYM;

                    {
                        this.uYM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ LoginIndepPass uYM;

                    {
                        this.uYM = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -9:
                g.h(this, R.l.ewM, R.l.ewN);
                return true;
            case -4:
            case -3:
                g.h(this, R.l.efc, R.l.ewN);
                return true;
            case -1:
                if (ap.vd().BR() != 5) {
                    return false;
                }
                g.h(this, R.l.eDp, R.l.eDo);
                return true;
            default:
                return false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bg.mA(stringExtra));
            if (!bg.mA(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            w.d(str2, str3, objArr2);
            if (intExtra == -217) {
                Tq();
            }
        }
    }
}
