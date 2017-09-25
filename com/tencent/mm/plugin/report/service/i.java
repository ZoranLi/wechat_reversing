package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class i implements am {
    private static HashMap<Integer, c> oUw;
    private a oUx;
    private com.tencent.mm.sdk.b.c oUy = new com.tencent.mm.sdk.b.c<l>(this) {
        final /* synthetic */ i oUz;

        {
            this.oUz = r2;
            this.usg = l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((l) bVar).fCE.fCF && !h.vG().uV()) {
                w.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        oUw = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.report.a.b.gUx;
            }
        });
    }

    public final void onAccountRelease() {
        if (aXL() != null) {
            i aXL = aXL();
            if (aXL.oUx != null) {
                aXL.oUx.ha(aXL.hashCode());
                aXL.oUx = null;
            }
        }
        com.tencent.mm.sdk.b.a.urY.c(this.oUy);
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.oUx = g.a(hashCode(), h.vI().cachePath + "CommonOneMicroMsg.db", oUw, false);
        w.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bg.bJZ());
        com.tencent.mm.sdk.b.a.urY.b(this.oUy);
        h.vJ();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i oUz;

            {
                this.oUz = r1;
            }

            public final void run() {
                if (h.vG().uV()) {
                    bg.d(h.vI().cachePath + "logcat/", "temp_", 10800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void aN(boolean z) {
    }

    private static i aXL() {
        return (i) com.tencent.mm.u.l.o(i.class);
    }
}
