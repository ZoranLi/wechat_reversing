package com.tencent.mm.plugin.sns;

import com.tencent.mm.bb.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.l;

public class PluginSns extends d implements b {
    l pyO = new l();
    a pyP = new a();
    o pyQ = new o();

    public void configure(e eVar) {
        h.vJ();
        h.a(com.tencent.mm.plugin.sns.b.h.class, this.pyO);
        if (eVar.ej("")) {
            w.i("MicroMsg.PluginSns", "PluginSns configure");
            pin(new l(ae.class));
            h.vJ();
            h.a(a.class, this.pyP);
            h.vJ();
            h.a(com.tencent.mm.plugin.sns.b.l.class, this.pyQ);
        }
    }

    public void execute(e eVar) {
        String str = "sns";
        if (((f) h.vF().vj()).ej("")) {
            com.tencent.mm.bb.d.a(str, c.sYr, c.sYs);
        }
    }

    public String getAccSnsPath() {
        return h.vI().gYf + "sns/";
    }

    public String getAccSnsTmpPath() {
        return h.vI().gYf + "sns/temp/";
    }
}
