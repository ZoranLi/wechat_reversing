package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.sa;
import com.tencent.mm.e.a.sb;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.k;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private c gKr = new c<sa>(this) {
        final /* synthetic */ WalletPwdConfirmUI rMW;

        {
            this.rMW = r2;
            this.usg = sa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((sa) bVar) instanceof sa) {
                w.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
                this.rMW.rMU = false;
                this.rMW.bvc();
            }
            return false;
        }
    };
    private TextView rMT;
    private boolean rMU = false;
    private aj rMV = new aj(new aj.a(this) {
        final /* synthetic */ WalletPwdConfirmUI rMW;

        {
            this.rMW = r1;
        }

        public final boolean oQ() {
            if (this.rMW.rMU) {
                this.rMW.rMU = false;
                this.rMW.bvc();
            }
            return false;
        }
    }, false);
    public EditHintPasswdView rwi;
    private PayInfo rze;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(s.fk(this));
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        KC();
        com.tencent.mm.plugin.wallet_core.d.c.b(this, this.uT, 6);
    }

    protected final void KC() {
        ((TextView) findViewById(R.h.cRG)).setText(m.xY() ? getString(R.l.fhF) : getString(R.l.fhE));
        this.rMT = (TextView) findViewById(R.h.bXK);
        if (bg.J(qK(0))) {
            this.rMT.setText(R.l.dHp);
        } else {
            this.rMT.setText(R.l.fko);
        }
        this.rMT.setVisibility(0);
        this.rMT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPwdConfirmUI rMW;

            {
                this.rMW = r1;
            }

            public final void onClick(View view) {
                String string = this.rMW.uT.getString("key_new_pwd1");
                String ccL = this.rMW.rwi.ccL();
                String string2 = this.rMW.uT.getString("kreq_token");
                String string3 = this.rMW.uT.getString("key_verify_code");
                w.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + this.rMW.rze + " vertifyCode: " + string3);
                if (string == null || !string.equals(ccL)) {
                    com.tencent.mm.wallet_core.a.j(this.rMW, -1002);
                    return;
                }
                n nVar = new n();
                nVar.rHx = this.rMW.rwi.getText();
                nVar.oLz = this.rMW.rze;
                nVar.token = string2;
                nVar.rHy = string3;
                nVar.rHz = this.rMW.uT.getBoolean("key_is_bind_bankcard", true);
                if (com.tencent.mm.wallet_core.a.ai(this.rMW).cbQ()) {
                    nVar.flag = "4";
                } else {
                    nVar.flag = "1";
                }
                FavorPayInfo favorPayInfo = (FavorPayInfo) this.rMW.uT.getParcelable("key_favor_pay_info");
                if (favorPayInfo != null) {
                    nVar.rDN = favorPayInfo.rFp;
                    nVar.rDO = favorPayInfo.rFm;
                }
                this.rMW.ccF().j(nVar);
            }
        });
        this.rMT.setEnabled(false);
        this.rMT.setClickable(false);
        this.rwi = (EditHintPasswdView) findViewById(R.h.bXJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rwi);
        this.rwi.wFT = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletPwdConfirmUI rMW;

            {
                this.rMW = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    String string = this.rMW.uT.getString("key_new_pwd1");
                    String ccL = this.rMW.rwi.ccL();
                    if (string == null || !string.equals(ccL)) {
                        com.tencent.mm.wallet_core.a.j(this.rMW, -1002);
                        return;
                    }
                    this.rMW.rMT.setEnabled(z);
                    this.rMW.rMT.setClickable(z);
                    return;
                }
                this.rMW.rMT.setEnabled(z);
                this.rMW.rMT.setClickable(z);
            }
        };
        findViewById(R.h.btB).setVisibility(8);
        d(this.rwi, 0, false);
    }

    public void onResume() {
        this.rwi.requestFocus();
        super.onResume();
        com.tencent.mm.sdk.b.a.urY.b(this.gKr);
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.gKr);
    }

    private void bvc() {
        Bundle bundle = this.uT;
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, bundle);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.uT.putString("key_pwd1", this.rwi.getText());
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
            if (!this.rMU) {
                bvc();
            }
        } else if (com.tencent.mm.wallet_core.a.ai(this) == null || !com.tencent.mm.wallet_core.a.ai(this).e(this, null)) {
            com.tencent.mm.wallet_core.a.k(this, this.uT);
        } else {
            q(new com.tencent.mm.plugin.wallet_core.b.m(this.rze != null ? this.rze.fJH : ""));
            b sbVar = new sb();
            if (com.tencent.mm.sdk.b.a.urY.s(sbVar.getClass())) {
                this.rMU = true;
                com.tencent.mm.sdk.b.a.urY.m(sbVar);
            }
            this.rMV.v(10000, 10000);
        }
        return true;
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
