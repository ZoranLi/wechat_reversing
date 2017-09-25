package com.tencent.mm.ui.account;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.j.a;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;

public class RegByMobileRegAIOUI extends MMActivity implements e {
    private String countryCode = null;
    private String hJF = null;
    private int iQX;
    private ImageView ipv;
    private String oVk;
    private String ota = null;
    private int progress = 0;
    private c uXF = new c<il>(this) {
        final /* synthetic */ RegByMobileRegAIOUI val;

        {
            this.val = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.RegByMobileRegAIOUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private p uYL;
    private ResizeLayout uYq;
    private LinearLayout uZF;
    private TextView uZG;
    private EditText uZH;
    private MMFormInputView uZI;
    private String uZJ = null;
    private boolean uZK = true;
    private String uZL;
    private String uZM;
    private String uZN = null;
    private TextView uZO;
    private Button uZP;
    private Button uZQ;
    private MMFormInputView uZR;
    private boolean uZS = false;
    private ImageView uZT;
    private MMFormInputView uZU;
    private int uZV = 0;
    private boolean uZW;
    private boolean uZX;
    private ScrollView uZY;
    private boolean uZZ = false;
    private ProgressBar vaa;
    private h vab = null;
    private ae vac = new ae(this) {
        final /* synthetic */ RegByMobileRegAIOUI val;

        {
            this.val = r1;
        }

        public final void handleMessage(Message message) {
            if ((this.val.vab == null || this.val.vab.isShowing()) && !this.val.vae) {
                this.val.progress = this.val.progress + 2;
                this.val.vaa.setProgress(this.val.progress);
                if (this.val.progress < this.val.vaa.getMax()) {
                    sendEmptyMessageDelayed(0, 10);
                    return;
                }
                this.val.vaa.setIndeterminate(true);
                if (!this.val.vae) {
                    if (this.val.vab != null) {
                        this.val.vab.dismiss();
                    }
                    this.val.SO(null);
                }
            }
        }
    };
    private j vad;
    private boolean vae = false;
    private a vaf = new a(this) {
        final /* synthetic */ RegByMobileRegAIOUI val;

        {
            this.val = r1;
        }

        public final void SP(String str) {
            this.val.SO(str.trim());
        }

        public final void bQX() {
            this.val.SO(null);
        }
    };
    private int vag;
    private int vah;
    private boolean vai;
    private boolean vaj;
    private final int vak = FileUtils.S_IWUSR;

    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] uZE = new int[a.bRj().length];

        static {
            try {
                uZE[a.vbO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                uZE[a.vbP - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                uZE[a.vbR - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                uZE[a.vbQ - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ void a(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        View currentFocus = regByMobileRegAIOUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - regByMobileRegAIOUI.cO().cP().getHeight()) - 128;
            if (height > 0) {
                regByMobileRegAIOUI.uZY.post(new Runnable(regByMobileRegAIOUI) {
                    final /* synthetic */ RegByMobileRegAIOUI val;

                    public final void run() {
                        this.val.uZY.smoothScrollBy(0, height);
                    }
                });
            }
        }
    }

    static /* synthetic */ boolean b(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        int i = bg.mA(regByMobileRegAIOUI.countryCode) ? 0 : 1;
        boolean a = regByMobileRegAIOUI.uZX ? i & regByMobileRegAIOUI.a(regByMobileRegAIOUI.uZH.getText(), regByMobileRegAIOUI.uZR.getText(), regByMobileRegAIOUI.uZU.getText()) : i & regByMobileRegAIOUI.a(regByMobileRegAIOUI.uZH.getText(), regByMobileRegAIOUI.uZU.getText());
        if (a) {
            regByMobileRegAIOUI.uZQ.setEnabled(true);
        } else {
            regByMobileRegAIOUI.uZQ.setEnabled(false);
        }
        return a;
    }

    static /* synthetic */ void c(RegByMobileRegAIOUI regByMobileRegAIOUI, String str) {
        String obj;
        if (regByMobileRegAIOUI.uZX) {
            int i;
            obj = regByMobileRegAIOUI.uZR.getText().toString();
            if (obj.length() > 16) {
                regByMobileRegAIOUI.zB(a.vbP);
                i = 0;
            } else if (bg.PH(obj)) {
                g.h(regByMobileRegAIOUI, R.l.eJB, R.l.eJP);
                i = 0;
            } else if (bg.PM(obj)) {
                boolean z = true;
            } else {
                if (obj.length() < 8 || obj.length() >= 16) {
                    regByMobileRegAIOUI.zB(a.vbQ);
                } else {
                    regByMobileRegAIOUI.zB(a.vbR);
                }
                i = 0;
            }
            if (i == 0) {
                return;
            }
        }
        if (regByMobileRegAIOUI.uYL != null) {
            w.d("MicroMsg.RegByMobileRegAIOUI", "already checking ");
            return;
        }
        regByMobileRegAIOUI.getString(R.l.dIO);
        regByMobileRegAIOUI.uYL = g.a((Context) regByMobileRegAIOUI, regByMobileRegAIOUI.getString(R.l.eJC), true, new OnCancelListener(regByMobileRegAIOUI) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        if (regByMobileRegAIOUI.iQX == 0) {
            obj = an.PB(regByMobileRegAIOUI.uZH.getText().toString().trim());
            int i2 = (regByMobileRegAIOUI.uZL == null || regByMobileRegAIOUI.uZM == null || obj.equals(regByMobileRegAIOUI.uZL) || !obj.equals(regByMobileRegAIOUI.uZM)) ? (regByMobileRegAIOUI.uZL == null || regByMobileRegAIOUI.uZM == null || regByMobileRegAIOUI.uZM.equals(regByMobileRegAIOUI.uZL) || obj.equals(regByMobileRegAIOUI.uZM)) ? 0 : 2 : 1;
            k sVar = new s(str, 12, "", 0, "");
            sVar.fG(regByMobileRegAIOUI.uZV);
            sVar.fH(i2);
            ap.vd().a(sVar, 0);
            regByMobileRegAIOUI.uZL = an.PB(regByMobileRegAIOUI.uZH.getText().toString().trim());
            regByMobileRegAIOUI.uZV++;
            return;
        }
        throw new IllegalArgumentException("NO IMPLEMENT");
    }

    protected final int getLayoutId() {
        return R.i.dmx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hJF = bg.ap(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bg.ap(getIntent().getStringExtra("couttry_code"), "");
        this.uZJ = bg.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.iQX = getIntent().getIntExtra("login_type", 0);
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        bf.zK();
        com.tencent.mm.plugin.c.b.hi(20);
        KC();
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        ap.vd().a(701, (e) this);
        ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
        ap.vd().a(132, (e) this);
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_100," + ap.ec("RE200_100") + ",1");
        aHj();
        this.uZV = 0;
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        ap.vd().b(701, (e) this);
        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
        ap.vd().b(132, (e) this);
        com.tencent.mm.plugin.c.b.mM("RE200_100");
    }

    protected final void KC() {
        this.uZF = (LinearLayout) findViewById(R.h.bGQ);
        this.uZG = (TextView) findViewById(R.h.bGS);
        this.uZI = (MMFormInputView) findViewById(R.h.cxB);
        this.uZI.setInputType(3);
        this.uZH = this.uZI.oBT;
        this.uZO = (TextView) findViewById(R.h.bnY);
        this.uZQ = (Button) findViewById(R.h.cxs);
        this.ipv = (ImageView) findViewById(R.h.cCH);
        this.uZT = (ImageView) findViewById(R.h.cCJ);
        this.uZR = (MMFormInputView) findViewById(R.h.cxz);
        com.tencent.mm.ui.tools.a.c.d(this.uZR.oBT).Ch(16).a(null);
        this.uZY = (ScrollView) findViewById(R.h.Ki);
        this.uYq = (ResizeLayout) findViewById(R.h.cyC);
        this.uZU = (MMFormInputView) findViewById(R.h.cxu);
        this.uZU.oBT.requestFocus();
        this.uYq.vbI = new ResizeLayout.a(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void bQP() {
                RegByMobileRegAIOUI.a(this.val);
            }
        };
        OnFocusChangeListener anonymousClass19 = new OnFocusChangeListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    RegByMobileRegAIOUI.a(this.val);
                }
            }
        };
        this.uZU.vjo = anonymousClass19;
        this.uZR.vjo = anonymousClass19;
        bf.zK();
        this.uZX = true;
        bf.zK();
        this.uZW = true;
        if (!this.uZW) {
            this.ipv.setVisibility(8);
            this.uZT.setVisibility(8);
        }
        if (!this.uZX) {
            this.uZR.setVisibility(8);
        }
        String string = getString(R.l.eJY);
        if (d.sYQ) {
            string = string + getString(R.l.dDc);
        }
        qP(string);
        if (this.uZP != null) {
            this.uZP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.val.uSU.uTo, this.val.getString(R.l.eZp));
                }
            });
        }
        string = getString(R.l.ewh);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (v.bIK()) {
            string2 = getString(R.l.ewi);
            string3 = getString(R.l.eGS);
            string4 = getString(R.l.dDh);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.val.uSU.uTo, this.val.getString(R.l.eZp));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.val.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.val.uSU.uTo, "http://www.qq.com/privacy.htm");
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.val.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + str.length()) + string2.length()) + string4.length()) + string3.length(), 33);
            this.uZO.setText(newSpannable);
        } else {
            string2 = getString(R.l.ewk);
            string3 = getString(R.l.ewj);
            string4 = getString(R.l.dDh);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.val.uSU.uTo, this.val.getString(R.l.eZt));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.val.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.val.uSU.uTo, this.val.getString(R.l.eZs));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.val.getResources().getColor(R.e.aUA));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            this.uZO.setText(newSpannable);
        }
        this.uZO.setMovementMethod(LinkMovementMethod.getInstance());
        this.uZH.addTextChangedListener(new TextWatcher(this) {
            private an mRA = new an();
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r2;
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.val);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.uZR.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.val);
            }
        });
        this.uZU.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.val);
            }
        });
        this.uZQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c em = com.tencent.mm.ui.tools.a.c.d(this.val.uZU.oBT).em(1, 32);
                em.wpp = true;
                em.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass4 vam;

                    {
                        this.vam = r1;
                    }

                    public final void ro(String str) {
                        this.vam.val.ota = an.PB(this.vam.val.uZH.getText().toString());
                        this.vam.val.uZN = an.PD(this.vam.val.countryCode);
                        String str2 = this.vam.val.uZN + this.vam.val.ota;
                        this.vam.val.aHf();
                        RegByMobileRegAIOUI.c(this.vam.val, str2);
                    }

                    public final void YN() {
                        g.h(this.vam.val, R.l.eSW, R.l.eSY);
                    }

                    public final void Yp() {
                        g.h(this.vam.val, R.l.eSX, R.l.eSY);
                    }
                });
            }
        });
        this.uZQ.setEnabled(false);
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            string = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            w.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + string);
            if (bg.mA(string)) {
                w.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(this, string, getString(R.l.bGO));
                if (g == null) {
                    w.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                } else {
                    this.hJF = g.hJF;
                    this.countryCode = g.hJE;
                }
            }
        }
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            this.hJF = getString(R.l.eaQ);
            this.countryCode = an.PC(getString(R.l.eaP));
        }
        bQW();
        if (this.uZJ == null || this.uZJ.equals("")) {
            ap.vL().a(new af.a(this) {
                String kvq;
                final /* synthetic */ RegByMobileRegAIOUI val;

                {
                    this.val = r1;
                }

                public final boolean Bo() {
                    if (bg.mA((this.val.uZH.getText()).trim())) {
                        this.val.uZH.setText(bg.mA(this.kvq) ? "" : this.kvq);
                    }
                    return true;
                }

                public final boolean Bn() {
                    this.kvq = com.tencent.mm.modelsimple.c.y(this.val, this.val.countryCode);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView1";
                }
            });
        } else {
            this.uZH.setText(this.uZJ);
        }
        this.uZF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.val.hJF);
                intent.putExtra("couttry_code", this.val.countryCode);
                com.tencent.mm.plugin.c.a.imv.b(intent, this.val);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.val.aHf();
                this.val.aXS();
                this.val.finish();
                return true;
            }
        });
        this.ipv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.c.a.imw.c(this.val);
            }
        });
        ap.vL().a(new af.a(this) {
            Bitmap bitmap;
            String fFa;
            final /* synthetic */ RegByMobileRegAIOUI val;

            {
                this.val = r1;
            }

            public final boolean Bo() {
                if (!bg.mA(this.fFa) && bg.mA((this.val.uZU.getText()).trim())) {
                    this.val.uZU.setText(this.fFa);
                }
                if (f.rZ()) {
                    if (!(this.bitmap == null || this.bitmap.isRecycled() || this.val.uZS)) {
                        this.val.ipv.setImageBitmap(this.bitmap);
                        this.val.uZT.setVisibility(8);
                        this.val.uZS = true;
                    }
                    return true;
                }
                w.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
                return false;
            }

            public final boolean Bn() {
                this.fFa = com.tencent.mm.modelsimple.c.ba(this.val);
                this.bitmap = com.tencent.mm.modelsimple.c.bb(this.val);
                if (!(this.bitmap == null || this.bitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.bitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.gSG + "temp.avatar", false);
                    } catch (Throwable e) {
                        w.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                        w.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "", new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView2";
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        com.tencent.mm.plugin.c.b.mN(this.oVk);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",RE200_100," + ap.ec("RE200_100") + ",2");
        finish();
    }

    private void bQW() {
        if (bg.mA(this.hJF) || bg.mA(this.countryCode)) {
            this.uZG.setText(getString(R.l.eAX));
        } else {
            this.uZG.setText(an.ez(this.hJF, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.hJF = bg.ap(intent.getStringExtra("country_name"), "");
                this.countryCode = bg.ap(intent.getStringExtra("couttry_code"), "");
                bQW();
                return;
            default:
                Bitmap a = com.tencent.mm.plugin.c.a.imw.a((Activity) this, i, i2, intent);
                if (a != null) {
                    this.ipv.setImageBitmap(a);
                    this.uZS = true;
                    this.uZT.setVisibility(8);
                    return;
                }
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.uYL != null) {
            this.uYL.dismiss();
            this.uYL = null;
        }
        if (i2 == -75) {
            g.h(this, R.l.dDf, R.l.eJb);
            return;
        }
        com.tencent.mm.f.a dn;
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX) {
            int AJ = ((s) kVar).AJ();
            if (AJ == 12) {
                if (i2 == -41 || i2 == -59) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this, null, null);
                        return;
                    } else {
                        g.h(this, R.l.eJJ, R.l.eJK);
                        return;
                    }
                } else if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Fw = ((s) kVar).Fw();
                    if (!bg.mA(Fw)) {
                        this.ota = Fw.trim();
                    }
                    this.ota = an.PB(this.ota);
                    this.uZM = this.uZN + this.ota;
                    com.tencent.mm.plugin.c.b.mM("RE200_100");
                    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_200," + ap.ec("RE200_200") + ",1");
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByMobileRegAIOUI val;

                            {
                                this.val = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                RegByMobileRegAIOUI regByMobileRegAIOUI = this.val;
                                Context context = this.val;
                                this.val.getString(R.l.dIO);
                                regByMobileRegAIOUI.uYL = g.a(context, this.val.getString(R.l.eJC), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass11 van;

                                    {
                                        this.van = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                    }
                                });
                                ap.vd().a(new s(this.val.uZN + this.val.ota, 14, "", 0, ""), 0);
                                com.tencent.mm.plugin.c.b.mN("RE200_250");
                                this.val.uZZ = true;
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByMobileRegAIOUI val;

                            {
                                this.val = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + this.val.getClass().getName() + ",RE200_200," + ap.ec("RE200_200") + ",2");
                                com.tencent.mm.plugin.c.b.mN("RE200_100");
                            }
                        });
                        return;
                    }
                    getString(R.l.dIO);
                    this.uYL = g.a((Context) this, getString(R.l.eJC), true, new OnCancelListener(this) {
                        final /* synthetic */ RegByMobileRegAIOUI val;

                        {
                            this.val = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    ap.vd().a(new s(this.uZN + this.ota, 14, "", 0, ""), 0);
                    com.tencent.mm.plugin.c.b.mN("RE200_250");
                    this.uZZ = false;
                    return;
                } else if (i2 == -34) {
                    g.b(this, getString(R.l.dNy), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            }
            if (AJ == 14) {
                if (i2 == 0 || str == null) {
                    this.vag = ((s) kVar).Fy();
                    this.vah = ((s) kVar).Fz();
                    this.vai = ((s) kVar).FA();
                    this.vaj = ((s) kVar).FC();
                    if (this.vad == null) {
                        this.vad = new j(this, this.vaf);
                        this.vad.bRk();
                    }
                    if (this.vab == null) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.i.dmv, null);
                        this.vaa = (ProgressBar) inflate.findViewById(R.h.ctq);
                        TextView textView = (TextView) inflate.findViewById(R.h.cLA);
                        this.vab = g.a((Context) this, false, getString(R.l.dNP), inflate, "", "", null, null);
                        textView.setText(this.countryCode + " " + this.uZH.getText().toString());
                    } else {
                        this.vab.show();
                    }
                    this.progress = 0;
                    this.vaa.setIndeterminate(false);
                    this.vac.sendEmptyMessage(10);
                } else if (i2 == -41) {
                    g.h(this, R.l.eJJ, R.l.eJK);
                    return;
                } else if (i2 == -34) {
                    g.b(this, getString(R.l.dNy), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            }
        }
        if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str) && kVar.getType() == 701) {
            dn = com.tencent.mm.f.a.dn(str);
            if (dn != null && dn.a(this, null, null)) {
            }
        }
    }

    protected void onDestroy() {
        if (this.vad != null) {
            this.vad.bRl();
            this.vad = null;
        }
        if (this.vab != null) {
            this.vab.dismiss();
        }
        super.onDestroy();
    }

    private synchronized void SO(String str) {
        if (this.vad != null) {
            this.vad.bRl();
            this.vad = null;
        }
        if (!this.vae) {
            this.vae = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.uZN + " " + this.uZH.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.ota);
            intent.putExtra("country_name", this.hJF);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("login_type", this.iQX);
            intent.putExtra("mobileverify_countdownsec", this.vag);
            intent.putExtra("mobileverify_countdownstyle", this.vah);
            intent.putExtra("mobileverify_fb", this.vai);
            intent.putExtra("mobileverify_reg_qq", this.vaj);
            intent.putExtra("kintent_nickname", this.uZU.getText().toString());
            intent.putExtra("kintent_password", this.uZR.getText().toString());
            intent.putExtra("kintent_hasavatar", this.uZS);
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
        }
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        for (Object obj : editableArr) {
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.uZK) {
            return true;
        }
        return false;
    }

    private void zB(int i) {
        switch (AnonymousClass18.uZE[i - 1]) {
            case 1:
                g.h(this, R.l.eJN, R.l.eJP);
                return;
            case 2:
                g.h(this, R.l.eJO, R.l.eJP);
                return;
            case 3:
                g.h(this, R.l.eZW, R.l.dGS);
                return;
            case 4:
                g.h(this, R.l.eZY, R.l.dGS);
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileRegAIOUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.vad != null) {
                    this.vad.bRm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
