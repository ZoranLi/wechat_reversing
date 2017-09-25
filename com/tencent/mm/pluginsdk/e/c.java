package com.tencent.mm.pluginsdk.e;

import com.tencent.mm.e.a.jk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.b.c<T> implements e {
    private static HashMap<b, c<? extends b>> hCU = new HashMap();
    private static HashMap<k, b> sBN = new HashMap();
    private int sBM = 0;

    public abstract b a(int i, k kVar, T t);

    public abstract int ajb();

    public abstract k b(T t);

    public final void a(int i, int i2, String str, k kVar) {
        if (ajb() == kVar.getType()) {
            b bVar = (b) sBN.remove(kVar);
            if (bVar != null) {
                b jkVar = new jk();
                jkVar.fPP.fPQ = a(i2, kVar, bVar);
                jkVar.fPP.errType = i;
                jkVar.fPP.errCode = i2;
                jkVar.fPP.fPf = str;
                a.urY.m(jkVar);
            }
        }
    }

    public static void k(b bVar) {
        k kVar;
        for (Entry entry : sBN.entrySet()) {
            if (entry.getValue() == bVar) {
                kVar = (k) entry.getKey();
                break;
            }
        }
        kVar = null;
        if (kVar != null) {
            h.vd().c(kVar);
            sBN.remove(kVar);
        }
    }

    public final void bCx() {
        if (this.sBM == 0) {
            h.vd().a(ajb(), this);
        }
        this.sBM++;
    }

    public final void aFC() {
        if (this.sBM != 0) {
            this.sBM--;
            if (this.sBM == 0) {
                h.vd().b(ajb(), this);
            }
        }
    }

    public final void l(T t) {
        k b = b(t);
        h.vd().a(b, 0);
        sBN.put(b, t);
    }
}
