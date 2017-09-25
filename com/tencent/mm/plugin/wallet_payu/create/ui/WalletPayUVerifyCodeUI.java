package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.k;

@a(3)
public class WalletPayUVerifyCodeUI extends WalletVerifyCodeUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rOt.wGc = 60;
    }

    protected final void bvp() {
        super.bvp();
    }

    protected final void bvq() {
        super.bvq();
    }

    public final void bvo() {
        this.rOs = 180000;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) && !((com.tencent.mm.plugin.wallet_payu.a.a) kVar).rRH) {
            w.w("MicroMsg.WalletPayUVerifyCodeUI", "hy: confirm code not verified");
        }
        return false;
    }

    protected final boolean bsP() {
        return true;
    }
}
