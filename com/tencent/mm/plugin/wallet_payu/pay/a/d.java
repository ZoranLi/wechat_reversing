package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        if (orders == null || orders.rGe == null || orders.rGe.size() <= 0) {
            w.d("MicroMsg.OrdersWrapper", "hy: params error");
        } else {
            for (Commodity commodity : orders.rGe) {
                commodity.ofW = i;
                commodity.ofT = str.equals("1") ? "2" : "1";
                commodity.ofU = str2;
                commodity.ofY = str3;
            }
        }
        return orders;
    }
}
