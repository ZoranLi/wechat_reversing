package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.remittance.ui.RemittanceUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.plugin.wallet_payu.remittance.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;

public class PayURemittanceUI extends RemittanceUI {
    private final String rSW = "ZAR";

    public final void aXh() {
        k(new g(this.gLD, this.oRi));
    }

    public final void dj(String str, String str2) {
        k(new d(this.oRf, "ZAR", this.gLD, this.hPi));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof d)) {
            return true;
        }
        d dVar = (d) kVar;
        if (bg.mA(dVar.fOv)) {
            s.makeText(this.uSU.uTo, R.l.flI, 0).show();
            return true;
        }
        String str2 = dVar.fOv;
        String str3 = this.gLD;
        PayInfo payInfo = new PayInfo();
        payInfo.fJH = str2;
        payInfo.fRv = this.oRh;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", getIntent().getStringExtra("desc"));
        bundle.putString("extinfo_key_4", getIntent().getStringExtra("scan_remittance_id"));
        bundle.putString("fee_type", "ZAR");
        bundle.putDouble("total_fee", this.oRf);
        payInfo.sYe = bundle;
        e.a(this, payInfo, 1);
        return true;
    }
}
