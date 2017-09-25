package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

public final class b implements a<Void, Void> {
    private static j luv = new j();
    private static n luw = new n();
    private static i lux = new i();
    private static l luy = new l();
    private com.tencent.mm.vending.g.b ink = null;

    public final /* synthetic */ Object call(Object obj) {
        w.i("MicroMsg.TaskInitListner", "hy: TaskInitListner init");
        this.ink = g.cbB();
        safeAddListener(luv);
        safeAddListener(luw);
        safeAddListener(lux);
        safeAddListener(luy);
        return null;
    }

    private static void safeAddListener(c cVar) {
        if (cVar == null) {
            w.w("MicroMsg.TaskInitListner", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.urY.d(cVar)) {
            w.w("MicroMsg.TaskInitListner", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.urY.b(cVar);
        }
    }
}
