package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Set;

final class b implements d {
    c iGN;
    Runnable iGO = new Runnable(this) {
        final /* synthetic */ b iGR;

        {
            this.iGR = r1;
        }

        public final void run() {
            f.dT("com.tencent.mm:support");
        }
    };
    Runnable iGP = new Runnable(this) {
        final /* synthetic */ b iGR;

        {
            this.iGR = r1;
        }

        public final void run() {
            if (f.dV("com.tencent.mm:support")) {
                e.a("com.tencent.mm:support", null, a.class, new com.tencent.mm.ipcinvoker.c(this) {
                    final /* synthetic */ AnonymousClass2 iGS;

                    {
                        this.iGS = r1;
                    }

                    public final void k(Bundle bundle) {
                        f.dU("com.tencent.mm:support");
                        if (bundle.getInt("runningSize") == 0) {
                            w.i("MicroMsg.DynamicPagePerformance", "runningSize is 0, kill remote service and restart it.");
                            com.tencent.mm.plugin.appbrand.dynamic.b.c(this.iGS.iGR.iGO, 2000);
                        }
                    }
                });
            }
        }
    };
    Runnable iGQ = new Runnable(this) {
        final /* synthetic */ b iGR;

        {
            this.iGR = r1;
        }

        public final void run() {
            if (f.dV("com.tencent.mm:support")) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("forceKillProcess", true);
                e.a("com.tencent.mm:support", bundle, a.class, new com.tencent.mm.ipcinvoker.c(this) {
                    final /* synthetic */ AnonymousClass3 iGT;

                    {
                        this.iGT = r1;
                    }

                    public final void k(Bundle bundle) {
                        f.dU("com.tencent.mm:support");
                    }
                });
            }
        }
    };

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            boolean z = false;
            if (bundle != null && bundle.getBoolean("forceKillProcess", false)) {
                z = true;
            }
            int size = com.tencent.mm.plugin.appbrand.dynamic.d.RP().size();
            if (z || size == 0) {
                com.tencent.mm.plugin.appbrand.dynamic.performance.b.Sk();
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.performance.b.Sj();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("runningSize", size);
            cVar.k(bundle2);
        }
    }

    b(c cVar) {
        this.iGN = cVar;
    }

    public final void prepare() {
        com.tencent.mm.plugin.appbrand.dynamic.b.k(this.iGO);
    }

    public final void exit() {
        com.tencent.mm.plugin.appbrand.dynamic.b.k(this.iGP);
    }

    public final void restart() {
        com.tencent.mm.plugin.appbrand.dynamic.b.k(this.iGQ);
        com.tencent.mm.plugin.appbrand.dynamic.b.c(this.iGO, 2000);
    }

    public final void gJ(String str) {
        Set<View> ay = this.iGN.ay(str);
        if (ay != null && !ay.isEmpty()) {
            for (View view : ay) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    w.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onPause();
                }
            }
        }
    }

    public final void gK(String str) {
        Set<View> ay = this.iGN.ay(str);
        if (ay != null && !ay.isEmpty()) {
            for (View view : ay) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    w.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onResume();
                }
            }
        }
    }
}
