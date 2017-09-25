package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

public class PluginFace extends d implements a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        w.d("MicroMsg.PluginFace", "hy: on face plugin ");
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(e eVar) {
        w.d("MicroMsg.PluginFace", "hy: on face plugin config");
    }

    public String name() {
        return "plugin-facedetect";
    }

    public void execute(e eVar) {
        w.i("MicroMsg.PluginFace", "hy: starting execute.");
        g.cbJ().b(new b()).a(new com.tencent.mm.vending.g.d.a<c<Integer, String>>(this) {
            final /* synthetic */ PluginFace lse;

            {
                this.lse = r1;
            }

            public final /* synthetic */ void aD(Object obj) {
                c cVar = (c) obj;
                int intValue = ((Integer) cVar.get(0)).intValue();
                String str = (String) cVar.get(1);
                w.e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intValue), str});
            }
        });
    }
}
