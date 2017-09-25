package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public abstract class WalletLqtBasePresenterUI extends WalletBaseUI {
    private c gZG = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZG.C(getIntent(), this);
        this.wFv = true;
    }

    public void onResume() {
        super.onResume();
        this.gZG.CF(2);
    }

    public void onPause() {
        super.onPause();
        this.gZG.CF(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.gZG.onDestroy();
    }

    public final <T extends b<? extends a>> T m(Class<? extends b<? extends a>> cls) {
        return this.gZG.a(this, cls);
    }

    public final <T extends a> T p(Class<? extends a> cls) {
        return this.gZG.b(this, cls);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected final int Ol() {
        return 1;
    }
}
