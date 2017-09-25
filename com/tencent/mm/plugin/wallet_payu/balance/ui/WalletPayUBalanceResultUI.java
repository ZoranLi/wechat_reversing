package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    protected final void KC() {
        super.KC();
        this.ruT.setVisibility(8);
    }

    protected final void ar() {
        if (this.oSJ != null) {
            this.ruQ.setText(e.d(this.oSJ.rFM, this.oSJ.oga));
            if (this.ruU != null && !bg.mA(this.ruU.field_bankName)) {
                if (bg.mA(this.ruU.field_bankcardTail)) {
                    this.ruR.setText(this.ruU.field_bankName);
                } else {
                    this.ruR.setText(this.ruU.field_bankName + " " + getString(R.l.fiv) + this.ruU.field_bankcardTail);
                }
            }
        }
    }
}
