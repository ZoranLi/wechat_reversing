package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;

public final class d implements e {
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<i, a> gUK = new HashMap();

    public interface a {
        void a(boolean z, jk jkVar);

        void bG(String str, String str2);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            a aVar = (a) this.gUK.get(kVar);
            if (aVar == null) {
                w.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                return;
            }
            if (i == 0 && i2 == 0) {
                aVar.a(true, iVar.kAB);
            } else {
                w.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[]{iVar});
                aVar.a(false, null);
            }
            this.gUK.remove(kVar);
        }
    }
}
