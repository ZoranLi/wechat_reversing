package com.tencent.mm.compatible.a;

import com.tencent.mm.compatible.util.f;

public final class a {

    public interface a {
        void run();
    }

    public static boolean a(int i, a aVar) {
        if (!f.eo(i)) {
            return false;
        }
        aVar.run();
        return true;
    }
}
