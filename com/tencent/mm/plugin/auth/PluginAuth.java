package com.tencent.mm.plugin.auth;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.u;

public class PluginAuth extends d implements b {
    private final a jAH = new a();

    private static final class a extends com.tencent.mm.bn.a<com.tencent.mm.plugin.auth.a.a> implements com.tencent.mm.plugin.auth.a.a {
        public final void a(final f fVar, final g gVar, final boolean z) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.auth.a.a>(this) {
                final /* synthetic */ a jAM;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(fVar, gVar, z);
                }
            });
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
            final y.b bVar2 = bVar;
            final String str4 = str;
            final int i3 = i;
            final String str5 = str2;
            final String str6 = str3;
            final int i4 = i2;
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.auth.a.a>(this) {
                final /* synthetic */ a jAM;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(bVar2, str4, i3, str5, str6, i4);
                }
            });
        }
    }

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
        aq.a(new com.tencent.mm.u.aq.a(this) {
            final /* synthetic */ PluginAuth jAI;

            {
                this.jAI = r1;
            }

            public final void a(f fVar, g gVar) {
                u.a(gVar.sZm, true);
                this.jAI.getHandleAuthResponseCallbacks().a(fVar, gVar, true);
            }
        });
    }

    public void execute(e eVar) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a aVar) {
        return this.jAH.bI(aVar);
    }

    public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks() {
        return this.jAH;
    }
}
