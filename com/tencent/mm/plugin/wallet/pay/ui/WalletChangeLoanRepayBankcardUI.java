package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletChangeLoanRepayBankcardUI rzl;

            {
                this.rzl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rzl.setResult(-1, null);
                return true;
            }
        });
    }

    protected final e bsN() {
        this.ruj = m.btT().rIg;
        bsM();
        return new e(this, this.ruj, this.rzc, this.oSJ);
    }

    protected final void vu(int i) {
        int size = this.ruj != null ? this.ruj.size() : 0;
        if (this.ruj != null && i < size) {
            Bankcard bankcard = (Bankcard) this.ruj.get(i);
            this.ruk = bankcard;
            this.rzd.rKG = bankcard.field_bindSerial;
            this.rzb.setEnabled(true);
            this.rzd.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("bindSerial", bankcard.field_bindSerial);
            intent.putExtra("ret", 0);
            setResult(-1, intent);
        } else if (size == i) {
            Intent intent2 = new Intent();
            intent2.putExtra("ret", -1003);
            setResult(-1, intent2);
        }
        finish();
    }

    protected final int Ol() {
        return 1;
    }
}
