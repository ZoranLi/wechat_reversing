package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.k;

@a(3)
public class WalletPayUBankcardManageUI extends WalletBankcardManageUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void is(boolean z) {
        if (z) {
            b(new com.tencent.mm.plugin.wallet_core.b.b.a(), false);
        } else {
            q(new com.tencent.mm.plugin.wallet_core.b.b.a());
        }
    }

    protected final void bsv() {
        com.tencent.mm.wallet_core.a.a(this, c.class, null);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.b.a)) {
            return false;
        }
        bsw();
        return true;
    }

    protected final com.tencent.mm.plugin.wallet.bind.ui.a bsu() {
        return new a(this, this.rwS);
    }

    protected final void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, d.class, bundle);
    }
}
