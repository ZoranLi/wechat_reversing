package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.u.ap;

public final class b {
    private static b mQL;
    private g mQM;

    public static b aEL() {
        if (mQL == null) {
            mQL = new b();
        }
        return mQL;
    }

    public final void fb(boolean z) {
        ap.vd().c(this.mQM);
        this.mQM = null;
        if (z) {
            this.mQM = new g(1);
        } else {
            this.mQM = new g(0);
        }
        ap.vd().a(this.mQM, 0);
    }
}
