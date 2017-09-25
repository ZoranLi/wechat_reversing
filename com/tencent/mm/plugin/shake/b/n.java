package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.e.a.qi;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends c<qi> {
    public n() {
        this.usg = qi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qi qiVar = (qi) bVar;
        switch (qiVar.fXp.opType) {
            case 0:
                a En = com.tencent.mm.plugin.shake.e.c.En(qiVar.fXp.fXr);
                if (En != null) {
                    qiVar.fXq.fRT = com.tencent.mm.plugin.shake.e.c.a(qiVar.fXp.context, En);
                    qiVar.fXq.fKz = m.dl(En.field_thumburl, "@B");
                    qiVar.fXq.fFj = true;
                    break;
                }
                w.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", new Object[]{qiVar.fXp.fXr});
                qiVar.fXq.fFj = false;
                break;
        }
        return false;
    }
}
