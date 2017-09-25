package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.e.a.e;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;

public final class g {
    private static final c<e> iwj = new c<e>() {
        {
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(((e) bVar).fCm.fCn || ap.yQ())) {
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(a.uEd, Long.valueOf(0))).longValue();
                long Ny = bg.Ny();
                if (Ny >= longValue) {
                    g.Pq();
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uEd, Long.valueOf(Ny + 86400));
                }
            }
            return false;
        }
    };

    public static void setup() {
        com.tencent.mm.sdk.b.a.urY.a(iwj);
    }

    public static void release() {
        com.tencent.mm.sdk.b.a.urY.c(iwj);
    }

    public static void Pq() {
        d.vL().D(j.izq);
        d.vL().D(com.tencent.mm.plugin.appbrand.appstorage.d.izq);
    }
}
