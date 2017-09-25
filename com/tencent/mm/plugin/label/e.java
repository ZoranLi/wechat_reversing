package com.tencent.mm.plugin.label;

import com.tencent.mm.aj.a;
import com.tencent.mm.aj.b;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public class e implements am {
    private static HashMap<Integer, c> gJr;
    private ac mYR;
    private d mYS = new d();

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ac.gUx;
            }
        });
        gJr.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ab.gUx;
            }
        });
    }

    private static e aFE() {
        e eVar = (e) ap.yR().gs("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    eVar = new e();
                    ap.yR().a("plugin.label", eVar);
                }
            }
        }
        return eVar;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        a bVar = new b();
        com.tencent.mm.plugin.label.a.a.mYT = bVar;
        b.hJG = bVar;
        com.tencent.mm.sdk.b.a.urY.b(this.mYS);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.plugin.label.a.a.mYT = null;
        com.tencent.mm.sdk.b.a.urY.c(this.mYS);
    }

    public static ac aFF() {
        h.vG().uQ();
        if (aFE().mYR == null) {
            e aFE = aFE();
            ap.yY();
            aFE.mYR = new ac(com.tencent.mm.u.c.wO());
        }
        return aFE().mYR;
    }
}
