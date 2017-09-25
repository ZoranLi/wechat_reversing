package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.e.a.y;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(19)
public class LoginHistoryUI extends MMActivity implements e {
    private String fWY = "";
    private SharedPreferences hgx;
    protected int iQX;
    protected ProgressDialog isv = null;
    protected EditText ljL;
    protected int[] nkt = new int[5];
    protected String oVg;
    protected String rcw = "";
    protected LinearLayout syR;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ LoginHistoryUI uYE;

        {
            this.uYE = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.LoginHistoryUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private int uYA;
    private boolean uYB = false;
    private String uYC;
    private int uYD = 0;
    protected TextView uYe;
    protected Button uYf;
    protected Button uYg;
    protected View uYh;
    protected View uYi;
    protected View uYj;
    protected f uYk = new f();
    protected String uYl;
    protected String uYm;
    private String uYn;
    private ImageView uYo;
    private MMKeyboardUperView uYp;
    private ResizeLayout uYq;
    protected String uYr;
    private com.tencent.mm.pluginsdk.j.a uYs;
    protected LinearLayout uYt;
    protected LinearLayout uYu;
    protected MMFormInputView uYv;
    protected MMFormVerifyCodeInputView uYw;
    protected boolean uYx = false;
    protected boolean uYy;
    private int uYz;

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        ad.Pu("welcome_page_show");
        k.e(loginHistoryUI, true);
        b yVar = new y();
        yVar.fDf.fDg = false;
        com.tencent.mm.sdk.b.a.urY.m(yVar);
        ap.getNotification().ox();
        loginHistoryUI.finish();
        Context context = loginHistoryUI.uSU.uTo;
        w.bIP();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(context, Class.forName(ab.bIV()));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, int i) {
        loginHistoryUI.nkt[3] = 1;
        switch (i) {
            case 7001:
                loginHistoryUI.startActivity(new Intent(loginHistoryUI, LoginVoiceUI.class));
                loginHistoryUI.finish();
                return;
            case 7006:
                loginHistoryUI.startActivity(new Intent(loginHistoryUI, LoginFaceUI.class));
                loginHistoryUI.finish();
                return;
            case 7007:
                loginHistoryUI.startActivity(new Intent(loginHistoryUI, LoginPasswordUI.class));
                loginHistoryUI.finish();
                return;
            case 7008:
                loginHistoryUI.startActivity(new Intent(loginHistoryUI, LoginSmsUI.class));
                loginHistoryUI.finish();
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void c(LoginHistoryUI loginHistoryUI) {
        loginHistoryUI.nkt[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        loginHistoryUI.startActivity(intent);
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        if (d.sYQ) {
            String string = loginHistoryUI.getString(R.l.eaS, new Object[]{"0x" + Integer.toHexString(d.sYN), v.bIN()});
            w.e("MicroMsg.LoginHistoryUI", "url " + string);
            bf(loginHistoryUI.uSU.uTo, string);
            return;
        }
        bf.zK();
        Intent intent = new Intent(loginHistoryUI, RegByMobileRegAIOUI.class);
        intent.putExtra("login_type", 0);
        loginHistoryUI.startActivity(intent);
        bf.zK();
        com.tencent.mm.plugin.c.b.hi(20);
        com.tencent.mm.plugin.c.b.mN("RE200_100");
        com.tencent.mm.plugin.c.b.mM("RE100_100_logout");
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + loginHistoryUI.getClass().getName() + ",RE100_100_logout," + ap.ec("RE100_100_logout") + ",2");
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        bf(loginHistoryUI.uSU.uTo, v.bIN().equals("zh_CN") ? loginHistoryUI.getString(R.l.fnd) + "zh_CN" : "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=");
    }

    static /* synthetic */ void f(LoginHistoryUI loginHistoryUI) {
        int i = 0;
        if (loginHistoryUI.uYA == 0) {
            i = !com.tencent.mm.ai.b.Hp() ? 7 : 6;
        } else {
            if (!((loginHistoryUI.uYA & 2) == 0 && (loginHistoryUI.uYA & 4) == 0)) {
                i = 2;
            }
            if ((loginHistoryUI.uYA & 4) != 0) {
                i |= 4;
            }
            if ((loginHistoryUI.uYA & 1) != 0) {
                i |= 1;
            }
        }
        i |= 8;
        l lVar = new l(loginHistoryUI);
        lVar.qJf = new com.tencent.mm.ui.account.e.AnonymousClass1(i, loginHistoryUI);
        lVar.qJg = new com.tencent.mm.ui.account.e.AnonymousClass2(loginHistoryUI, null, null, null);
        lVar.blb();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.hgx = ab.getContext().getSharedPreferences(ab.bIX(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.uYB = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.uYB = this.uYB;
            if (this.uYB) {
                this.uYC = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        KC();
        this.uYs = new com.tencent.mm.pluginsdk.j.a();
    }

    public void onDestroy() {
        w.i("MicroMsg.LoginHistoryUI", "onDestroy");
        ap.vd().b(701, (e) this);
        if (this.uYs != null) {
            this.uYs.close();
        }
        g.oUh.i(14262, Integer.valueOf(this.nkt[0]), Integer.valueOf(this.nkt[1]), Integer.valueOf(this.nkt[2]), Integer.valueOf(this.nkt[3]), Integer.valueOf(this.nkt[4]));
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        final List arrayList = new ArrayList();
        if (!(!bQO() || this.iQX == 1 || (this.uYz & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0)) {
            m mVar = new m(7001, 0);
            mVar.setTitle(R.l.ewW);
            arrayList.add(mVar);
        }
        if (!(this.iQX == 5 || (this.uYz & 262144) == 0)) {
            mVar = new m(7005, 0);
            mVar.setTitle(R.l.ewT);
            arrayList.add(mVar);
        }
        if (!bg.mA(this.uYr)) {
            if (!(bg.mA(this.uYm) || this.iQX == 3)) {
                mVar = new m(7008, 0);
                mVar.setTitle(getString(R.l.ewV));
                arrayList.add(mVar);
            }
            if (this.iQX != 2) {
                mVar = new m(7007, 0);
                mVar.setTitle(getString(R.l.ewU));
                arrayList.add(mVar);
            }
            if (this.uYr.equalsIgnoreCase(this.uYl)) {
                this.ljL.setHint(getString(R.l.eKe));
            }
        }
        if (arrayList.size() > 1) {
            final com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wuP, false);
            eVar.qJf = new n.c(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    if (lVar.size() == 0) {
                        for (m mVar : arrayList) {
                            if (mVar != null) {
                                lVar.vla.add(mVar);
                            }
                        }
                    }
                }
            };
            eVar.qJg = new n.d(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                {
                    this.uYE = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    LoginHistoryUI.a(this.uYE, menuItem.getItemId());
                }
            };
            eVar.wva = new com.tencent.mm.ui.widget.e.a(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final void onDismiss() {
                    eVar.bzi();
                }
            };
            this.uYg.setVisibility(0);
            this.uYg.setText(R.l.ewJ);
            this.uYg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final void onClick(View view) {
                    eVar.bzh();
                }
            });
        } else if (arrayList.size() > 0) {
            this.uYg.setVisibility(0);
            this.uYg.setText(((m) arrayList.get(0)).getTitle());
            this.uYg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final void onClick(View view) {
                    LoginHistoryUI.a(this.uYE, ((m) arrayList.get(0)).getItemId());
                }
            });
        } else {
            this.uYg.setVisibility(8);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        ap.uZ();
        String A = ao.hlW.A("login_user_name", "");
        if (!ap.za() || A.equals("")) {
            if (com.tencent.mm.m.a.tP() == 2) {
                h.a aVar = new h.a(this);
                aVar.zW(R.l.dVX);
                aVar.SX(getString(R.l.dVW));
                aVar.kK(false);
                aVar.zZ(R.l.dVU).a(new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginHistoryUI uYE;

                    {
                        this.uYE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
                        LoginHistoryUI.a(this.uYE);
                    }
                });
                aVar.WJ().show();
                com.tencent.mm.m.a.b(this, System.currentTimeMillis());
            }
        } else if (this.isv == null || !this.isv.isShowing()) {
            b(null);
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this);
            ak.addFlags(67108864);
            ak.putExtra("can_finish", true);
            startActivity(ak);
            finish();
            com.tencent.mm.ui.base.b.eN(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void KC() {
        String str;
        this.syR = (LinearLayout) findViewById(R.h.cNg);
        this.uYu = (LinearLayout) findViewById(R.h.bNG);
        this.uYt = (LinearLayout) findViewById(R.h.bPU);
        this.uYv = (MMFormInputView) findViewById(R.h.ccG);
        this.uYw = (MMFormVerifyCodeInputView) findViewById(R.h.cFR);
        this.uYr = ao.hlW.A("login_user_name", "");
        String string = ao.hlW.hgx.getString("last_avatar_path", "");
        if (string.length() == 0 || string.endsWith("last_avatar")) {
            str = string;
        } else {
            String str2 = string + ".bm";
            str = com.tencent.mm.compatible.util.e.hgq + "last_avatar";
            String str3 = str + ".bm";
            if (FileOp.p(string, str) > 0 || FileOp.p(str2, str3) > 0) {
                w.i("MicroMsg.LastLoginInfo", "Copy avatar: %s -> %s", str2, str3);
            } else {
                w.w("MicroMsg.LastLoginInfo", "Can't find avatar file: " + str2);
                str = string;
            }
        }
        this.uYA = bg.PY(ao.hlW.A("last_bind_info", "0"));
        if ((this.uYA & 1) != 0) {
            this.uYl = ao.hlW.A("last_login_bind_qq", "");
        }
        if ((this.uYA & 4) != 0) {
            this.uYm = ao.hlW.A("last_login_bind_mobile", "");
        }
        string = getIntent().getStringExtra("email_address");
        if (!(bg.mA(string) || string.equalsIgnoreCase(this.uYr))) {
            this.uYr = string;
        }
        this.uYo = (ImageView) findViewById(R.h.cas);
        if (!bg.mA(str)) {
            Bitmap hn = com.tencent.mm.x.d.hn(str);
            if (hn != null && hn.getWidth() > 10) {
                this.uYo.setImageBitmap(Bitmap.createBitmap(hn, 5, 5, hn.getWidth() - 10, hn.getHeight() - 10, null, false));
            }
        }
        if (!ap.za() || this.uYr.equals("")) {
            this.uYz = bg.PY(ao.hlW.A("last_login_use_voice", ""));
            this.uYp = (MMKeyboardUperView) findViewById(R.h.Ki);
            this.uYe = (TextView) findViewById(R.h.ccA);
            this.ljL = this.uYv.oBT;
            this.uYf = (Button) findViewById(R.h.ccB);
            this.uYh = findViewById(R.h.ccK);
            this.uYi = findViewById(R.h.ccE);
            this.uYj = (Button) findViewById(R.h.cFl);
            this.uYg = (Button) findViewById(R.h.ccD);
            this.uYv.setVisibility(8);
            this.syR.setVisibility(8);
            this.uYu.setVisibility(8);
            this.uYt.setVisibility(8);
            this.uYf.setVisibility(8);
            this.uYh.setVisibility(8);
            this.uYi.setVisibility(8);
            this.uYj.setVisibility(8);
            this.uYg.setVisibility(8);
            com.tencent.mm.ui.tools.a.c.d(this.ljL).em(4, 16).a(null);
            this.uYq = (ResizeLayout) findViewById(R.h.cyC);
            if (!bg.Qh(this.uYr).booleanValue() || this.uYr.equals(this.uYl)) {
                this.nkt[2] = 2;
                this.uYe.setText(this.uYr);
            } else {
                this.nkt[2] = 1;
                this.uYe.setText(Di(this.uYr));
            }
            this.uYq.vbI = new ResizeLayout.a(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                {
                    this.uYE = r1;
                }

                public final void bQP() {
                    this.uYE.uYp.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass21 uYH;

                        {
                            this.uYH = r1;
                        }

                        public final void run() {
                            this.uYH.uYE.uYp.fullScroll(130);
                        }
                    });
                }
            };
            this.uYp.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                {
                    this.uYE = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.uYE.aHf();
                    return false;
                }
            });
            final com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wuP, false);
            eVar.qJf = new n.c(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                {
                    this.uYE = r1;
                }

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    if (lVar.size() == 0) {
                        lVar.dX(7002, R.l.ewK);
                        lVar.dX(7009, R.l.eIY);
                        lVar.dX(7004, R.l.ewP);
                        lVar.dX(7003, R.l.esF);
                    }
                }
            };
            eVar.qJg = new n.d(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                {
                    this.uYE = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 7002:
                            LoginHistoryUI.c(this.uYE);
                            return;
                        case 7003:
                            LoginHistoryUI.d(this.uYE);
                            return;
                        case 7004:
                            LoginHistoryUI.e(this.uYE);
                            return;
                        case 7009:
                            LoginHistoryUI.bf(this.uYE, this.uYE.getString(R.l.ewO) + v.bIN());
                            return;
                        default:
                            return;
                    }
                }
            };
            eVar.wva = new com.tencent.mm.ui.widget.e.a(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final void onDismiss() {
                    eVar.bzi();
                }
            };
            qP("");
            bPY();
            cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
            cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
            a(7000, R.l.dUG, R.k.dsQ, new OnMenuItemClickListener(this) {
                final /* synthetic */ LoginHistoryUI uYE;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.uYE.aHf();
                    eVar.bzh();
                    return true;
                }
            });
            if (f.usv) {
                com.tencent.mm.plugin.c.a.imw.d(this);
                return;
            }
            return;
        }
        this.uYx = true;
        b(null);
    }

    protected final String Di(String str) {
        an anVar = new an();
        String str2 = "86";
        if (this.uYr.startsWith("+")) {
            str = str.replace("+", "");
            str2 = an.yU(str);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return an.formatNumber(str2, str);
    }

    protected final void bQM() {
        ap.vd().a(701, (e) this);
    }

    protected final void bQN() {
        ap.vd().b(701, (e) this);
    }

    protected void Tq() {
        this.uYk.hSs = this.uYr.trim();
    }

    public final void aHf() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.d(str, str2, objArr);
        String stringExtra;
        if (i != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || intent == null) {
            if (i == 1025 && intent != null && i2 == 2) {
                stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                str = "MicroMsg.LoginHistoryUI";
                str2 = "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bg.mA(stringExtra));
                if (!bg.mA(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                w.i(str, str2, objArr);
                SM(stringExtra);
            }
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginHistoryUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bg.mA(stringExtra));
            if (!bg.mA(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            w.d(str2, str3, objArr2);
            SM(stringExtra);
        }
    }

    private void SM(String str) {
        this.rcw = str;
        Tq();
    }

    public final void a(int i, int i2, String str, final com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        w.d("MicroMsg.LoginHistoryUI", "Scene Type " + kVar.getType());
        com.tencent.mm.f.a dn;
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX) {
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
                this.isv = null;
            }
            int AJ = ((s) kVar).AJ();
            if (AJ == 16) {
                if (i2 == -41) {
                    com.tencent.mm.ui.base.g.h(this, R.l.eJJ, R.l.eJK);
                    this.uYw.reset();
                    return;
                } else if (i2 == -75) {
                    com.tencent.mm.ui.base.g.b(this, getString(R.l.dDe), "", true);
                    this.uYw.reset();
                    return;
                }
            } else if (AJ == 17) {
                if (i == 0 && i2 == 0) {
                    new com.tencent.mm.ui.account.mobile.a(new com.tencent.mm.ui.account.mobile.a.a(this) {
                        final /* synthetic */ LoginHistoryUI uYE;

                        {
                            this.uYE = r1;
                        }

                        public final void a(ProgressDialog progressDialog) {
                            this.uYE.isv = progressDialog;
                        }
                    }, ((s) kVar).getUsername(), ((s) kVar).Ft(), this.uYm).h(this);
                    return;
                } else if (i2 == -51) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this, null, null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.h(this, R.l.eJg, R.l.btr);
                        return;
                    }
                }
            }
        } else if (kVar.getType() == 701) {
            this.fWY = ((u) kVar).Jh();
            w.e("MicroMsg.LoginHistoryUI", "url " + this.fWY);
            ap.vd().b(701, (e) this);
            this.uYk.uYX = ((u) kVar).Ji();
            this.uYk.uYU = ((u) kVar).FJ();
            this.uYk.uYW = ((u) kVar).FI();
            this.uYk.uYV = ((u) kVar).Jj();
            if (i2 == -205) {
                this.oVg = ((u) kVar).Fv();
                this.uYm = ((u) kVar).Jk();
                this.uYn = ((u) kVar).Jn();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ap.vd().a(new bb(new bb.a(this) {
                    final /* synthetic */ LoginHistoryUI uYE;

                    {
                        this.uYE = r1;
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
                r0 = true;
            } else {
                r0 = false;
            }
            if (r0 || (i == 0 && i2 == 0)) {
                ap.unhold();
                com.tencent.mm.modelsimple.d.bc(this);
                com.tencent.mm.platformtools.m.mv(this.uYk.hSs);
                if (this.isv != null && this.isv.isShowing()) {
                    this.isv.setMessage(getString(R.l.eSL));
                }
                b((u) kVar);
                if (this.iQX == 3) {
                    this.uYy = ((u) kVar).Jp();
                    ap.vd().a(255, (e) this);
                    final com.tencent.mm.y.k vVar = new com.tencent.mm.modelsimple.v(1);
                    ap.vd().a(vVar, 0);
                    getString(R.l.dIO);
                    this.isv = com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ LoginHistoryUI uYE;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(vVar);
                            ap.vd().b(255, this.uYE);
                        }
                    });
                    return;
                }
                return;
            }
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i2 == -106) {
                com.tencent.mm.platformtools.m.E(this, str);
                return;
            } else if (i2 == -217) {
                com.tencent.mm.platformtools.m.a(this, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
                return;
            } else if (i2 == -30) {
                if (d.sYQ) {
                    bf(this.uSU.uTo, this.fWY);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.exc), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LoginHistoryUI uYE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.c.b.mN("R400_100_login");
                            Intent intent = new Intent();
                            intent.putExtra("regsetinfo_binduin", this.uYE.uYk.hSs);
                            intent.putExtra("regsetinfo_pwd", this.uYE.uYk.uYS);
                            intent.putExtra("regsetinfo_ismobile", 0);
                            intent.putExtra("regsetinfo_NextControl", ((u) kVar).Fx());
                            intent.setClass(this.uYE, RegSetInfoUI.class);
                            this.uYE.uSU.uTo.startActivity(intent);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LoginHistoryUI uYE;

                        {
                            this.uYE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            } else if (!p(i, i2, str)) {
                dn = com.tencent.mm.f.a.dn(str);
                if (dn == null || !dn.a(this, null, null)) {
                    Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (kVar.getType() == 255) {
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
                this.isv = null;
            }
            ap.vd().b(255, (e) this);
            if (i != 0 || i2 != 0) {
                r0 = this.uYy;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.l.eSZ));
                intent.putExtra("kintent_cancelable", r0);
                startActivity(intent);
                return;
            }
            return;
        }
        if (!p(i, i2, str)) {
        }
    }

    private void b(u uVar) {
        w.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", Integer.valueOf(hashCode()), bg.bJZ());
        Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this);
        ak.addFlags(67108864);
        if (uVar != null) {
            ak.putExtra("kstyle_show_bind_mobile_afterauth", uVar.Jl());
            ak.putExtra("kstyle_bind_recommend_show", uVar.Jo());
            ak.putExtra("kstyle_bind_wording", uVar.Jm());
        }
        startActivity(ak);
        finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean p(final int r12, int r13, java.lang.String r14) {
        /*
        r11 = this;
        r5 = 2;
        r10 = 1;
        r0 = 4;
        if (r12 != r0) goto L_0x0008;
    L_0x0005:
        switch(r13) {
            case -311: goto L_0x00a2;
            case -310: goto L_0x00a2;
            case -205: goto L_0x0155;
            case -140: goto L_0x019d;
            case -100: goto L_0x0127;
            case -75: goto L_0x007b;
            case -72: goto L_0x0072;
            case -33: goto L_0x0093;
            case -32: goto L_0x0080;
            case -9: goto L_0x0069;
            case -6: goto L_0x00a2;
            case -4: goto L_0x001b;
            case -3: goto L_0x001b;
            case -1: goto L_0x0055;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = com.tencent.mm.plugin.c.a.imw;
        r0 = r0.a(r11, r12, r13, r14);
        if (r0 == 0) goto L_0x01ad;
    L_0x0010:
        r0 = r11.uUx;
        if (r0 == 0) goto L_0x0019;
    L_0x0014:
        r0 = r11.uUx;
        r0.dismiss();
    L_0x0019:
        r0 = r10;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r11.uYD;
        if (r0 > 0) goto L_0x002e;
    L_0x001f:
        r0 = com.tencent.mm.R.l.efc;
        r1 = com.tencent.mm.R.l.ewN;
        com.tencent.mm.ui.base.g.h(r11, r0, r1);
        r0 = r11.uYD;
        r0 = r0 + 1;
        r11.uYD = r0;
    L_0x002c:
        r0 = r10;
        goto L_0x001a;
    L_0x002e:
        r0 = com.tencent.mm.R.l.efd;
        r1 = r11.getString(r0);
        r0 = com.tencent.mm.R.l.ewN;
        r2 = r11.getString(r0);
        r0 = com.tencent.mm.R.l.efe;
        r3 = r11.getString(r0);
        r0 = com.tencent.mm.R.l.dGs;
        r4 = r11.getString(r0);
        r5 = new com.tencent.mm.ui.account.LoginHistoryUI$7;
        r5.<init>(r11);
        r6 = new com.tencent.mm.ui.account.LoginHistoryUI$8;
        r6.<init>(r11);
        r0 = r11;
        com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x002c;
    L_0x0055:
        r0 = com.tencent.mm.u.ap.vd();
        r0 = r0.BR();
        r1 = 5;
        if (r0 != r1) goto L_0x0069;
    L_0x0060:
        r0 = com.tencent.mm.R.l.eDp;
        r1 = com.tencent.mm.R.l.eDo;
        com.tencent.mm.ui.base.g.h(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x0069:
        r0 = com.tencent.mm.R.l.ewM;
        r1 = com.tencent.mm.R.l.ewN;
        com.tencent.mm.ui.base.g.h(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x0072:
        r0 = com.tencent.mm.R.l.eJZ;
        r1 = com.tencent.mm.R.l.dIO;
        com.tencent.mm.ui.base.g.h(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x007b:
        com.tencent.mm.platformtools.m.bo(r11);
        r0 = r10;
        goto L_0x001a;
    L_0x0080:
        r0 = com.tencent.mm.R.l.dOh;
        r0 = r11.getString(r0);
        r1 = "";
        r2 = new com.tencent.mm.ui.account.LoginHistoryUI$9;
        r2.<init>(r11);
        com.tencent.mm.ui.base.g.a(r11, r0, r1, r2);
        r0 = r10;
        goto L_0x001a;
    L_0x0093:
        r0 = com.tencent.mm.R.l.dOf;
        r1 = com.tencent.mm.R.l.btr;
        r2 = new com.tencent.mm.ui.account.LoginHistoryUI$10;
        r2.<init>(r11);
        com.tencent.mm.ui.base.g.a(r11, r0, r1, r2);
        r0 = r10;
        goto L_0x001a;
    L_0x00a2:
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        r0.a(r1, r11);
        r0 = r11.uUx;
        if (r0 != 0) goto L_0x00d8;
    L_0x00af:
        r1 = com.tencent.mm.R.l.eKg;
        r0 = r11.uYk;
        r2 = r0.uYX;
        r0 = r11.uYk;
        r3 = r0.uYW;
        r0 = r11.uYk;
        r4 = r0.uYU;
        r0 = r11.uYk;
        r5 = r0.uYV;
        r6 = new com.tencent.mm.ui.account.LoginHistoryUI$11;
        r6.<init>(r11, r12);
        r7 = 0;
        r8 = new com.tencent.mm.ui.account.LoginHistoryUI$12;
        r8.<init>(r11);
        r9 = r11.uYk;
        r0 = r11;
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r11.uUx = r0;
    L_0x00d5:
        r0 = r10;
        goto L_0x001a;
    L_0x00d8:
        r0 = "MicroMsg.LoginHistoryUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r11.uYk;
        r2 = r2.uYU;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r11.uYk;
        r2 = r2.uYW;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.sd();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r11.uUx;
        r1 = r11.uYk;
        r1 = r1.uYX;
        r2 = r11.uYk;
        r2 = r2.uYW;
        r3 = r11.uYk;
        r3 = r3.uYU;
        r4 = r11.uYk;
        r4 = r4.uYV;
        r0.a(r1, r2, r3, r4);
        goto L_0x00d5;
    L_0x0127:
        com.tencent.mm.u.ap.hold();
        r0 = com.tencent.mm.u.ap.uI();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0150;
    L_0x0134:
        r0 = com.tencent.mm.R.l.ezi;
        r0 = com.tencent.mm.bg.a.V(r11, r0);
    L_0x013a:
        r1 = com.tencent.mm.R.l.dIO;
        r1 = r11.getString(r1);
        r2 = new com.tencent.mm.ui.account.LoginHistoryUI$13;
        r2.<init>(r11);
        r3 = new com.tencent.mm.ui.account.LoginHistoryUI$14;
        r3.<init>(r11);
        com.tencent.mm.ui.base.g.a(r11, r0, r1, r2, r3);
        r0 = r10;
        goto L_0x001a;
    L_0x0150:
        r0 = com.tencent.mm.u.ap.uI();
        goto L_0x013a;
    L_0x0155:
        r0 = "MicroMsg.LoginHistoryUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = new java.lang.Object[r5];
        r3 = 0;
        r4 = r11.oVg;
        r4 = com.tencent.mm.sdk.platformtools.bg.Qj(r4);
        r2[r3] = r4;
        r3 = r11.uYn;
        r2[r10] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r11.uYk;
        com.tencent.mm.ui.account.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r11.oVg;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r11.uYm;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r11.uYn;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r0.putExtra(r1, r5);
        r1 = com.tencent.mm.plugin.c.a.imv;
        r1.f(r11, r0);
        r0 = r10;
        goto L_0x001a;
    L_0x019d:
        r0 = r11.fWY;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01aa;
    L_0x01a5:
        r0 = r11.fWY;
        com.tencent.mm.platformtools.m.j(r11, r14, r0);
    L_0x01aa:
        r0 = r10;
        goto L_0x001a;
    L_0x01ad:
        r0 = new com.tencent.mm.pluginsdk.j.p;
        r0.<init>(r12, r13, r14);
        r1 = r11.uYs;
        r0 = r1.a(r11, r0);
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.LoginHistoryUI.p(int, int, java.lang.String):boolean");
    }

    protected final int getLayoutId() {
        return R.i.dgU;
    }

    public void setRequestedOrientation(int i) {
    }

    public static void bf(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        com.tencent.mm.bb.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean bQO() {
        return true;
    }
}
