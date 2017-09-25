package com.tencent.mm.bn;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void ao(_Callback _Callback);
    }

    public a() {
        super(new d());
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        Iterator it = cbx().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.fwy != null) {
                    this.wCx.b(bVar.fwy);
                    this.wCx.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                        final /* synthetic */ a wGh;

                        public final /* synthetic */ Object call(Object obj) {
                            Void voidR = (Void) obj;
                            aVar.ao(bVar.wCz);
                            return voidR;
                        }
                    }, com.tencent.mm.vending.c.a.wCE, true);
                } else {
                    aVar.ao(bVar.wCz);
                }
            }
        }
    }

    public final b<_Callback> bI(_Callback _Callback) {
        return super.a(new b(_Callback, this));
    }

    public final void remove(_Callback _Callback) {
        super.b(new b(_Callback, this));
    }
}
