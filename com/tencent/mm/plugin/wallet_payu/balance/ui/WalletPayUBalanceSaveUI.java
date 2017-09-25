package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.y.k;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.run.setVisibility(8);
    }

    protected final void bsq() {
        k(new a(this.oRf, "ZAR"));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            e.a(this, ((a) kVar).fJH, "", 11, 1);
        }
        return false;
    }
}
