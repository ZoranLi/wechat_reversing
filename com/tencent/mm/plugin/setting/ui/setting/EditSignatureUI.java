package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI extends MMActivity {
    private p isP = null;
    private c ktC = new c<kr>(this) {
        final /* synthetic */ EditSignatureUI piB;

        {
            this.piB = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kr krVar = (kr) bVar;
            String str = krVar.fRk.fRl;
            String str2 = krVar.fRk.fRm;
            int i = krVar.fRk.ret;
            if (i != 0 && this.piB.piy != null) {
                g.b(this.piB, str2, str, true);
                if (this.piB.piz != null) {
                    ap.yY();
                    com.tencent.mm.u.c.wQ().c(this.piB.piz);
                }
            } else if (i == 0 && this.piB.kty) {
                str = this.piB.piy.getText().toString().trim();
                ap.yY();
                com.tencent.mm.u.c.vr().set(12291, str);
                this.piB.finish();
            }
            if (this.piB.isP != null) {
                this.piB.isP.dismiss();
            }
            return true;
        }
    };
    private boolean kty = false;
    final bg piA = bg.zL();
    private TextView pio;
    private MMEditText piy;
    private e.b piz;

    private class a implements TextWatcher {
        final /* synthetic */ EditSignatureUI piB;
        private int piC = 60;

        public a(EditSignatureUI editSignatureUI) {
            this.piB = editSignatureUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.piB.kr(true);
        }

        public final void afterTextChanged(Editable editable) {
            this.piC = h.aI(60, editable.toString());
            if (this.piC < 0) {
                this.piC = 0;
            }
            if (this.piB.pio != null) {
                this.piB.pio.setText(this.piC);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dao;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.b(this.ktC);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.ktC);
    }

    protected final void KC() {
        zi(R.l.eUd);
        this.piy = (MMEditText) findViewById(R.h.content);
        this.pio = (TextView) findViewById(R.h.cTh);
        ap.yY();
        this.piy.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, com.tencent.mm.sdk.platformtools.bg.mz((String) com.tencent.mm.u.c.vr().get(12291, null)), this.piy.getTextSize()));
        this.piy.setSelection(this.piy.getText().length());
        this.pio.setText(h.aI(60, this.piy.getEditableText().toString()));
        com.tencent.mm.ui.tools.a.c.d(this.piy).em(0, 60).a(null);
        this.piy.addTextChangedListener(new a(this));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EditSignatureUI piB;

            {
                this.piB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.piB.aHf();
                this.piB.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ EditSignatureUI piB;

            {
                this.piB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.piB.piy.getText().toString().trim();
                String sE = com.tencent.mm.i.b.sE();
                if (com.tencent.mm.sdk.platformtools.bg.mA(sE) || !trim.matches(".*[" + sE + "].*")) {
                    EditSignatureUI editSignatureUI = this.piB;
                    Context context = this.piB.uSU.uTo;
                    this.piB.getString(R.l.dIO);
                    editSignatureUI.isP = g.a(context, this.piB.getString(R.l.dXM), false, null);
                    this.piB.piz = m.m(18, trim);
                    this.piB.kty = true;
                    this.piB.aHf();
                    return true;
                }
                g.b(this.piB.uSU.uTo, this.piB.getString(R.l.esK, new Object[]{sE}), this.piB.getString(R.l.dIO), true);
                return false;
            }
        }, l.b.uTY);
        kr(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
