package com.tencent.mm.plugin.emoji;

import com.tencent.mm.af.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends l implements b {
    private static d kHp;

    private d() {
        super(a.class);
    }

    public static synchronized d akT() {
        d dVar;
        synchronized (d.class) {
            if (kHp == null) {
                kHp = new d();
            }
            dVar = kHp;
        }
        return dVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"emoji/"});
        return linkedList;
    }

    public static String akU() {
        return h.vI().gYf + "emoji/";
    }
}
