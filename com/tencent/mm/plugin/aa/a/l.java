package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class l implements com.tencent.mm.vending.c.b<k> {
    protected k inR;
    public final a inS;
    public final b inT;

    public class a implements e<Boolean, c<Integer, Map<String, Object>>> {
        final /* synthetic */ l inU;

        public a(l lVar) {
            this.inU = lVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            c cVar = (c) obj;
            this.inU.inR.d(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<d<Boolean, String, Long>, Map<String, Object>> {
        final /* synthetic */ l inU;

        public b(l lVar) {
            this.inU = lVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            this.inU.inR.o((Map) obj);
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.inR;
    }

    public l() {
        this(new k());
    }

    private l(k kVar) {
        this.inS = new a(this);
        this.inT = new b(this);
        this.inR = kVar;
    }

    public final k NW() {
        return this.inR;
    }
}
