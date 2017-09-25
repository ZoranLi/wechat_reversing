package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SecurityAccountVerifyUI extends MMWizardActivity implements e {
    private String fMK;
    private String fMM;
    private String fOI;
    private aj fyI;
    private ProgressDialog isv = null;
    private String oVg;
    private Button oVj;
    private String oVk;
    private EditText oVo;
    private TextView oVp;
    private TextView oVq;
    private Button oVr;
    private boolean oVs = false;

    protected final int getLayoutId() {
        return R.i.dnr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oVk = b.Oz();
        KC();
    }

    protected void onResume() {
        ap.vd().a(a.CTRL_INDEX, this);
        ap.vd().a(132, this);
        super.onResume();
        if (!this.oVs) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",L600_200," + ap.ec("L600_200") + ",1");
            b.mM("L600_200");
        }
    }

    protected void onPause() {
        ap.vd().b(a.CTRL_INDEX, this);
        ap.vd().b(132, this);
        super.onPause();
        if (!this.oVs) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",L600_200," + ap.ec("L600_200") + ",2");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fyI.KH();
    }

    protected final void KC() {
        this.fOI = getIntent().getStringExtra("binded_mobile");
        this.oVg = getIntent().getStringExtra("auth_ticket");
        this.oVs = getIntent().getBooleanExtra("re_open_verify", false);
        this.oVo = (EditText) findViewById(R.h.btq);
        this.oVp = (TextView) findViewById(R.h.ckG);
        this.oVq = (TextView) findViewById(R.h.cyB);
        this.oVr = (Button) findViewById(R.h.cyA);
        this.oVo.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SecurityAccountVerifyUI oVt;

            {
                this.oVt = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = (editable == null || bg.mA(editable.toString())) ? false : true;
                this.oVt.kr(z);
            }
        });
        this.oVp.setText(bg.Qg(this.fOI));
        this.oVq.setTag(Integer.valueOf(60));
        this.fyI = new aj(new aj.a(this) {
            final /* synthetic */ SecurityAccountVerifyUI oVt;

            {
                this.oVt = r1;
            }

            public final boolean oQ() {
                int intValue = ((Integer) this.oVt.oVq.getTag()).intValue();
                if (intValue <= 1) {
                    this.oVt.oVr.setVisibility(0);
                    this.oVt.oVq.setVisibility(8);
                    return false;
                }
                this.oVt.oVq.setTag(Integer.valueOf(intValue - 1));
                this.oVt.oVq.setText(this.oVt.getString(R.l.eOb, new Object[]{Integer.valueOf(intValue)}));
                if (this.oVt.oVq.getVisibility() != 0) {
                    this.oVt.oVq.setVisibility(0);
                }
                return true;
            }
        }, true);
        this.oVr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI oVt;

            {
                this.oVt = r1;
            }

            public final void onClick(View view) {
                w.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                this.oVt.oVr.setVisibility(8);
                this.oVt.oVq.setTag(Integer.valueOf(60));
                this.oVt.fyI.KH();
                this.oVt.fyI.v(1000, 1000);
                final k sVar = new s(this.oVt.fOI, 10, "", 0, "", this.oVt.oVg);
                ap.vd().a(sVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = this.oVt;
                Context context = this.oVt.uSU.uTo;
                this.oVt.getString(R.l.dIO);
                securityAccountVerifyUI.isv = g.a(context, this.oVt.getString(R.l.eOd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass3 oVu;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(sVar);
                    }
                });
            }
        });
        if (!this.oVs) {
            this.oVj = (Button) findViewById(R.h.bCz);
            this.oVj.setVisibility(0);
            this.oVj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SecurityAccountVerifyUI oVt;

                {
                    this.oVt = r1;
                }

                public final void onClick(View view) {
                    b.mO(ap.uY() + "," + getClass().getName() + ",L600_300," + ap.ec("L600_300") + ",1");
                    String d = v.d(this.oVt.getSharedPreferences(ab.bIX(), 0));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", this.oVt.getString(R.l.eOa));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.plugin.c.a.imv.j(intent, this.oVt);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI oVt;

            {
                this.oVt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oVt.aXS();
                return true;
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI oVt;

            {
                this.oVt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.oVt.oVo.getText().toString().trim();
                if (bg.mA(trim)) {
                    g.h(this.oVt, R.l.dOl, R.l.dIO);
                } else {
                    k tVar;
                    this.oVt.aHf();
                    this.oVt.fMK = com.tencent.mm.plugin.safedevice.a.e.cK(this.oVt);
                    this.oVt.fMM = com.tencent.mm.plugin.safedevice.a.e.aXN();
                    if (this.oVt.oVs) {
                        tVar = new t(this.oVt.fOI, 11, trim, "", this.oVt.fMK, this.oVt.fMM);
                    } else {
                        tVar = new s(this.oVt.fOI, trim, "", this.oVt.oVg, this.oVt.fMK, this.oVt.fMM);
                    }
                    ap.vd().a(tVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = this.oVt;
                    Context context = this.oVt;
                    this.oVt.getString(R.l.dIO);
                    securityAccountVerifyUI.isv = g.a(context, this.oVt.getString(R.l.dOc), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 oVw;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(tVar);
                        }
                    });
                }
                return true;
            }
        });
        kr(false);
        zi(R.l.eNX);
        this.fyI.v(1000, 1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        cancel();
        zu(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        Intent intent;
        switch (kVar.getType()) {
            case 132:
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.safedevice.a.e.q(true, true);
                    intent = new Intent(this, MySafeDeviceListUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    finish();
                    return;
                } else if (!p(i, i2, str)) {
                    Toast.makeText(this, getString(R.l.eOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            case a.CTRL_INDEX /*145*/:
                s sVar = (s) kVar;
                if (sVar.AJ() == 10) {
                    if (i == 0 && i2 == 0) {
                        w.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        return;
                    }
                    w.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!p(i, i2, str)) {
                        Toast.makeText(this.uSU.uTo, getString(R.l.eOc, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (sVar.AJ() != 11) {
                    w.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[]{Integer.valueOf(sVar.AJ()), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.oVg = sVar.Fv();
                    w.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.oVg);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.fOI);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.oVg);
                            com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                            finish();
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.oVg);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) uVi.get(stringExtra);
                            uVi.clear();
                            if (intent != null) {
                                com.tencent.mm.plugin.safedevice.a.a(this, intent2, intent);
                            } else {
                                com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                            }
                            finish();
                            return;
                        default:
                            zu(1);
                            return;
                    }
                } else {
                    w.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!p(i, i2, str)) {
                        Toast.makeText(this.uSU.uTo, getString(R.l.eOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private boolean p(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -74:
                g.a(this.uSU.uTo, R.l.dNu, R.l.dIO, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.uSU.uTo, R.l.dGU, 0).show();
                return true;
            case -41:
                Toast.makeText(this.uSU.uTo, R.l.dNx, 0).show();
                return true;
            case -34:
                Toast.makeText(this, R.l.dNy, 0).show();
                return true;
            case -33:
                g.a(this.uSU.uTo, R.l.dOf, R.l.btr, null);
                return true;
            case -32:
                g.a(this.uSU.uTo, R.l.dOg, R.l.btr, null);
                return true;
            default:
                return false;
        }
    }
}
