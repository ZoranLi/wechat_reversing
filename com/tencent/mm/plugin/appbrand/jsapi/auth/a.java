package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

class a extends e<a> implements a {
    public static final Map<String, a> iQD = new android.support.v4.e.a();
    private static final a iQE = new a() {
        protected final /* bridge */ /* synthetic */ boolean Tp() {
            return true;
        }

        protected final /* synthetic */ void aJ(Object obj) {
            super.a((a) obj);
        }

        protected final boolean To() {
            return true;
        }
    };

    interface a {
        void Tq();
    }

    protected /* synthetic */ boolean Tp() {
        return To();
    }

    protected /* synthetic */ void aJ(Object obj) {
        a((a) obj);
    }

    public static a d(h hVar) {
        if (hVar == null || hVar.mFinished) {
            return iQE;
        }
        a aVar;
        synchronized (iQD) {
            aVar = (a) iQD.get(hVar.ivH);
            if (aVar == null) {
                aVar = new a(hVar);
                iQD.put(hVar.ivH, aVar);
            }
        }
        return aVar;
    }

    public a(h hVar) {
        super("MicroMsg.AppBrandAuthJsApiQueue" + (hVar == null ? "|DUMMY" : "|" + hVar.ivH), d.vL().nJF.getLooper());
        if (hVar != null) {
            final String str = hVar.ivH;
            com.tencent.mm.plugin.appbrand.e.a(str, new b(this) {
                final /* synthetic */ a iQF;

                public final void onDestroy() {
                    this.iQF.quit();
                    synchronized (a.iQD) {
                        a.iQD.remove(str);
                    }
                }
            });
        }
    }

    public final void Tn() {
        yw(2);
    }

    protected boolean To() {
        return false;
    }

    protected final void a(a aVar) {
        w.d(this.mName, "about to executeTask %s", new Object[]{aVar.toString()});
        aVar.Tq();
    }
}
