package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity extends MMActivity {
    private c gZG = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZG.C(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.gZG.CF(2);
    }

    protected void onPause() {
        super.onPause();
        this.gZG.CF(3);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.gZG.onDestroy();
    }
}
