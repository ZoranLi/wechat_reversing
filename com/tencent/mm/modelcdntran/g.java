package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.c;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class g implements am {
    private b hyZ = null;
    private c hza = null;
    private c hzb;

    public static g Ei() {
        return (g) l.o(g.class);
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public static String Ej() {
        h.vG().uQ();
        return h.vI().cachePath + "cdndnsinfo/";
    }

    public final void aN(boolean z) {
    }

    public static c Ek() {
        return Ei().hzb;
    }

    public final void aM(boolean z) {
        onAccountRelease();
        h.vG().uQ();
        File file = new File(Ej());
        if (!file.exists()) {
            file.mkdir();
        }
        this.hzb = new c(this) {
            final /* synthetic */ g hzc;

            {
                this.hzc = r1;
            }

            public final void a(if ifVar, if ifVar2, if ifVar3) {
                w.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + ifVar.toString() + " getCore().engine:" + g.Em());
                if (g.Em() != null) {
                    g.Em().a(ifVar, ifVar2, ifVar3, null, null, null);
                    h.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 hzd;

                        {
                            this.hzd = r1;
                        }

                        public final void run() {
                            if (g.El() != null) {
                                g.El().be(false);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|infoUpdate";
                        }
                    });
                }
            }
        };
    }

    public static c El() {
        if (Ei().hza == null) {
            Ei().hza = new c();
        }
        return Ei().hza;
    }

    public static b Em() {
        if (Ei().hyZ == null) {
            h.vG();
            if (a.uU()) {
                Ei().hyZ = new b(h.vI().cachePath, El());
            } else {
                w.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", com.tencent.mm.storage.w.hgq + com.tencent.mm.a.g.n(("mm" + new Random().nextLong()).getBytes()) + "/");
                Ei().hyZ = new b(r0, El());
            }
        }
        return Ei().hyZ;
    }

    public final void onAccountRelease() {
        this.hzb = null;
        if (this.hyZ != null) {
            b bVar = this.hyZ;
            CdnLogic.setCallBack(null);
            bVar.hyd = null;
            this.hyZ = null;
        }
        if (this.hza != null) {
            e eVar = this.hza;
            if (h.vG().uV()) {
                h.vI().vr().b(eVar);
            }
            h.vH().b(eVar.hyk);
            h.vH().gXC.b(379, eVar);
            this.hza = null;
        }
    }
}
