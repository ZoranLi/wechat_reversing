package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class q {
    public HashMap<Integer, a> rUG = new HashMap();

    public final void a(a aVar) {
        for (Integer intValue : aVar.bvW()) {
            w.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[]{Integer.valueOf(intValue.intValue()), aVar});
            this.rUG.put(Integer.valueOf(r0), aVar);
        }
    }

    public final a vN(int i) {
        return (a) this.rUG.get(Integer.valueOf(i));
    }
}
