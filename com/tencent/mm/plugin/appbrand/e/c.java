package com.tencent.mm.plugin.appbrand.e;

import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.concurrent.CountDownLatch;

public final class c {

    public static class a<T extends avp> extends com.tencent.mm.y.a.a<T> {
        public a() {
            this.errType = 3;
            this.errCode = -13;
        }
    }

    public static <T extends avp> com.tencent.mm.y.a.a<T> b(b bVar) {
        if (bVar == null) {
            return null;
        }
        final l lVar = new l();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        u.a(bVar, new com.tencent.mm.y.u.a() {
            public final int a(int i, int i2, String str, b bVar, k kVar) {
                lVar.jou = com.tencent.mm.y.a.a.a(i, i2, str, (avp) bVar.hsk.hsr, kVar, null);
                countDownLatch.countDown();
                return 0;
            }
        });
        new aj(d.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a() {
            public final boolean oQ() {
                lVar.jou = new a();
                countDownLatch.countDown();
                return false;
            }
        }, false).v(20000, 20000);
        try {
            countDownLatch.await();
            return (com.tencent.mm.y.a.a) lVar.jou;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
            return null;
        }
    }
}
