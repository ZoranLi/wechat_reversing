package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.mm.ipcinvoker.a.c;
import com.tencent.mm.ipcinvoker.f.1;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class d implements b {

    private static final class a {
        public static final d gWz = new d();
    }

    public d() {
        Context context = ((f) h.vF().vj()).gZz;
        com.tencent.mm.ipcinvoker.a.b anonymousClass1 = new com.tencent.mm.ipcinvoker.a.a(this) {
            final /* synthetic */ d gWy;

            {
                this.gWy = r1;
            }

            public final void a(com.tencent.mm.ipcinvoker.a.d dVar) {
                super.a(dVar);
                dVar.a(new c());
                dVar.a(new a());
            }

            public final void a(c cVar) {
                cVar.a("com.tencent.mm", MainProcessIPCService.class);
                cVar.a("com.tencent.mm:tools", ToolsProcessIPCService.class);
                cVar.a("com.tencent.mm:support", SupportProcessIPCService.class);
            }
        };
        Assert.assertNotNull(context);
        com.tencent.mm.ipcinvoker.d.gVO = context;
        anonymousClass1.a(new 1());
        anonymousClass1.a(com.tencent.mm.ipcinvoker.b.un());
        w.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[]{com.tencent.mm.ipcinvoker.d.up(), Integer.valueOf(context.hashCode())});
        if (ab.bJd()) {
            com.tencent.mm.ipcinvoker.f.dT("com.tencent.mm:tools");
        }
    }
}
