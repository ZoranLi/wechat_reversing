package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.model.m;

public class a extends b {
    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        if (m.btS().bum()) {
            b(activity, WalletLoanCheckPwdUI.class, bundle);
        } else {
            super.c(activity, bundle);
        }
        return this;
    }

    public final void c(Activity activity, int i) {
        d(activity, this.lHw);
    }

    public final void d(Activity activity, Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean("intent_bind_end", false)) {
            i = -1;
        }
        a(activity, WalletLoanRepaymentUI.class, i, null, true);
    }
}
