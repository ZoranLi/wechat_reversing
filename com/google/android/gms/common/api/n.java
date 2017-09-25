package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import java.util.Collections;

public final class n implements p {
    private final o and;

    public n(o oVar) {
        this.and = oVar;
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        this.and.anN.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void bR(int i) {
    }

    public final void begin() {
        for (b disconnect : this.and.anT.values()) {
            disconnect.disconnect();
        }
        this.and.anV = Collections.emptySet();
    }

    public final void connect() {
        o oVar = this.and;
        oVar.anf.lock();
        try {
            oVar.anW = new m(oVar, oVar.anu, oVar.anv, oVar.amC, oVar.amD, oVar.anf, oVar.mContext);
            oVar.anW.begin();
            oVar.anL.signalAll();
        } finally {
            oVar.anf.unlock();
        }
    }

    public final void disconnect() {
        for (e cancel : this.and.anN) {
            cancel.cancel();
        }
        this.and.anN.clear();
        this.and.anU.clear();
        this.and.jI();
    }

    public final void g(Bundle bundle) {
    }

    public final String getName() {
        return "DISCONNECTED";
    }
}
