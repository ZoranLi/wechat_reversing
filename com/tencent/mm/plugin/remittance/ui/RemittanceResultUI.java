package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fe;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.pb.common.c.d;

@a(19)
public class RemittanceResultUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        if (aXw()) {
            PayInfo payInfo;
            b feVar;
            Orders orders = (Orders) this.uT.getParcelable("key_orders");
            String str = "MicroMsg.RemittanceResultUI";
            Object[] objArr = new Object[2];
            objArr[0] = "orders==null:%s";
            objArr[1] = Boolean.valueOf(orders == null);
            d.j(str, objArr);
            if (orders != null) {
                d.j("MicroMsg.RemittanceResultUI", new Object[]{"is_use_new_paid_succ_page: %s", Integer.valueOf(orders.rGo)});
                if (orders.rGo != 1) {
                    ccE().b(this, RemittanceResultOldUI.class, this.uT);
                    finish();
                    payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
                    if (payInfo != null) {
                        i = payInfo.fRv;
                    }
                    if (i != 33 || i == 32) {
                        feVar = new fe();
                        feVar.fJG.fJH = payInfo.fJH;
                        com.tencent.mm.sdk.b.a.urY.m(feVar);
                    }
                    return;
                }
            }
            ccE().b(this, RemittanceResultNewUI.class, this.uT);
            finish();
            payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
            if (payInfo != null) {
                i = payInfo.fRv;
            }
            if (i != 33) {
            }
            feVar = new fe();
            feVar.fJG.fJH = payInfo.fJH;
            com.tencent.mm.sdk.b.a.urY.m(feVar);
        }
    }

    protected boolean aXw() {
        return true;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected int getLayoutId() {
        return R.i.dpj;
    }
}
