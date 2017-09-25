package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.WeakHashMap;

public final class k {
    public static final WeakHashMap<h, k> ixj = new WeakHashMap();
    public final h ixi;

    private k(final h hVar) {
        this.ixi = hVar;
        e.a(hVar.ivH, new b(this) {
            final /* synthetic */ k ixl;

            public final void onDestroy() {
                synchronized (k.ixj) {
                    k.ixj.remove(hVar);
                }
            }
        });
    }

    public static k b(h hVar) {
        if (hVar == null || bg.mA(hVar.ivH)) {
            return null;
        }
        k kVar;
        synchronized (ixj) {
            kVar = (k) ixj.get(hVar);
            if (kVar == null) {
                kVar = new k(hVar);
                ixj.put(hVar, kVar);
            }
        }
        return kVar;
    }
}
