package com.tencent.mm.plugin.appbrand.g;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.report.a.a;
import com.tencent.mm.plugin.appbrand.report.a.b;
import com.tencent.mm.plugin.appbrand.report.a.d;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class k {
    private final String ivH;
    private final h ixr;
    public Intent jcN;
    public b jcO = null;
    d jcP = null;
    boolean jck = false;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] jcU = new int[v.values().length];

        static {
            try {
                jcU[v.APP_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jcU[v.REDIRECT_TO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jcU[v.RE_LAUNCH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jcU[v.AUTO_RE_LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    class AnonymousClass3 implements c {
        final /* synthetic */ k jcR;
        final /* synthetic */ m jcS;
        final /* synthetic */ List jcT;

        AnonymousClass3(k kVar, m mVar, List list) {
            this.jcR = kVar;
            this.jcS = mVar;
            this.jcT = list;
        }

        public final void onDestroy() {
            this.jcS.b((c) this);
            b bVar = this.jcR.jcO;
            for (h hVar : this.jcT) {
                bVar.jgp = hVar.VC().jdl.VV() ? 5 : 1;
                String str = (String) bVar.jgj.pollFirst();
                bVar.jgq = str;
                bVar.jgo = str;
                bVar.jgj.push(hVar.VC().jde.jdU);
                bVar.d(hVar.VC());
                bVar.qg();
            }
        }
    }

    k(h hVar) {
        this.ivH = hVar.ivH;
        this.ixr = hVar;
        VQ();
    }

    public final void VQ() {
        String Wv = a.Wv();
        if (!bg.mA(this.ivH)) {
            com.tencent.mm.plugin.appbrand.k b = com.tencent.mm.plugin.appbrand.k.b(this.ixr);
            if (b != null) {
                LinkedList linkedList;
                l.nt(this.ivH).ixn = Wv;
                AppBrandLaunchReferrer appBrandLaunchReferrer = b.ixi.iwn.iEK;
                String str = "";
                if (1 == appBrandLaunchReferrer.iEL || 3 == appBrandLaunchReferrer.iEL) {
                    str = appBrandLaunchReferrer.appId;
                } else if (2 == appBrandLaunchReferrer.iEL) {
                    str = appBrandLaunchReferrer.url;
                }
                if (this.jcO != null) {
                    linkedList = this.jcO.jgj;
                    linkedList.pollFirst();
                } else {
                    linkedList = new LinkedList();
                }
                linkedList.push(bg.mz(str));
                this.jcO = b.a(this.ixr, Wv, linkedList);
                this.jcP = d.a(this.ixr, Wv, str);
                return;
            }
        }
        w.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[]{bg.g(new Throwable())});
        this.jcP = d.Wx();
        this.jcO = b.Ww();
    }

    final void c(m mVar) {
        d dVar = this.jcP;
        dVar.fCO = mVar.jde.jdU;
        dVar.qg();
    }

    final void b(final m mVar, final String str) {
        this.jcP.e(mVar);
        af.v(new Runnable(this) {
            final /* synthetic */ k jcR;

            public final void run() {
                b bVar = this.jcR.jcO;
                m mVar = mVar;
                String str = str;
                bVar.jgo = (String) bVar.jgj.pollFirst();
                bVar.jgp = 2;
                bVar.jgq = str;
                bVar.jgj.push(mVar.jde.jdU);
                bVar.d(mVar);
                bVar.qg();
            }
        });
    }

    public final void b(final h hVar) {
        this.jck = true;
        if (hVar != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ k jcR;

                public final void run() {
                    b bVar = this.jcR.jcO;
                    h hVar = hVar;
                    bVar.jgo = (String) bVar.jgj.peekFirst();
                    bVar.jgq = null;
                    switch (com.tencent.mm.plugin.appbrand.report.a.b.AnonymousClass2.ivI[e.nk(bVar.appId).ordinal()]) {
                        case 1:
                            bVar.jgp = hVar.VC().jdl.VV() ? 4 : 3;
                            break;
                        case 2:
                            bVar.jgp = 6;
                            break;
                        case 3:
                            break;
                        default:
                            Intent intent = bVar.ixr.iwr.jct.jcN;
                            if (intent == null) {
                                bVar.jgp = 7;
                                break;
                            }
                            String str;
                            if (intent.getComponent() == null) {
                                str = "";
                                w.e("MicroMsg.AppBrand.Report.kv_13536", "onBackground, intent %s, get null cmp name", new Object[]{intent});
                            } else {
                                str = intent.getComponent().getClassName();
                            }
                            if (str.contains("WebViewUI")) {
                                bVar.jgp = 10;
                                bVar.jgq = intent.getStringExtra("appbrand_report_key_target_url");
                            } else {
                                bVar.jgp = 8;
                                bVar.jgq = bg.ap(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                            }
                            str = bVar.jgq;
                            bVar.jgj.pollFirst();
                            bVar.jgj.push(bg.mz(str));
                            break;
                    }
                    Activity bB = g.bB(hVar.getContext());
                    if (bB != null && bB.isFinishing()) {
                        bVar.jgk = true;
                    }
                    bVar.d(hVar.VC());
                    bVar.qg();
                }
            });
        }
    }

    public final void c(h hVar) {
        this.jcN = null;
        d dVar = this.jcP;
        dVar.fCO = hVar.VC().jde.jdU;
        dVar.qg();
    }

    final void g(long j, int i) {
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(this.ivH);
        int i2 = mY == null ? 0 : mY.iFk.izW;
        com.tencent.mm.plugin.report.service.g.oUh.i(13543, new Object[]{this.ivH, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)});
    }
}
