package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI extends MMActivity implements a {
    private p isP = null;
    private c ktC = new c<kr>(this) {
        final /* synthetic */ SettingsModifyNameUI plw;

        {
            this.plw = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kr krVar = (kr) bVar;
            String str = krVar.fRk.fRl;
            String str2 = krVar.fRk.fRm;
            int i = krVar.fRk.ret;
            if (i != 0 && str2 != null) {
                g.b(this.plw, str2, str, true);
                if (this.plw.piz != null) {
                    ap.yY();
                    com.tencent.mm.u.c.wQ().c(this.plw.piz);
                }
            } else if (i == 0 && this.plw.kty) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(4, this.plw.kuG.getText().toString());
                this.plw.finish();
            }
            if (this.plw.isP != null) {
                this.plw.isP.dismiss();
            }
            return true;
        }
    };
    private boolean kty = false;
    private MMEditText kuG;
    private e.b piz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.b(this.ktC);
        KC();
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.ktC);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dod;
    }

    protected final void KC() {
        zi(R.l.dod);
        this.kuG = (MMEditText) findViewById(R.h.cDt);
        MMEditText mMEditText = this.kuG;
        ap.yY();
        mMEditText.setText(h.b(this, (String) com.tencent.mm.u.c.vr().get(4, null), this.kuG.getTextSize()));
        this.kuG.setSelection(this.kuG.getText().length());
        this.kuG.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SettingsModifyNameUI plw;

            {
                this.plw = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.plw.kr(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c em = com.tencent.mm.ui.tools.a.c.d(this.kuG).em(1, 32);
        em.wpp = false;
        em.a(null);
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyNameUI plw;

            {
                this.plw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String obj = this.plw.kuG.getText().toString();
                String sE = com.tencent.mm.i.b.sE();
                if (bg.mA(sE) || !obj.matches(".*[" + sE + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(this.plw.kuG).em(1, 32).a(this.plw);
                    return true;
                }
                g.b(this.plw.uSU.uTo, this.plw.getString(R.l.esK, new Object[]{sE}), this.plw.getString(R.l.dIO), true);
                return false;
            }
        }, l.b.uTY);
        kr(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyNameUI plw;

            {
                this.plw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plw.aHf();
                this.plw.finish();
                return true;
            }
        });
    }

    public final void ro(String str) {
        w.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + str);
        this.kty = true;
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isP = g.a(context, getString(R.l.dXM), false, null);
        this.piz = m.m(2, str);
    }

    public final void YN() {
        g.h(this, R.l.eSW, R.l.eSY);
    }

    public final void Yp() {
        g.h(this, R.l.eSX, R.l.eSY);
    }
}
