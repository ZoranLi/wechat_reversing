package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.m.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public class ct {
    public static long iQx = 200;
    private static long iQy = 20;
    private static ct iQz;
    private f iMs;
    public final List<e> iQA = new LinkedList();
    public Runnable iQB;

    public static ct Tl() {
        if (iQz == null) {
            synchronized (ct.class) {
                if (iQz == null) {
                    iQz = new ct();
                }
            }
        }
        return iQz;
    }

    public static int Tm() {
        return MMWebView.getTbsCoreVersion(ab.getContext()) >= 36867 ? 5 : 20;
    }

    private ct() {
        iQx = (long) (MMWebView.getTbsCoreVersion(ab.getContext()) >= 36867 ? 20 : m.CTRL_INDEX);
        this.iQB = new Runnable(this) {
            final /* synthetic */ ct iQC;

            {
                this.iQC = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r5 = this;
                r4 = 0;
                r0 = r5.iQC;
                r0 = r0.iQA;
                r0 = r0.isEmpty();
                if (r0 == 0) goto L_0x000c;
            L_0x000b:
                return;
            L_0x000c:
                r0 = r5.iQC;
                r1 = r0.iQA;
                monitor-enter(r1);
                r0 = r5.iQC;	 Catch:{ all -> 0x001d }
                r0 = r0.iQA;	 Catch:{ all -> 0x001d }
                r0 = r0.isEmpty();	 Catch:{ all -> 0x001d }
                if (r0 == 0) goto L_0x0020;
            L_0x001b:
                monitor-exit(r1);	 Catch:{ all -> 0x001d }
                goto L_0x000b;
            L_0x001d:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x001d }
                throw r0;
            L_0x0020:
                r0 = r5.iQC;	 Catch:{ all -> 0x001d }
                r0 = r0.iQA;	 Catch:{ all -> 0x001d }
                r2 = 0;
                r0 = r0.remove(r2);	 Catch:{ all -> 0x001d }
                r0 = (com.tencent.mm.plugin.appbrand.jsapi.e) r0;	 Catch:{ all -> 0x001d }
                monitor-exit(r1);	 Catch:{ all -> 0x001d }
                r0.SR();
                r1 = "MicroMsg.SensorJsEventPublisher";
                r2 = "publish next event(event : %s), list size is : %d.";
                r3 = 2;
                r3 = new java.lang.Object[r3];
                r0 = r0.getName();
                r3[r4] = r0;
                r0 = 1;
                r4 = r5.iQC;
                r4 = r4.iQA;
                r4 = r4.size();
                r4 = java.lang.Integer.valueOf(r4);
                r3[r0] = r4;
                com.tencent.mm.sdk.platformtools.w.v(r1, r2, r3);
                r0 = r5.iQC;
                r0 = r0.iQA;
                r0 = r0.isEmpty();
                if (r0 != 0) goto L_0x000b;
            L_0x005a:
                r0 = com.tencent.mm.plugin.appbrand.m.d.vL();
                r2 = com.tencent.mm.plugin.appbrand.jsapi.ct.iQx;
                r0.e(r5, r2);
                goto L_0x000b;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ct.1.run():void");
            }
        };
        this.iMs = new f(iQx, new a(this) {
            final /* synthetic */ ct iQC;

            {
                this.iQC = r1;
            }

            public final boolean f(Object... objArr) {
                if (this.iQC.iQA.isEmpty()) {
                    return false;
                }
                this.iQC.iQB.run();
                return true;
            }
        });
    }

    public final boolean a(e eVar, c cVar) {
        if (eVar == null) {
            return false;
        }
        if (!eVar.b(cVar)) {
            return false;
        }
        synchronized (this.iQA) {
            boolean isEmpty = this.iQA.isEmpty();
            if (this.iQA.isEmpty()) {
                this.iQA.add(eVar);
            } else if (((e) this.iQA.get(0)).equals(eVar)) {
                this.iQA.add(0, eVar);
                this.iQA.remove(1);
            } else {
                this.iQA.remove(eVar);
                this.iQA.add(eVar);
            }
        }
        if (isEmpty && !this.iMs.h(new Object[0])) {
            w.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[]{eVar.getName()});
            d.vL().e(this.iQB, iQx);
        }
        return true;
    }
}
