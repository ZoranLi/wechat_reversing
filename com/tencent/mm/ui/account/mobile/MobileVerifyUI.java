package com.tencent.mm.ui.account.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegByMobileVoiceVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.wcdb.FileUtils;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileVerifyUI extends MMActivity {
    String aIO;
    protected String fOI;
    int hSN;
    protected ProgressDialog isv = null;
    String lOq;
    String oVk;
    private Timer okA;
    private String[] pyE;
    private ContentResolver pyz;
    protected Button rxr;
    SecurityImage uUx = null;
    private com.tencent.mm.pluginsdk.j.a uYs;
    protected boolean uZk = false;
    private int vaH = 30;
    protected EditText vcL;
    protected TextView vdD;
    private int vds;
    protected MMFormInputView ved;
    protected TextView vee;
    protected TextView vef;
    protected TextView veg;
    protected ScrollView veh;
    private c vei;
    private long vej = 0;
    private boolean vek = false;
    private String vel;
    private boolean vem = false;
    Boolean ven;
    Boolean veo;
    protected boolean vep = false;
    protected boolean veq = false;
    protected int ves = -1;
    private b vet;
    String veu;

    protected enum a {
        ;

        public static int[] bRt() {
            return (int[]) veF.clone();
        }

        static {
            veB = 1;
            veC = 2;
            veD = 3;
            veE = 4;
            veF = new int[]{veB, veC, veD, veE};
        }
    }

    public interface b {
        void a(MobileVerifyUI mobileVerifyUI);

        void start();

        void stop();

        boolean zE(int i);
    }

    public class c extends ContentObserver {
        private Activity activity;
        final /* synthetic */ MobileVerifyUI vev;

        public c(MobileVerifyUI mobileVerifyUI, Activity activity) {
            this.vev = mobileVerifyUI;
            super(ae.fetchFreeHandler());
            this.activity = activity;
        }

        public final void onChange(boolean z) {
            super.onChange(z);
            if (this.vev.vds != 3) {
                w.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.activity, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")), bg.bJZ(), this.activity);
                if (com.tencent.mm.pluginsdk.i.a.a(this.activity, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")) {
                    this.vev.bRm();
                }
            }
        }
    }

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        mobileVerifyUI.vek = false;
        if (mobileVerifyUI.okA != null) {
            mobileVerifyUI.okA.cancel();
        }
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.vds) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bf.zK();
        this.veo = Boolean.valueOf(true);
        this.vds = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.veu = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.lOq = getIntent().getStringExtra("kintent_password");
        this.aIO = getIntent().getStringExtra("kintent_nickname");
        this.ven = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.uZk = getIntent().getBooleanExtra("from_deep_link", false);
        switch (this.vds) {
            case 2:
                this.vet = new h();
                if (this.lOq != null && this.lOq.length() >= 8) {
                    this.hSN = 1;
                    break;
                } else {
                    this.hSN = 4;
                    break;
                }
                break;
            case 3:
                this.vet = new f();
                break;
            case 4:
                this.vet = new g();
                break;
            default:
                w.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", Integer.valueOf(this.vds));
                finish();
                return;
        }
        String string = getString(R.l.dNS);
        if (d.sYQ) {
            string = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        qP(string);
        this.vaH = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.vep = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.veq = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.fOI = getIntent().getExtras().getString("bindmcontact_mobile");
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        KC();
        this.vet.a(this);
        if (this.veu != null) {
            this.vcL.setText(this.veu);
            btn();
        } else {
            this.vei = new c(this, this);
            getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.vei);
        }
        this.uYs = new com.tencent.mm.pluginsdk.j.a();
    }

    public void onDestroy() {
        if (this.vei != null) {
            getContentResolver().unregisterContentObserver(this.vei);
            this.vei = null;
        }
        if (this.uYs != null) {
            this.uYs.close();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.vet.start();
    }

    public void onPause() {
        super.onPause();
        this.vet.stop();
    }

    protected final int getLayoutId() {
        return R.i.djz;
    }

    private void aDK() {
        if (!this.vek) {
            this.okA = new Timer();
            this.vek = true;
            this.vej = (long) this.vaH;
            this.okA.schedule(new TimerTask(this) {
                final /* synthetic */ MobileVerifyUI vev;

                {
                    this.vev = r1;
                }

                public final void run() {
                    this.vev.vef.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 vew;

                        {
                            this.vew = r1;
                        }

                        public final void run() {
                            this.vew.vev.vej = this.vew.vev.vej - 1;
                            if (this.vew.vev.vej >= 0) {
                                this.vew.vev.vef.setText(this.vew.vev.getResources().getQuantityString(R.j.dsv, (int) this.vew.vev.vej, new Object[]{Integer.valueOf((int) this.vew.vev.vej)}));
                                return;
                            }
                            this.vew.vev.vef.setVisibility(8);
                            this.vew.vev.vee.setVisibility(0);
                            MobileVerifyUI.d(this.vew.vev);
                            this.vew.vev.vee.setEnabled(true);
                            this.vew.vev.vee.setText(this.vew.vev.getString(R.l.eBi));
                        }
                    });
                }
            }, 1000, 1000);
        }
    }

    public final void bit() {
        if (this.uSU.uTG == 1) {
            this.veh.scrollTo(0, this.veh.getChildAt(0).getMeasuredHeight() - this.veh.getMeasuredHeight());
        } else {
            this.veh.scrollTo(0, 0);
        }
    }

    protected final void KC() {
        w.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.fOI);
        this.ved = (MMFormInputView) findViewById(R.h.btq);
        MMFormInputView mMFormInputView = this.ved;
        if (mMFormInputView.oBT != null) {
            mMFormInputView.oBT.setImeOptions(5);
        } else {
            w.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
        this.ved.setInputType(3);
        this.vcL = this.ved.oBT;
        this.vee = (TextView) findViewById(R.h.ckK);
        this.vef = (TextView) findViewById(R.h.ckJ);
        this.vdD = (TextView) findViewById(R.h.bto);
        this.vdD.setText(this.fOI);
        this.fOI = an.PB(this.fOI);
        this.vee.setText(getString(R.l.eBj));
        this.veg = (TextView) findViewById(R.h.btr);
        this.rxr = (Button) findViewById(R.h.cnY);
        this.veh = (ScrollView) findViewById(R.h.cAe);
        this.pyE = getResources().getStringArray(R.c.aSp);
        this.veg.setText(Html.fromHtml(getString(R.l.eJI)));
        InputFilter[] inputFilterArr = new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return bg.K(charSequence);
            }
        }};
        this.vef.setVisibility(0);
        this.vef.setText(getResources().getQuantityString(R.j.dsv, this.vaH, new Object[]{Integer.valueOf(this.vaH)}));
        aDK();
        this.vem = false;
        this.vcL.setFilters(inputFilterArr);
        this.vcL.addTextChangedListener(new com.tencent.mm.ui.widget.MMEditText.c(this.vcL, null, 12));
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final void onClick(View view) {
                this.vev.btn();
            }
        });
        this.rxr.setEnabled(false);
        this.vcL.setTextSize(15.0f);
        this.vcL.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (bg.mA(this.vev.vcL.getText().toString())) {
                    this.vev.vcL.setTextSize(15.0f);
                    this.vev.vcL.setGravity(16);
                } else {
                    this.vev.vcL.setTextSize(24.0f);
                    this.vev.vcL.setGravity(16);
                }
                if (this.vev.vcL.getText() == null || this.vev.vcL.getText().toString().length() <= 0) {
                    this.vev.rxr.setEnabled(false);
                } else {
                    this.vev.rxr.setEnabled(true);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.vee.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileVerifyUI vev;
            private final int vex = 0;
            private final int vey = 1;
            private final int vez = 2;

            {
                this.vev = r2;
            }

            public final void onClick(View view) {
                l lVar = new l(this.vev);
                lVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ AnonymousClass8 veA;

                    {
                        this.veA = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.e(0, this.veA.vev.getString(R.l.eBj));
                        if (com.tencent.mm.ai.b.jN(this.veA.vev.fOI)) {
                            lVar.e(1, this.veA.vev.getString(R.l.dOn));
                        }
                        if (this.veA.vev.vds == 2 && this.veA.vev.veq) {
                            lVar.e(2, this.veA.vev.getString(R.l.eJL));
                        }
                    }
                };
                lVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass8 veA;

                    {
                        this.veA = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                this.veA.vev.OP();
                                return;
                            case 1:
                                this.veA.vev.aHf();
                                if (this.veA.vev.vds == 2) {
                                    com.tencent.mm.plugin.c.b.mN("R200_500");
                                } else if (this.veA.vev.vds == 3) {
                                    com.tencent.mm.plugin.c.b.mN("F200_300");
                                }
                                Intent intent = new Intent(this.veA.vev, RegByMobileVoiceVerifyUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("bindmcontact_mobile", this.veA.vev.fOI);
                                bundle.putInt("voice_verify_type", MobileVerifyUI.h(this.veA.vev));
                                intent.putExtras(bundle);
                                this.veA.vev.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                };
                lVar.blb();
            }
        });
        this.vee.setEnabled(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vev.goBack();
                return true;
            }
        });
        this.vcL.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.vev.btn();
                return true;
            }
        });
        this.vcL.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MobileVerifyUI vev;

            {
                this.vev = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.vev.btn();
                return true;
            }
        });
    }

    private void btn() {
        aHf();
        if (this.vcL.getText().toString().trim().equals("")) {
            g.h(this, R.l.dOl, R.l.dIO);
        } else {
            this.vet.zE(a.veC);
        }
    }

    private void OP() {
        this.vem = false;
        this.vee.setEnabled(false);
        this.vef.setVisibility(0);
        this.vef.setText(getResources().getQuantityString(R.j.dsv, this.vaH, new Object[]{Integer.valueOf(this.vaH)}));
        this.vee.setVisibility(8);
        aDK();
        this.vet.zE(a.veD);
        g.bl(this, getString(R.l.eAY));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.c.b.mN(this.oVk);
        if (!this.vet.zE(a.veB)) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            w.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", stringExtra);
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                OP();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean p(int r8, int r9, java.lang.String r10) {
        /*
        r7 = this;
        r3 = 0;
        r2 = 0;
        r1 = 1;
        r0 = com.tencent.mm.f.a.dn(r10);
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0.a(r7, r3, r3);
        r0 = r1;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = 4;
        if (r8 != r0) goto L_0x0014;
    L_0x0011:
        switch(r9) {
            case -75: goto L_0x0030;
            case -1: goto L_0x001c;
            default: goto L_0x0014;
        };
    L_0x0014:
        switch(r9) {
            case -100: goto L_0x0082;
            case -43: goto L_0x0040;
            case -41: goto L_0x004b;
            case -36: goto L_0x0056;
            case -34: goto L_0x0035;
            case -33: goto L_0x0074;
            case -32: goto L_0x0061;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r2;
    L_0x0018:
        if (r0 == 0) goto L_0x00bc;
    L_0x001a:
        r0 = r1;
        goto L_0x000d;
    L_0x001c:
        r0 = com.tencent.mm.u.ap.vd();
        r0 = r0.BR();
        r2 = 5;
        if (r0 != r2) goto L_0x0030;
    L_0x0027:
        r0 = com.tencent.mm.R.l.eDp;
        r2 = com.tencent.mm.R.l.eDo;
        com.tencent.mm.ui.base.g.h(r7, r0, r2);
        r0 = r1;
        goto L_0x000d;
    L_0x0030:
        com.tencent.mm.platformtools.m.bo(r7);
        r0 = r1;
        goto L_0x000d;
    L_0x0035:
        r0 = com.tencent.mm.R.l.dNy;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0040:
        r0 = com.tencent.mm.R.l.dNv;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x004b:
        r0 = com.tencent.mm.R.l.dNx;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0056:
        r0 = com.tencent.mm.R.l.dNA;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0061:
        r0 = com.tencent.mm.R.l.dOh;
        r0 = r7.getString(r0);
        r3 = "";
        r4 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$12;
        r4.<init>(r7);
        com.tencent.mm.ui.base.g.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x0074:
        r0 = com.tencent.mm.R.l.dOf;
        r3 = com.tencent.mm.R.l.btr;
        r4 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$2;
        r4.<init>(r7);
        com.tencent.mm.ui.base.g.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x0082:
        com.tencent.mm.u.ap.hold();
        r0 = r7.uSU;
        r3 = r0.uTo;
        r0 = com.tencent.mm.u.ap.uI();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x0093:
        r0 = r7.uSU;
        r0 = r0.uTo;
        r4 = com.tencent.mm.R.l.ezi;
        r0 = com.tencent.mm.bg.a.V(r0, r4);
    L_0x009d:
        r4 = r7.uSU;
        r4 = r4.uTo;
        r5 = com.tencent.mm.R.l.dIO;
        r4 = r4.getString(r5);
        r5 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$3;
        r5.<init>(r7);
        r6 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$4;
        r6.<init>(r7);
        com.tencent.mm.ui.base.g.a(r3, r0, r4, r5, r6);
        r0 = r1;
        goto L_0x0018;
    L_0x00b7:
        r0 = com.tencent.mm.u.ap.uI();
        goto L_0x009d;
    L_0x00bc:
        r0 = new com.tencent.mm.pluginsdk.j.p;
        r0.<init>(r8, r9, r10);
        r3 = r7.uYs;
        r0 = r3.a(r7, r0);
        if (r0 == 0) goto L_0x00cc;
    L_0x00c9:
        r0 = r1;
        goto L_0x000d;
    L_0x00cc:
        r0 = r2;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.mobile.MobileVerifyUI.p(int, int, java.lang.String):boolean");
    }

    protected final void kE(boolean z) {
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.l.eSZ));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
    }

    private void bRm() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.pyz = getContentResolver();
        String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
        String str2 = "( ";
        int i = 0;
        while (i < this.pyE.length) {
            str2 = i == this.pyE.length + -1 ? str2 + " body like \"%" + this.pyE[i] + "%\" ) " : str2 + "body like \"%" + this.pyE[i] + "%\" or ";
            i++;
        }
        String str3 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        w.v("MicroMsg.MobileVerifyUI", "sql where:" + str3);
        if (str3 != null && !str3.equals("")) {
            Cursor query;
            try {
                query = this.pyz.query(parse, strArr, str3, null, null);
                if (query != null) {
                    int i2 = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        try {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    this.vel = null;
                    if (i2 >= 0) {
                        query.moveToPosition(i2);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            str = matcher.group();
                        }
                        this.vel = str;
                        if (!this.vem) {
                            this.vem = true;
                            this.vcL.setText(this.vel);
                            aHf();
                            if (!this.vcL.getText().toString().trim().equals("")) {
                                if (this.isv != null) {
                                    this.isv.dismiss();
                                    this.isv = null;
                                }
                                this.vet.zE(a.veE);
                            }
                        }
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                } else if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    w.e("MicroMsg.MobileVerifyUI", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.close();
                throw th;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.MobileVerifyUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0) {
                    bRm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
