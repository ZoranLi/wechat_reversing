package com.tencent.mm.plugin.wallet_core.d;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;

public final class c {
    public static long rPt = 0;
    public static int rPu = 2;
    public static int rPv = 1;
    public static int rPw = 2;

    public static void bvt() {
        rPt = System.currentTimeMillis();
    }

    public static int bvu() {
        return (int) ((System.currentTimeMillis() - rPt) / 1000);
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        b ai = a.ai(activity);
        if (!m.btS().bum() && ai != null && ai.cbS()) {
            Orders orders = (Orders) bundle.getParcelable("key_orders");
            if (((PayInfo) bundle.getParcelable("key_pay_info")) != null && orders != null) {
                g.oUh.i(10725, new Object[]{Integer.valueOf(i), Integer.valueOf(r0.fRv), Integer.valueOf((int) (orders.rFM * 100.0d)), orders.oga});
            }
        } else if (!m.btS().bum() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
            g.oUh.i(10932, new Object[]{Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0))});
        }
    }

    public static void du(int i, int i2) {
        g.oUh.i(10932, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static void b(PayInfo payInfo, Orders orders) {
        if (!m.btS().bum() && payInfo != null && orders != null) {
            g.oUh.i(10725, new Object[]{Integer.valueOf(1), Integer.valueOf(payInfo.fRv), Integer.valueOf((int) (orders.rFM * 100.0d)), orders.oga});
        }
    }
}
