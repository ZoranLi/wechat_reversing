package com.tencent.mm.plugin.r;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.storage.at;
import java.util.HashMap;

public final class b implements a, com.tencent.mm.kernel.b.b {
    private static b nyg;

    private b() {
    }

    public static synchronized b aJV() {
        b bVar;
        synchronized (b.class) {
            if (nyg == null) {
                nyg = new b();
            }
            bVar = nyg;
        }
        return bVar;
    }

    public final HashMap<Integer, c> collectDatabaseFactory() {
        HashMap<Integer, c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new c(this) {
            final /* synthetic */ b nyh;

            {
                this.nyh = r1;
            }

            public final String[] pP() {
                return at.gUx;
            }
        });
        return hashMap;
    }
}
