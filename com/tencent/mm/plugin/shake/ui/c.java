package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;

final class c {
    aj fyI = new aj(new a(this) {
        final /* synthetic */ c pqL;

        {
            this.pqL = r1;
        }

        public final boolean oQ() {
            this.pqL.bbx();
            return false;
        }
    }, false);
    View view;

    public c(View view) {
        this.view = view;
    }

    public final void bbx() {
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
    }
}
