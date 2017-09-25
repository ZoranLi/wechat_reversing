package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class ContactSearchUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private EditText qVh;

    protected final int getLayoutId() {
        return R.i.cZJ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onResume() {
        ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        super.onResume();
    }

    protected void onPause() {
        ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        super.onPause();
    }

    protected final void KC() {
        zi(R.l.eax);
        this.qVh = (EditText) findViewById(R.h.bGc);
        this.qVh.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContactSearchUI qVi;

            {
                this.qVi = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.qVi.kr(editable.length() > 0);
            }
        });
        this.qVh.setImeOptions(3);
        this.qVh.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ContactSearchUI qVi;

            {
                this.qVi = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || bg.mA(this.qVi.qVh.getText().toString().trim()))) {
                    this.qVi.bnh();
                }
                return false;
            }
        });
        a(0, getString(R.l.dHo), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchUI qVi;

            {
                this.qVi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qVi.bnh();
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchUI qVi;

            {
                this.qVi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qVi.aHf();
                this.qVi.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.qVh.setText(getIntent().getStringExtra("userName"));
            bnh();
        }
    }

    private void bnh() {
        String trim = this.qVh.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            g.h(this.uSU.uTo, R.l.eZV, R.l.dIO);
            return;
        }
        w.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final k aaVar = new aa(trim, 1);
        ap.vd().a(aaVar, 0);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.dCL), true, new OnCancelListener(this) {
            final /* synthetic */ ContactSearchUI qVi;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(aaVar);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!b.imw.b(this.uSU.uTo, i, i2, str)) {
            if (i == 4 && i2 == -4) {
                g.h(this.uSU.uTo, R.l.dCI, R.l.dIO);
            } else if (i == 0 && i2 == 0) {
                awr Jx = ((aa) kVar).Jx();
                if (Jx.tDR > 0) {
                    Intent intent = new Intent();
                    intent.setClass(this, ContactSearchResultUI.class);
                    try {
                        intent.putExtra("result", Jx.toByteArray());
                        startActivity(intent);
                        return;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                        return;
                    }
                }
                String a = n.a(Jx.ttp);
                Intent intent2 = new Intent();
                ((com.tencent.mm.pluginsdk.g) h.h(com.tencent.mm.pluginsdk.g.class)).a(intent2, Jx, Hn(this.qVh.getText().toString().trim()));
                if (bg.mz(a).length() > 0) {
                    if ((Jx.tMP & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.oUh.A(10298, a + "," + Hn(this.qVh.getText().toString().trim()));
                    }
                    d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                }
            } else {
                Toast.makeText(this, getString(R.l.elR), 0).show();
                w.w("MicroMsg.ContactSearchUI", getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
    }

    private static int Hn(String str) {
        if (bg.PJ(str)) {
            return 1;
        }
        if (bg.PK(str)) {
            return 2;
        }
        return bg.PL(str) ? 3 : 3;
    }
}
