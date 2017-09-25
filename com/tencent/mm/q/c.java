package com.tencent.mm.q;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class c implements am {
    private static c gVg;
    private a gVh;

    private c() {
        if (a.gUL == null) {
            a.gUL = new a();
        }
        this.gVh = a.gUL;
    }

    public final void onAccountRelease() {
        a aVar = this.gVh;
        aVar.gUN.clear();
        b bVar = aVar.gUM;
        w.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.gUW.clear();
        bVar.gUY.clear();
        bVar.gUX.clear();
        bVar.gUZ.clear();
        aVar.gUO = false;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.gVh.init();
    }

    public final void aN(boolean z) {
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public static a uk() {
        h.vG().uQ();
        if (gVg == null) {
            c cVar = new c();
            gVg = cVar;
            cVar.gVh.init();
        }
        return gVg.gVh;
    }
}
