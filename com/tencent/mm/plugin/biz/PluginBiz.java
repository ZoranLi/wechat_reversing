package com.tencent.mm.plugin.biz;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.storage.o;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class PluginBiz extends d implements a, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("")) {
            h.a(com.tencent.mm.modelbiz.n.class, new c(new k()));
            h.a(com.tencent.mm.plugin.biz.a.a.class, new a());
        }
        j.a.sNr = new com.tencent.mm.pluginsdk.ui.applet.c();
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            pin(new l(w.class));
        }
    }

    public HashMap<Integer, g.c> collectDatabaseFactory() {
        HashMap<Integer, g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new g.c(this) {
            final /* synthetic */ PluginBiz jQi;

            {
                this.jQi = r1;
            }

            public final String[] pP() {
                return o.gUx;
            }
        });
        return hashMap;
    }
}
