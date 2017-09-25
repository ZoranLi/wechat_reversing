package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.al.a;

public final class h {
    public boolean nPO;
    private boolean nPP;

    public final void F(Activity activity) {
        if (!this.nPO) {
            this.nPO = true;
            a.a(activity, R.l.eCh, null);
        }
    }

    public final void G(Activity activity) {
        if (!this.nPP) {
            this.nPP = true;
            a.a(activity, R.l.fcr, null);
        }
    }

    public final void reset() {
        this.nPP = false;
        this.nPO = false;
    }
}
