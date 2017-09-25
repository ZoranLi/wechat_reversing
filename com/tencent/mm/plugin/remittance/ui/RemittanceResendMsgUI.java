package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.remittance.c.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.ipu.setVisibility(8);
        zg(8);
        String stringExtra = getIntent().getStringExtra("transaction_id");
        String stringExtra2 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (!bg.mA(stringExtra) && !bg.mA(stringExtra2)) {
            j(stringExtra, stringExtra2, intExtra2, intExtra);
        }
    }

    public void j(String str, String str2, int i, int i2) {
        k jVar = new j(str, str2, i, i2);
        jVar.gWO = "RemittanceProcess";
        k(jVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof j)) {
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

    protected final int getLayoutId() {
        return -1;
    }
}
