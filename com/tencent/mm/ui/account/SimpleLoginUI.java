package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class SimpleLoginUI extends MMWizardActivity implements e {
    private TextWatcher acO = new TextWatcher(this) {
        final /* synthetic */ SimpleLoginUI vbY;

        {
            this.vbY = r1;
        }

        public final void afterTextChanged(Editable editable) {
            SimpleLoginUI.a(this.vbY);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String fWY = "";
    private ProgressDialog isv = null;
    private String oVg;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ SimpleLoginUI vbY;

        {
            this.vbY = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.SimpleLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
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
    private MMClearEditText uZd;
    private MMClearEditText uZe;
    private MMFormInputView uZf;
    private MMFormInputView uZg;
    private Button uZh;
    private MMKeyboardUperView uZj;

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        if (bg.mA(simpleLoginUI.uZd.getText().toString()) || bg.mA(simpleLoginUI.uZe.getText().toString())) {
            simpleLoginUI.uZh.setEnabled(false);
        } else {
            simpleLoginUI.uZh.setEnabled(true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dgT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", 4);
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        zi(R.l.bpJ);
        if (a.imw != null) {
            a.imw.ox();
        }
        KC();
        ap.vd().a(701, (e) this);
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
    }

    public void onDestroy() {
        ap.vd().b(701, (e) this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.oVg = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.oVg = extras.getString("auth_ticket");
        }
        if (!bg.mA(this.oVg)) {
            this.uZd.setText(bg.mz(f.bQQ()));
            this.uZe.setText(bg.mz(f.bQR()));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ SimpleLoginUI vbY;

                {
                    this.vbY = r1;
                }

                public final void run() {
                    this.vbY.Tq();
                }
            }, 500);
        }
    }

    protected final void KC() {
        this.uZf = (MMFormInputView) findViewById(R.h.ccA);
        this.uZg = (MMFormInputView) findViewById(R.h.ccF);
        this.uZd = (MMClearEditText) this.uZf.oBT;
        this.uZd.setFocusableInTouchMode(false);
        this.uZd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.vbY.uZd.setFocusableInTouchMode(true);
                return this.vbY.uZd.rlX.onTouch(view, motionEvent);
            }
        });
        this.uZe = (MMClearEditText) this.uZg.oBT;
        this.uZe.setFocusableInTouchMode(false);
        this.uZe.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.vbY.uZe.setFocusableInTouchMode(true);
                this.vbY.uZd.setFocusableInTouchMode(false);
                return this.vbY.uZe.rlX.onTouch(view, motionEvent);
            }
        });
        com.tencent.mm.ui.tools.a.c.d(this.uZe).Ch(16).a(null);
        this.uZh = (Button) findViewById(R.h.ccB);
        this.uZh.setEnabled(false);
        this.uZd.addTextChangedListener(this.acO);
        this.uZe.addTextChangedListener(this.acO);
        this.uZe.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.vbY.Tq();
                return true;
            }
        });
        this.uZe.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.vbY.Tq();
                return true;
            }
        });
        this.uYq = (ResizeLayout) findViewById(R.h.cyC);
        this.uZj = (MMKeyboardUperView) findViewById(R.h.Ki);
        this.uYq.vbI = new ResizeLayout.a(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final void bQP() {
                this.vbY.uZj.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass18 vcb;

                    {
                        this.vcb = r1;
                    }

                    public final void run() {
                        this.vcb.vbY.uZj.fullScroll(130);
                    }
                });
            }
        };
        this.uZj.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.vbY.aHf();
                return false;
            }
        });
        findViewById(R.h.ccC).setVisibility(8);
        View findViewById = findViewById(R.h.bPm);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        zi(R.l.ccJ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vbY.aXS();
                return true;
            }
        });
        this.oVg = getIntent().getStringExtra("auth_ticket");
        if (!bg.mA(this.oVg)) {
            this.uZd.setText(bg.mz(f.bQQ()));
            this.uZe.setText(bg.mz(f.bQR()));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ SimpleLoginUI vbY;

                {
                    this.vbY = r1;
                }

                public final void run() {
                    this.vbY.Tq();
                }
            }, 500);
        }
        if (f.usv) {
            a.imw.d(this);
        }
        this.uZh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SimpleLoginUI vbY;

            {
                this.vbY = r1;
            }

            public final void onClick(View view) {
                this.vbY.Tq();
            }
        });
    }

    private void aXS() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        zu(1);
        if (booleanExtra) {
            exit(1);
        }
    }

    private void Tq() {
        this.uYk.hSs = this.uZd.getText().toString().trim();
        this.uYk.uYS = this.uZe.getText().toString();
        if (this.uYk.hSs.equals("")) {
            g.h(this, R.l.faa, R.l.ewN);
        } else if (this.uYk.uYS.equals("")) {
            g.h(this, R.l.eZX, R.l.ewN);
        } else {
            aHf();
            final k uVar = new u(this.uYk.hSs, this.uYk.uYS, this.oVg, 0);
            ap.vd().a(uVar, 0);
            getString(R.l.dIO);
            this.isv = g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ SimpleLoginUI vbY;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    protected void onPause() {
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.y.k r14) {
        /*
        r10 = this;
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd: errType = ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " errMsg = ";
        r1 = r1.append(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "Scene Type ";
        r1.<init>(r2);
        r2 = r14.getType();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r10.isv;
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r10.isv;
        r0.dismiss();
        r0 = 0;
        r10.isv = r0;
    L_0x0052:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Jh();
        r10.fWY = r0;
        r1 = 0;
        r0 = r14.getType();
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r2) goto L_0x02e0;
    L_0x0064:
        r2 = r10.uYk;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Ji();
        r2.uYX = r0;
        r2 = r10.uYk;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.FJ();
        r2.uYU = r0;
        r2 = r10.uYk;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.FI();
        r2.uYW = r0;
        r2 = r10.uYk;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Jj();
        r2.uYV = r0;
        r0 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r12 != r0) goto L_0x00af;
    L_0x0094:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Fv();
        r10.oVg = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Jk();
        r10.uYm = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.u) r0;
        r0 = r0.Jn();
        r10.uYn = r0;
    L_0x00af:
        r0 = 4;
        if (r11 != r0) goto L_0x02e0;
    L_0x00b2:
        r0 = -16;
        if (r12 == r0) goto L_0x00ba;
    L_0x00b6:
        r0 = -17;
        if (r12 != r0) goto L_0x02e0;
    L_0x00ba:
        r0 = 1;
        r1 = com.tencent.mm.u.ap.vd();
        r2 = new com.tencent.mm.u.bb;
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$10;
        r3.<init>(r10);
        r2.<init>(r3);
        r3 = 0;
        r1.a(r2, r3);
    L_0x00cd:
        if (r0 != 0) goto L_0x00d3;
    L_0x00cf:
        if (r11 != 0) goto L_0x0153;
    L_0x00d1:
        if (r12 != 0) goto L_0x0153;
    L_0x00d3:
        com.tencent.mm.u.ap.unhold();
        com.tencent.mm.modelsimple.d.bc(r10);
        r0 = r10.uYk;
        r0 = r0.hSs;
        com.tencent.mm.platformtools.m.mv(r0);
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = new com.tencent.mm.ui.account.SimpleLoginUI$11;
        r1.<init>(r10);
        r2 = new com.tencent.mm.plugin.accountsync.a.b;
        r2.<init>(r0, r1);
        r0 = com.tencent.mm.plugin.c.a.imw;
        r0 = r0.a(r2);
        r2.fGg = r0;
        r0 = r2.fGg;
        if (r0 != 0) goto L_0x0104;
    L_0x00fa:
        r0 = r2.irK;
        if (r0 == 0) goto L_0x0103;
    L_0x00fe:
        r0 = r2.irK;
        r0.OA();
    L_0x0103:
        return;
    L_0x0104:
        r0 = r2.fGg;
        r0 = r0.getType();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        if (r0 != r1) goto L_0x013f;
    L_0x010e:
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r0.a(r1, r2);
    L_0x0117:
        r0 = com.tencent.mm.u.ap.vd();
        r1 = r2.fGg;
        r3 = 0;
        r0.a(r1, r3);
        r0 = r2.context;
        r1 = r2.context;
        r3 = com.tencent.mm.R.l.dIO;
        r1.getString(r3);
        r1 = r2.context;
        r3 = com.tencent.mm.R.l.dHA;
        r1 = r1.getString(r3);
        r3 = 1;
        r4 = new com.tencent.mm.plugin.accountsync.a.b$1;
        r4.<init>(r2);
        r0 = com.tencent.mm.ui.base.g.a(r0, r1, r3, r4);
        r2.irJ = r0;
        goto L_0x0103;
    L_0x013f:
        r0 = r2.fGg;
        r0 = r0.getType();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        if (r0 != r1) goto L_0x0117;
    L_0x0149:
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r0.a(r1, r2);
        goto L_0x0117;
    L_0x0153:
        r0 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        if (r12 != r0) goto L_0x0161;
    L_0x0157:
        r14 = (com.tencent.mm.modelsimple.u) r14;
        r0 = com.tencent.mm.pluginsdk.a.a.a(r14);
        com.tencent.mm.platformtools.m.a(r10, r0, r12);
        goto L_0x0103;
    L_0x0161:
        r0 = com.tencent.mm.plugin.c.a.imw;
        r1 = r10.uSU;
        r1 = r1.uTo;
        r0 = r0.a(r1, r11, r12, r13);
        if (r0 == 0) goto L_0x019f;
    L_0x016d:
        r0 = 1;
    L_0x016e:
        if (r0 != 0) goto L_0x0103;
    L_0x0170:
        r0 = com.tencent.mm.f.a.dn(r13);
        if (r0 == 0) goto L_0x017e;
    L_0x0176:
        r1 = 0;
        r2 = 0;
        r0 = r0.a(r10, r1, r2);
        if (r0 != 0) goto L_0x0103;
    L_0x017e:
        r0 = com.tencent.mm.R.l.elh;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r12);
        r1[r2] = r3;
        r0 = r10.getString(r0, r1);
        r1 = 0;
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
        goto L_0x0103;
    L_0x019f:
        r0 = 4;
        if (r11 != r0) goto L_0x01a5;
    L_0x01a2:
        switch(r12) {
            case -311: goto L_0x01e3;
            case -310: goto L_0x01e3;
            case -205: goto L_0x027f;
            case -140: goto L_0x02ca;
            case -106: goto L_0x02da;
            case -100: goto L_0x0262;
            case -75: goto L_0x01da;
            case -72: goto L_0x01cd;
            case -30: goto L_0x01bb;
            case -9: goto L_0x01c4;
            case -6: goto L_0x01e3;
            case -4: goto L_0x01bb;
            case -3: goto L_0x01bb;
            case -1: goto L_0x01a7;
            default: goto L_0x01a5;
        };
    L_0x01a5:
        r0 = 0;
        goto L_0x016e;
    L_0x01a7:
        r0 = com.tencent.mm.u.ap.vd();
        r0 = r0.BR();
        r1 = 5;
        if (r0 != r1) goto L_0x01bb;
    L_0x01b2:
        r0 = com.tencent.mm.R.l.eDp;
        r1 = com.tencent.mm.R.l.eDo;
        com.tencent.mm.ui.base.g.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01bb:
        r0 = com.tencent.mm.R.l.efc;
        r1 = com.tencent.mm.R.l.ewN;
        com.tencent.mm.ui.base.g.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01c4:
        r0 = com.tencent.mm.R.l.ewM;
        r1 = com.tencent.mm.R.l.ewN;
        com.tencent.mm.ui.base.g.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01cd:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.eJZ;
        r2 = com.tencent.mm.R.l.dIO;
        com.tencent.mm.ui.base.g.h(r0, r1, r2);
        r0 = 1;
        goto L_0x016e;
    L_0x01da:
        r0 = r10.uSU;
        r0 = r0.uTo;
        com.tencent.mm.platformtools.m.bo(r0);
        r0 = 1;
        goto L_0x016e;
    L_0x01e3:
        r0 = r10.uUx;
        if (r0 != 0) goto L_0x0213;
    L_0x01e7:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.eKg;
        r2 = r10.uYk;
        r2 = r2.uYX;
        r3 = r10.uYk;
        r3 = r3.uYW;
        r4 = r10.uYk;
        r4 = r4.uYU;
        r5 = r10.uYk;
        r5 = r5.uYV;
        r6 = new com.tencent.mm.ui.account.SimpleLoginUI$6;
        r6.<init>(r10);
        r7 = 0;
        r8 = new com.tencent.mm.ui.account.SimpleLoginUI$7;
        r8.<init>(r10);
        r9 = r10.uYk;
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r10.uUx = r0;
    L_0x0210:
        r0 = 1;
        goto L_0x016e;
    L_0x0213:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r10.uYk;
        r2 = r2.uYU;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r10.uYk;
        r2 = r2.uYW;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.sd();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r10.uUx;
        r1 = r10.uYk;
        r1 = r1.uYX;
        r2 = r10.uYk;
        r2 = r2.uYW;
        r3 = r10.uYk;
        r3 = r3.uYU;
        r4 = r10.uYk;
        r4 = r4.uYV;
        r0.a(r1, r2, r3, r4);
        goto L_0x0210;
    L_0x0262:
        com.tencent.mm.u.ap.hold();
        r0 = com.tencent.mm.u.ap.uI();
        r1 = com.tencent.mm.R.l.dIO;
        r1 = r10.getString(r1);
        r2 = new com.tencent.mm.ui.account.SimpleLoginUI$8;
        r2.<init>(r10);
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$9;
        r3.<init>(r10);
        com.tencent.mm.ui.base.g.a(r10, r0, r1, r2, r3);
        r0 = 1;
        goto L_0x016e;
    L_0x027f:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.oVg;
        r4 = com.tencent.mm.sdk.platformtools.bg.Qj(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r10.uYn;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r10.uYk;
        com.tencent.mm.ui.account.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r10.oVg;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r10.uYm;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r10.uYn;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r2 = 3;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.plugin.c.a.imv;
        r1.f(r10, r0);
        r0 = 1;
        goto L_0x016e;
    L_0x02ca:
        r0 = r10.fWY;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x02d7;
    L_0x02d2:
        r0 = r10.fWY;
        com.tencent.mm.platformtools.m.j(r10, r13, r0);
    L_0x02d7:
        r0 = 1;
        goto L_0x016e;
    L_0x02da:
        com.tencent.mm.platformtools.m.E(r10, r13);
        r0 = 1;
        goto L_0x016e;
    L_0x02e0:
        r0 = r1;
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.SimpleLoginUI.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
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
