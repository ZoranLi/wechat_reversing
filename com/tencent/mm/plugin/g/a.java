package com.tencent.mm.plugin.g;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.k;
import com.tencent.mm.u.l;
import com.tencent.mm.x.n;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements b {
    private static a jAU;

    private a() {
        super(n.class);
    }

    public static synchronized a ZV() {
        a aVar;
        synchronized (a.class) {
            if (jAU == null) {
                jAU = new a();
            }
            aVar = jAU;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        return linkedList;
    }

    public static String ZW() {
        return h.vI().gYf + "avatar/";
    }

    public final void eg(String str) {
        super.eg(str);
        String str2 = "avatar/";
        if (f.rZ()) {
            h.vJ();
            if (h.vI().gYe.equals(e.hgu)) {
                h.vJ();
                com.tencent.mm.sdk.f.e.post(new k(h.vI().cachePath, str, str2), "Account_moveDataFiles_" + str2);
            }
        }
    }
}
