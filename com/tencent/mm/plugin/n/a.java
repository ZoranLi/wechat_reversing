package com.tencent.mm.plugin.n;

import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.l;

public final class a extends l {
    private static a mLT;

    private a() {
        super(n.class);
    }

    public static synchronized a aDu() {
        a aVar;
        synchronized (a.class) {
            if (mLT == null) {
                mLT = new a();
            }
            aVar = mLT;
        }
        return aVar;
    }

    public static at wY() {
        h.vG().uQ();
        return ((com.tencent.mm.plugin.r.a.a) h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
    }
}
