package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        c.vr().set(196658, Boolean.valueOf(false));
        KC();
    }

    protected final void KC() {
        int i = 0;
        zi(R.l.flw);
        bPS();
        kq(false);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenNotifyUI sAG;

            {
                this.sAG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sAG.setResult(-1);
                this.sAG.finish();
                return true;
            }
        });
        ((TextView) findViewById(R.h.cRP)).setText(e.o(this.uT.getDouble("key_total_amount")));
        Button button = (Button) findViewById(R.h.cnY);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenNotifyUI sAG;

            {
                this.sAG = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_bankcard", this.sAG.uT.getParcelable("key_bankcard"));
                a.a(this.sAG, b.class, bundle);
            }
        });
        if (!this.uT.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
    }
}
