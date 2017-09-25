package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c implements b<b> {
    protected b inl;
    public final a inm;

    public class a implements e<v, f<String, Integer, String, String, Integer>> {
        final /* synthetic */ c inn;

        public a(c cVar) {
            this.inn = cVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            f fVar = (f) obj;
            b bVar = this.inn.inl;
            ap.vd().a(new j((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue()), 0);
            bVar.ink = g.cbK();
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.inl;
    }

    public c() {
        this(new b());
    }

    private c(b bVar) {
        this.inm = new a(this);
        this.inl = bVar;
    }

    public final b NL() {
        return this.inl;
    }
}
