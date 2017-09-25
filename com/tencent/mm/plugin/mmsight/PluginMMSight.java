package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.mmsight.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.l;

public class PluginMMSight extends d implements a {
    public String name() {
        return "plugin-mmsight";
    }

    public void installed() {
        w.i("MicroMsg.PluginMMSight", "installed");
        alias(a.class);
    }

    public void dependency() {
        w.i("MicroMsg.PluginMMSight", "dependency");
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    }

    public void configure(e eVar) {
        if (eVar != null) {
            w.i("MicroMsg.PluginMMSight", "configure, process: %s", new Object[]{eVar.gWO});
        }
    }

    public void execute(e eVar) {
        if (eVar != null) {
            w.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[]{eVar.gWO});
        }
        a.nAQ = new com.tencent.mm.plugin.e.a.a();
        pin(new l(e.class));
    }
}
