package com.tencent.mm.plugin.j;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.l;

public final class a extends l implements com.tencent.mm.plugin.auth.a.a {
    private static a ksl;

    private a() {
        super(g.class);
    }

    public static synchronized a aiY() {
        a aVar;
        synchronized (a.class) {
            if (ksl == null) {
                ksl = new a();
            }
            aVar = ksl;
        }
        return aVar;
    }

    public final void a(f fVar, i.g gVar, boolean z) {
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        if (bVar.taf.leD != 0) {
            final if ifVar = bVar.taf.tpc;
            final if ifVar2 = bVar.taf.tpd;
            final if ifVar3 = bVar.taf.tpe;
            af.v(new Runnable() {
                public final void run() {
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    long j = -1;
                    g.Ei();
                    if (!(g.Ek() == null || ifVar == null)) {
                        g.Ei();
                        g.Ek().a(ifVar, ifVar2, ifVar3);
                        j = aVar.se();
                    }
                    w.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[]{Long.valueOf(aVar.se()), Long.valueOf(j)});
                }
            });
        }
    }
}
