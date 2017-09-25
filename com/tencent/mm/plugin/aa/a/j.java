package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class j implements com.tencent.mm.vending.c.b<i> {
    protected i inC;
    public final b inD;
    public final a inE;

    public class a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
        final /* synthetic */ j inF;

        public a(j jVar) {
            this.inF = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            i iVar = this.inF.inC;
            String str = (String) eVar.get(0);
            int intValue = ((Integer) eVar.get(1)).intValue();
            String str2 = (String) eVar.get(2);
            long longValue = ((Long) eVar.get(3)).longValue();
            iVar.hsf = g.cbB();
            iVar.fGM = longValue;
            if (bg.mA(str)) {
                iVar.hsf.bJ(Boolean.valueOf(false));
            } else {
                ap.vd().a(new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2), 0);
                w.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
                iVar.hsf = g.cbK();
            }
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<Boolean, d<String, Integer, String>> {
        final /* synthetic */ j inF;

        public b(j jVar) {
            this.inF = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            d dVar = (d) obj;
            i iVar = this.inF.inC;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            String str2 = (String) dVar.get(2);
            iVar.hsf = g.cbB();
            if (bg.mA(str)) {
                iVar.hsf.bJ(Boolean.valueOf(false));
            } else {
                ap.vd().a(new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2), 0);
                w.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
                iVar.hsf = g.cbK();
            }
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.inC;
    }

    public j() {
        this(new i());
    }

    private j(i iVar) {
        this.inD = new b(this);
        this.inE = new a(this);
        this.inC = iVar;
    }

    public final i NV() {
        return this.inC;
    }
}
