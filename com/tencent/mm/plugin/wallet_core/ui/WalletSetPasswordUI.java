package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.k;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    public EditHintPasswdView rwi;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(s.fk(this));
        KC();
        c.b(this, this.uT, 5);
    }

    protected final void KC() {
        TextView textView;
        if (this.uT.getInt("key_err_code", 0) == -1002) {
            textView = (TextView) findViewById(R.h.bXI);
            textView.setVisibility(0);
            textView.setText(m.xY() ? getString(R.l.fkn) : getString(R.l.fkm));
            this.uT.putInt("key_err_code", 0);
        }
        this.rwi = (EditHintPasswdView) findViewById(R.h.bXJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rwi);
        findViewById(R.h.btB).setVisibility(8);
        textView = (TextView) findViewById(R.h.cRG);
        b ai = com.tencent.mm.wallet_core.a.ai(this);
        CharSequence string = (ai == null || !(ai instanceof com.tencent.mm.plugin.wallet_core.id_verify.a)) ? m.xY() ? getString(R.l.fkl) : getString(R.l.cRG) : getString(R.l.fkk);
        textView.setText(string);
        this.rwi.wFT = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletSetPasswordUI rOd;

            {
                this.rOd = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    String ccL = this.rOd.rwi.ccL();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_new_pwd1", ccL);
                    this.rOd.rwi.aWw();
                    com.tencent.mm.wallet_core.a.k(this.rOd, bundle);
                }
            }
        };
        d(this.rwi, 0, false);
    }

    public void onResume() {
        this.rwi.requestFocus();
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drs;
    }

    protected final boolean bsP() {
        return true;
    }

    protected final int Ol() {
        return 1;
    }
}
