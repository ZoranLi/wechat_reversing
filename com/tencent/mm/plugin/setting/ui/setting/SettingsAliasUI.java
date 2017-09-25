package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;

public class SettingsAliasUI extends MMActivity implements e {
    private String gtR;
    private ImageView ipv;
    private ProgressDialog isv = null;
    private TextView jWd;
    private TextView lNw;
    private e pjE = null;
    private EditText pkK;
    private b pkL;
    private boolean pkM = false;
    private TextView pkN;

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        if (settingsAliasUI.gtR.equals(m.xL())) {
            g.h(settingsAliasUI.uSU.uTo, R.l.eBp, R.l.eBn);
        } else if (bg.PL(settingsAliasUI.gtR)) {
            Context context = settingsAliasUI.uSU.uTo;
            settingsAliasUI.getString(R.l.eBn);
            settingsAliasUI.isv = g.a(context, settingsAliasUI.getString(R.l.eBm), true, new OnCancelListener(settingsAliasUI) {
                final /* synthetic */ SettingsAliasUI pkO;

                {
                    this.pkO = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.pkO.pkL != null) {
                        ap.vd().c(this.pkO.pkL);
                    }
                }
            });
            if (settingsAliasUI.pkL != null) {
                ap.vd().c(settingsAliasUI.pkL);
            }
            settingsAliasUI.pkL = new b(settingsAliasUI.gtR);
            ap.vd().a(settingsAliasUI.pkL, 0);
        } else {
            g.h(settingsAliasUI.uSU.uTo, R.l.eZR, R.l.eJc);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pkM = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        KC();
        ap.vd().a(177, this);
    }

    protected final int getLayoutId() {
        return R.i.dnY;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        if (this.pkL != null) {
            ap.vd().c(this.pkL);
        }
        ap.vd().b(177, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eBn);
        this.ipv = (ImageView) findViewById(R.h.bqM);
        this.jWd = (TextView) findViewById(R.h.cof);
        this.pkN = (TextView) findViewById(R.h.cLm);
        this.lNw = (TextView) findViewById(R.h.ckW);
        this.pkK = (EditText) findViewById(R.h.cxF);
        String xL = m.xL();
        if (!x.QQ(xL)) {
            this.pkK.setText(m.xL());
            this.pkN.setText(getString(R.l.dDi, new Object[]{xL}));
        }
        this.pkK.setSelection(this.pkK.getText().length());
        this.pkK.setFocusable(true);
        this.pkK.setFocusableInTouchMode(true);
        this.pkK.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SettingsAliasUI pkO;

            {
                this.pkO = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SettingsAliasUI settingsAliasUI = this.pkO;
                a aVar = new a();
                if (charSequence.length() < 6 || charSequence.length() > 20) {
                    aVar.fPf = settingsAliasUI.getString(R.l.eZR);
                    aVar.fHd = false;
                } else if (bg.j(charSequence.charAt(0))) {
                    int length = charSequence.length() - 1;
                    while (length > 0) {
                        char charAt = charSequence.charAt(length);
                        if (bg.j(charAt) || charAt == '-' || charAt == '_' || bg.k(charAt)) {
                            length--;
                        } else if (Character.isSpace(charAt)) {
                            aVar.fPf = settingsAliasUI.getString(R.l.eZO);
                            aVar.fHd = false;
                        } else if (bg.f(charAt)) {
                            aVar.fPf = settingsAliasUI.getString(R.l.eZN);
                            aVar.fHd = false;
                        } else {
                            aVar.fPf = settingsAliasUI.getString(R.l.eZR);
                            aVar.fHd = false;
                        }
                    }
                    aVar.fPf = settingsAliasUI.getString(R.l.eBq);
                    aVar.fHd = true;
                } else {
                    aVar.fPf = settingsAliasUI.getString(R.l.eZP);
                    aVar.fHd = false;
                }
                if (aVar.fHd) {
                    this.pkO.kr(true);
                    this.pkO.lNw.setTextColor(this.pkO.getResources().getColorStateList(R.e.aUo));
                } else {
                    this.pkO.kr(false);
                    this.pkO.lNw.setTextColor(this.pkO.getResources().getColorStateList(R.e.aVO));
                }
                this.pkO.lNw.setText(aVar.fPf);
                this.pkO.pkN.setText(this.pkO.getString(R.l.dDi, new Object[]{charSequence}));
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.jWd.setText(h.b(this, bg.mz(m.xN()), this.jWd.getTextSize()));
        a.b.a(this.ipv, xL);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasUI pkO;

            {
                this.pkO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkO.aHf();
                this.pkO.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasUI pkO;

            {
                this.pkO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkO.gtR = this.pkO.pkK.getText().toString().trim();
                if (m.xL().equalsIgnoreCase(this.pkO.gtR)) {
                    this.pkO.aHf();
                    this.pkO.finish();
                } else {
                    g.a(this.pkO.uSU.uTo, this.pkO.getString(R.l.eBo, new Object[]{this.pkO.gtR}), this.pkO.getString(R.l.dXq), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 pkP;

                        {
                            this.pkP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SettingsAliasUI.e(this.pkP.pkO);
                        }
                    }, null);
                }
                return true;
            }
        }, l.b.uTY);
        kr(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.y.k r9) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        if (r6 != 0) goto L_0x0042;
    L_0x0004:
        if (r7 != 0) goto L_0x0042;
    L_0x0006:
        r2 = r5.pkM;
        if (r2 == 0) goto L_0x0014;
    L_0x000a:
        r2 = com.tencent.mm.plugin.report.service.g.oUh;
        r3 = 10358; // 0x2876 float:1.4515E-41 double:5.1175E-320;
        r4 = "1";
        r2.A(r3, r4);
    L_0x0014:
        r5.aHf();
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.vr();
        r3 = 42;
        r4 = r5.gtR;
        r2.set(r3, r4);
        r2 = com.tencent.mm.u.ap.vd();
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = new com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$5;
        r4.<init>(r5);
        r5.pjE = r4;
        r2.a(r3, r4);
        r2 = new com.tencent.mm.modelsimple.v;
        r2.<init>(r0);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r2, r1);
    L_0x0041:
        return;
    L_0x0042:
        r2 = r5.isv;
        if (r2 == 0) goto L_0x004e;
    L_0x0046:
        r2 = r5.isv;
        r2.dismiss();
        r2 = 0;
        r5.isv = r2;
    L_0x004e:
        r2 = com.tencent.mm.plugin.setting.a.imw;
        r3 = r5.uSU;
        r3 = r3.uTo;
        r2 = r2.a(r3, r6, r7, r8);
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        if (r0 == 0) goto L_0x0041;
    L_0x005c:
        goto L_0x0041;
    L_0x005d:
        switch(r6) {
            case 4: goto L_0x0062;
            default: goto L_0x0060;
        };
    L_0x0060:
        r0 = r1;
        goto L_0x005a;
    L_0x0062:
        r2 = -7;
        if (r7 == r2) goto L_0x0069;
    L_0x0065:
        r2 = -10;
        if (r7 != r2) goto L_0x0060;
    L_0x0069:
        r1 = r5.uSU;
        r1 = r1.uTo;
        r2 = com.tencent.mm.R.l.eJa;
        r3 = com.tencent.mm.R.l.eBr;
        com.tencent.mm.ui.base.g.h(r1, r2, r3);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }
}
