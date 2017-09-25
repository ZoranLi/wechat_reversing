package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.wallet_core.c.n;

public class a extends b {
    public static int rtv = 1;
    public static int rtw = 2;

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        n.CH(14);
        return super.c(activity, bundle);
    }

    public final void c(Activity activity, int i) {
        n.ccf();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        n.ccf();
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", rtw) == rtv) {
            intent.putExtra("from_bind_ui", rtv);
            a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            return;
        }
        intent.putExtra("from_bind_ui", rtw);
        a(activity, "wallet", ".balance.ui.WalletBalanceFetchUI", -1, intent, true);
    }

    public final String avB() {
        return "BalanceFetchCardProcess";
    }
}
