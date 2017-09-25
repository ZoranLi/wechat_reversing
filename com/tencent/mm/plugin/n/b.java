package com.tencent.mm.plugin.n;

import com.tencent.mm.kernel.h;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class b implements com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.b.b {
    private static b mLU;

    private b() {
    }

    public static synchronized b aDv() {
        b bVar;
        synchronized (b.class) {
            if (mLU == null) {
                mLU = new b();
            }
            bVar = mLU;
        }
        return bVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/"});
        return linkedList;
    }

    public static String xb() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("image/").toString();
    }

    public static String xc() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("image2/").toString();
    }

    public static String xr() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("sfs").toString();
    }
}
