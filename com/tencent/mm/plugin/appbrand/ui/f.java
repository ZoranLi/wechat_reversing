package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.i;

final class f extends e {
    private i iwl;

    f(Activity activity, i iVar) {
        super(activity);
        this.iwl = iVar;
    }

    protected final void QH() {
        h PF = this.iwl.PF();
        if (PF != null) {
            PF.iwC.iAk.hx(10);
        }
    }
}
