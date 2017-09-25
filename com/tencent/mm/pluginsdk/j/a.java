package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;

public final class a {
    private j sEI;
    private k sEJ;
    private l sEK;
    private h sEL;
    private i sEM;
    private g sEN;

    public final boolean a(Activity activity, p pVar) {
        if (pVar.type == 0 || pVar.action == 0) {
            return false;
        }
        if (this.sEN == null) {
            this.sEN = new g(activity);
        }
        if (this.sEN.a(pVar)) {
            return true;
        }
        switch (pVar.type) {
            case 1:
                if (this.sEI == null) {
                    this.sEI = new j(activity);
                }
                this.sEI.a(pVar);
                return false;
            case 2:
                if (this.sEJ == null) {
                    this.sEJ = new k(activity);
                }
                this.sEJ.a(pVar);
                return false;
            case 3:
                if (this.sEK == null) {
                    this.sEK = new l(activity);
                }
                this.sEK.a(pVar);
                return false;
            case 4:
                if (this.sEL == null) {
                    this.sEL = new h(activity);
                }
                this.sEL.a(pVar);
                return false;
            case 5:
                if (this.sEM == null) {
                    this.sEM = new i(activity);
                }
                this.sEM.a(pVar);
                return false;
            case 6:
                if (this.sEN == null) {
                    this.sEN = new g(activity);
                }
                this.sEN.a(pVar);
                return false;
            default:
                w.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                return false;
        }
    }

    private static void a(b bVar) {
        if (bVar != null) {
            for (Integer intValue : bVar.sEO) {
                ap.vd().b(intValue.intValue(), (e) bVar);
            }
            bVar.activity = null;
        }
    }

    public final void close() {
        a(this.sEI);
        a(this.sEJ);
        a(this.sEK);
        a(this.sEL);
        a(this.sEM);
        a(this.sEN);
    }
}
