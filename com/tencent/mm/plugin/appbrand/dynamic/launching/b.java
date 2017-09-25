package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int iIc = 0;
    public static int iId = 1;
    final String appId;
    final int fKL;
    String iGy;
    int iIb;
    volatile String iIe;
    volatile int izW;

    public final /* synthetic */ Object call() {
        return Sg();
    }

    public b(String str, String str2, int i, int i2, int i3, String str3) {
        this.appId = str;
        this.fKL = i;
        this.izW = i2;
        this.iIe = str3;
        this.iIb = i3;
        this.iGy = str2;
    }

    public final WxaPkgWrappingInfo Sg() {
        int i = 1;
        Pair p = h.p(this.appId, this.fKL, this.izW);
        if (p.second != null) {
            return (WxaPkgWrappingInfo) p.second;
        }
        if (a.izj.equals(p.first)) {
            if (this.fKL == CdnLogic.MediaType_FAVORITE_VIDEO || this.fKL == 10102) {
                i a = c.PY().a(this.appId, this.fKL, "version", "versionMd5", "versionState");
                if (a == null) {
                    a((a) p.first);
                    return null;
                }
                com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, this.fKL == 10102 ? 2 : 1).gUA);
                if (b == null || b.errType != 0 || b.errCode != 0) {
                    if (this.iIb == 1) {
                        g.oUh.i(14452, new Object[]{this.iGy + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                    }
                    return null;
                } else if (bg.mA(((adp) b.fYb).url)) {
                    if (this.iIb == 1) {
                        g.oUh.i(14452, new Object[]{this.iGy + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                    }
                    return null;
                } else {
                    if (this.iIb == 1) {
                        g.oUh.i(14452, new Object[]{this.iGy + "-" + this.appId, Integer.valueOf(5), Long.valueOf(System.currentTimeMillis())});
                    }
                    bqg com_tencent_mm_protocal_c_bqg = new bqg();
                    String str = ((adp) b.fYb).url;
                    this.iIe = str;
                    com_tencent_mm_protocal_c_bqg.uoy = str;
                    int i2 = a.field_version;
                    this.izW = i2;
                    com_tencent_mm_protocal_c_bqg.tkv = i2;
                    com_tencent_mm_protocal_c_bqg.uow = a.field_versionState;
                    com_tencent_mm_protocal_c_bqg.uox = a.field_versionMd5;
                    c.PY().a(this.appId, com_tencent_mm_protocal_c_bqg, this.fKL);
                }
            }
            WxaPkgWrappingInfo Sh = Sh();
            if (Sh != null) {
                if (this.iIb != 1) {
                    return Sh;
                }
                g.oUh.i(14452, new Object[]{this.iGy + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis())});
                return Sh;
            } else if (this.iIb == 1) {
                g.oUh.i(14452, new Object[]{this.iGy + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis())});
            }
        }
        if (this.fKL == CdnLogic.MediaType_FAVORITE_VIDEO || this.fKL == 10102) {
            int[] nF = c.PY().nF(this.appId);
            if (nF != null && nF.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair p2 = h.p(this.appId, this.fKL, nF[i]);
                    if (p2 != null && p2.first == a.izf && p2.second != null) {
                        return (WxaPkgWrappingInfo) p2.second;
                    }
                    if (i2 >= nF.length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        a((a) p.first);
        return null;
    }

    private WxaPkgWrappingInfo Sh() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final l lVar = new l();
        n.a anonymousClass1 = new n.a(this) {
            final /* synthetic */ b iIg;

            public final void a(String str, com.tencent.mm.plugin.appbrand.appcache.n.a.b bVar, n.a.a aVar) {
                w.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdatingCallback, appId = %s, return = %s", new Object[]{str, bVar.name()});
                if (com.tencent.mm.plugin.appbrand.appcache.n.a.b.OK.equals(bVar)) {
                    WxaPkgWrappingInfo nH = WxaPkgWrappingInfo.nH(aVar.filePath);
                    if (nH == null) {
                        w.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdatingCallback, ret=OK but obtain null appPkgInfo");
                    } else {
                        nH.izW = aVar.version;
                        nH.izX = d.XH();
                        nH.izV = aVar.izM;
                        lVar.jou = nH;
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.n.a.b.SEVER_FILE_NOT_FOUND.equals(bVar);
                }
                countDownLatch.countDown();
            }
        };
        if (this.fKL == CdnLogic.MediaType_FAVORITE_VIDEO || this.fKL == 10102) {
            w.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.izW)});
            if (!n.a(this.appId, this.fKL, this.izW, this.iIe, anonymousClass1)) {
                a(a.izk);
                return null;
            }
        }
        w.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[]{this.appId, Integer.valueOf(this.fKL)});
        if (c.PY() == null) {
            w.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            a(a.izk);
            return null;
        }
        String P = c.PY().P(this.appId, this.fKL);
        if (bg.mA(P)) {
            w.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil");
            a(a.izg);
            return null;
        }
        n.a(this.appId, this.fKL, P, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) lVar.jou;
    }

    private void a(a aVar) {
        if (a.izg.equals(aVar)) {
            if (this.fKL == 10000 || this.fKL == 10100) {
                d.e(R.l.dEO, new Object[0]);
                return;
            }
            d.e(R.l.dFJ, com.tencent.mm.plugin.appbrand.appcache.a.hu(this.fKL));
        } else if (!a.izi.equals(aVar) && a.izh.equals(aVar)) {
        }
    }
}
