package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> iDL = new HashMap();

    public final void a(a aVar) {
        if (aVar == null || bg.mA(aVar.fJz)) {
            w.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        w.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[]{aVar.fJz, aVar.iDA});
        this.iDL.put(aVar.fJz, aVar);
    }

    public final a nY(String str) {
        if (!bg.mA(str)) {
            return (a) this.iDL.get(str);
        }
        w.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
