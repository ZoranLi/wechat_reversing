package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.e;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import java.io.File;
import java.util.HashMap;

public final class w implements am {
    private v oAA;
    private p oBc;
    private b oBd = new b();

    private static w aUy() {
        w wVar = (w) ap.yR().gs("plugin.qqmail");
        if (wVar != null) {
            return wVar;
        }
        Object wVar2 = new w();
        ap.yR().a("plugin.qqmail", wVar2);
        return wVar2;
    }

    public static p aUz() {
        h.vG().uQ();
        if (aUy().oBc == null) {
            aUy().oBc = new p(d.sYN, d.DEVICE_TYPE);
        }
        return aUy().oBc;
    }

    public static v aUA() {
        h.vG().uQ();
        if (aUy().oAA == null) {
            aUy().oAA = new v();
        }
        return aUy().oAA;
    }

    public final void onAccountRelease() {
        p pVar = aUy().oBc;
        if (pVar != null) {
            pVar.reset();
        }
        a.urY.c(this.oBd);
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
        if ((i & 1) != 0) {
            aUB();
        }
    }

    public static void aUB() {
        ay.gl("qqmail");
        ap.yY();
        com.tencent.mm.u.c.wW().Rl("qqmail");
        p aUz = aUz();
        ap.yY();
        e.d(new File(com.tencent.mm.u.c.xj()));
        aUz.reset();
    }

    public final void aM(boolean z) {
        a.urY.b(this.oBd);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ w oBe;

            {
                this.oBe = r1;
            }

            public final void run() {
                if (ap.zb()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    s sVar = new s();
                    if (sVar.oAy.nwX.size() > 0) {
                        for (int i = 0; i < sVar.oAy.nwX.size(); i++) {
                            s.CT(((q) sVar.oAy.nwX.get(i)).ozq);
                        }
                        sVar.oAy.nwX.clear();
                        sVar.save();
                    }
                    com.tencent.mm.sdk.platformtools.w.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        });
    }

    public final void aN(boolean z) {
    }
}
