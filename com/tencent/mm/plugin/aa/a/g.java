package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public final class g implements b<f> {
    public final a inA;
    protected f inz;

    public class a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
        final /* synthetic */ g inB;

        public a(g gVar) {
            this.inB = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            f fVar = this.inB.inz;
            String str = (String) eVar.get(0);
            long longValue = ((Long) eVar.get(1)).longValue();
            int intValue = ((Integer) eVar.get(2)).intValue();
            String str2 = (String) eVar.get(3);
            if (fVar.iny) {
                w.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                ap.vd().a(new i(str, longValue, intValue, str2), 0);
                fVar.ink = com.tencent.mm.vending.g.g.cbK();
                fVar.iny = true;
            }
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.inz;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.inA = new a(this);
        this.inz = fVar;
    }

    public final f NS() {
        return this.inz;
    }
}
