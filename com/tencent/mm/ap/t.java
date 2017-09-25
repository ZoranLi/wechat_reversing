package com.tencent.mm.ap;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class t implements am {
    private static HashMap<Integer, c> gJr;
    private n hOs;
    private b hOt;
    private o hOu = new o();
    private p hOv = new p();
    private q hOw = new q();
    private r hOx = new r();
    private l hOy = null;
    private aj hOz = new aj(h.vL().nJF.getLooper(), new a(this) {
        final /* synthetic */ t hOA;

        {
            this.hOA = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here TRULY!");
            s.Ia().update();
            return false;
        }

        public final String toString() {
            return super.toString() + "|regCodeUpdater";
        }
    }, false);

    private static t Ib() {
        return (t) l.o(t.class);
    }

    public static n Ic() {
        h.vG().uQ();
        if (Ib().hOs == null) {
            Ib().hOs = new n(h.vI().gYg);
        }
        return Ib().hOs;
    }

    public static b Id() {
        h.vG().uQ();
        if (Ib().hOt == null) {
            Ib().hOt = new b(h.vI().gYg);
        }
        return Ib().hOt;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.hOu);
        com.tencent.mm.sdk.b.a.urY.c(this.hOv);
        com.tencent.mm.sdk.b.a.urY.c(this.hOw);
        com.tencent.mm.sdk.b.a.urY.c(this.hOx);
        com.tencent.mm.sdk.b.a.urY.c(this.hOy.hOn);
        com.tencent.mm.sdk.b.a.urY.c(this.hOy.hOo);
    }

    public final void aM(boolean z) {
        if (z) {
            w.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here !");
            this.hOz.v(10000, 10000);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.hOu);
        com.tencent.mm.sdk.b.a.urY.b(this.hOv);
        com.tencent.mm.sdk.b.a.urY.b(this.hOw);
        com.tencent.mm.sdk.b.a.urY.b(this.hOx);
        if (this.hOy != null) {
            this.hOy.hOm.clear();
        } else {
            this.hOy = new l();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.hOy.hOn);
        com.tencent.mm.sdk.b.a.urY.b(this.hOy.hOo);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return n.gUx;
            }
        });
        gJr.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }
}
