package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class ModSafeDeviceNameUI extends MMActivity implements e {
    private String fGl;
    private long iam;
    private ProgressDialog isv = null;
    private String ktB;
    private EditText oUI;
    private String oUJ;
    private String oUK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onResume() {
        ap.vd().a(361, this);
        super.onResume();
    }

    protected void onPause() {
        ap.vd().b(361, this);
        super.onPause();
    }

    protected final void KC() {
        this.oUJ = getIntent().getStringExtra("safe_device_name");
        this.oUK = getIntent().getStringExtra("safe_device_uid");
        this.fGl = getIntent().getStringExtra("safe_device_type");
        qP(a.V(this, R.l.eNV));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModSafeDeviceNameUI oUL;

            {
                this.oUL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oUL.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModSafeDeviceNameUI oUL;

            {
                this.oUL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oUL.ktB = this.oUL.oUI.getText().toString();
                if (!bg.mA(this.oUL.ktB)) {
                    this.oUL.aHf();
                    final k bVar = new b(this.oUL.oUK, this.oUL.ktB, this.oUL.fGl);
                    ap.vd().a(bVar, 0);
                    this.oUL.isv = g.a(this.oUL, a.V(this.oUL, R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 oUN;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(bVar);
                        }
                    });
                }
                return true;
            }
        });
        MMEditText.b anonymousClass3 = new MMEditText.b(this) {
            final /* synthetic */ ModSafeDeviceNameUI oUL;

            {
                this.oUL = r1;
            }

            public final void aXQ() {
                if (this.oUL.oUI.getText().toString().trim().length() > 0) {
                    this.oUL.kr(true);
                } else {
                    this.oUL.kr(false);
                }
            }
        };
        this.oUI = (EditText) findViewById(R.h.ckR);
        TextWatcher cVar = new c(this.oUI, null, 32);
        cVar.wvq = anonymousClass3;
        this.oUI.addTextChangedListener(cVar);
        if (bg.mA(this.oUJ)) {
            kr(false);
        } else {
            this.oUI.setText(this.oUJ);
        }
    }

    protected final int getLayoutId() {
        return R.i.ckR;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.sdk.e.c cVar = new com.tencent.mm.plugin.safedevice.a.c();
            cVar.field_devicetype = this.fGl;
            cVar.field_name = this.ktB;
            cVar.field_uid = this.oUK;
            cVar.field_createtime = this.iam;
            f.aXP().c(cVar, new String[0]);
            g.bl(this, a.V(this, R.l.eNZ));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ ModSafeDeviceNameUI oUL;

                {
                    this.oUL = r1;
                }

                public final void run() {
                    this.oUL.finish();
                }
            }, 1000);
        } else if (!com.tencent.mm.plugin.c.a.imw.a(this, i, i2, str)) {
        }
    }
}
