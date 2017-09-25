package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (1 == this.ruU.field_bankcardState) {
            bss();
            findViewById(R.h.cPu).setVisibility(8);
            findViewById(R.h.cPt).setVisibility(8);
        } else {
            iq(false);
        }
        findViewById(R.h.cPw).setVisibility(8);
        ((TextView) findViewById(R.h.cPy)).setText(R.l.fdR);
    }
}
