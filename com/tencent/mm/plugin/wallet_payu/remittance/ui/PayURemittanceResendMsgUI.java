package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.h;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

@a(3)
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void j(String str, String str2, int i, int i2) {
        k(new h(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str2, i));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof h)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            g.bl(this, getString(R.l.eLv));
            finish();
            return true;
        }
        g.bl(this, str);
        finish();
        return true;
    }
}
