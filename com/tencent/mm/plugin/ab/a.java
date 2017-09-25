package com.tencent.mm.plugin.ab;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.h;
import java.util.List;

public final class a implements b, com.tencent.mm.kernel.b.b {
    private static a oQc;

    private a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized a aWY() {
        a aVar;
        synchronized (a.class) {
            if (oQc == null) {
                oQc = new a();
            }
            aVar = oQc;
        }
        return aVar;
    }

    public static String xd() {
        return h.vI().gYf + "remark/";
    }
}
