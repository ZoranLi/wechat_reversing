package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        ((TextView) findViewById(R.h.cRP)).setText(e.o(this.uT.getDouble("key_credit_amount")));
        bPS();
        kq(false);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountResultUI szZ;

            {
                this.szZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.szZ.ccE().a(this.szZ.uSU.uTo, 0, this.szZ.uT);
                return true;
            }
        });
    }
}
