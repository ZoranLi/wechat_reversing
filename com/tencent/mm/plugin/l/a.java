package com.tencent.mm.plugin.l;

import com.tencent.mm.ap.t;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements b {
    private static a kFY;

    private a() {
        super(t.class);
    }

    public static synchronized a akK() {
        a aVar;
        synchronized (a.class) {
            if (kFY == null) {
                kFY = new a();
            }
            aVar = kFY;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        return linkedList;
    }

    public static String xl() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("package/").toString();
    }
}
