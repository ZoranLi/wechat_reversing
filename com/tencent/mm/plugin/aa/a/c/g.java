package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass1;
import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass2;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.w;

public class g implements com.tencent.mm.vending.c.b<f> {
    protected f ioJ;
    public final d ioK;
    public final a ioL;
    public final e ioM;
    public final c ioN;
    public final b ioO;
    public final f ioP;

    public class a implements com.tencent.mm.vending.h.e<o, Long> {
        final /* synthetic */ g ioQ;

        public a(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            Long l = (Long) obj;
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            long longValue = l.longValue();
            String stringExtra = aVar.wBK.getStringExtra("bill_no");
            String stringExtra2 = aVar.wBK.getStringExtra("chatroom");
            int i = aVar.wBK.getIntExtra("enter_scene", 0) == 1 ? com.tencent.mm.plugin.aa.a.a.inc : com.tencent.mm.plugin.aa.a.a.ind;
            w.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", new Object[]{Long.valueOf(longValue), stringExtra, stringExtra2});
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).a(aVar.ioG.inA));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, Void> {
        final /* synthetic */ g ioQ;

        public b(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            String stringExtra = aVar.wBK.getStringExtra("bill_no");
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 0);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Integer.valueOf(intExtra), aVar.wBK.getStringExtra("chatroom")).a(aVar.ioH.inD));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<Long, String, String>> {
        final /* synthetic */ g ioQ;

        public c(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            long longValue = ((Long) dVar.get(0)).longValue();
            String str = (String) dVar.get(1);
            String str2 = (String) dVar.get(2);
            com.tencent.mm.vending.g.b cbB = com.tencent.mm.vending.g.g.cbB();
            String stringExtra = aVar.wBK.getStringExtra("bill_no");
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 0);
            String stringExtra2 = aVar.wBK.getStringExtra("chatroom");
            cbB.cbA();
            new com.tencent.mm.plugin.aa.a.a.a(stringExtra, longValue, intExtra, stringExtra2, str, str2).BC().e(new AnonymousClass1(aVar, cbB));
            return wCE;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class d implements com.tencent.mm.vending.h.e<v, Void> {
        final /* synthetic */ g ioQ;

        public d(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            String stringExtra = aVar.wBK.getStringExtra("bill_no");
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 0);
            String stringExtra2 = aVar.wBK.getStringExtra("chatroom");
            String stringExtra3 = aVar.wBK.getStringExtra("key_sign");
            int intExtra2 = aVar.wBK.getIntExtra("key_ver", 0);
            w.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", new Object[]{stringExtra, Integer.valueOf(intExtra), stringExtra2});
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).a(aVar.ioF.inm));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<String, String, String>> {
        final /* synthetic */ g ioQ;

        public e(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            String str = (String) dVar.get(1);
            h.b(str, aVar.wBK.getStringExtra("chatroom"), aVar.wBK.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
            return wCE;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public class f implements com.tencent.mm.vending.h.e<Boolean, Void> {
        final /* synthetic */ g ioQ;

        public f(g gVar) {
            this.ioQ = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.ioQ.ioJ;
            String stringExtra = aVar.wBK.getStringExtra("bill_no");
            String stringExtra2 = aVar.wBK.getStringExtra("chatroom");
            int intExtra = aVar.wBK.getIntExtra("enter_scene", 0);
            w.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            com.tencent.mm.vending.g.b cbB = com.tencent.mm.vending.g.g.cbB();
            cbB.cbA();
            new com.tencent.mm.plugin.aa.a.a.b(stringExtra, stringExtra2, intExtra).BC().e(new AnonymousClass2(aVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.ioJ;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.ioK = new d(this);
        this.ioL = new a(this);
        this.ioM = new e(this);
        this.ioN = new c(this);
        this.ioO = new b(this);
        this.ioP = new f(this);
        this.ioJ = fVar;
    }
}
