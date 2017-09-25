package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.y.k;

public class WalletBindDepositUI extends WalletBaseUI {
    private ElementQuery rCX = new ElementQuery();
    private WalletFormView rJH;
    private WalletFormView rJn;
    private Button rxr;
    private WalletFormView szU;
    private boolean szV = true;

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        if (!walletBindDepositUI.rJn.Pb()) {
            s.makeText(walletBindDepositUI, R.l.fes, 0).show();
            return false;
        } else if (!walletBindDepositUI.rJH.Pb()) {
            s.makeText(walletBindDepositUI, R.l.fel, 0).show();
            return false;
        } else if (walletBindDepositUI.szU.Pb()) {
            return true;
        } else {
            s.makeText(walletBindDepositUI, R.l.feD, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dpS;
    }

    public final void KC() {
        zi(R.l.fdZ);
        this.rJn = (WalletFormView) findViewById(R.h.cPR);
        a.a(this.rJn);
        this.rJH = (WalletFormView) findViewById(R.h.cQg);
        this.szU = (WalletFormView) findViewById(R.h.ckq);
        a.c(this, this.szU);
        this.rxr = (Button) findViewById(R.h.cnY);
        d(this.rJn, 0, false);
        d(this.szU, 0, false);
        this.rJH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBindDepositUI szW;

            {
                this.szW = r1;
            }

            public final void onClick(View view) {
                if (!bg.mA(this.szW.rJn.getText())) {
                    if (this.szW.szV) {
                        this.szW.ccF().p(new Object[]{r0});
                        this.szW.szV = false;
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_support_bankcard", 1);
                    bundle.putString("key_bank_type", this.szW.rCX.ofd);
                    bundle.putInt("key_bankcard_type", 1);
                    com.tencent.mm.wallet_core.a.ai(this.szW).a(this.szW, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBindDepositUI szW;

            {
                this.szW = r1;
            }

            public final void onClick(View view) {
                if (WalletBindDepositUI.e(this.szW)) {
                    this.szW.ccF().j(new Object[]{this.szW.rJn.getText(), this.szW.rCX.ofd, this.szW.szU.getText(), this.szW.rCX.rEV, Boolean.valueOf(false)});
                }
            }
        });
    }

    private void ar() {
        if (bg.mA(this.rCX.mMa)) {
            this.rJH.setText("");
        } else if (2 == this.rCX.rES) {
            this.rJH.setText(this.rCX.mMa + " " + getString(R.l.ffh));
        } else {
            this.rJH.setText(this.rCX.mMa + " " + getString(R.l.ffv));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    if (elementQuery.btH()) {
                        this.rCX = elementQuery;
                        ar();
                        return;
                    }
                    g.h(this, R.l.fdY, R.l.dIO);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
            com.tencent.mm.plugin.wallet_core.b.k kVar2 = (com.tencent.mm.plugin.wallet_core.b.k) kVar;
            if (kVar2.rBW != null) {
                if (kVar2.rBW.btH()) {
                    this.rCX = kVar2.rBW;
                    ar();
                    if (this.rCX.rEQ && this.rCX.isError()) {
                        g.h(this, R.l.fdN, R.l.dIO);
                        return true;
                    }
                    b ai = com.tencent.mm.wallet_core.a.ai(this);
                    if (ai != null) {
                        int i3 = this.rCX.rBY;
                        if (ai != null) {
                            if (ai.lHw.containsKey("key_support_bankcard")) {
                                int cbP = ai.cbP();
                                z = cbP == 0 ? true : Bankcard.ds(cbP, i3);
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (ai.cbQ()) {
                                w.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                g.h(this, R.l.fdf, R.l.dIO);
                            } else {
                                w.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                g.h(this, R.l.fde, R.l.dIO);
                            }
                            this.rJn.aWw();
                            return true;
                        }
                    }
                    ar();
                    return true;
                }
                g.h(this, R.l.fdY, R.l.dIO);
                return true;
            }
        }
        return false;
    }

    protected final int Ol() {
        return 1;
    }
}
