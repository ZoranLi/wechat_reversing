package com.tencent.b.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    protected abstract void a(a aVar);

    protected abstract boolean nK();

    protected abstract String nL();

    protected abstract a nM();

    protected abstract void write(String str);

    protected q(Context context) {
        this.context = context;
    }

    public final g nS() {
        String decode;
        if (nK()) {
            decode = s.decode(nL());
        } else {
            decode = null;
        }
        if (decode != null) {
            return g.aI(decode);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (nK()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a nT() {
        if (nK()) {
            return nM();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && nK()) {
            a(aVar);
        }
    }
}
