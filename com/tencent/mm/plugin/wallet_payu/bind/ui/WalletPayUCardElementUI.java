package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button liz;
    private WalletFormView rQU;
    WalletFormView rQV;
    private WalletFormView rQW;
    private TextView rQX;
    private TextView rQY;
    private TextView rQZ;
    private b rRa;
    private boolean rRb = false;
    private boolean rRc = false;
    private boolean rRd = false;
    private HashMap<String, PayUBankcardElement> rRe = null;
    private HashSet<String> rRf = null;

    private abstract class a implements TextWatcher {
        final /* synthetic */ WalletPayUCardElementUI rRg;

        public a(WalletPayUCardElementUI walletPayUCardElementUI) {
            this.rRg = walletPayUCardElementUI;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    protected class b {
        final /* synthetic */ WalletPayUCardElementUI rRg;
        boolean rRh;
        boolean rRi;
        boolean rRj;

        protected b(WalletPayUCardElementUI walletPayUCardElementUI) {
            this.rRg = walletPayUCardElementUI;
        }

        protected final void bvA() {
            this.rRh = this.rRg.rQU.Pb();
            this.rRi = this.rRg.rQV.Pb();
            this.rRj = this.rRg.rQW.Pb();
            if (!this.rRg.rRd || this.rRj) {
                this.rRg.rQY.setVisibility(4);
            } else {
                this.rRg.rQY.setVisibility(0);
                this.rRg.rQY.setText(R.l.fep);
            }
            boolean z;
            if (!this.rRg.rRb) {
                z = false;
            } else if (!this.rRh) {
                this.rRg.rQX.setVisibility(0);
                this.rRg.rQX.setTextColor(this.rRg.getResources().getColor(R.e.aVD));
                this.rRg.rQX.setText(R.l.fek);
                z = false;
            } else if (!this.rRg.rRe.containsKey(this.rRg.rQU.getText()) || this.rRg.rRf.contains(this.rRg.rQU.getText())) {
                this.rRg.b(new NetScenePayUElementQuery(this.rRg.rQU.getText()), false);
                this.rRg.rRf.add(this.rRg.rQU.getText());
                this.rRg.rQX.setVisibility(0);
                this.rRg.rQX.setTextColor(this.rRg.getResources().getColor(R.e.aUo));
                this.rRg.rQX.setText(this.rRg.getString(R.l.feb));
                z = true;
            } else {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.rRg.rRe.get(this.rRg.rQU.getText());
                this.rRg.rQX.setVisibility(0);
                if (bg.mA(payUBankcardElement.rQP)) {
                    this.rRg.rQX.setTextColor(this.rRg.getResources().getColor(R.e.aVD));
                    this.rRg.rQX.setText(payUBankcardElement.rQQ);
                    this.rRh = false;
                    z = false;
                } else {
                    this.rRg.rQX.setTextColor(this.rRg.getResources().getColor(R.e.aUo));
                    this.rRg.rQX.setText(payUBankcardElement.rQQ);
                    z = false;
                }
            }
            if (this.rRh && this.rRi && this.rRj && !r0) {
                this.rRg.liz.setEnabled(true);
            } else {
                this.rRg.liz.setEnabled(false);
            }
        }
    }

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.rQU.getId()) {
                walletPayUCardElementUI.rRb = true;
            } else if (view.getId() == walletPayUCardElementUI.rQW.getId()) {
                walletPayUCardElementUI.rRd = true;
            } else if (view.getId() == walletPayUCardElementUI.rQV.getId()) {
                walletPayUCardElementUI.rRc = true;
            }
        }
        walletPayUCardElementUI.rRa.bvA();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rRa = new b(this);
        this.rRe = new HashMap();
        this.rRf = new HashSet();
        this.rQU = (WalletFormView) findViewById(R.h.bxR);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rQU);
        this.rQV = (WalletFormView) findViewById(R.h.bHJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.rQV);
        this.rQW = (WalletFormView) findViewById(R.h.bHB);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.rQW);
        this.rQX = (TextView) findViewById(R.h.cQd);
        this.rQY = (TextView) findViewById(R.h.cPU);
        this.liz = (Button) findViewById(R.h.cnY);
        d(this.rQU, 0, false);
        d(this.rQW, 0, false);
        this.rQU.wFY = this;
        this.rQW.wFY = this;
        this.rQV.wFY = this;
        this.rQU.wGc = 0;
        this.rQW.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI rRg;

            {
                this.rRg = r1;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.rRg, this.rRg.rQW, editable);
            }
        });
        this.rQV.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI rRg;

            {
                this.rRg = r1;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.rRg, this.rRg.rQV, editable);
            }
        });
        this.rQU.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI rRg;

            {
                this.rRg = r1;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.rRg, this.rRg.rQU, editable);
            }
        });
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUCardElementUI rRg;

            {
                this.rRg = r1;
            }

            public final void onClick(View view) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.rRg.rRe.get(this.rRg.rQU.getText());
                if (payUBankcardElement == null) {
                    w.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    return;
                }
                this.rRg.rQU.wGc = 50;
                this.rRg.uT.putParcelable("key_card_element", payUBankcardElement);
                this.rRg.uT.putString("key_card_id", this.rRg.rQU.getText());
                this.rRg.uT.putString("key_cvv", this.rRg.rQW.getText());
                this.rRg.uT.putString("key_expire_data", this.rRg.rQV.getText());
                this.rRg.ccF().j(new Object[0]);
            }
        });
        ((TextView) findViewById(R.h.cRx)).setText(s.ccm());
        this.rQZ = (TextView) findViewById(R.h.cGk);
        c.a(this, this.rQZ);
    }

    public void onResume() {
        super.onResume();
        this.rRa.bvA();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof NetScenePayUElementQuery) {
            this.rRe.put(((NetScenePayUElementQuery) kVar).rQM, (PayUBankcardElement) this.uT.getParcelable("key_card_element"));
            this.rRa.bvA();
            this.rRf.remove(((NetScenePayUElementQuery) kVar).rQM);
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                return false;
            }
            this.rQU.wGc = 0;
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dkx;
    }

    public final void gA(boolean z) {
    }

    protected final boolean bsP() {
        return true;
    }
}
