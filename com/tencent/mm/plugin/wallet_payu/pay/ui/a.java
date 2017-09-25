package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.e;
import java.util.ArrayList;

public final class a extends e {
    public final /* synthetic */ Object getItem(int i) {
        return vs(i);
    }

    public a(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        super(context, arrayList, i, orders);
    }

    public final int getCount() {
        return (this.ruj == null || this.ruj.size() == 0) ? 1 : this.ruj.size();
    }

    public final Bankcard vs(int i) {
        if (this.ruj != null && this.ruj.size() != 0) {
            return (Bankcard) this.ruj.get(i);
        }
        if (i != getCount() - 1) {
            return (Bankcard) this.ruj.get(i);
        }
        return null;
    }
}
