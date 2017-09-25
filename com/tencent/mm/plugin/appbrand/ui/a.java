package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.base.h;

public final class a extends com.tencent.mm.ui.base.h.a {
    private boolean jhZ = false;

    public a(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.jhZ = g.b(((Activity) context).getWindow());
        }
    }

    public final h WJ() {
        h WJ = super.WJ();
        g.a(WJ.getWindow(), this.jhZ);
        return WJ;
    }
}
