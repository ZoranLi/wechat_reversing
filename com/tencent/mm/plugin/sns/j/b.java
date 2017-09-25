package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a qPG;
    public final a qPH;
    public final b qPI;

    public class a implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        final /* synthetic */ b qPJ;

        public a(b bVar) {
            this.qPJ = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = this.qPJ.qPG;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.g(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            return wCE;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }

        public final c<Void> b(String str, boolean z, boolean z2, int i) {
            return g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).a(this);
        }
    }

    public class b implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        final /* synthetic */ b qPJ;

        public b(b bVar) {
            this.qPJ = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = this.qPJ.qPG;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.h(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            return wCE;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }

        public final c<Void> b(String str, boolean z, boolean z2, int i) {
            return g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).a(this);
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.qPG;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.qPH = new a(this);
        this.qPI = new b(this);
        this.qPG = aVar;
    }

    public final a blO() {
        return this.qPG;
    }
}
