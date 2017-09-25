package com.tencent.mm.p;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.u.l;

public final class h extends l implements c {
    private static h gUH;

    public static synchronized h ud() {
        h hVar;
        synchronized (h.class) {
            if (gUH == null) {
                gUH = new h();
            }
            hVar = gUH;
        }
        return hVar;
    }

    private h() {
        super(i.class);
    }

    public final void onAccountInitialized(f fVar) {
        super.onAccountInitialized(fVar);
    }
}
