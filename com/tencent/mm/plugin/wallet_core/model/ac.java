package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class ac {
    public ArrayList<Bankcard> rIg = new ArrayList();
    public String rIh;

    public final Bankcard HW(String str) {
        if (this.rIg.size() > 0) {
            Bankcard bankcard;
            Iterator it = this.rIg.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    break;
                }
            }
            bankcard = null;
            if (bankcard == null) {
                w.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
                return bankcard;
            }
            w.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
            return bankcard;
        }
        w.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        return null;
    }

    public final boolean bud() {
        return this.rIg.size() > 0;
    }

    public final Bankcard bue() {
        if (!bud()) {
            w.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
            return null;
        } else if (!TextUtils.isEmpty(this.rIh)) {
            return HW(this.rIh);
        } else {
            w.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
            return (Bankcard) this.rIg.get(0);
        }
    }
}
