package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.mi;
import com.tencent.mm.plugin.sns.model.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class k extends c<mi> {
    public k() {
        this.usg = mi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mi miVar = (mi) bVar;
        if (miVar instanceof mi) {
            if (miVar.fTE.state == 0) {
                w.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                aa.ncZ = true;
                aa aaVar = new aa();
                aaVar.pUY = System.currentTimeMillis();
                if (!aaVar.pUX) {
                    new a(aaVar).l("");
                }
            } else {
                w.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                aa.ncZ = false;
            }
            return true;
        }
        w.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        return false;
    }
}
