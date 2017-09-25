package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.a.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.b;

public class j extends b {
    public final b c(Activity activity, Bundle bundle) {
        String str;
        String str2 = "";
        if (bundle != null) {
            if (bg.mA(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.rGe == null || orders.rGe.size() <= 0)) {
                    str = ((Commodity) orders.rGe.get(0)).fTA;
                }
            } else {
                str = "key_trans_id";
            }
            ap.vd().a(new g("offlineshowpage", "push", str), 0);
            b(activity, WalletOrderInfoUI.class, bundle);
            ap.yY();
            c.vr().a(a.uEO, Boolean.valueOf(true));
            return this;
        }
        str = str2;
        ap.vd().a(new g("offlineshowpage", "push", str), 0);
        b(activity, WalletOrderInfoUI.class, bundle);
        ap.yY();
        c.vr().a(a.uEO, Boolean.valueOf(true));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletOrderInfoUI) {
            J(activity);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        aj(activity);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return "ShowOrderSuccessProcess";
    }
}
