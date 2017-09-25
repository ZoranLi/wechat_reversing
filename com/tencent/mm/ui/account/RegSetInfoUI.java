package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.t;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private ProgressBar kYg;
    private String kwg;
    private String lOK;
    private Button liz;
    private int nXW = 0;
    private SecurityImage uUx = null;
    private a uYs;
    private boolean uZS = false;
    private EditText vaX;
    private String vaY;
    private String vaZ;
    private EditText vap;
    private int vba;
    private String vbb;
    private TextView vbc;
    private View vbd;
    private boolean vbe = false;
    private ImageView vbf;
    private int vbg = 3;
    private LinkedList<String> vbh = new LinkedList();
    private ImageView vbi;
    private ImageView vbj;
    private String vbk = "";
    private ImageView vbl;
    private View vbm;
    private TextView vbn;
    private String vbo = null;
    private boolean vbp = false;
    private o vbq;
    private View vbr;
    private boolean vbs = false;
    private aj vbt = new aj(Looper.myLooper(), new aj.a(this) {
        final /* synthetic */ RegSetInfoUI vbu;

        {
            this.vbu = r1;
        }

        public final boolean oQ() {
            String str;
            String trim = this.vbu.vaX.getText().toString().trim();
            String trim2 = this.vbu.vap.getText().toString().trim();
            if (bg.mA(trim) && !bg.mA(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (bg.mA(trim) || !bg.mA(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!bg.mA(trim) && this.vbu.bRa() && this.vbu.bRd()) {
                int e = this.vbu.bRh();
                String f = this.vbu.bRi();
                ap.vd().a(429, this.vbu);
                ap.vd().a(new x(f, this.vbu.kwg, e, str, trim, "", ""), 0);
                this.vbu.kYg.setVisibility(0);
            }
            return false;
        }
    }, true);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void q(com.tencent.mm.ui.account.RegSetInfoUI r18) {
        /*
        r0 = r18;
        r1 = r0.vap;
        r1 = r1.getText();
        r1 = r1.toString();
        r4 = r1.trim();
        r0 = r18;
        r1 = r0.vaX;
        r1 = r1.getText();
        r1 = r1.toString();
        r12 = r1.trim();
        if (r4 == 0) goto L_0x0028;
    L_0x0022:
        r1 = r4.length();
        if (r1 > 0) goto L_0x0032;
    L_0x0028:
        r1 = com.tencent.mm.R.l.eZQ;
        r2 = com.tencent.mm.R.l.eJP;
        r0 = r18;
        com.tencent.mm.ui.base.g.h(r0, r1, r2);
    L_0x0031:
        return;
    L_0x0032:
        r0 = r18;
        r1 = r0.kYg;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x005e;
    L_0x003c:
        r1 = com.tencent.mm.R.l.dIO;
        r0 = r18;
        r0.getString(r1);
        r1 = com.tencent.mm.R.l.eKf;
        r0 = r18;
        r1 = r0.getString(r1);
        r2 = 1;
        r3 = new com.tencent.mm.ui.account.RegSetInfoUI$6;
        r0 = r18;
        r3.<init>(r0);
        r0 = r18;
        r1 = com.tencent.mm.ui.base.g.a(r0, r1, r2, r3);
        r0 = r18;
        r0.isv = r1;
        goto L_0x0031;
    L_0x005e:
        r1 = r18.bRa();
        if (r1 == 0) goto L_0x00b1;
    L_0x0064:
        r1 = r18.bRd();
        if (r1 == 0) goto L_0x00b1;
    L_0x006a:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
        if (r1 != 0) goto L_0x00b1;
    L_0x0070:
        r0 = r18;
        r1 = r0.vbc;
        r1 = r1.getText();
        r1 = r1.toString();
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 != 0) goto L_0x0090;
    L_0x0082:
        r2 = com.tencent.mm.R.l.eKo;
        r0 = r18;
        r2 = r0.getString(r2);
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x00a2;
    L_0x0090:
        r0 = r18;
        r1 = r0.vbo;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x00ac;
    L_0x009a:
        r1 = com.tencent.mm.R.l.eKq;
        r0 = r18;
        r1 = r0.getString(r1);
    L_0x00a2:
        r2 = "";
        r3 = 1;
        r0 = r18;
        com.tencent.mm.ui.base.g.b(r0, r1, r2, r3);
        goto L_0x0031;
    L_0x00ac:
        r0 = r18;
        r1 = r0.vbo;
        goto L_0x00a2;
    L_0x00b1:
        r18.aHf();
        r1 = r18.bRd();
        if (r1 == 0) goto L_0x015b;
    L_0x00ba:
        r0 = r18;
        r1 = r0.vbh;
        if (r1 == 0) goto L_0x00ca;
    L_0x00c0:
        r0 = r18;
        r1 = r0.vbh;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0147;
    L_0x00ca:
        r1 = 0;
        r17 = r1;
    L_0x00cd:
        r11 = r18.bRh();
        r1 = com.tencent.mm.u.ap.vd();
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = r18;
        r1.a(r2, r0);
        r1 = new com.tencent.mm.modelsimple.w;
        r2 = "";
        r0 = r18;
        r3 = r0.lOK;
        r0 = r18;
        r5 = r0.vba;
        r0 = r18;
        r6 = r0.vaZ;
        r0 = r18;
        r7 = r0.vaY;
        r8 = "";
        r9 = "";
        r0 = r18;
        r10 = r0.kwg;
        r13 = "";
        r14 = "";
        r0 = r18;
        r15 = r0.vbe;
        r0 = r18;
        r0 = r0.uZS;
        r16 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r2 = r1.htt;
        r2 = r2.BG();
        r2 = (com.tencent.mm.protocal.y.a) r2;
        r2 = r2.tae;
        r0 = r17;
        r2.tSy = r0;
        r2 = com.tencent.mm.u.ap.vd();
        r3 = 0;
        r2.a(r1, r3);
        r2 = com.tencent.mm.R.l.dIO;
        r0 = r18;
        r0.getString(r2);
        r2 = com.tencent.mm.R.l.eKf;
        r0 = r18;
        r2 = r0.getString(r2);
        r3 = 1;
        r4 = new com.tencent.mm.ui.account.RegSetInfoUI$7;
        r0 = r18;
        r4.<init>(r0, r1);
        r0 = r18;
        r1 = com.tencent.mm.ui.base.g.a(r0, r2, r3, r4);
        r0 = r18;
        r0.isv = r1;
        goto L_0x0031;
    L_0x0147:
        r0 = r18;
        r1 = r0.vbh;
        r1 = r1.contains(r12);
        if (r1 == 0) goto L_0x0156;
    L_0x0151:
        r1 = 1;
        r17 = r1;
        goto L_0x00cd;
    L_0x0156:
        r1 = 2;
        r17 = r1;
        goto L_0x00cd;
    L_0x015b:
        r11 = r18.bRh();
        r1 = com.tencent.mm.u.ap.vd();
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = r18;
        r1.a(r2, r0);
        r1 = new com.tencent.mm.modelsimple.w;
        r2 = "";
        r0 = r18;
        r3 = r0.lOK;
        r0 = r18;
        r5 = r0.vba;
        r0 = r18;
        r6 = r0.vaZ;
        r0 = r18;
        r7 = r0.vaY;
        r8 = "";
        r9 = "";
        r0 = r18;
        r10 = r0.kwg;
        r12 = "";
        r13 = "";
        r14 = "";
        r0 = r18;
        r15 = r0.vbe;
        r0 = r18;
        r0 = r0.uZS;
        r16 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r2 = com.tencent.mm.u.ap.vd();
        r3 = 0;
        r2.a(r1, r3);
        r2 = com.tencent.mm.R.l.dIO;
        r0 = r18;
        r0.getString(r2);
        r2 = com.tencent.mm.R.l.eKf;
        r0 = r18;
        r2 = r0.getString(r2);
        r3 = 1;
        r4 = new com.tencent.mm.ui.account.RegSetInfoUI$8;
        r0 = r18;
        r4.<init>(r0, r1);
        r0 = r18;
        r1 = com.tencent.mm.ui.base.g.a(r0, r2, r3, r4);
        r0 = r18;
        r0.isv = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegSetInfoUI.q(com.tencent.mm.ui.account.RegSetInfoUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.eKp);
        if (d.sYQ) {
            string = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        qP(string);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.vaY = getIntent().getStringExtra("regsetinfo_user");
        this.vaZ = getIntent().getStringExtra("regsetinfo_bind_email");
        this.kwg = getIntent().getStringExtra("regsetinfo_ticket");
        this.lOK = getIntent().getStringExtra("regsetinfo_pwd");
        this.vbb = getIntent().getStringExtra("regsetinfo_binduin");
        if (!bg.mA(this.vbb)) {
            this.vba = com.tencent.mm.a.o.aY(this.vbb);
        }
        this.nXW = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.vbe = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.vbg = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        KC();
        if (this.nXW == 1) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",1");
            b.mM("R200_900_phone");
        } else if (this.nXW == 2) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R4_QQ," + ap.ec("R4_QQ") + ",1");
            b.mM("R4_QQ");
        } else if (this.nXW == 3) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R200_900_email," + ap.ec("R200_900_email") + ",1");
            b.mM("R200_900_email");
        }
        this.vbs = false;
        this.uYs = new a();
    }

    public void onResume() {
        super.onResume();
        this.vap.postDelayed(new Runnable(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void run() {
                this.vbu.vbf.requestFocus();
                this.vbu.vap.clearFocus();
            }
        }, 500);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.nXW == 1) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",2");
        } else if (this.nXW == 2) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R4_QQ," + ap.ec("R4_QQ") + ",2");
        } else if (this.nXW == 3) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R200_900_email," + ap.ec("R200_900_email") + ",2");
        }
        if (this.uYs != null) {
            this.uYs.close();
        }
    }

    protected final void KC() {
        int i;
        int i2 = 0;
        this.vbr = findViewById(R.h.csb);
        this.vbm = findViewById(R.h.cCI);
        this.vbf = (ImageView) findViewById(R.h.cCH);
        this.vap = (EditText) findViewById(R.h.cxt);
        this.vbn = (TextView) findViewById(R.h.cCK);
        this.vaX = (EditText) findViewById(R.h.cxw);
        this.vbc = (TextView) findViewById(R.h.bos);
        this.vbd = findViewById(R.h.cxK);
        this.vbi = (ImageView) findViewById(R.h.cob);
        this.vbj = (ImageView) findViewById(R.h.cSL);
        this.kYg = (ProgressBar) findViewById(R.h.cto);
        this.vbl = (ImageView) findViewById(R.h.cCJ);
        this.liz = (Button) findViewById(R.h.cnY);
        this.vbi.setVisibility(8);
        this.vbj.setVisibility(8);
        this.kYg.setVisibility(8);
        this.vbl.setVisibility(8);
        this.uZS = false;
        this.vbp = false;
        this.vbm.setVisibility(bRc() ? 0 : 8);
        View view = this.vbd;
        if (bRd()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.vbc;
        if (!bRd()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (bRc() && bRd()) {
            this.vbn.setText(getString(R.l.eKm));
        } else if (bRc() && !bRd()) {
            this.vbn.setText(getString(R.l.eKk));
        } else if (bRc() || !bRd()) {
            this.vbn.setText(getString(R.l.eKj));
        } else {
            this.vbn.setText(getString(R.l.eKl));
        }
        ap.vL().a(new af.a(this) {
            Bitmap mBitmap;
            String mwO;
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean Bo() {
                if (!bg.mA(this.mwO) && bg.mA((this.vbu.vap.getText()).trim())) {
                    this.vbu.vap.setText(this.mwO);
                }
                if (f.rZ()) {
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled() || this.vbu.uZS)) {
                        this.vbu.vbf.setImageBitmap(this.mBitmap);
                        this.vbu.uZS = true;
                        this.vbu.vbl.setVisibility(0);
                    }
                    return true;
                }
                w.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
                return false;
            }

            public final boolean Bn() {
                try {
                    this.mwO = c.ba(this.vbu);
                    this.mBitmap = c.bb(this.vbu);
                } catch (Exception e) {
                    w.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
                }
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.gSG + "temp.avatar", false);
                    } catch (Throwable e2) {
                        w.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                        w.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView";
            }
        });
        this.vap.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void afterTextChanged(Editable editable) {
                CharSequence trim = this.vbu.vap.getText().toString().trim();
                if (trim == null || trim.length() <= 16) {
                    if (!this.vbu.vbt.bJq()) {
                        this.vbu.vbt.KH();
                    }
                    this.vbu.bRb();
                    if (bg.mA(this.vbu.vap.getText().toString().trim())) {
                        this.vbu.vbi.setVisibility(8);
                    } else {
                        this.vbu.vbi.setVisibility(0);
                    }
                    if (!this.vbu.vbs) {
                        this.vbu.vaX.setText(trim);
                        return;
                    }
                    return;
                }
                this.vbu.vap.setText(trim.substring(0, 16));
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void onClick(View view) {
                RegSetInfoUI.q(this.vbu);
            }
        });
        this.vaX.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.vbu.vbs = true;
                    this.vbu.vbt.v(200, 200);
                }
            }
        });
        this.vaX.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.vbu.vbt.bJq()) {
                    this.vbu.vbt.KH();
                }
                String trim = this.vbu.vaX.getText().toString().trim();
                if (bg.mA(trim)) {
                    this.vbu.vbc.setText(this.vbu.getString(R.l.eKo));
                    this.vbu.K(false, false);
                    if (this.vbu.vbq != null) {
                        this.vbu.vbq.dismiss();
                        this.vbu.vbq = null;
                    }
                    this.vbu.vaX.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass32 vbH;

                        {
                            this.vbH = r1;
                        }

                        public final void run() {
                            this.vbH.vbu.vaX.clearFocus();
                            this.vbH.vbu.vaX.requestFocus();
                        }
                    }, 50);
                }
                if (!bg.mA(trim) && (this.vbu.bRa() || !trim.equals(this.vbu.vbk))) {
                    this.vbu.K(false, false);
                    this.vbu.vbt.v(500, 500);
                }
                this.vbu.vbk = trim;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vbu.aXS();
                return true;
            }
        });
        this.vap.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.q(this.vbu);
                return true;
            }
        });
        this.vap.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.q(this.vbu);
                return true;
            }
        });
        this.vaX.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.q(this.vbu);
                return true;
            }
        });
        this.vaX.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.q(this.vbu);
                return true;
            }
        });
        this.vbf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI vbu;

            {
                this.vbu = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.c.a.imw.c(this.vbu);
            }
        });
        File file = new File(com.tencent.mm.compatible.util.e.gSG);
        if (!file.exists()) {
            file.mkdir();
        }
        bRb();
    }

    private void K(boolean z, boolean z2) {
        boolean z3 = false;
        if (bg.mA(this.vaX.getText().toString().trim())) {
            z = false;
        }
        this.vbj.setImageResource(z2 ? R.g.bkb : R.g.bjY);
        this.vbj.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.vbp = z3;
    }

    private boolean bRa() {
        return this.vbj.getVisibility() == 8 || this.vbp;
    }

    private void bRb() {
        this.liz.setEnabled(!bg.mA(this.vap.getText().toString().trim()));
    }

    private boolean bRc() {
        return (this.vbg & 1) > 0;
    }

    private boolean bRd() {
        return (this.vbg & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        w.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap a = com.tencent.mm.plugin.c.a.imw.a((Activity) this, i, i2, intent);
        if (a != null) {
            this.vbf.setImageBitmap(a);
            this.uZS = true;
            this.vbl.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dmB;
    }

    private boolean bRe() {
        return this.nXW == 1;
    }

    private boolean bRf() {
        return this.nXW == 2;
    }

    private boolean bRg() {
        return this.nXW == 3;
    }

    private int bRh() {
        if (bRe()) {
            return 4;
        }
        if (bRf() || !bRg()) {
            return 2;
        }
        return 6;
    }

    private String bRi() {
        if (bRe()) {
            return this.vaY;
        }
        if (bRg()) {
            return this.vaZ;
        }
        return this.vbb;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int PY;
        com.tencent.mm.f.a dn;
        w.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 126) {
            ap.vd().b(126, (e) this);
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                String str4;
                final k kVar2;
                final String str5;
                final String str6;
                final boolean z;
                final k kVar3;
                final String str7;
                final String str8;
                final int i3;
                this.vbo = null;
                final String bRi = bRi();
                final String Jr = ((com.tencent.mm.modelsimple.w) kVar).Jr();
                final int Js = ((com.tencent.mm.modelsimple.w) kVar).Js();
                String str9 = null;
                String str10 = null;
                boolean z2 = false;
                Map q = bh.q(((com.tencent.mm.modelsimple.w) kVar).Jt(), "wording");
                if (q != null) {
                    str2 = (String) q.get(".wording.switch");
                    if (bg.mA(str2)) {
                        z2 = true;
                    } else {
                        PY = bg.PY(str2);
                        if (PY == 0) {
                            z2 = false;
                        } else if (PY == 1) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        str2 = (String) q.get(".wording.title");
                        if (!bg.mA(str2)) {
                            str9 = str2;
                        }
                        str2 = (String) q.get(".wording.desc");
                        if (bg.mA(str2)) {
                            str3 = str9;
                        } else {
                            str10 = str2;
                            str3 = str9;
                        }
                        w.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                        ap.unhold();
                        ap.aT(true);
                        if (this.uZS) {
                            this.kwg = ((com.tencent.mm.modelsimple.w) kVar).Jq();
                            ao.hlW.L("login_user_name", bRi);
                            if (Jr == null && Jr.contains("0")) {
                                b.mN("R300_100_phone");
                                if (z2) {
                                    intent = new Intent(this, FindMContactAlertUI.class);
                                    intent.putExtra("alert_title", str3);
                                    intent.putExtra("alert_message", str10);
                                } else {
                                    intent = new Intent(this, FindMContactIntroUI.class);
                                }
                                intent.addFlags(67108864);
                                intent.putExtra("regsetinfo_ticket", this.kwg);
                                intent.putExtra("regsetinfo_NextStep", Jr);
                                intent.putExtra("regsetinfo_NextStyle", Js);
                                Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this);
                                ak.addFlags(67108864);
                                ak.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, intent, ak);
                                finish();
                            } else {
                                intent = com.tencent.mm.plugin.c.a.imv.ak(this);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(intent);
                                b.mO(ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                finish();
                            }
                        } else {
                            str4 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar";
                            str2 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
                            new File(str4).renameTo(new File(str2));
                            com.tencent.mm.loader.stub.b.deleteFile(str4);
                            com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                            kVar2 = kVar;
                            str5 = bRi;
                            str6 = Jr;
                            z = z2;
                            kVar3 = kVar;
                            str7 = str3;
                            str8 = str10;
                            i3 = Js;
                            new com.tencent.mm.pluginsdk.model.o(this, com.tencent.mm.compatible.util.e.gSG + "temp.avatar").a(new Runnable(this) {
                                final /* synthetic */ RegSetInfoUI vbu;

                                public final void run() {
                                    this.vbu.kwg = ((com.tencent.mm.modelsimple.w) kVar2).Jq();
                                    ao.hlW.L("login_user_name", str5);
                                    com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSG + "temp.avatar");
                                    if (str6 == null || !str6.contains("0")) {
                                        Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vbu);
                                        ak.addFlags(67108864);
                                        this.vbu.startActivity(ak);
                                        b.mO(ap.uY() + "," + this.vbu.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                        this.vbu.finish();
                                        return;
                                    }
                                    b.mN("R300_100_phone");
                                    if (z) {
                                        ak = new Intent(this.vbu, FindMContactAlertUI.class);
                                        ak.putExtra("alert_title", str3);
                                        ak.putExtra("alert_message", str10);
                                    } else {
                                        ak = new Intent(this.vbu, FindMContactIntroUI.class);
                                    }
                                    ak.addFlags(67108864);
                                    ak.putExtra("regsetinfo_ticket", this.vbu.kwg);
                                    ak.putExtra("regsetinfo_NextStep", str6);
                                    ak.putExtra("regsetinfo_NextStyle", Js);
                                    Intent ak2 = com.tencent.mm.plugin.c.a.imv.ak(this.vbu);
                                    ak2.addFlags(67108864);
                                    MMWizardActivity.b(this.vbu, ak, ak2);
                                    this.vbu.finish();
                                }
                            }, new Runnable(this) {
                                final /* synthetic */ RegSetInfoUI vbu;

                                public final void run() {
                                    this.vbu.kwg = ((com.tencent.mm.modelsimple.w) kVar3).Jq();
                                    ao.hlW.L("login_user_name", bRi);
                                    if (Jr == null || !Jr.contains("0")) {
                                        Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vbu);
                                        ak.addFlags(67108864);
                                        this.vbu.startActivity(ak);
                                        b.mO(ap.uY() + "," + this.vbu.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                        this.vbu.finish();
                                        return;
                                    }
                                    b.mN("R300_100_phone");
                                    if (z2) {
                                        ak = new Intent(this.vbu, FindMContactAlertUI.class);
                                        ak.putExtra("alert_title", str7);
                                        ak.putExtra("alert_message", str8);
                                    } else {
                                        ak = new Intent(this.vbu, FindMContactIntroUI.class);
                                    }
                                    ak.addFlags(67108864);
                                    ak.putExtra("regsetinfo_ticket", this.vbu.kwg);
                                    ak.putExtra("regsetinfo_NextStep", Jr);
                                    ak.putExtra("regsetinfo_NextStyle", i3);
                                    Intent ak2 = com.tencent.mm.plugin.c.a.imv.ak(this.vbu);
                                    ak2.addFlags(67108864);
                                    MMWizardActivity.b(this.vbu, ak, ak2);
                                    this.vbu.finish();
                                }
                            });
                        }
                    }
                }
                str3 = null;
                w.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                ap.unhold();
                ap.aT(true);
                if (this.uZS) {
                    this.kwg = ((com.tencent.mm.modelsimple.w) kVar).Jq();
                    ao.hlW.L("login_user_name", bRi);
                    if (Jr == null) {
                    }
                    intent = com.tencent.mm.plugin.c.a.imv.ak(this);
                    intent.addFlags(67108864);
                    intent.putExtra("LauncherUI.enter_from_reg", true);
                    startActivity(intent);
                    b.mO(ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                    finish();
                } else {
                    str4 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar";
                    str2 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
                    new File(str4).renameTo(new File(str2));
                    com.tencent.mm.loader.stub.b.deleteFile(str4);
                    com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                    kVar2 = kVar;
                    str5 = bRi;
                    str6 = Jr;
                    z = z2;
                    kVar3 = kVar;
                    str7 = str3;
                    str8 = str10;
                    i3 = Js;
                    new com.tencent.mm.pluginsdk.model.o(this, com.tencent.mm.compatible.util.e.gSG + "temp.avatar").a(/* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                    return;
                } else if (p(i, i2, str)) {
                    return;
                }
            } else if (this.uUx == null) {
                final k kVar4 = kVar;
                kVar4 = kVar;
                this.uUx = SecurityImage.a.a(this.uSU.uTo, R.l.eKg, 0, ((com.tencent.mm.modelsimple.w) kVar).FI(), ((com.tencent.mm.modelsimple.w) kVar).FJ(), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.vbu.vaX.getText().toString().trim();
                        String trim2 = this.vbu.vap.getText().toString().trim();
                        if (trim2 == null || trim2.length() <= 0) {
                            g.h(this.vbu, R.l.eZQ, R.l.eJP);
                            return;
                        }
                        int e = this.vbu.bRh();
                        ap.vd().a(126, this.vbu);
                        final k wVar = new com.tencent.mm.modelsimple.w("", this.vbu.lOK, trim2, this.vbu.vba, this.vbu.vaZ, this.vbu.vaY, "", "", this.vbu.kwg, e, trim, ((com.tencent.mm.modelsimple.w) kVar4).FJ(), this.vbu.uUx.bRz(), this.vbu.vbe, this.vbu.uZS);
                        ap.vd().a(wVar, 0);
                        RegSetInfoUI regSetInfoUI = this.vbu;
                        Context context = this.vbu;
                        this.vbu.getString(R.l.dIO);
                        regSetInfoUI.isv = g.a(context, this.vbu.getString(R.l.eKf), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass11 vbC;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(wVar);
                                ap.vd().b(126, this.vbC.vbu);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.vbu.uUx = null;
                    }
                }, new SecurityImage.b(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    public final void bQI() {
                        this.vbu.aHf();
                        String trim = this.vbu.vaX.getText().toString().trim();
                        String trim2 = this.vbu.vap.getText().toString().trim();
                        int e = this.vbu.bRh();
                        ap.vd().a(126, this.vbu);
                        ap.vd().a(new com.tencent.mm.modelsimple.w("", this.vbu.lOK, trim2, this.vbu.vba, this.vbu.vaZ, this.vbu.vaY, "", "", this.vbu.kwg, e, trim, ((com.tencent.mm.modelsimple.w) kVar4).FJ(), "", this.vbu.vbe, this.vbu.uZS), 0);
                    }
                });
                return;
            } else {
                this.uUx.a(0, ((com.tencent.mm.modelsimple.w) kVar).FI(), ((com.tencent.mm.modelsimple.w) kVar).FJ(), "");
                return;
            }
        }
        if (kVar.getType() == 429) {
            ap.vd().b(429, (e) this);
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            this.kYg.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.vbo = null;
                PY = ((t.b) ((x) kVar).htt.zg()).sZY.tHm;
                w.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", Integer.valueOf(PY));
                if (PY == -14 || PY == -10 || PY == -7) {
                    LinkedList linkedList = ((t.b) ((x) kVar).htt.zg()).sZY.jNe;
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        this.vbc.setText(dn.desc);
                    }
                    this.vbh.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        final String[] strArr = new String[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            strArr[i4] = ((avx) linkedList.get(i4)).tZr;
                            this.vbh.add(strArr[i4]);
                        }
                        if (this.vbs) {
                            if (this.vbq != null) {
                                this.vbq.dismiss();
                                this.vbq = null;
                            }
                            this.vbq = g.a(this, this.vbr, strArr, new OnItemClickListener(this) {
                                final /* synthetic */ RegSetInfoUI vbu;

                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    if (this.vbu.vbq != null) {
                                        this.vbu.vbq.dismiss();
                                        this.vbu.vbq = null;
                                    }
                                    this.vbu.vaX.setText(strArr[i]);
                                    this.vbu.vaX.postDelayed(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass19 vbG;

                                        {
                                            this.vbG = r1;
                                        }

                                        public final void run() {
                                            this.vbG.vbu.vaX.clearFocus();
                                            this.vbG.vbu.vaX.requestFocus();
                                        }
                                    }, 50);
                                    this.vbu.vbc.setText(this.vbu.getString(R.l.eKo));
                                }
                            });
                        }
                    }
                    K(true, true);
                    return;
                } else if (bg.mA(this.vaX.getText().toString().trim())) {
                    K(false, false);
                    return;
                } else {
                    K(true, false);
                    this.vbc.setText(getString(R.l.eKo));
                    if (this.vbq != null) {
                        this.vbq.dismiss();
                        this.vbq = null;
                    }
                    this.vaX.postDelayed(new Runnable(this) {
                        final /* synthetic */ RegSetInfoUI vbu;

                        {
                            this.vbu = r1;
                        }

                        public final void run() {
                            this.vbu.vaX.clearFocus();
                            this.vbu.vaX.requestFocus();
                        }
                    }, 50);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                K(true, true);
            } else if (this.uUx == null) {
                kVar4 = kVar;
                kVar4 = kVar;
                this.uUx = SecurityImage.a.a(this.uSU.uTo, R.l.eKg, 0, ((x) kVar).FI(), ((x) kVar).FJ(), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.vbu.vap.getText().toString().trim();
                        String trim2 = this.vbu.vaX.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            g.h(this.vbu, R.l.eZQ, R.l.eJP);
                            return;
                        }
                        this.vbu.aHf();
                        int e = this.vbu.bRh();
                        String f = this.vbu.bRi();
                        ap.vd().a(429, this.vbu);
                        final k xVar = new x(f, this.vbu.kwg, e, trim, trim2, ((x) kVar4).FJ(), this.vbu.uUx.bRz());
                        ap.vd().a(xVar, 0);
                        RegSetInfoUI regSetInfoUI = this.vbu;
                        Context context = this.vbu;
                        this.vbu.getString(R.l.dIO);
                        regSetInfoUI.isv = g.a(context, this.vbu.getString(R.l.eKf), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass16 vbE;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(xVar);
                                ap.vd().b(429, this.vbE.vbu);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.vbu.uUx = null;
                    }
                }, new SecurityImage.b(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    public final void bQI() {
                        this.vbu.aHf();
                        int e = this.vbu.bRh();
                        String f = this.vbu.bRi();
                        ap.vd().a(429, this.vbu);
                        ap.vd().a(new x(f, this.vbu.kwg, e, "", "", ((x) kVar4).FJ(), ""), 0);
                    }
                });
                return;
            } else {
                this.uUx.a(0, ((x) kVar).FI(), ((x) kVar).FJ(), "");
                return;
            }
        }
        if (!p(i, i2, str)) {
            if (i == 8) {
                this.vbo = getString(R.l.elu, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, this.vbo, 0).show();
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(R.l.elL, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean p(int i, int i2, String str) {
        if (this.uYs.a(this, new p(i, i2, str))) {
            return true;
        }
        if (com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -100:
                ap.hold();
                g.a(this.uSU.uTo, TextUtils.isEmpty(ap.uI()) ? com.tencent.mm.bg.a.V(this.uSU.uTo, R.l.ezi) : ap.uI(), this.uSU.uTo.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -75:
                g.h(this, R.l.dDf, R.l.eJb);
                return true;
            case -48:
                com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                } else {
                    g.b(this, getString(R.l.eKn), "", true);
                }
                return true;
            case -10:
            case -7:
                g.h(this, R.l.eJa, R.l.eJb);
                return true;
            default:
                return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        aHf();
        if (bRe()) {
            g.a((Context) this, getString(R.l.eKi), "", new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RegSetInfoUI vbu;

                {
                    this.vbu = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.mN("R200_100");
                    Intent intent = new Intent(this.vbu, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 2);
                    intent.addFlags(67108864);
                    this.vbu.startActivity(intent);
                    this.vbu.finish();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RegSetInfoUI vbu;

                {
                    this.vbu = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (!bRf()) {
            if ((this.nXW == 0 ? 1 : null) != null) {
                g.a((Context) this, getString(R.l.eKh), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mN("R400_100_signup");
                        Intent intent = new Intent(this.vbu, LoginUI.class);
                        intent.addFlags(67108864);
                        this.vbu.startActivity(intent);
                        this.vbu.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (bRg()) {
                g.a((Context) this, getString(R.l.eKh), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mN("R500_100");
                        Intent intent = new Intent(this.vbu, RegByEmailUI.class);
                        intent.addFlags(67108864);
                        this.vbu.startActivity(intent);
                        this.vbu.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI vbu;

                    {
                        this.vbu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                b.mN("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }
}
