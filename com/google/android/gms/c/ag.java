package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ag<T extends ag> {
    public final ah aAI;
    protected final ae aAJ;
    private final List<Object> aAK = new ArrayList();

    public ag(ah ahVar, v vVar) {
        w.Z(ahVar);
        this.aAI = ahVar;
        ae aeVar = new ae(this, vVar);
        aeVar.aAF = true;
        this.aAJ = aeVar;
    }

    public void a(ae aeVar) {
    }

    public ae iZ() {
        ae lb = this.aAJ.lb();
        le();
        return lb;
    }

    public final ae lc() {
        return this.aAJ;
    }

    public final List<ai> ld() {
        return this.aAJ.aAH;
    }

    public final void le() {
        Iterator it = this.aAK.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
