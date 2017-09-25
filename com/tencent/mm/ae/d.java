package com.tencent.mm.ae;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public class d implements am {
    private static HashMap<Integer, c> gJr;
    private b hDV;
    private c hDW;

    private static d Gr() {
        a aVar = (a) ap.yR().gs("plugin.subapp");
        d dVar = (d) aVar.Hj(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        aVar.b(d.class.getName(), dVar2);
        return dVar2;
    }

    public static b Gs() {
        h.vG().uQ();
        if (Gr().hDV == null) {
            d Gr = Gr();
            ap.yY();
            Gr.hDV = new b(com.tencent.mm.u.c.wO());
        }
        return Gr().hDV;
    }

    public final void onAccountRelease() {
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        if (this.hDW == null) {
            this.hDW = new c();
        }
        ag.a.hlS = this.hDW;
        w.d("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.hDW);
    }

    public final void aN(boolean z) {
    }
}
