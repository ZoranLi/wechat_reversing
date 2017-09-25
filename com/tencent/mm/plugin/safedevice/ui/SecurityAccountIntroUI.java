package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements e {
    private String fOI;
    private ProgressDialog isv = null;
    private String jumpUrl;
    private String oVg;
    private String oVh;
    private boolean oVi = false;
    private Button oVj;
    private String oVk;

    protected final int getLayoutId() {
        return R.i.dnp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oVg = getIntent().getStringExtra("auth_ticket");
        this.fOI = getIntent().getStringExtra("binded_mobile");
        this.oVi = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        w.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[]{bg.Qj(this.oVg), stringExtra});
        if (!bg.mA(stringExtra)) {
            Map q = bh.q(stringExtra, "wording");
            if (q != null) {
                this.oVh = (String) q.get(".wording.title");
                this.jumpUrl = (String) q.get(".wording.url");
                w.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[]{this.oVh, this.jumpUrl});
            }
        }
        this.oVk = b.Oz();
        KC();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(a.CTRL_INDEX, this);
        ap.vd().a(132, this);
        if (!this.oVi) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",L600_100," + ap.ec("L600_100") + ",1");
            b.mM("L600_100");
        }
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(a.CTRL_INDEX, this);
        ap.vd().b(132, this);
        if (!this.oVi) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",L600_100," + ap.ec("L600_100") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    protected final void KC() {
        zi(R.l.eOf);
        findViewById(R.h.cpG).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SecurityAccountIntroUI oVl;

            {
                this.oVl = r1;
            }

            public final void onClick(View view) {
                k tVar;
                if (this.oVl.oVi) {
                    tVar = new t(this.oVl.fOI, 10, "", 0, "");
                } else {
                    tVar = new s(this.oVl.fOI, 10, "", 0, "", this.oVl.oVg);
                }
                ap.vd().a(tVar, 0);
                SecurityAccountIntroUI securityAccountIntroUI = this.oVl;
                Context context = this.oVl;
                this.oVl.getString(R.l.dIO);
                securityAccountIntroUI.isv = g.a(context, this.oVl.getString(R.l.eOd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 oVn;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(tVar);
                    }
                });
            }
        });
        if (!this.oVi) {
            this.oVj = (Button) findViewById(R.h.bCz);
            if (!bg.mA(this.oVh)) {
                this.oVj.setText(this.oVh);
            }
            this.oVj.setVisibility(0);
            this.oVj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SecurityAccountIntroUI oVl;

                {
                    this.oVl = r1;
                }

                public final void onClick(View view) {
                    String d = v.d(this.oVl.getSharedPreferences(ab.bIX(), 0));
                    Intent intent = new Intent();
                    if (bg.mA(this.oVl.jumpUrl)) {
                        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    } else {
                        intent.putExtra("rawUrl", this.oVl.jumpUrl);
                    }
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", this.oVl.getString(R.l.eOa));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.plugin.c.a.imv.j(intent, this.oVl);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountIntroUI oVl;

            {
                this.oVl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oVl.aXS();
                return true;
            }
        });
    }

    private void aXS() {
        b.mN(this.oVk);
        cancel();
        zu(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.oVi) {
                str2 = ((ge) ((t) kVar).gUA.hsk.hsr).thq;
            } else {
                str2 = ((s) kVar).Fv();
            }
            w.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.oVg + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.fOI);
            intent.putExtra("re_open_verify", this.oVi);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            z(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
                return;
            }
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                g.a(this, R.l.dNu, R.l.dIO, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, R.l.dGU, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.l.dNx, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.l.dNy, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0 && !com.tencent.mm.plugin.c.a.imw.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eOc, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
