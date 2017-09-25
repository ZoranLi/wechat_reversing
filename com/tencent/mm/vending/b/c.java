package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _Callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void cby() {
        a(null);
    }

    public final synchronized void a(final a aVar) {
        Iterator it = cbx().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.fwy != null) {
                    this.wCx.b(bVar.fwy);
                } else {
                    this.wCx.b(d.cbL());
                }
                this.wCx.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                    final /* synthetic */ c wCD;

                    public final /* synthetic */ Object call(Object obj) {
                        Void voidR = (Void) obj;
                        this.wCD.a(bVar.wCz, aVar);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.wCE, true);
            }
        }
    }

    public final b<_Callback> bI(_Callback _Callback) {
        return a(new b(_Callback, this));
    }
}
