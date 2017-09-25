package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public class f implements am {
    private static HashMap<Integer, c> mrL;
    private d oUB;
    private com.tencent.mm.sdk.b.c oUC = new com.tencent.mm.sdk.b.c<rb>(this) {
        final /* synthetic */ f oUG;

        {
            this.oUG = r2;
            this.usg = rb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            avp com_tencent_mm_protocal_c_avp = ((rb) bVar).fYa.fYb;
            if (com_tencent_mm_protocal_c_avp == null) {
                w.e("MicroMsg.SafeDeviceStorageLogic", "null resp");
            } else if (com_tencent_mm_protocal_c_avp instanceof ge) {
                ge geVar = (ge) com_tencent_mm_protocal_c_avp;
                if (geVar != null) {
                    e.a(geVar.tjQ);
                }
            } else if (com_tencent_mm_protocal_c_avp instanceof gg) {
                gg ggVar = (gg) com_tencent_mm_protocal_c_avp;
                if (ggVar != null) {
                    e.a(ggVar.tjQ);
                }
            } else if (com_tencent_mm_protocal_c_avp instanceof aal) {
                aal com_tencent_mm_protocal_c_aal = (aal) com_tencent_mm_protocal_c_avp;
                if (!(com_tencent_mm_protocal_c_aal == null || com_tencent_mm_protocal_c_aal.tGp == null)) {
                    e.a(com_tencent_mm_protocal_c_aal.tGp.tjQ);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oUD = new com.tencent.mm.sdk.b.c<rc>(this) {
        final /* synthetic */ f oUG;

        {
            this.oUG = r2;
            this.usg = rc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rc rcVar = (rc) bVar;
            e.q(rcVar.fYc.fYd, rcVar.fYc.fYe);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oUE = new com.tencent.mm.sdk.b.c<hh>(this) {
        final /* synthetic */ f oUG;

        {
            this.oUG = r2;
            this.usg = hh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hh hhVar = (hh) bVar;
            hhVar.fMJ.fMK = e.cK(hhVar.fMI.context);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oUF = new com.tencent.mm.sdk.b.c<hi>(this) {
        final /* synthetic */ f oUG;

        {
            this.oUG = r2;
            this.usg = hi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((hi) bVar).fML.fMM = e.aXN();
            return false;
        }
    };

    private static f aXO() {
        f fVar = (f) ap.yR().gs(f.class.getName());
        if (fVar != null) {
            return fVar;
        }
        Object fVar2 = new f();
        ap.yR().a(f.class.getName(), fVar2);
        return fVar2;
    }

    public static d aXP() {
        h.vG().uQ();
        if (aXO().oUB == null) {
            f aXO = aXO();
            ap.yY();
            aXO.oUB = new d(com.tencent.mm.u.c.wO());
        }
        return aXO().oUB;
    }

    static {
        HashMap hashMap = new HashMap();
        mrL = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return mrL;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        a.urY.b(this.oUC);
        a.urY.b(this.oUD);
        a.urY.b(this.oUE);
        a.urY.b(this.oUF);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        a.urY.c(this.oUC);
        a.urY.c(this.oUD);
        a.urY.c(this.oUE);
        a.urY.c(this.oUF);
    }
}
