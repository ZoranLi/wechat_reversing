package com.tencent.mm.plugin.appbrand.a;

import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public final String TAG;
    public final c iAk;
    public final android.support.v4.e.a<a, b> iAl = new android.support.v4.e.a();
    public final com.tencent.mm.plugin.appbrand.l.a iAm = new com.tencent.mm.plugin.appbrand.l.a(this) {
        final /* synthetic */ b iAn;

        {
            this.iAn = r1;
        }

        public final void onTrimMemory(int i) {
            switch (i) {
                case 5:
                case 10:
                case 15:
                    if (this.iAn.iAk.QD() == a.SUSPEND && d.sYQ) {
                        w.i(this.iAn.TAG, "onTrimMemory level %d, finishRuntime", new Object[]{Integer.valueOf(i)});
                        this.iAn.QB();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final h ixr;

    public interface a {
        void a(a aVar);
    }

    public final void QB() {
        if (!this.ixr.mFinished) {
            this.ixr.finish();
        }
    }

    public b(h hVar) {
        this.TAG = String.format("MicroMsg.AppBrand.AppRunningStateController[%s]", new Object[]{hVar.ivH});
        this.ixr = hVar;
        this.iAk = new c(this, hVar) {
            final /* synthetic */ b iAn;

            final void QC() {
                this.iAn.QB();
            }

            final void b(a aVar) {
                b bVar = this.iAn;
                synchronized (bVar.iAl) {
                }
                for (a a : (a[]) bVar.iAl.keySet().toArray(new a[bVar.iAl.size()])) {
                    a.a(aVar);
                }
            }
        };
    }

    public final void a(a aVar) {
        if (aVar != null && a.DESTROYED != this.iAk.QD()) {
            synchronized (this.iAl) {
                this.iAl.put(aVar, this);
            }
        }
    }
}
