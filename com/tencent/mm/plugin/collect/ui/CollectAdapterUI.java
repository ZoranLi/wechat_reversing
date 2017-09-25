package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class CollectAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        ap.yY();
        w.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", new Object[]{Integer.valueOf(((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue())});
        if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue() == 8) {
            d.b(this, "collect", ".ui.CollectHKMainUI", getIntent());
        } else {
            d.b(this, "collect", ".ui.CollectMainUI", getIntent());
        }
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
