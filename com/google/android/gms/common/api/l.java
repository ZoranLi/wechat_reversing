package com.google.android.gms.common.api;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.internal.w;

public final class l implements p {
    private final o and;

    public l(o oVar) {
        this.and = oVar;
    }

    private <A extends b> void a(e<A> eVar) {
        this.and.b((e) eVar);
        o oVar = this.and;
        b bVar = (b) oVar.anT.get(eVar.ji());
        w.h(bVar, "Appropriate Api was not requested.");
        if (bVar.isConnected() || !this.and.anU.containsKey(eVar.ji())) {
            eVar.a(bVar);
        } else {
            eVar.c(new Status(17));
        }
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        return b(t);
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        try {
            a((e) t);
        } catch (DeadObjectException e) {
            this.and.a(new b(this, this) {
                final /* synthetic */ l ane;

                public final void jz() {
                    this.ane.bR(1);
                }
            });
        }
        return t;
    }

    public final void bR(int i) {
        if (i == 1) {
            o oVar = this.and;
            if (!oVar.anO) {
                oVar.anO = true;
                if (oVar.anS == null) {
                    oVar.anS = new c(oVar);
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    oVar.mContext.getApplicationContext().registerReceiver(oVar.anS, intentFilter);
                }
                oVar.anR.sendMessageDelayed(oVar.anR.obtainMessage(1), oVar.anP);
                oVar.anR.sendMessageDelayed(oVar.anR.obtainMessage(2), oVar.anQ);
            }
        }
        for (e a : this.and.anZ) {
            a.a(new Status(8, "The connection to Google Play services was lost"));
        }
        this.and.f(null);
        this.and.anM.bY(i);
        this.and.anM.kc();
        if (i == 2) {
            this.and.connect();
        }
    }

    public final void begin() {
        while (!this.and.anN.isEmpty()) {
            try {
                a((e) this.and.anN.remove());
            } catch (DeadObjectException e) {
            }
        }
    }

    public final void connect() {
    }

    public final void disconnect() {
        this.and.anU.clear();
        this.and.jI();
        this.and.f(null);
        this.and.anM.kc();
    }

    public final void g(Bundle bundle) {
    }

    public final String getName() {
        return "CONNECTED";
    }
}
