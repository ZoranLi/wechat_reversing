package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.b;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;

public class PluginComm extends d implements a {
    public String name() {
        return "plugin-comm";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("")) {
            new com.tencent.mm.plugin.zero.tasks.d().after((n) h.j(n.class)).before(this);
        }
    }

    public void execute(e eVar) {
        if (eVar.ej("")) {
            pin(com.tencent.mm.plugin.g.a.ZV());
            pin(com.tencent.mm.plugin.a.NH());
            pin(com.tencent.mm.plugin.j.a.aiY());
            pin(com.tencent.mm.plugin.l.a.akK());
            pin(com.tencent.mm.plugin.b.a.Ox());
            pin(b.Oy());
            pin(com.tencent.mm.plugin.n.b.aDv());
            pin(com.tencent.mm.plugin.n.a.aDu());
            pin(com.tencent.mm.p.h.ud());
            pin(com.tencent.mm.plugin.x.a.aSP());
            pin(com.tencent.mm.plugin.r.b.aJV());
            pin(com.tencent.mm.plugin.d.a.Pj());
            pin(com.tencent.mm.plugin.w.a.aRo());
            h.a(com.tencent.mm.plugin.r.a.a.class, new com.tencent.mm.plugin.r.a());
            ((com.tencent.mm.plugin.auth.a.b) h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.j.a.aiY());
            com.tencent.mm.ui.f.a.a.a(new com.tencent.mm.ui.f.a.b(this) {
                final /* synthetic */ PluginComm kDw;

                {
                    this.kDw = r1;
                }

                public final void a(ImageView imageView, String str) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
                }
            });
        }
        pin(a.gWz);
    }
}
