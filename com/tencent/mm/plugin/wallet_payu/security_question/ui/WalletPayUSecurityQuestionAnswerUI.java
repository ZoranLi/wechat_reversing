package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button liz;
    private WalletPayUSecurityQuestionView rTa;
    private WalletFormView rTb;
    private PayUSecurityQuestion rTc;
    private a rTd;

    protected class a {
        final /* synthetic */ WalletPayUSecurityQuestionAnswerUI rTe;

        protected a(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
            this.rTe = walletPayUSecurityQuestionAnswerUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rTd = new a(this);
        this.rTa = (WalletPayUSecurityQuestionView) findViewById(R.h.crr);
        this.rTb = (WalletFormView) findViewById(R.h.crq);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.rTb);
        this.liz = (Button) findViewById(R.h.crp);
        this.rTb.wFY = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionAnswerUI rTe;

            {
                this.rTe = r1;
            }

            public final void gA(boolean z) {
                boolean z2;
                a a = this.rTe.rTd;
                if (a.rTe.rTb.Pb()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    a.rTe.liz.setEnabled(true);
                } else {
                    a.rTe.liz.setEnabled(false);
                }
            }
        };
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionAnswerUI rTe;

            {
                this.rTe = r1;
            }

            public final void onClick(View view) {
                if (this.rTe.rTb.Pb()) {
                    this.rTe.uT.putString("key_question_answer", this.rTe.rTb.getText());
                    this.rTe.ccF().j(new Object[0]);
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            this.rTc = (PayUSecurityQuestion) this.uT.getParcelable("key_security_question");
            w.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.rTc != null) {
                this.rTa.IA(this.rTc.desc);
            }
            this.rTb.aWw();
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dky;
    }

    protected final boolean bsP() {
        return true;
    }
}
