package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.d.v;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.pluginsdk.k.a.d.j;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m;
import com.tencent.mm.pluginsdk.k.a.d.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLException;

final class g {
    final c iyR = new c(this);

    private static final class a {

        static abstract class a implements com.tencent.mm.modelcdntran.h.a {
            private final e iyV;

            abstract void a(l lVar);

            a(e eVar) {
                this.iyV = eVar;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i != 0) {
                    a(new l(this.iyV, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.iyV.bDp(), Integer.valueOf(i)})), 3));
                    w.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[]{this.iyV.bDp(), Integer.valueOf(i)});
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    return 0;
                } else {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        w.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d", new Object[]{this.iyV.bDp(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            a(new l(this.iyV, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.iyV.bDp(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)})), 3));
                        } else {
                            a(new l(this.iyV, -1, null));
                            int aN = com.tencent.mm.a.e.aN(this.iyV.Qn().getFilePath());
                            if (com.tencent.mm.u.ag.a.hlT != null) {
                                com.tencent.mm.u.ag.a.hlT.aH(aN, 0);
                            }
                        }
                    }
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return new byte[0];
            }
        }

        public final l a(e eVar) {
            String bDp = eVar.bDp();
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final com.tencent.mm.plugin.appbrand.m.l lVar = new com.tencent.mm.plugin.appbrand.m.l();
                k Qn = eVar.Qn();
                com.tencent.mm.modelcdntran.h.a anonymousClass1 = new a(this, eVar) {
                    final /* synthetic */ a iyU;

                    final void a(l lVar) {
                        lVar.jou = lVar;
                        countDownLatch.countDown();
                    }
                };
                h hVar = new h();
                hVar.field_mediaId = Qn.sEX;
                hVar.field_fullpath = Qn.getFilePath();
                hVar.hzg = Qn.url;
                hVar.fZK = false;
                hVar.hze = anonymousClass1;
                hVar.hzf = true;
                hVar.hzh = 15;
                hVar.hzi = 30;
                String host = Uri.parse(hVar.hzg).getHost();
                if (!bg.mA(host)) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        com.tencent.mm.kernel.h.vH().gXC.hsZ.getHostByName(host, arrayList);
                        hVar.hzj = new String[arrayList.size()];
                        arrayList.toArray(hVar.hzj);
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", new Object[]{e});
                    }
                }
                com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                try {
                    countDownLatch.await();
                    return (l) lVar.jou;
                } catch (Exception e2) {
                    w.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[]{bDp, e2});
                    return null;
                }
            } catch (Exception e22) {
                w.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[]{bDp, e22});
                return null;
            }
        }
    }

    private final class c extends m {
        final /* synthetic */ g iyW;

        c(g gVar) {
            this.iyW = gVar;
            super(new t("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new f(gVar));
        }

        public final void shutdown() {
            super.shutdown();
            ((f) this.sGK).iza.getLooper().quit();
        }

        protected final com.tencent.mm.pluginsdk.k.a.d.f.d a(k kVar) {
            com.tencent.mm.pluginsdk.k.a.d.f.d eVar = new e((d) kVar);
            eVar.sGM = this.sGK;
            return eVar;
        }

        protected final int b(k kVar) {
            int b = super.b(kVar);
            if (b != 1) {
                return b;
            }
            super.b(kVar);
            return 2;
        }
    }

    @SuppressLint({"DefaultLocale"})
    static class d extends k {
        final String appId;
        final int fKL;
        final int version;

        d(String str, int i, int i2, String str2) {
            this(String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i2)}), g.Qj() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i2)}), str2, str, i2, i);
        }

        d(String str, String str2, String str3, String str4, int i, int i2) {
            super(str, str2, String.valueOf(i), "AppBrandWxaPkgDownloader", str3, "GET", 3, 2, 0);
            this.appId = str4;
            this.version = i;
            this.fKL = i2;
        }

        public int Qk() {
            return 368;
        }

        public boolean Ql() {
            return true;
        }

        public boolean Qm() {
            return false;
        }

        public void hw(int i) {
        }
    }

    private static final class e extends com.tencent.mm.pluginsdk.k.a.d.m.a<d> {
        private static final ThreadLocal<a> iyX = new ThreadLocal<a>() {
            protected final /* synthetic */ Object initialValue() {
                return new a();
            }
        };
        private volatile long iyY;
        private String iyZ = null;

        protected final /* bridge */ /* synthetic */ com.tencent.mm.pluginsdk.k.a.d.f.b Qv() {
            return (d) super.Qv();
        }

        e(d dVar) {
            super(dVar);
        }

        protected final d Qn() {
            return (d) super.Qv();
        }

        public final String getURL() {
            return this.iyZ;
        }

        protected final l a(j jVar) {
            String str;
            int i;
            int i2;
            d dVar = (d) super.Qv();
            com.tencent.mm.loader.stub.b.deleteFile(dVar.getFilePath());
            this.iyZ = dVar.url;
            ArrayList arrayList = new ArrayList();
            if ("@LibraryAppId".equals(dVar.appId)) {
                str = "";
                i = 7;
            } else {
                int i3;
                if (com.tencent.mm.plugin.appbrand.appcache.c.a.hv(dVar.fKL)) {
                    if (com.tencent.mm.plugin.appbrand.app.c.PY() == null) {
                        i3 = 1;
                    } else {
                        i3 = com.tencent.mm.plugin.appbrand.app.c.PY().O(dVar.appId, dVar.fKL);
                    }
                    i3 = i3 > 1 ? 4 : 1;
                } else {
                    i3 = 1;
                }
                str = dVar.appId;
                i = i3;
            }
            int Qk = dVar.Qk();
            if (1 == i) {
                arrayList.add(new IDKey(Qk, 1, 1));
            } else if (4 == i) {
                arrayList.add(new IDKey(Qk, 10, 1));
            } else {
                arrayList.add(new IDKey(Qk, 20, 1));
            }
            this.iyY = bg.Nz();
            l a = this.iyZ.startsWith("https") ? ((a) iyX.get()).a(this) : null;
            if ((a == null || a.status == 3) && this.iyZ.startsWith("https")) {
                Object obj = 1;
                if (dVar instanceof b) {
                    arrayList.add(new IDKey(Qk, 31, 1));
                    obj = null;
                } else if ("@LibraryAppId".equals(dVar.appId)) {
                    arrayList.add(new IDKey(Qk, 30, 1));
                } else if (dVar instanceof d) {
                    arrayList.add(new IDKey(Qk, 31, 1));
                }
                if (obj != null) {
                    this.iyZ = this.iyZ.replaceFirst("https", "http");
                    a = super.a(jVar);
                }
            } else if (a == null) {
                a = super.a(jVar);
            }
            int Nz = (int) (bg.Nz() - this.iyY);
            AppBrandPerformanceManager.aj(str, Nz);
            if (a == null || a.status == 3) {
                i2 = 2;
            } else if (a.status == 4) {
                i2 = 3;
            } else {
                i2 = 1;
            }
            if (1 == i) {
                if (i2 == 1) {
                    arrayList.add(new IDKey(Qk, 2, 1));
                } else if (i2 == 2) {
                    arrayList.add(new IDKey(Qk, 3, 1));
                }
            } else if (4 == i) {
                if (i2 == 1) {
                    arrayList.add(new IDKey(Qk, 11, 1));
                } else if (i2 == 2) {
                    arrayList.add(new IDKey(Qk, 12, 1));
                }
            } else if (7 == i) {
                if (i2 == 1) {
                    arrayList.add(new IDKey(Qk, 21, 1));
                } else if (i2 == 2) {
                    arrayList.add(new IDKey(Qk, 22, 1));
                }
            }
            try {
                if (dVar.Ql()) {
                    com.tencent.mm.plugin.appbrand.report.a.b(str, "", i, i2, Nz);
                }
                if (dVar.Qm()) {
                    dVar.hw(Nz);
                }
                com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "download report", new Object[0]);
            }
            return a;
        }

        public final String Qo() {
            return "AppBrandWxaPkgDownloader";
        }

        public final boolean Qp() {
            return true;
        }

        public final boolean Qq() {
            return false;
        }

        public final boolean Qr() {
            return true;
        }

        protected final boolean Qs() {
            return false;
        }

        public final boolean Qt() {
            return false;
        }

        public final boolean Qu() {
            switch (v.rR()) {
                case 1:
                    return super.Qu();
                default:
                    return false;
            }
        }
    }

    private final class f implements com.tencent.mm.pluginsdk.k.a.d.c {
        final /* synthetic */ g iyW;
        public final ae iza = new ae(new af("WxaPkgDownloadPerformerEventDispatchThread").nJF.getLooper());

        f(g gVar) {
            this.iyW = gVar;
        }

        public final void a(final com.tencent.mm.pluginsdk.k.a.d.e eVar, final l lVar) {
            this.iza.post(new Runnable(this) {
                final /* synthetic */ f izd;

                public final void run() {
                    switch (lVar.status) {
                        case 2:
                            f.c(eVar, lVar);
                            return;
                        case 3:
                            f.b(eVar, lVar);
                            return;
                        case 4:
                            f.d(eVar, lVar);
                            return;
                        default:
                            return;
                    }
                }
            });
        }

        public final void n(String str, int i, int i2) {
        }

        public final void n(String str, long j) {
        }

        public static void b(com.tencent.mm.pluginsdk.k.a.d.e eVar, l lVar) {
            e(eVar, lVar);
        }

        public static void c(com.tencent.mm.pluginsdk.k.a.d.e eVar, l lVar) {
            String str = ((e) eVar).Qn().appId;
            int i = ((e) eVar).Qn().version;
            int i2 = ((e) eVar).Qn().fKL;
            try {
                if ("@LibraryAppId".equals(str) && i2 == 0) {
                    n.g(lVar.sEX, lVar.filePath, i);
                } else {
                    n.a(lVar.sEX, str, lVar.filePath, i, i2);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
                n.az(lVar.sEX, str);
            }
        }

        public static void d(com.tencent.mm.pluginsdk.k.a.d.e eVar, l lVar) {
            e(eVar, lVar);
        }

        private static void e(com.tencent.mm.pluginsdk.k.a.d.e eVar, l lVar) {
            com.tencent.mm.plugin.appbrand.appcache.n.a.b bVar;
            com.tencent.mm.loader.stub.b.deleteFile(lVar.filePath);
            String str = ((e) eVar).Qn().appId;
            switch (lVar.httpStatusCode) {
                case 403:
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    bVar = com.tencent.mm.plugin.appbrand.appcache.n.a.b.SEVER_FILE_NOT_FOUND;
                    break;
                default:
                    bVar = com.tencent.mm.plugin.appbrand.appcache.n.a.b.FAILED;
                    break;
            }
            n.a(((e) eVar).Qn(), lVar.sEX, str, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    static class b extends d {
        b(String str, String str2, int i) {
            super(String.format("WxaDebugPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), g.Qj() + String.format("debug_%d_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), str2, str, String.format("%d-%s", new Object[]{Integer.valueOf(i), str2}).hashCode(), i);
        }
    }

    g() {
    }

    static String Qj() {
        ap.yY();
        String xu = com.tencent.mm.u.c.xu();
        if (!xu.endsWith("/")) {
            xu = xu + "/";
        }
        xu = xu + "appbrand/pkg/";
        com.tencent.mm.sdk.platformtools.h.KS(xu);
        return xu;
    }

    final int a(d dVar) {
        if (this.iyR.Ms(dVar.sEX)) {
            w.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[]{dVar.sEX});
            return 0;
        }
        w.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[]{dVar.sEX, Integer.valueOf(this.iyR.b(dVar))});
        return this.iyR.b(dVar);
    }
}
