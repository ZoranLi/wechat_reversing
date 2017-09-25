package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static d iGH;
    Map<String, c> iGI = new ConcurrentHashMap();

    private d() {
    }

    public static d RP() {
        if (iGH == null) {
            synchronized (d.class) {
                if (iGH == null) {
                    iGH = new d();
                }
            }
        }
        return iGH;
    }

    public final c oy(String str) {
        if (!bg.mA(str)) {
            return (c) this.iGI.get(str);
        }
        w.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
        return null;
    }

    public final int size() {
        return this.iGI.size();
    }
}
