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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.il;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class LoginUI extends MMActivity implements e {
    private TextWatcher acO = new TextWatcher(this) {
        final /* synthetic */ LoginUI uZl;

        {
            this.uZl = r1;
        }

        public final void afterTextChanged(Editable editable) {
            LoginUI.a(this.uZl);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String fGV = null;
    private String fWY = "";
    private ProgressDialog isv = null;
    private int nXW = 0;
    private String oVg;
    private String oVk;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ LoginUI uZl;

        {
            this.uZl = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.LoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private f uYk = new f();
    private String uYm;
    private String uYn;
    private ResizeLayout uYq;
    private a uYs;
    private MMClearEditText uZd;
    private MMClearEditText uZe;
    private MMFormInputView uZf;
    private MMFormInputView uZg;
    private Button uZh;
    private Button uZi;
    private MMKeyboardUperView uZj;
    private boolean uZk = false;

    static /* synthetic */ void a(LoginUI loginUI) {
        if (bg.mA(loginUI.uZd.getText().toString()) || bg.mA(loginUI.uZe.getText().toString())) {
            loginUI.uZh.setEnabled(false);
        } else {
            loginUI.uZh.setEnabled(true);
        }
    }

    static /* synthetic */ void bg(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void j(LoginUI loginUI) {
        h.vJ().eh("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        com.tencent.mm.plugin.c.a.imv.t(intent, loginUI);
    }

    protected final int getLayoutId() {
        return R.i.dgT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "";
        if (com.tencent.mm.protocal.d.sYQ) {
            str = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        this.nXW = getIntent().getIntExtra("login_type", 0);
        qP(str);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        KC();
        this.uYs = new a();
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            g.oUh.i(14262, Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4]));
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        if (this.nXW == 0) {
            com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L100_100_logout," + ap.ec("L100_100_logout") + ",1");
            com.tencent.mm.plugin.c.b.mM("L100_100_logout");
        } else if (this.nXW == 1) {
            com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L400_100_login," + ap.ec("L400_100_login") + ",1");
            com.tencent.mm.plugin.c.b.mM("L400_100_login");
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        if (this.nXW == 0) {
            com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L100_100_logout," + ap.ec("L100_100_logout") + ",2");
        } else if (this.nXW == 1) {
            com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L400_100_login," + ap.ec("L400_100_login") + ",2");
        }
    }

    public void onDestroy() {
        if (this.uYs != null) {
            this.uYs.close();
        }
        ap.vd().b(701, (e) this);
        super.onDestroy();
    }

    protected final void KC() {
        this.uZf = (MMFormInputView) findViewById(R.h.ccA);
        this.uZg = (MMFormInputView) findViewById(R.h.ccF);
        this.uZd = (MMClearEditText) this.uZf.oBT;
        this.uZd.setFocusableInTouchMode(false);
        this.uZd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.uZl.uZd.setFocusableInTouchMode(true);
                return this.uZl.uZd.rlX.onTouch(view, motionEvent);
            }
        });
        this.uZe = (MMClearEditText) this.uZg.oBT;
        this.uZe.setFocusableInTouchMode(false);
        this.uZe.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.uZl.uZe.setFocusableInTouchMode(true);
                this.uZl.uZd.setFocusableInTouchMode(false);
                return this.uZl.uZe.rlX.onTouch(view, motionEvent);
            }
        });
        com.tencent.mm.ui.tools.a.c.d(this.uZe).Ch(16).a(null);
        this.uZh = (Button) findViewById(R.h.ccB);
        this.uZh.setEnabled(false);
        this.uZi = (Button) findViewById(R.h.ccC);
        this.uYq = (ResizeLayout) findViewById(R.h.cyC);
        this.uZj = (MMKeyboardUperView) findViewById(R.h.Ki);
        this.uYq.vbI = new ResizeLayout.a(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void bQP() {
                this.uZl.uZj.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass22 uZn;

                    {
                        this.uZn = r1;
                    }

                    public final void run() {
                        this.uZn.uZl.uZj.fullScroll(130);
                    }
                });
            }
        };
        this.uZj.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.uZl.aHf();
                return false;
            }
        });
        boolean Hm = com.tencent.mm.ai.b.Hm();
        View findViewById = findViewById(R.h.bPm);
        findViewById.setVisibility(!Hm ? 8 : 0);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void onClick(View view) {
                this.uZl.startActivity(new Intent(this.uZl, FacebookLoginUI.class));
            }
        });
        final com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void a(l lVar) {
                if (lVar.size() == 0) {
                    lVar.e(1, this.uZl.getString(R.l.eIY));
                    lVar.e(2, this.uZl.getString(R.l.ewP));
                }
            }
        };
        eVar.qJg = new n.d(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                String string;
                switch (menuItem.getItemId()) {
                    case 1:
                        Context context = this.uZl.uSU.uTo;
                        String str = bg.em(context) + "_" + System.currentTimeMillis();
                        w.d("MicroMsg.ForgotPwdMenu", "cpan showProblemH5 randomID:%s", str);
                        string = context.getString(R.l.ewL);
                        string = v.bIN().equals("zh_CN") ? string + "zh_CN" : (v.bIN().equals("zh_TW") || v.bIN().equals("zh_HK")) ? string + "zh_TW" : string + "en";
                        e.i(context, string + "&rid=" + str, false);
                        g.oUh.i(11930, str, Integer.valueOf(3));
                        ab.getContext().getSharedPreferences("randomid_prefs", 4).edit().putString("randomID", str).commit();
                        return;
                    case 2:
                        string = this.uZl.getString(R.l.fnd);
                        if (v.bIN().equals("zh_CN")) {
                            string = string + "zh_CN";
                        } else {
                            string = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                        }
                        LoginUI.bg(this.uZl, string);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.wva = new com.tencent.mm.ui.widget.e.a(this) {
            final /* synthetic */ LoginUI uZl;

            public final void onDismiss() {
                eVar.bzi();
            }
        };
        qP("");
        cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
        cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
        a(0, R.l.dUG, R.k.dsQ, new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginUI uZl;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uZl.aHf();
                eVar.bzh();
                return true;
            }
        });
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uZl.goBack();
                return true;
            }
        }, R.k.dsP);
        this.uZh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void onClick(View view) {
                this.uZl.Tq();
            }
        });
        this.uZi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.uZl, MobileInputUI.class);
                int[] iArr = new int[5];
                iArr[0] = 2;
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("kv_report_login_method_data", iArr);
                this.uZl.startActivity(intent);
                this.uZl.finish();
            }
        });
        this.oVg = getIntent().getStringExtra("auth_ticket");
        if (!bg.mA(this.oVg)) {
            this.uZd.setText(bg.mz(f.bQQ()));
            this.uZe.setText(bg.mz(f.bQR()));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ LoginUI uZl;

                {
                    this.uZl = r1;
                }

                public final void run() {
                    this.uZl.Tq();
                }
            }, 500);
        }
        this.uZd.addTextChangedListener(this.acO);
        this.uZe.addTextChangedListener(this.acO);
        this.uZe.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.uZl.Tq();
                return true;
            }
        });
        this.uZe.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ LoginUI uZl;

            {
                this.uZl = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.uZl.Tq();
                return true;
            }
        });
        if (f.usv) {
            com.tencent.mm.plugin.c.a.imw.d(this);
        }
        CharSequence stringExtra = getIntent().getStringExtra("login_username");
        this.uZk = getIntent().getBooleanExtra("from_deep_link", false);
        if (!bg.mA(stringExtra)) {
            this.uZd.setText(stringExtra);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        aHf();
        com.tencent.mm.plugin.c.b.mN(this.oVk);
        p.bDe();
        finish();
    }

    private boolean p(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str)) {
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    ap.vd().a(701, (e) this);
                    if (this.uUx == null) {
                        this.uUx = SecurityImage.a.a(this, R.l.eKg, this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LoginUI uZl;

                            {
                                this.uZl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (this.uZl.uUx == null) {
                                    w.e("MicroMsg.LoginUI", "secimg is null!");
                                    return;
                                }
                                w.d("MicroMsg.LoginUI", "imgSid:" + this.uZl.uYk.uYU + " img len" + this.uZl.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                                final k uVar = new u(this.uZl.uYk.hSs, this.uZl.uYk.uYS, this.uZl.uYk.uYX, this.uZl.uUx.bRz(), this.uZl.uUx.uYU, this.uZl.uUx.uYV, 2, "", false, false);
                                ap.vd().a(uVar, 0);
                                LoginUI loginUI = this.uZl;
                                Context context = this.uZl;
                                this.uZl.getString(R.l.dIO);
                                loginUI.isv = com.tencent.mm.ui.base.g.a(context, this.uZl.getString(R.l.ewX), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass10 uZm;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(uVar);
                                        ap.vd().b(701, this.uZm.uZl);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ LoginUI uZl;

                            {
                                this.uZl = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.uZl.uUx = null;
                            }
                        }, this.uYk);
                    } else {
                        w.d("MicroMsg.LoginUI", "imgSid:" + this.uYk.uYU + " img len" + this.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                        this.uUx.a(this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV);
                    }
                    return true;
                case -205:
                    w.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bg.Qj(this.oVg), this.uYn);
                    f.a(this.uYk);
                    com.tencent.mm.plugin.c.b.mN("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.oVg);
                    intent.putExtra("binded_mobile", this.uYm);
                    intent.putExtra("close_safe_device_style", this.uYn);
                    intent.putExtra("from_source", 1);
                    com.tencent.mm.plugin.c.a.imv.f((Context) this, intent);
                    return true;
                case -140:
                    if (!bg.mA(this.fWY)) {
                        m.j(this, str, this.fWY);
                    }
                    return true;
                case -100:
                    ap.hold();
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, TextUtils.isEmpty(ap.uI()) ? com.tencent.mm.bg.a.V(this.uSU.uTo, R.l.ezi) : ap.uI(), this.uSU.uTo.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LoginUI uZl;

                        {
                            this.uZl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginUI.j(this.uZl);
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ LoginUI uZl;

                        {
                            this.uZl = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            LoginUI.j(this.uZl);
                        }
                    });
                    return true;
                case -75:
                    m.bo(this.uSU.uTo);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.eJZ, R.l.dIO);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.g.h(this, R.l.ewM, R.l.ewN);
                    return true;
                case -4:
                case -3:
                    com.tencent.mm.ui.base.g.h(this, R.l.efc, R.l.ewN);
                    return true;
                case -1:
                    if (ap.vd().BR() != 5) {
                        return false;
                    }
                    com.tencent.mm.ui.base.g.h(this, R.l.eDp, R.l.eDo);
                    return true;
            }
        }
        return this.uYs.a(this, new com.tencent.mm.pluginsdk.j.p(i, i2, str));
    }

    public final void a(int i, int i2, String str, final k kVar) {
        w.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() == 701) {
            boolean z;
            ap.vd().b(701, (e) this);
            this.fWY = ((u) kVar).Jh();
            this.uYk.uYU = ((u) kVar).FJ();
            this.uYk.uYW = ((u) kVar).FI();
            this.uYk.uYV = ((u) kVar).Jj();
            this.uYk.uYX = ((u) kVar).Ji();
            if (i2 == -205) {
                this.oVg = ((u) kVar).Fv();
                this.uYm = ((u) kVar).Jk();
                this.uYn = ((u) kVar).Jn();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ap.vd().a(new bb(new bb.a(this) {
                    final /* synthetic */ LoginUI uZl;

                    {
                        this.uZl = r1;
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
            if (z || (i == 0 && i2 == 0)) {
                ap.unhold();
                m.mv(this.uYk.hSs);
                com.tencent.mm.modelsimple.d.bc(this);
                m.a(this, new Runnable(this) {
                    final /* synthetic */ LoginUI uZl;

                    public final void run() {
                        w.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.uZl);
                        ak.addFlags(67108864);
                        ak.putExtra("kstyle_show_bind_mobile_afterauth", ((u) kVar).Jl());
                        ak.putExtra("kstyle_bind_wording", ((u) kVar).Jm());
                        ak.putExtra("kstyle_bind_recommend_show", ((u) kVar).Jo());
                        this.uZl.startActivity(ak);
                        this.uZl.finish();
                    }
                }, false, 2);
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                if (this.uZk) {
                    String string = ab.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                    g.oUh.i(11930, string, Integer.valueOf(4));
                }
            } else if (i2 == -106) {
                m.E(this, str);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
            } else if (i2 == -30) {
                if (com.tencent.mm.protocal.d.sYQ) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.fWY);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.plugin.c.a.imv.j(intent, this);
                    return;
                }
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",1");
                com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.exc), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginUI uZl;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.c.b.mN("R400_100_login");
                        Intent intent = new Intent();
                        intent.putExtra("regsetinfo_binduin", this.uZl.uYk.hSs);
                        intent.putExtra("regsetinfo_pwd", this.uZl.uYk.uYS);
                        intent.putExtra("regsetinfo_ismobile", 0);
                        intent.putExtra("regsetinfo_ticket", this.uZl.fGV);
                        intent.putExtra("regsetinfo_NextControl", ((u) kVar).Fx());
                        intent.setClass(this.uZl, RegSetInfoUI.class);
                        this.uZl.uSU.uTo.startActivity(intent);
                        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uZl.getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",2");
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginUI uZl;

                    {
                        this.uZl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uZl.getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",2");
                    }
                });
            } else if (!p(i, i2, str)) {
                if (i2 == -5) {
                    Toast.makeText(this, getString(R.l.ewY), 0).show();
                    return;
                }
                if (kVar.getType() == 701) {
                    com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null && dn.a(this, null, null)) {
                        return;
                    }
                }
                Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private void Tq() {
        this.uYk.hSs = this.uZd.getText().toString().trim();
        this.uYk.uYS = this.uZe.getText().toString();
        if (this.uYk.hSs.equals("")) {
            com.tencent.mm.ui.base.g.h(this, R.l.faa, R.l.ewN);
        } else if (this.uYk.uYS.equals("")) {
            com.tencent.mm.ui.base.g.h(this, R.l.eZX, R.l.ewN);
        } else {
            aHf();
            ap.vd().a(701, (e) this);
            final k uVar = new u(this.uYk.hSs, this.uYk.uYS, this.oVg, 2);
            ap.vd().a(uVar, 0);
            getString(R.l.dIO);
            this.isv = com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ LoginUI uZl;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                    ap.vd().b(701, this.uZl);
                }
            });
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.aQL, R.a.aQL);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginUI";
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
