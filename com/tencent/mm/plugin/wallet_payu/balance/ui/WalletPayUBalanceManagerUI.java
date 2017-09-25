package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.y.k;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bsl() {
        o.bsC();
        b(new a(), o.bsD().ruN == null);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            ar();
        }
        return false;
    }

    protected final void bsm() {
        v(WalletPayUBalanceSaveUI.class);
    }
}
