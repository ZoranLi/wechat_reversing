package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.i.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.i.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.i.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.a.a.i.AnonymousClass4;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class j implements com.tencent.mm.vending.c.b<i> {
    protected i rtK;
    public final d rtL;
    public final b rtM;
    public final c rtN;
    public final a rtO;

    public class a implements e<arc, Integer> {
        final /* synthetic */ j rtP;

        public a(j jVar) {
            this.rtP = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            i iVar = this.rtP.rtK;
            int intValue = num.intValue();
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new b(intValue).BC().f(new AnonymousClass4(iVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public class b implements e<aso, com.tencent.mm.vending.j.d<String, String, Integer>> {
        final /* synthetic */ j rtP;

        public b(j jVar) {
            this.rtP = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            i iVar = this.rtP.rtK;
            String str = (String) dVar.get(0);
            String str2 = (String) dVar.get(1);
            int intValue = ((Integer) dVar.get(2)).intValue();
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new d(str, str2, intValue).BC().f(new AnonymousClass2(iVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public class c implements e<aui, com.tencent.mm.vending.j.d<Integer, String, String>> {
        final /* synthetic */ j rtP;

        public c(j jVar) {
            this.rtP = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            i iVar = this.rtP.rtK;
            int intValue = ((Integer) dVar.get(0)).intValue();
            String str = (String) dVar.get(1);
            String str2 = (String) dVar.get(2);
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new f(intValue, str, str2).BC().f(new AnonymousClass3(iVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public class d implements e<asf, com.tencent.mm.vending.j.c<String, Integer>> {
        final /* synthetic */ j rtP;

        public d(j jVar) {
            this.rtP = jVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            i iVar = this.rtP.rtK;
            String str = (String) cVar.get(0);
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new c(str, intValue).BC().f(new AnonymousClass1(iVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.rtK;
    }

    public j() {
        this(new i());
    }

    private j(i iVar) {
        this.rtL = new d(this);
        this.rtM = new b(this);
        this.rtN = new c(this);
        this.rtO = new a(this);
        this.rtK = iVar;
    }
}
