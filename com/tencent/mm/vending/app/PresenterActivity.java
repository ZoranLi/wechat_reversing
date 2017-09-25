package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c gZG = new c();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZG.C(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.gZG.CF(2);
    }

    protected void onPause() {
        this.gZG.CF(3);
        super.onPause();
    }

    protected void onDestroy() {
        this.gZG.onDestroy();
        super.onDestroy();
    }
}
