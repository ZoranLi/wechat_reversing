package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.storage.c;

public final class a {
    public static boolean Wy() {
        boolean z;
        c dX = com.tencent.mm.u.c.c.Az().dX("100159");
        if (dX.isValid() && "1".equals(dX.bKK().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }
}
