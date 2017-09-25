package com.tencent.mm.plugin.x;

import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.u.l;

public final class a extends l {
    private static a ooH;

    public static synchronized a aSP() {
        a aVar;
        synchronized (a.class) {
            if (ooH == null) {
                ooH = new a();
            }
            aVar = ooH;
        }
        return aVar;
    }

    private a() {
        super(c.class);
    }
}
