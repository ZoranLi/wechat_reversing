package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;

public final class e implements b<d> {
    protected d inv;
    public final a inw;

    public class a implements com.tencent.mm.vending.h.e<Void, Void> {
        final /* synthetic */ e inx;

        public a(e eVar) {
            this.inx = eVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            d dVar = this.inx.inv;
            ap.vd().a(new h(), 0);
            dVar.ink = g.cbK();
            return wCE;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.inv;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.inw = new a(this);
        this.inv = dVar;
    }

    public final d NR() {
        return this.inv;
    }
}
