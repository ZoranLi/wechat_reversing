package com.c.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b extends a {
    private z aJe;

    private static class a implements Runnable {
        private final WeakReference<b> aJf;
        private final p aJg;

        public a(b bVar, p pVar) {
            if (bVar == null || pVar == null) {
                throw new Exception("CoreAssembly: HandleMsgTask: null arg");
            }
            this.aJf = new WeakReference(bVar);
            this.aJg = pVar;
        }

        public final void run() {
            b bVar = (b) this.aJf.get();
            if (bVar != null) {
                switch (this.aJg.what) {
                    case f.CTRL_INDEX /*202*/:
                        f fVar = (f) this.aJg;
                        if (fVar.aMA == 1) {
                            bVar.a(fVar.aMB, fVar.aMa, fVar.aMb);
                            return;
                        } else {
                            bVar.a(fVar.aMA, fVar.message, fVar.aMa, fVar.aMb);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    abstract void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    abstract void a(float f, float f2, int i, float f3, float f4, float f5, long j);

    abstract void a(int i, String str, long j, long j2);

    abstract void a(x xVar, long j, long j2);

    abstract void a(List<ScanResult> list, long j, long j2);

    b() {
        super(ab.nJ(), r.np(), u.nD(), k.nl());
    }

    synchronized void a(Handler handler, a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.aJe = z.b(handler);
        super.a(handler, aVar);
    }

    final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    final void a(a aVar, a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    public void a(p pVar) {
        switch (pVar.what) {
            case 101:
                a(((a) pVar).aPL, pVar.aMa, pVar.aMb);
                return;
            case bh.CTRL_INDEX /*201*/:
                b(pVar);
                return;
            case f.CTRL_INDEX /*202*/:
                b(pVar);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX /*301*/:
                e eVar = (e) pVar;
                a(eVar.x, eVar.y, eVar.aOD, eVar.aOB, eVar.aOC, eVar.aLi, eVar.aMb);
                return;
            case 401:
                b bVar = (b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.aLg).intValue(), Math.round(bVar.aLh), Math.round(bVar.aLi), bVar.aLk, bVar.aLl, bVar.aLj, bVar.aLm, bVar.aMb);
                return;
            default:
                return;
        }
    }

    a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(Math.max(aVar.aJl, 10000));
    }

    private void b(p pVar) {
        if (this.aJe != null) {
            try {
                this.aJe.execute(new a(this, pVar));
            } catch (Exception e) {
            }
        }
    }
}
