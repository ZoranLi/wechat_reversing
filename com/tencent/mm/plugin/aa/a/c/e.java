package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.g.g;
import java.util.Map;

public class e implements com.tencent.mm.vending.c.b<d> {
    protected d ioA;
    public final b ioB;
    public final c ioC;
    public final a ioD;

    public class a implements com.tencent.mm.vending.h.e<d, Void> {
        final /* synthetic */ e ioE;

        public a(e eVar) {
            this.ioE = eVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            g.a(g.cbJ().a(this.ioE.ioA.ioz.inw));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>> {
        final /* synthetic */ e ioE;

        public b(e eVar) {
            this.ioE = eVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            com.tencent.mm.vending.app.a aVar = this.ioE.ioA;
            int intValue = ((Integer) cVar.get(0)).intValue();
            Map map = (Map) cVar.get(1);
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 1);
            if (intExtra == 1) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imN));
            } else if (intExtra == 2) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imO));
            } else if (intExtra == 3) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imP));
            }
            g.a(g.s(Integer.valueOf(intValue), map).a(aVar.ioy.inS));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>> {
        final /* synthetic */ e ioE;

        public c(e eVar) {
            this.ioE = eVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            Map map = (Map) obj;
            com.tencent.mm.vending.app.a aVar = this.ioE.ioA;
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 1);
            if (intExtra == 1) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imN));
            } else if (intExtra == 2) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imO));
            } else if (intExtra == 3) {
                map.put(k.inL, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.imP));
            }
            g.a(g.bN(map).a(aVar.ioy.inT));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.ioA;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.ioB = new b(this);
        this.ioC = new c(this);
        this.ioD = new a(this);
        this.ioA = dVar;
    }

    public final d NY() {
        return this.ioA;
    }
}
