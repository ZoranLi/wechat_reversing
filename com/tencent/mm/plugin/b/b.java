package com.tencent.mm.plugin.b;

import com.tencent.mm.u.c.c;
import com.tencent.mm.u.l;

public final class b extends l {
    private static b irI;

    private b() {
        super(c.class);
    }

    public static synchronized b Oy() {
        b bVar;
        synchronized (b.class) {
            if (irI == null) {
                irI = new b();
            }
            bVar = irI;
        }
        return bVar;
    }

    public final void eg(String str) {
        super.eg(str);
    }
}
