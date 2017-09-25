package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.a.a.AnonymousClass2;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.i;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e implements b {
    public final ArrayList<String> gZt = new ArrayList();

    public void od() {
    }

    public final void vO() {
        i.vN();
        i.vE().vi();
    }

    public final void c(com.tencent.mm.kernel.b.e eVar) {
        i.vN();
        i.vE().a(eVar);
    }

    public static void f(Class<? extends d> cls) {
        i.vN();
        i.vE().f(cls);
    }

    public final void ei(String str) {
        if (!this.gZt.contains(str)) {
            this.gZt.add(str);
        }
    }

    public boolean of() {
        return true;
    }

    public void a(com.tencent.mm.kernel.b.e eVar, c<Void> cVar, com.tencent.mm.vending.h.d dVar) {
    }

    public void a(com.tencent.mm.kernel.b.e eVar, com.tencent.mm.vending.h.d dVar, b bVar) {
        final long timestamp = a.timestamp();
        a.a("boot start to execute task on scheduler [%s]...", dVar.getType());
        final c lV = g.cbJ().lV(true);
        if (of()) {
            a(eVar, lV, dVar);
        } else {
            this.gZt.clear();
            a.a("This process(%s) will not install any pending plugin", eVar.gWO);
        }
        final com.tencent.mm.kernel.b.e eVar2 = eVar;
        final com.tencent.mm.vending.h.d dVar2 = dVar;
        final b bVar2 = bVar;
        lV.d(new a<Void, Void>(this) {
            final /* synthetic */ e gZx;

            public final /* synthetic */ Object call(Object obj) {
                if (this.gZx.gZt.size() > 0) {
                    a.a("boot start to install and init pending plugins in scheduler [%s]...", dVar2.getType());
                    Iterator it = this.gZx.gZt.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        i.vN();
                        i.vE().ee(str);
                    }
                    i.vN();
                    i.vE().vi();
                    i.vN();
                    i.vE().a(eVar2);
                    this.gZx.gZt.clear();
                }
                lV.a(dVar2);
                eVar2.gZy.a(lV, timestamp);
                a aVar = eVar2.gZy;
                lV.a(new AnonymousClass2(aVar, i.vN().vF().vj(), timestamp));
                if (bVar2 != null) {
                    lV.a(com.tencent.mm.vending.h.d.wDA, bVar2);
                }
                return wCE;
            }
        });
    }
}
