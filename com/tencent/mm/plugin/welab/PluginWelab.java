package com.tencent.mm.plugin.welab;

import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public class PluginWelab extends d implements a, c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.welab.a.a {
    private c ssl = new c();
    public boolean ssm;

    public void installed() {
        alias(com.tencent.mm.plugin.welab.a.a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("")) {
            w.v("PluginWelab", "configure");
            h.a(com.tencent.mm.plugin.welab.a.a.d.class, new com.tencent.mm.kernel.c.c(new d()));
            ((b) h.j(b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a(this) {
                final /* synthetic */ PluginWelab ssn;

                {
                    this.ssn = r1;
                }

                public final void a(f fVar, g gVar, boolean z) {
                    b.bAG();
                    b.D(this.ssn.ssm, !z);
                }

                public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
                }
            });
        }
    }

    public void execute(e eVar) {
        w.v("PluginWelab", "execute");
    }

    public String toString() {
        return "plugin-welab";
    }

    public void onDataBaseOpened(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
        w.v("PluginWelab", "onDataBaseOpened");
        b.bAG().ssN = new com.tencent.mm.plugin.welab.c.a(gVar);
    }

    public void onDataBaseClosed(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.f fVar) {
        w.v("PluginWelab", "onAccountInitialized");
        h.a(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
        h.a(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
        this.ssm = fVar.gYz;
        ((n) h.j(n.class)).getSysCmdMsgExtension().a("newabtestlabs", this.ssl, true);
    }

    public void onAccountRelease() {
        w.v("PluginWelab", "onAccountRelease");
        ((n) h.j(n.class)).getSysCmdMsgExtension().b("newabtestlabs", this.ssl, true);
    }

    public HashMap<Integer, com.tencent.mm.bj.g.c> collectDatabaseFactory() {
        w.v("PluginWelab", "collectDatabaseFactory");
        HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginWelab ssn;

            {
                this.ssn = r1;
            }

            public final String[] pP() {
                return new String[]{i.a(com.tencent.mm.plugin.welab.c.a.a.gTP, "LabAppInfo")};
            }
        });
        return hashMap;
    }
}
