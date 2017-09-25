package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.g.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.g.AnonymousClass2;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class h implements com.tencent.mm.vending.c.b<g> {
    protected g rtF;
    public final b rtG;
    public final a rtH;

    public class a implements e<ls, String> {
        final /* synthetic */ h rtI;

        public a(h hVar) {
            this.rtI = hVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            String str = (String) obj;
            g gVar = this.rtI.rtF;
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new a(str).BC().e(new AnonymousClass2(gVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<asq, Void> {
        final /* synthetic */ h rtI;

        public b(h hVar) {
            this.rtI = hVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            g gVar = this.rtI.rtF;
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            new e().BC().e(new AnonymousClass1(gVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.rtF;
    }

    public h() {
        this(new g());
    }

    private h(g gVar) {
        this.rtG = new b(this);
        this.rtH = new a(this);
        this.rtF = gVar;
    }
}
