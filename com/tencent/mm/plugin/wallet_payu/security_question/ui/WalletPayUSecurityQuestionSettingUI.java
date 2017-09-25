package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button liz;
    private WalletPayUSecurityQuestionView rTa;
    private WalletFormView rTb;
    private m rTf;
    private String rTg = "";
    private a rTh;

    protected class a {
        final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

        protected a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
            this.rTi = walletPayUSecurityQuestionSettingUI;
        }

        public final void bvA() {
            if (bvF()) {
                this.rTi.liz.setEnabled(true);
            } else {
                this.rTi.liz.setEnabled(false);
            }
        }

        protected final boolean bvF() {
            boolean z;
            if (bg.mA(this.rTi.rTa.rTl)) {
                z = false;
            } else {
                z = true;
            }
            return z && this.rTi.rTb.Pb();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rTf = new m(this);
        this.rTf.lL(true);
        this.rTf.qJf = new c(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

            {
                this.rTi = r1;
            }

            public final void a(l lVar) {
                lVar.clear();
                ArrayList a = this.rTi.uT.getParcelableArrayList("key_security_question_list");
                if (a != null) {
                    for (int i = 0; i < a.size(); i++) {
                        lVar.add(((PayUSecurityQuestion) a.get(i)).desc);
                    }
                }
            }
        };
        this.rTf.qJg = new d(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

            {
                this.rTi = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                this.rTi.rTa.IA(((PayUSecurityQuestion) this.rTi.uT.getParcelableArrayList("key_security_question_list").get(i)).desc);
                this.rTi.rTg = ((PayUSecurityQuestion) this.rTi.uT.getParcelableArrayList("key_security_question_list").get(i)).id;
                this.rTi.rTb.aWw();
                this.rTi.rTh.bvA();
            }
        };
        this.rTh = new a(this);
        this.rTa = (WalletPayUSecurityQuestionView) findViewById(R.h.crr);
        this.rTb = (WalletFormView) findViewById(R.h.crq);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.rTb);
        this.liz = (Button) findViewById(R.h.crp);
        this.rTa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

            {
                this.rTi = r1;
            }

            public final void onClick(View view) {
                this.rTi.rTf.dL();
            }
        });
        this.rTb.wFY = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

            {
                this.rTi = r1;
            }

            public final void gA(boolean z) {
                this.rTi.rTh.bvA();
            }
        };
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI rTi;

            {
                this.rTi = r1;
            }

            public final void onClick(View view) {
                if (this.rTi.rTh.bvF()) {
                    this.rTi.uT.putString("key_question_id", this.rTi.rTg);
                    this.rTi.uT.putString("key_question_answer", this.rTi.rTb.getText());
                    com.tencent.mm.wallet_core.a.k(this.rTi, this.rTi.uT);
                    return;
                }
                this.rTi.rTh.bvA();
            }
        });
        this.rTh.bvA();
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.rTf.isShowing()) {
            this.rTf.dismiss();
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dkz;
    }

    protected final boolean bsP() {
        return true;
    }
}
