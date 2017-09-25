package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.aj;

public final class v extends o {
    private final aj ajc = new aj();

    v(q qVar) {
        super(qVar);
    }

    protected final void hu() {
        this.ahK.ih().lf().a(this.ajc);
        l ik = this.ahK.ik();
        String hR = ik.hR();
        if (hR != null) {
            this.ajc.ahs = hR;
        }
        String hQ = ik.hQ();
        if (hQ != null) {
            this.ajc.aht = hQ;
        }
    }

    public final aj iv() {
        ie();
        return this.ajc;
    }
}
