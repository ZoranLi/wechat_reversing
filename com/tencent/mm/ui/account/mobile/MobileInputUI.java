package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.il;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.account.MMKeyboardUperView;
import com.tencent.mm.ui.account.ResizeLayout;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.e;
import com.tencent.wcdb.database.SQLiteDatabase;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected String hJF = null;
    protected int hmn;
    protected EditText ljL;
    protected int[] nkt = new int[5];
    protected String oVk;
    protected String ota = null;
    protected TextView qUS;
    private c uXF = new c<il>(this) {
        final /* synthetic */ MobileInputUI vdu;

        {
            this.vdu = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    protected p uYL;
    private ResizeLayout uYq;
    protected LinearLayout uZF;
    protected TextView uZG;
    protected String uZJ = null;
    protected boolean uZK = true;
    protected TextView uZO;
    protected Button uZP;
    protected Button uZQ;
    protected MMFormInputView uZg;
    private MMKeyboardUperView uZj;
    protected boolean uZk = false;
    protected CheckBox uZy;
    protected MMFormInputView vdk;
    protected EditText vdl;
    protected MMFormVerifyCodeInputView vdm;
    protected View vdn;
    protected TextView vdo;
    protected TextView vdp;
    protected Button vdq;
    protected String vdr = null;
    private int vds = 0;
    private b vdt;

    protected enum a {
        ;

        public static int[] bRs() {
            return (int[]) vdy.clone();
        }

        static {
            vdw = 1;
            vdx = 2;
            vdy = new int[]{vdw, vdx};
        }
    }

    public interface b {
        void a(MobileInputUI mobileInputUI);

        void start();

        void stop();

        void zD(int i);
    }

    static /* synthetic */ boolean a(MobileInputUI mobileInputUI, String str) {
        return str != null && str.length() > 0 && mobileInputUI.uZK && (!mobileInputUI.bRq() || mobileInputUI.uZy.isChecked());
    }

    static /* synthetic */ void bh(Context context, String str) {
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

    static /* synthetic */ boolean d(MobileInputUI mobileInputUI) {
        if (mobileInputUI.vds != -1) {
            if (mobileInputUI.bRq() && !mobileInputUI.uZy.isChecked()) {
                return false;
            }
            mobileInputUI.bRr();
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.djx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vds = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.hmn = getIntent().getIntExtra("mobile_auth_type", 0);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vdu.goBack();
                return true;
            }
        }, R.k.dtY);
        switch (this.vds) {
            case -1:
                this.vdt = new e();
                break;
            case 1:
                if (!bg.mA(getIntent().getStringExtra("auth_ticket"))) {
                    this.vdt = new e();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.nkt = intArrayExtra;
                }
                this.vdt = new c();
                a(new OnMenuItemClickListener(this) {
                    final /* synthetic */ MobileInputUI vdu;

                    {
                        this.vdu = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.vdu.goBack();
                        return true;
                    }
                }, R.k.dsP);
                overridePendingTransition(R.a.aQL, R.a.aQL);
                break;
            case 2:
                this.vdt = new d();
                break;
            case 3:
                this.vdt = new b();
                break;
            case 4:
                this.vdt = new d();
                break;
            default:
                w.e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.vds));
                finish();
                return;
        }
        this.countryCode = an.PC(bg.ap(getIntent().getStringExtra("input_country_code"), ""));
        this.hJF = bg.ap(getIntent().getStringExtra("country_name"), "");
        this.uZJ = bg.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.vdr = an.PD(this.countryCode);
        this.ota = bg.ap(getIntent().getStringExtra("input_mobile_number"), "");
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        KC();
        this.uZk = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.uZk || bg.mA(this.vdr) || bg.mA(this.ota))) {
            this.vdk.setText(this.ota);
        }
        this.vdt.a(this);
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        this.vdt.start();
        aHj();
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        this.vdt.stop();
    }

    public void finish() {
        super.finish();
        if (this.vds == 1) {
            overridePendingTransition(R.a.aQL, R.a.aQL);
        }
        g.oUh.i(14262, Integer.valueOf(this.nkt[0]), Integer.valueOf(this.nkt[1]), Integer.valueOf(this.nkt[2]), Integer.valueOf(this.nkt[3]), Integer.valueOf(this.nkt[4]));
    }

    public void onDestroy() {
        this.vdm.reset();
        super.onDestroy();
    }

    private boolean bRq() {
        return this.vds == 2;
    }

    protected final void KC() {
        this.uZg = (MMFormInputView) findViewById(R.h.cCL);
        this.ljL = this.uZg.oBT;
        com.tencent.mm.ui.tools.a.c.d(this.ljL).Ch(16).a(null);
        this.vdk = (MMFormInputView) findViewById(R.h.ckF);
        this.vdk.setInputType(3);
        this.vdl = this.vdk.oBT;
        this.vdm = (MMFormVerifyCodeInputView) findViewById(R.h.cFR);
        this.vdm.bRT();
        this.uZF = (LinearLayout) findViewById(R.h.bGQ);
        this.uZG = (TextView) findViewById(R.h.bGS);
        this.vdn = findViewById(R.h.cxr);
        this.uZy = (CheckBox) findViewById(R.h.bnW);
        this.uZO = (TextView) findViewById(R.h.bnY);
        this.uZP = (Button) findViewById(R.h.bnV);
        this.uZQ = (Button) findViewById(R.h.cnY);
        this.vdo = (TextView) findViewById(R.h.cxJ);
        this.vdp = (TextView) findViewById(R.h.ccJ);
        this.qUS = (TextView) findViewById(R.h.ckE);
        this.vdq = (Button) findViewById(R.h.ccC);
        this.uYq = (ResizeLayout) findViewById(R.h.cyC);
        this.uZj = (MMKeyboardUperView) findViewById(R.h.Ki);
        this.uZF.setVisibility(8);
        this.uZg.setVisibility(8);
        this.vdm.setVisibility(8);
        this.vdk.setVisibility(8);
        this.vdo.setVisibility(8);
        this.vdp.setVisibility(8);
        this.uZQ.setVisibility(8);
        this.vdn.setVisibility(8);
        this.vdq.setVisibility(8);
        this.uZy.setVisibility(8);
        this.uZy.setChecked(true);
        this.uYq.vbI = new com.tencent.mm.ui.account.ResizeLayout.a(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void bQP() {
                this.vdu.uZj.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 vdv;

                    {
                        this.vdv = r1;
                    }

                    public final void run() {
                        this.vdv.vdu.uZj.fullScroll(130);
                    }
                });
            }
        };
        this.uZj.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.vdu.aHf();
                return false;
            }
        });
        this.vdl.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (MobileInputUI.a(this.vdu, this.vdu.vdk.getText().toString())) {
                    this.vdu.uZQ.setEnabled(true);
                } else {
                    this.vdu.uZQ.setEnabled(false);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.vdl.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 5) {
                    return MobileInputUI.d(this.vdu);
                }
                return false;
            }
        });
        this.vdl.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 == i && keyEvent.getAction() == 0) {
                    return MobileInputUI.d(this.vdu);
                }
                return false;
            }
        });
        this.uZQ.setEnabled(false);
        this.uZQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void onClick(View view) {
                this.vdu.bRr();
            }
        });
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            w.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bg.mA(simCountryIso)) {
                w.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(this, simCountryIso, getString(R.l.bGO));
                if (g == null) {
                    w.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.countryCode = an.PC(g.hJE);
                    this.hJF = g.hJF;
                }
            }
        }
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            this.hJF = getString(R.l.eaQ);
            this.countryCode = an.PC(getString(R.l.eaP));
        }
        bQW();
        if (bg.mA(this.uZJ)) {
            this.vdl.setText(this.uZJ);
        }
        this.uZF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.vdu.hJF);
                intent.putExtra("couttry_code", this.vdu.countryCode);
                com.tencent.mm.plugin.c.a.imv.b(intent, this.vdu);
            }
        });
        final e eVar = new e(this, e.wuP, false);
        eVar.qJf = new n.c(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void a(l lVar) {
                if (lVar.size() == 0) {
                    lVar.e(1, this.vdu.getString(R.l.eIY));
                    lVar.e(2, this.vdu.getString(R.l.ewP));
                }
            }
        };
        eVar.qJg = new n.d(this) {
            final /* synthetic */ MobileInputUI vdu;

            {
                this.vdu = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        MobileInputUI.bh(this.vdu, this.vdu.getString(R.l.ewO) + v.bIN());
                        return;
                    case 2:
                        String string = this.vdu.getString(R.l.fnd);
                        if (v.bIN().equals("zh_CN")) {
                            string = string + "zh_CN";
                        } else {
                            string = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                        }
                        MobileInputUI.bh(this.vdu, string);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.wva = new com.tencent.mm.ui.widget.e.a(this) {
            final /* synthetic */ MobileInputUI vdu;

            public final void onDismiss() {
                eVar.bzi();
            }
        };
        qP("");
        cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
        cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
        a(0, R.l.dUG, R.k.dsQ, new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileInputUI vdu;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vdu.aHf();
                eVar.bzh();
                return true;
            }
        });
    }

    private void bRr() {
        aHf();
        this.vdt.zD(a.vdx);
    }

    private void goBack() {
        this.vdt.zD(a.vdw);
        com.tencent.mm.plugin.c.b.mN(this.oVk);
        aHf();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void bQW() {
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            this.uZG.setText(getString(R.l.eAX));
        } else {
            this.uZG.setText(an.ez(this.hJF, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                    String str = "MicroMsg.MobileInputUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(bg.mA(stringExtra));
                    if (!bg.mA(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(intExtra);
                    w.d(str, str2, objArr);
                    if (intExtra == -217) {
                        bRr();
                        return;
                    }
                    return;
                }
                return;
            case 100:
                this.hJF = bg.ap(intent.getStringExtra("country_name"), "");
                this.countryCode = bg.ap(intent.getStringExtra("couttry_code"), "");
                bQW();
                return;
            default:
                return;
        }
    }

    public void setRequestedOrientation(int i) {
    }
}
