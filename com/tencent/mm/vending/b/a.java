package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    protected d fwy;
    private LinkedList<b> wCw;
    public f wCx;

    public a() {
        this(g.cbL());
    }

    public a(d dVar) {
        this.wCw = new LinkedList();
        Assert.assertNotNull(dVar);
        this.fwy = dVar;
        this.wCx = new f(dVar, null);
    }

    public final synchronized b a(b bVar) {
        this.wCw.add(bVar);
        return bVar;
    }

    public final synchronized void b(b bVar) {
        if (bVar != null) {
            this.wCw.remove(bVar);
        }
    }

    public final synchronized LinkedList<b> cbx() {
        return new LinkedList(this.wCw);
    }

    public final synchronized int size() {
        return this.wCw.size();
    }

    public final synchronized boolean contains(_Callback _Callback) {
        return this.wCw.contains(new b(_Callback, this));
    }
}
