package com.tencent.mm.plugin.video;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.l;

public class PluginVideo extends d implements a {
    public String name() {
        return "plugin-video";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
        w.i("MicroMsg.PluginVideo", "plugin video execute");
        if (eVar.ej("")) {
            pin(new l(o.class));
            pin(new l(com.tencent.mm.modelcontrol.d.class));
            pin(new l(n.class));
        }
    }
}
