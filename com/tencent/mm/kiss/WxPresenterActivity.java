package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c gZG = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZG.C(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.gZG.CF(2);
    }

    public void onPause() {
        this.gZG.CF(3);
        super.onPause();
    }

    public void onDestroy() {
        this.gZG.onDestroy();
        super.onDestroy();
    }

    public final void a(a aVar) {
        this.gZG.a(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T m(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gZG.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a vQ() {
        return this.gZG.vQ();
    }
}
