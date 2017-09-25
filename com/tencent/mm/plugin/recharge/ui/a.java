package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class a {
    public static MallRechargeProduct bg(List<MallRechargeProduct> list) {
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                w.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                return mallRechargeProduct;
            }
        }
        w.d("MicroMsg.MallRechargeLogic", "products.get(0)");
        return (MallRechargeProduct) list.get(0);
    }
}
